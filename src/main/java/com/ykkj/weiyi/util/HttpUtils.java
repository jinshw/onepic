package com.ykkj.weiyi.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * HTTP工具类
 *
 * @author lixiangyang
 */
public class HttpUtils
{
    private static Log log = LogFactory.getLog(HttpUtils.class);

    /**
     * 定义编码格式 UTF-8
     */
    public static final String URL_PARAM_DECODECHARSET_UTF8 = "UTF-8";

    /**
     * 定义编码格式 GBK
     */
    public static final String URL_PARAM_DECODECHARSET_GBK = "GBK";

    private static final String URL_PARAM_CONNECT_FLAG = "&";

    private static final String EMPTY = "";

    private static MultiThreadedHttpConnectionManager connectionManager = null;

    private static int connectionTimeOut = 120000;

    private static int socketTimeOut = 120000;

    private static int maxConnectionPerHost = 20;

    private static int maxTotalConnections = 20;

    private static HttpClient client;

    static
    {
        connectionManager = new MultiThreadedHttpConnectionManager();
        connectionManager.getParams().setConnectionTimeout(connectionTimeOut);
        connectionManager.getParams().setSoTimeout(socketTimeOut);
        connectionManager.getParams().setDefaultMaxConnectionsPerHost(
                maxConnectionPerHost);
        connectionManager.getParams().setMaxTotalConnections(
                maxTotalConnections);
        client = new HttpClient(connectionManager);
    }

    /**
     * POST方式提交数据
     *
     * @param url
     *            待请求的URL
     * @param params
     *            要提交的数据
     * @param enc
     *            编码
     * @return 响应结果
     * @throws IOException
     *             IO异常
     */
    public static String URLPost(String url, Map<String, String> params,
            String enc, HttpServletRequest request)
    {

        String response = EMPTY;
        PostMethod postMethod = null;
        try
        {
            postMethod = new PostMethod(url);
            postMethod.setRequestHeader("Content-Type",
                    "application/x-www-form-urlencoded;charset=" + enc);
            postMethod.getParams().setParameter("http.protocol.cookie-policy",
                    CookiePolicy.BROWSER_COMPATIBILITY);
            // 将表单的值放入postMethod中
            Set<String> keySet = params.keySet();
            for (String key : keySet)
            {
                String value = params.get(key);
                postMethod.addParameter(key, value);
            }
            client.getState().addCookie(getJESESSIONID(request));
            // 执行postMethod
            int statusCode = client.executeMethod(postMethod);
            if (statusCode == HttpStatus.SC_OK)
            {
                response = postMethod.getResponseBodyAsString();
            }
            else
            {
                log.error("响应状态码 = " + postMethod.getStatusCode());
            }
        }
        catch (HttpException e)
        {
            log.error("发生致命的异常，可能是协议不对或者返回的内容有问题", e);
            e.printStackTrace();
        }
        catch (IOException e)
        {
            log.error("发生网络异常", e);
            e.printStackTrace();
        }
        finally
        {
            if (postMethod != null)
            {
                postMethod.releaseConnection();
                postMethod = null;
            }
        }

        return response;
    }

    public static String URLPostXML(String url, String sendXML, String enc)
    {
        String response = EMPTY;
        PostMethod postMethod = null;
        String responseString = null;
        try
        {
            postMethod = new PostMethod(url);
            postMethod.setRequestEntity(new StringRequestEntity(sendXML,
                    "text/xml", enc));
            client.getParams().setSoTimeout(300 * 1000);
            // 执行postMethod
            int statusCode = client.executeMethod(postMethod);
            if (statusCode == HttpStatus.SC_OK)
            {
                BufferedInputStream bis = new BufferedInputStream(
                        postMethod.getResponseBodyAsStream());
                byte[] bytes = new byte[1024];
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int count = 0;
                while ((count = bis.read(bytes)) != -1)
                {
                    bos.write(bytes, 0, count);
                }
                byte[] strByte = bos.toByteArray();
                responseString = new String(strByte, 0, strByte.length, "utf-8");
                bos.close();
                bis.close();
            }
            else
            {
                log.error("响应状态码 = " + postMethod.getStatusCode());
            }
        }
        catch (HttpException e)
        {
            log.error("发生致命的异常，可能是协议不对或者返回的内容有问题", e);
            e.printStackTrace();
        }
        catch (IOException e)
        {
            log.error("发生网络异常", e);
            e.printStackTrace();
        }
        finally
        {
            if (postMethod != null)
            {
                postMethod.releaseConnection();
                postMethod = null;
            }
        }
        log.info("接口返回response====\n" + responseString + "\n");
        return responseString;
    }

    public static org.apache.commons.httpclient.Cookie getJESESSIONID(
            HttpServletRequest request)
    {
        Cookie[] cookies = request.getCookies();
        request.getContextPath();

        for (Cookie c : cookies)
        {
            if (c.getName().equals("JSESSIONID"))
            {
                org.apache.commons.httpclient.Cookie jsessionId = new org.apache.commons.httpclient.Cookie();
                jsessionId.setName("JSESSIONID");
                jsessionId.setValue(c.getValue());
                // jsessionId.setDomain(StaticUtils.COOKIE_DOMAIN);
                jsessionId.setPath("/");
                System.out.println("JSESSIONID:" + c.getValue());
                return jsessionId;
            }
        }
        return null;
    }

    /**
     * GET方式提交数据
     *
     * @param url
     *            待请求的URL
     * @param params
     *            要提交的数据
     * @param enc
     *            编码
     * @return 响应结果
     * @throws IOException
     *             IO异常
     */
    public static String URLGet(String url, Map<String, String> params,
            String enc)
    {

        String response = EMPTY;
        GetMethod getMethod = null;
        StringBuffer strtTotalURL = new StringBuffer(EMPTY);
        if (strtTotalURL.indexOf("?") == -1)
        {
            strtTotalURL.append(url).append("?").append(getUrl(params, enc));
        }
        else
        {
            strtTotalURL.append(url).append("&").append(getUrl(params, enc));
        }
        log.debug("GET请求URL = \n" + strtTotalURL.toString());
        System.out.println(url);
        try
        {
            getMethod = new GetMethod(strtTotalURL.toString());
            getMethod.setRequestHeader("Content-Type",
                    "application/x-www-form-urlencoded;charset=" + enc);
            getMethod.getParams().setParameter("http.protocol.cookie-policy",
                    CookiePolicy.BROWSER_COMPATIBILITY);
            // 执行getMethod
            int statusCode = client.executeMethod(getMethod);
            if (statusCode == HttpStatus.SC_OK)
            {
                response = getMethod.getResponseBodyAsString();
            }
            else
            {
                log.debug("响应状态码 = " + getMethod.getStatusCode());
            }
        }
        catch (HttpException e)
        {
            log.error("发生致命的异常，可能是协议不对或者返回的内容有问题", e);
            e.printStackTrace();
        }
        catch (IOException e)
        {
            log.error("发生网络异常", e);
            e.printStackTrace();
        }
        finally
        {
            if (getMethod != null)
            {
                getMethod.releaseConnection();
                getMethod = null;
            }
        }

        return response;
    }

    /**
     * 据Map生成URL字符串
     *
     * @param map
     *            Map
     * @param valueEnc
     *            URL编码
     * @return URL
     */
    private static String getUrl(Map<String, String> map, String valueEnc)
    {

        if (null == map || map.keySet().size() == 0)
        {
            return (EMPTY);
        }
        StringBuffer url = new StringBuffer();
        Set<String> keys = map.keySet();
        for (Iterator<String> it = keys.iterator(); it.hasNext();)
        {
            String key = it.next();
            if (map.containsKey(key))
            {
                String val = map.get(key);
                String str = val != null ? val : EMPTY;
                try
                {
                    str = URLEncoder.encode(str, valueEnc);
                }
                catch (UnsupportedEncodingException e)
                {
                    e.printStackTrace();
                }
                url.append(key).append("=").append(str)
                        .append(URL_PARAM_CONNECT_FLAG);
            }
        }
        String strURL = EMPTY;
        strURL = url.toString();
        if (URL_PARAM_CONNECT_FLAG.equals(EMPTY
                + strURL.charAt(strURL.length() - 1)))
        {
            strURL = strURL.substring(0, strURL.length() - 1);
        }

        return (strURL);
    }

    public static Cookie getCookie(HttpServletRequest request, String name)
    {
        Cookie cookies[] = request.getCookies();
        if (cookies == null || name == null || name.length() == 0)
        {
            return null;
        }
        for (int i = 0; i < cookies.length; i++)
        {
            if (name.equals(cookies[i].getName()))
            {
                return cookies[i];
            }
        }
        return null;
    }

}
package com.ykkj.weiyi.util;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;




public class CookieUtil {

public static Cookie getCookie(HttpServletRequest request, String name) {
     Cookie cookies[] = request.getCookies();
    if (cookies == null || name == null || name.length() == 0) {
      return null;
     }
    for (int i = 0; i < cookies.length; i++) {
      if (name.equals(cookies[i].getName())) {
        return cookies[i];
       }
     }
    return null;
   }

public static void deleteCookie(HttpServletRequest request,
       HttpServletResponse response, Cookie cookie) {
    if (cookie != null) {
       cookie.setPath(getPath(request));
       cookie.setValue("");
       cookie.setMaxAge(0);
       response.addCookie(cookie);
     }
   }

public static void setCookie(HttpServletRequest request,
       HttpServletResponse response, String name, String value) {
     setCookie(request, response, name, value, 0x278d00);
   }

public static void setCookie(HttpServletRequest request,
       HttpServletResponse response, String name, String value, int maxAge) {
     Cookie cookie = new Cookie(name, value == null ? "" : value);
     cookie.setMaxAge(maxAge);
     cookie.setPath(getPath(request));
     response.addCookie(cookie);
   }
public static void setCatCookie(HttpServletRequest request,HttpServletResponse response,String name,String result){
	Cookie cookie =getCookie(request,name);
	if(cookie!=null){
				if(cookie.getValue().equals("")){
					cookie.setValue(result);
				}
				else{
					String   catjson = "";
					catjson +=cookie.getValue() +",";
					catjson +=result;
					cookie.setValue(catjson);
				}
				cookie.setMaxAge(24*60*60);   //存活期为�?�?
				cookie.setPath(getPath(request));
				response.addCookie(cookie);
	}else{
		setCookie(request,response,name,result,24*60*60);
	}
}

public static void updateCookie(HttpServletRequest request,
	       HttpServletResponse response, String name, String value){
	Cookie[] cookies=request.getCookies(); 
    if(cookies.length>1){ 
          for(int i=0;i<cookies.length;i++){
               if(cookies[i].getName().equals(name)) {
                cookies[i].setValue(value);
                cookies[i].setPath(getPath(request));
                response.addCookie(cookies[i]); 
                break;
               } 
          }
    }

}
private static String getPath(HttpServletRequest request) {
     String path = request.getContextPath();
    return (path == null || path.length()==0) ? "/" : path;
   }
/**
 * 获取cookie的map数据格式
 * @param Cookie c
 * @return Map<String, Integer>
 *//*
public static Map<Long, Integer> getCartMap(Cookie c){
	Map<Long, Integer> map = new HashMap<Long, Integer>();
	if(c!=null){
		String cart = c.getValue();
		String[] cartItems = StringUtils.split(cart, "|");
		for(int i=0;i<cartItems.length;i++){
			String[] item = StringUtils.split(cartItems[i], "-");
			map.put(Long.valueOf(item[0]), Integer.valueOf(item[1]));
		}
	}
	return map;
}*/
/**
 * 将map格式数据转成cookie�?
 * @param map
 * @return
 */
public static String getCartCookie(Map<Long, Integer> map){
	StringBuffer s = new StringBuffer();
	for(Map.Entry<Long, Integer> entry:map.entrySet()){
		String temp = entry.getKey()+"-"+entry.getValue()+"|";
		s.append(temp);
	}
	return s.toString();
}

}


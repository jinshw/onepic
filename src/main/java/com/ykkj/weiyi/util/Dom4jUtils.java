package com.ykkj.weiyi.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by jinshw on 2016/7/7.
 */
public class Dom4jUtils {
    private static Log logger = LogFactory.getLog(Dom4jUtils.class);

    public static Document getDocument(String xml) {
        Document document = null;
        try {
            SAXReader reader = new SAXReader();
            InputStream in = new ByteArrayInputStream(xml.getBytes("UTF-8"));
            InputStreamReader strInStream = new InputStreamReader(in, "UTF-8");
            document = (Document) reader.read(strInStream);
        } catch (Exception e) {
            logger.error("XML不合法! :", e);
        }
        return document;
    }

    // 测试使用
    public static Map<String, String> getMapByDocument(Document document) {
        Map<String, String> map = new HashMap<String, String>(200);
        try {
            List<Element> level = document.getRootElement().element("Authentication").elements();
            List<Element> level3 = document.getRootElement().element("TrainOrderService").elements();
            List<Element> level2 = document.getRootElement().element("TrainOrderService").element("OrderInfo").elements();
            Element element = document.getRootElement().element("TrainOrderService").element("DeliveryInfo");
            for (Element e : level) {
                map.put(e.getName(), e.getTextTrim());
            }
            for (Element e : level2) {
                map.put(e.getName(), e.getTextTrim());
            }
            if (null != element) {
                List<Element> list = element.elements();
                for (Element e : list) {
                    map.put(e.getName(), e.getTextTrim());
                }
            }
            for (Element e : level3) {
                map.put(e.getName(), e.getTextTrim());
            }
        } catch (Exception e) {
            logger.error("Dom4jUtil-->getMapByDocument()订单推送过来的XML节点问题,请查看原始的XML信息!", e);
        }
        return map;
    }

    /**
     * XML转Map
     * @param doc
     * @return
     */
    public static Map<String, Object> Dom2Map(Document doc) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext(); ) {
            Element e = (Element) iterator.next();
            //System.out.println(e.getName());
            List list = e.elements();
            if (list.size() > 0) {
                map.put(e.getName(), Dom2Map(e));
            } else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map Dom2Map(Element e) {
        Map map = new HashMap();
        List list = e.elements();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if (iter.elements().size() > 0) {
                    Map m = Dom2Map(iter);
                    if (map.get(iter.getName()) != null) {
                        Object obj = map.get(iter.getName());
                        if (!obj.getClass().getName().equals("java.util.ArrayList")) {
                            mapList = new ArrayList();
                            mapList.add(obj);
                            mapList.add(m);
                        }
                        if (obj.getClass().getName().equals("java.util.ArrayList")) {
                            mapList = (List) obj;
                            mapList.add(m);
                        }
                        map.put(iter.getName(), mapList);
                    } else{
                        map.put(iter.getName(), m);
                    }
                } else {
                    if (map.get(iter.getName()) != null) {
                        Object obj = map.get(iter.getName());
                        if (!obj.getClass().getName().equals("java.util.ArrayList")) {
                            mapList = new ArrayList();
                            mapList.add(obj);
                            mapList.add(iter.getText());
                        }
                        if (obj.getClass().getName().equals("java.util.ArrayList")) {
                            mapList = (List) obj;
                            mapList.add(iter.getText());
                        }
                        map.put(iter.getName(), mapList);
                    } else{
                        map.put(iter.getName(), iter.getText());
                    }
                }
            }
        } else
            map.put(e.getName(), e.getText());
        return map;
    }

    public static void main(String[] args) throws Exception {
        Document doc = Dom4jUtils.createXml();
        String strXml = doc.asXML();
        System.out.println(strXml);
        Map map = Dom4jUtils.Dom2Map(doc);
        System.out.println("-----------------------------");
        System.out.println(map.toString());
        System.out.println("##############################");
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();

        while (entries.hasNext()) {

            Map.Entry<Integer, Integer> entry = entries.next();

            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

        }
    }

    /**
     * 创建测试xml
     * @return
     */
    public static Document createXml(){
        Document doc = DocumentHelper.createDocument();
        Element e = doc.addElement("GmMail");
        e.addElement("template_id").setText("2");
        e.addElement("to_address").setText("test@corp.gm.com");
        e.addElement("to_alias").setText("tom");
        e.addElement("message").setText("XML-未来世界 Message");
        e.addElement("recipient_name").setText("xml-tom");
        e.addElement("send_address").setText("xml-test@163.com");
        e.addElement("sender_comp_name").setText("xml-gm");
        e.addElement("subject").setText("xml-hello guys");
        Element Selecteditems = e.addElement("selected_items");

        Element itemsGroup = Selecteditems.addElement("item_group");
        //Element item = itemsGroup.addElement("item");
        itemsGroup.addElement("item_url").setText("http://china.gm.com");
        itemsGroup.addElement("item_name").setText("gm中文站");
        itemsGroup.addElement("item_desc").setText("gm中文站desc");
        itemsGroup.addElement("item_desc2").setText("gm中文站desc2");
        itemsGroup.addElement("item_desc3").setText("gm中文站desc3");
        itemsGroup.addElement("item_desc4").setText("gm中文站desc4");
        Selecteditems.addElement("items_source").setText("products");
        itemsGroup = Selecteditems.addElement("item_group");
        itemsGroup.addElement("item_url").setText("http://www.gm.com");
        itemsGroup.addElement("item_name").setText("gm");
        itemsGroup.addElement("item_desc").setText("gmdesc");
        Element attachment = e.addElement("attachments");
        Element attachmentGroup =    attachment.addElement("attachment-group");
        attachmentGroup.addElement("attachment_url").setText("http://china.gm.com/pics/com.cn.gm/story/frsc.jpg");
        attachmentGroup.addElement("attachment_name").setText("黄晓豫");
        Element attachmentDesc = attachmentGroup.addElement("attachment_desc");
        attachmentDesc.addElement("desc1").setText("attach-desc1");
        attachmentDesc.addElement("desc2").setText("attach-desc2");
        attachmentDesc.addElement("desc3").setText("attach-desc3");
        attachmentDesc.addElement("desc4").setText("attach-desc4");
        attachmentGroup =    attachment.addElement("attachment-group");
        attachmentGroup.addElement("attachment_url").setText("http://china.gm.com/pics/com.cn.gm/story/wr.jpg");
        attachmentGroup.addElement("attachment_name").setText("张中汉");
        attachmentDesc = attachmentGroup.addElement("attachment_desc");
        attachmentDesc.addElement("desc1").setText("attach-desc1");
        attachmentDesc.addElement("desc2").setText("attach-desc2");
        attachmentDesc = attachmentGroup.addElement("attachment_desc");
        attachmentDesc.addElement("desc1").setText("attach-desc1");
        attachmentDesc.addElement("desc2").setText("attach-desc2");
        Element descGroup = e.addElement("desc_group");
        descGroup.addElement("desc_item").setText("desc_item_1");
        descGroup.addElement("desc_item").setText("desc_item_2");
        descGroup.addElement("desc_item").setText("desc_item_3");
        descGroup.addElement("desc_item").setText("desc_item_4");
        descGroup.addElement("desc_item").setText("desc_item_5");
        return doc;
    }
}
/**
 * 系统配置管理类,负责系统整个配置的读取、缓存、修改
 * @author	[ChenTianCao]
 * @version	[cms1.0, 2014-04-03]
 * @since	[cms1.0] 
 */
package com.ykkj.weiyi.util;

import com.ykkj.weiyi.common.SysConfig;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class SysConfigManager {

	private static Logger logger = LoggerFactory.getLogger(SysConfigManager.class);

	private static SysConfigManager instance;

	private SAXReader reader = null;
	private String encode = "UTF-8";

	/**
	 * 是否制作工具权限
	 */
	private Boolean licTopicTool = null;

	/** 系统整体配置xml对象 */
	private Document document;

	/**
	 * 系统部署路径，其它功能模板调用该属性获取当前部署目录
	 */
	private String SysRootPath;

	public void setSysRootPath(String sysRootPath) {
		SysRootPath = sysRootPath;
	}

	private SysConfigManager() {
		init();
	}

	public static SysConfigManager getInstance() {
		if (instance == null) {
			instance = new SysConfigManager();
		}
		return instance;
	}

	/**
	 * 初始化
	 */
	private void init() {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		try {
			fis = new FileInputStream(new File(getConfigDir()));
			isr = new InputStreamReader(fis, encode);
			reader = new SAXReader();
			document = reader.read(isr);
		} catch (Exception e) {
			logger.error("初始化系统配置内容时出错", e);
		} finally {
			try {
				isr.close();
				fis.close();
			} catch (IOException e) {
				logger.error("关闭配置文件流出错", e);
			}
		}
	}

	/**
	 * 获取配置文件路径
	 * 
	 * @return
	 * @throws Exception
	 */
	private String getConfigDir() throws Exception {
		String configPath = getClass().getClassLoader().getResource("RRConfig.xml").getPath();
		System.out.println(configPath + "===========================路径");
		return configPath;
	}

	/**
	 * 保存系统配置
	 * 
	 * @param entity
	 */
	public synchronized void save(SysConfig entity) throws Exception {
		XMLWriter writer = null;
		try {
			init();
			Element element = (Element) document.selectSingleNode("/zm/modules/module[@id=" + entity.getModuleid() + "]/Parameter[@id=" + entity.getId() + "]/value");
			element.setText(entity.getValue());
			writer = new XMLWriter(new FileOutputStream(this.getConfigDir()));
			writer.write(document);
		} catch (Exception e) {
			logger.error("保存系统配置出错", e);
			throw e;
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException ioe) {
			}
		}
	}

	/**
	 * 获取系统配置列表
	 * 
	 * @return
	 */
	public List<SysConfig> getAllConfigList() {
		Attribute attr = null;
		List<SysConfig> result = null;
		SysConfig config = null;
		try {
			if (document == null) {
				init();
			}
			result = new ArrayList<SysConfig>();
			List<Element> moduleList = document.selectNodes("/zm/modules/module");
			// 遍历模块标签
			for (Element moduleNode : moduleList) {
				attr = moduleNode.attribute("id");
				// 获取模块的属性
				Long moduleId = ConvertUtils.createLong(attr.getText());
				attr = moduleNode.attribute("name");
				String moduleName = attr.getText();
				List<Element> parameterList = moduleNode.selectNodes("Parameter");
				for (Element paramNode : parameterList) {
					attr = paramNode.attribute("isshow");
					boolean isshow = ConvertUtils.createBoolean(attr.getText());
					// 判断是否要显示到系统工作平台
					if (isshow) {
						config = new SysConfig();
						config.setModuleid(moduleId);
						config.setModulename(moduleName);
						attr = paramNode.attribute("id");
						config.setId(ConvertUtils.createLong(attr.getText()));
						Element tmp = (Element) paramNode.selectSingleNode("name");
						config.setName(tmp.getText());
						tmp = (Element) paramNode.selectSingleNode("description");
						config.setDescription(tmp.getText());
						tmp = (Element) paramNode.selectSingleNode("value");
						config.setValue(tmp.getText());
						result.add(config);
					}
				}
			}
		} catch (Exception e) {
			logger.error("获取系统配置列表出错", e);
		}
		return result;
	}

	/**
	 * 获取当前系统部署目录
	 * 
	 * @return
	 */
	public String getSysRootPath() {
		if (SysRootPath == null) {
			SysRootPath = System.getProperty("webRoot");
		}
		return SysRootPath;
	}

	/**
	 * 向外公开获取系统配置方法，传入配置路径
	 * 
	 * @param xPath
	 *            节点路径
	 * @return
	 * @throws Exception
	 */
	public String getProperty(String xPath) throws Exception {
		String result = null;
		try {
			if (document == null) {
				init();
			}
			Element ele = (Element) document.selectSingleNode(xPath);
			if (ele != null) {
				result = ele.getText();
			}
		} catch (Exception e) {
			logger.error("获取指定配置时出错", e);
			throw e;
		}
		return result;
	}

	/**
	 * 向外公开获取系统配置方法，传入配置路径
	 * 
	 * @param xPath
	 *            节点路径
	 * @return 返回整型
	 * @throws Exception
	 */
	public int getPropertyToInt(String xPath) throws Exception {
		int result = 0;
		String str = getProperty(xPath);
		if (str != null && str.length() > 0) {
			result = Integer.parseInt(str);
		}
		return result;
	}

}

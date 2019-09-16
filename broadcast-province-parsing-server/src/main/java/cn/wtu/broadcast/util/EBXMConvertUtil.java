package cn.wtu.broadcast.util;

import java.io.File;
import java.io.StringWriter;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EBXMConvertUtil {
	private static Logger logger = LoggerFactory.getLogger(EBXMConvertUtil.class);

	public static void main(String[] args) {

		//HeartBeatXmlModel model = (HeartBeatXmlModel) EBXMConvertUtil.xmlConvertToModel("c:/HeartBeatXml.xml",
		//		"cn.wtu.broadcast.openapi.vo.HeartBeatXmlModel");

		//EBXMConvertUtil.modelConvertToXml(model);
		
		System.out.println(getNodeValue("C:/Users/Lenovo/Desktop/test.xml", "DEST.EBRID"));		
	}

	/**
	 * xml转换成java对象模型
	 * 
	 * @param xmlUrl
	 *            需要转换的xml的路径：例如c:/HeartBeatXml.xml
	 * @param classType
	 *            转换的对象类，包名加类名的字符串：例如cn.wtu.broadcast.openapi.vo.
	 *            HeartBeatXmlModel
	 * @return
	 */
	public static Object xmlConvertToModel(String xmlUrl, String classType) {
		Object model = null;
		try {
			JAXBContext context = JAXBContext.newInstance(Class.forName(classType));
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File(xmlUrl);
			URL xmlFileUrl = file.toURI().toURL();
			model = unmarshaller.unmarshal(xmlFileUrl);
		} catch (Exception e) {
			logger.error("XML生成Model错误！", e);
		}

		return model;
	}

	/**
	 * 将java对象模型转换成xml
	 * 
	 * @param model
	 *            JAVA对象(包含数据的)
	 * @return
	 */
	public static String modelConvertToXml(Object model) {
		String xmlObject = null;
		try {
			StringWriter writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(model.getClass());
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			m.marshal(model, writer);
			xmlObject = writer.toString();
			System.out.println(xmlObject);
		} catch (Exception e) {
			logger.error("Model生成XML错误！", e);
		}

		return xmlObject;
	}

	/**
	 * 获取指定节点的值
	 * @param xmlPath XML的路径
	 * @param nodeName 节点的名称集合，以"."隔离(不包含根节点的名称)
	 * 	例如DEST.EBRID是获取根节点下节点DEST的节点EBRID的值
	 * @return
	 */
	public static String getNodeValue(String xmlPath, String nodeNames) {
		String value = null;
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File(xmlPath));
			//获取文档根节点
			Element root = document.getRootElement();
			//获取文档根节点
			String[] nodeNameArr = nodeNames.split("\\.");
			if(nodeNameArr != null && nodeNameArr.length > 0){
				Element nameElem = root;
				for (String nodeName : nodeNameArr) {
					nameElem = nameElem.element(nodeName);
				}
				value = nameElem.getText();
			}
		} catch (Exception e) {
			logger.error("获取指定节点的值发生异常", e);
		}
		return value;
	}
}

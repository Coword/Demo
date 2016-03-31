import java.io.File;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlParse {
	
	private SAXReader saxReader = new SAXReader(); 
	private Document document = null;
	public XmlParse(File file){
		try {	// 通过read方法读取xml文件转换成Document对象 
			document = saxReader.read(file);
		} catch (DocumentException e) {
			System.out.println("解析xml文档异常,请检查文档结构！");
			e.printStackTrace();
		}
	}
	public XmlParse(Reader reader){
		try {	   // 通过read方法读取字符流转换成Document对象 
			document = saxReader.read(reader);
		} catch (DocumentException e) {
			System.out.println("解析xml字符流异常,请检查字符流结构！");
			e.printStackTrace();
		}	
	}
	public Document getDocument(){
		return document;
	}
	
	/**
	  * @Title: listNodes
	  * @Description: 遍历所有节点
	  * @param @param node    起始节点
	  * @return void    返回类型
	  * @throws
	  */
	@SuppressWarnings("unchecked")
	public void listNodes(Element node){  
		for(Iterator<Element> i = node.elementIterator(); i.hasNext();){   
			Element element = (Element) i.next();
	        System.out.println(element.getName() + ":" + element.getText());
	        for(Iterator<Element> j = element.nodeIterator(); !(element.elements().isEmpty()) && j.hasNext();){
	        	Element element1 = (Element) j.next();
	        	System.out.println(element1.getName() + ":" + element1.getText());
	        }
	    }
	}
	
	public static void main(String[] args) {
		String s = "<root><trade id=\"01\"><pear></pear><apple>10</apple><banana>20</banana></trade><trade id=\"02\"><apple>20</apple></trade></root>";
		StringReader sr = new StringReader(s);       
		XmlParse xml = new XmlParse(sr);
		//获取根节点元素对象 
		Element rootNode = xml.getDocument().getRootElement();
		//遍历全文件
		xml.listNodes(rootNode);
		//遍历指定节点下的子节点
		//Element识别不了下面这种格式
//		Element tradeNode = rootNode.element("trade[@id = '02']");	//遍历第二个trade节点
		//这句要添加<jaxen-1.1-beta-6.jar>,在dom4j的lib文件夹下
		//要不会报错java.lang.NoClassDefFoundError: org/jaxen/JaxenException
		Element tradeNode =  (Element) rootNode.selectSingleNode("trade[@id = '02']");//获取特定节点
		xml.listNodes(tradeNode);	//遍历trade节点下子节点
		//获取特定节点
		try{
			Element element = rootNode.element("trade"); 
			System.out.println(element.getName() + ":" + element.getTextTrim());
		}
		catch (NullPointerException e){
			System.out.println("查无此节点！");
		}
		
		@SuppressWarnings("unchecked")
		List<Element> nodes = rootNode.selectNodes("trade");
		System.out.println("trade节点个数" + nodes.size()); 
	}
}

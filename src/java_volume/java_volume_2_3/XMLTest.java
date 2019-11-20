package java_volume.java_volume_2_3;



import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Simple API for XML
 * SAX
 * */
public class XMLTest {


    public static void main(String[] args)throws Exception{
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        File f = new File("src/java_volume/java_volume_2_3/a.xml");
        Document document = builder.parse(f);
        //获取子元素
        Element e = document.getDocumentElement();
        System.out.println(e);
        //获取子元素下面所有元素结点
        NodeList nodeList = e.getChildNodes();

        for(int i=0;i<nodeList.getLength();i++){
            Node child = nodeList.item(i);
           if(child instanceof Element){
               System.out.println(child.getAttributes().getNamedItem("c"));
               System.out.println(child.getAttributes().getNamedItem("c1"));
               System.out.println(child.getAttributes().getNamedItem("c2"));
               //System.out.println(child.getNodeValue());
           }
        }
    }
}

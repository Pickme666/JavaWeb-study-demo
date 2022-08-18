package xml_analysis;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import java.util.List;

/**
 * XML文件解析，Xpath
 * 使用Xpath检索，Xpath技术依赖于dom4j，且比dom4j更加高效
 *      全文检索：//contact
 *      属性查找：//@属性名、//元素[@属性名]、//元素//[@属性名='值']
 */

public class XpathDemo {
    public static void main(String[] args) throws Exception {

        //导入jaxen包，创建Document对象，加载XML文件
        Document document =  new SAXReader().read(Dom4jDemo.class.getResourceAsStream("/student.xml"));

        //全文检索，查找name元素（标签）
        List<Node> nameNode = document.selectNodes("//name");
        for (Node node : nameNode) {
            Element element = (Element) node;
            System.out.println(element.getTextTrim());  //打印元素数据
        }

    }
}

package xml_analysis;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * XML文件解析，dom4j
 * 使用 dom4j框架 解析XML文件中的数据
 */

public class Dom4jDemo {
    public static void main(String[] args) throws Exception {

        //导入dom4j包，创建Dom4j的解析器对象
        SAXReader saxReader = new SAXReader();

        //加载XML文件成为Document对象
        InputStream stream = Dom4jDemo.class.getResourceAsStream("/student.xml");
        Document document = saxReader.read(stream);

        //先拿根元素
        Element root = document.getRootElement();

        //提取子元素
        List<Element> listElem = root.elements("message");

        //创建集合封装解析的数据
        List<Student> student = new ArrayList<>();

        //变量子元素message
        for (Element element : listElem) {
            //每个子元素都是一个Student对象
            Student s = new Student();
            s.setId(Integer.parseInt(element.attributeValue("id")));
            s.setVip(Boolean.parseBoolean(element.attributeValue("vip")));
            s.setName(element.elementTextTrim("name"));
            s.setSex(element.elementTextTrim("sex").charAt(0));
            s.setSchool(element.elementTextTrim("school"));
            student.add(s);
        }

        //遍历集合数据
        for (Student s : student) {
            System.out.println(s);
        }

        assert stream != null;
        stream.close();
    }
}

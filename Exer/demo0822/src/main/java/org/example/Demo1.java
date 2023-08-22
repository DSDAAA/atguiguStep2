package org.example;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("Exer/demo0822/student3.xml");
        Element rootElement = document.getRootElement();
        System.out.println(rootElement.getName());
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            System.out.println(element.getName());
            List<Element> elements1 = element.elements();
            for (Element element1 : elements1) {
                System.out.println(element1.getName());
            }
        }
    }
}

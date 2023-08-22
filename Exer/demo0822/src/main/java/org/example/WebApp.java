package org.example;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;
import java.util.Scanner;

public class WebApp {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("Exer/demo0822/web.xml");
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements("servlet-mapping");

        String string = new Scanner(System.in).next();
        String servlet_name = null;

        for (Element servlet_mappings : elements) {
            boolean findIt = false;
            List<Element> url_patterns = servlet_mappings.elements("url-pattern");
            for (Element url_pattren : url_patterns) {
                if (url_pattren.getText().equals(string)) {
                    findIt = true;
                }
            }
            if (findIt) {
                servlet_name = servlet_mappings.element("servlet-name").getText();
            }
        }

        List<Element> elements1 = rootElement.elements("servlet");
        for (Element servlets : elements1) {
            boolean findIt = false;
            List<Element> servlet_names = servlets.elements("servlet-name");
            for (Element servlet_nametarget : servlet_names) {
                if (servlet_nametarget.getText().equals(servlet_name)) {
                    findIt = true;
                }
            }
            if (findIt) {
                System.out.println(servlets.element("servlet-class").getText());
            }
        }
    }
}



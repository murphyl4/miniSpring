package com.minis.core;

import java.net.URL;
import java.util.Iterator;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

/**
 * @author malin28
 * @date 2024/5/11 15:52
 */
public class ClassPathXmlResource implements Resource {
    Document document;
    Element rootElement;
    Iterator<Element> elementIterator;
    public ClassPathXmlResource(String filename){
        SAXReader reader = new SAXReader();
        URL xmlPath = this.getClass().getClassLoader().getResource(filename);
        try {
            this.document = reader.read(xmlPath);
            this.rootElement = document.getRootElement();
            this.elementIterator = rootElement.elementIterator();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasNext() {
        return elementIterator.hasNext();
    }

    @Override
    public Object next(){
        return elementIterator.next();
    }
}

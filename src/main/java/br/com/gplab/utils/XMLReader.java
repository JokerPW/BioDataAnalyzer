package br.com.gplab.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLReader {
    
    private File fXmlFile;
    private DocumentBuilderFactory dbFactory;
    private DocumentBuilder dBuilder;
    
    private Document doc;
    public Document getDoc() { return doc; }
    
    
    public XMLReader() {
	
	try {
	    dbFactory = DocumentBuilderFactory.newInstance();
	    dBuilder = dbFactory.newDocumentBuilder();
	    
	} catch (ParserConfigurationException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
    }
    
    
    public boolean readFileXML(String path) {
	
	try {
	    fXmlFile = new File(path);
	    doc = dBuilder.parse(fXmlFile);
	    doc.getDocumentElement().normalize();
	    
	} catch (SAXException | IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return false;
	}
	
	return true;
    }
    

    public boolean readGETXML(String url) {
	System.out.println("Reading XML: " + url);
	try {
	    doc = dBuilder.parse(new URL(url).openStream());
	    doc.getDocumentElement().normalize();
	    
	} catch (SAXException | IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return false;
	}
	
	return true;
    }
    
    public void destroy() {
	fXmlFile = null;
	dbFactory = null;
	dBuilder = null;
	doc = null;
    }
    
}
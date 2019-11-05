package com.san.misc;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.lang.StringEscapeUtils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class EscapeXml {
  
  public static String getEscapedString(String str){
	  
	 return StringEscapeUtils.escapeXml(str);
  }
  
  public static void escapeXmlFile(String inputFile, String outputFile) throws Exception {
	  Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(inputFile));

    // locate the node(s)
    // ways to get particular nodes based on values
    // XPath xpath = XPathFactory.newInstance().newXPath();
    //  NodeList nodes = (NodeList)xpath.evaluate("//employee/name[text()='John']", doc, XPathConstants.NODESET);
    
    NodeList nodes = (NodeList)doc.getElementsByTagName("*");

    // escape text nodes
    for (int idx = 0; idx < nodes.getLength(); idx++) {
      Node node = nodes.item(idx);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        NodeList childNodes = node.getChildNodes();
        for (int cIdx = 0; cIdx < childNodes.getLength(); cIdx++) {
          Node childNode = childNodes.item(cIdx);
          if (childNode.getNodeType() == Node.TEXT_NODE) {
            String newTextContent =  
              StringEscapeUtils.escapeXml(childNode.getTextContent());
            childNode.setTextContent(newTextContent);
          }
        }
      }
    }

    // save the result
    Transformer xformer = TransformerFactory.newInstance().newTransformer();
    xformer.transform(new DOMSource(doc), new StreamResult(new File(outputFile)));
	  
  }

  public static void main(String[] args) throws Exception {
    
	 // Escaping special char in xml
	 String inputFile = "Resources/data.xml";
	 String outputFile = "Resources/data_new.xml";
	  
	 escapeXmlFile(inputFile, outputFile);
	 System.out.println("Generated escaped xml output file at -> "+outputFile);
    
	// Escaping special char in string
	String strEscaped = getEscapedString("<test>");
	System.out.println("Escaped String <test> -> "+strEscaped);
  }
}

package com.bluebone.core;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BBXMLParser {
	
	
	private static BBXMLParser _instance;
	
	public static String getValue(Element item, String str) {
		NodeList n = item.getElementsByTagName(str);
		return getElementValue(n.item(0));
	}

	public final static String getElementValue( Node elem ) {
		     Node child;
		     if( elem != null){
		         if (elem.hasChildNodes()){
		             for( child = elem.getFirstChild(); child != null; child = child.getNextSibling() ){
		                 if( child.getNodeType() == Node.TEXT_NODE  ){
		                     return child.getNodeValue();
		                 }
		             }
		         }
		     }
		     return "";
	  }	
	
	public static BBXMLParser getInstance() {
		if ( _instance instanceof BBXMLParser) {
			return _instance;
		} else {
			_instance = new BBXMLParser();
			return _instance;
		}
	}
}

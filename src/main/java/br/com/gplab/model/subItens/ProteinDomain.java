package br.com.gplab.model.subItens;

import org.w3c.dom.Element;

public class ProteinDomain {
    
    private String description;
    private int begin;
    private int end;
    
    
    public ProteinDomain(Element yourNode) {
	description = yourNode.getAttribute("description");
	begin = Integer.parseInt(((Element)yourNode.getElementsByTagName("begin").item(0)).getAttribute("position"));
	end = Integer.parseInt(((Element)yourNode.getElementsByTagName("end").item(0)).getAttribute("position"));	
    }
    
    
    public String getDescription(int position) {
	
	if (begin <= position && position <= end)
	    return description;
	
	return "";
    }
    
}
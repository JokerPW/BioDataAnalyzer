package br.com.gplab.model.unimod;

import org.w3c.dom.Element;

import br.com.gplab.model.unimod.interfaces.IUnimod;
import br.com.gplab.utils.FailSafe;

// <brick2element_row brick_key="2" num_element="1" element="H" record_id="1"></brick2element_row>
public class Brick2Element implements IUnimod {

    private int recordID;
    public int getRecordID() { return recordID; }
    public void setRecordID(int recordID) { this.recordID = recordID; }

    private int brickKey;	// recordID from table Brick
    public int getBrickKey() { return brickKey; }
    public void setBrickKey(int brickKey) { this.brickKey = brickKey; }
    
    private int numElement;	// recordID from table Element
    public int getNumElement() { return numElement; }
    public void setNumElement(int numElement) { this.numElement = numElement; }
    
    private String element;
    public String getElement() { return element; }
    public void setElement(String element) { this.element = element; }
    
    
    public void populate (Element data) {
	recordID = FailSafe.forceInteger(data.getAttribute("record_id"));
	brickKey = FailSafe.forceInteger(data.getAttribute("brick_key"));
	numElement = FailSafe.forceInteger(data.getAttribute("num_element"));
	element = data.getAttribute("element");
    }
    
}
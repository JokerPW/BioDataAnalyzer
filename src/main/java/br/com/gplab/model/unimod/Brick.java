package br.com.gplab.model.unimod;

import org.w3c.dom.Element;

import br.com.gplab.model.unimod.interfaces.IUnimod;
import br.com.gplab.utils.FailSafe;

// <bricks_row full_name="Hydrogen" brick="H" record_id="2"></bricks_row>
public class Brick implements IUnimod {
    
    private int recordID;
    public int getRecordID() { return recordID; }
    public void setRecordID(int recordID) { this.recordID = recordID; }
    
    private String brick;
    public String getBrick() { return brick; }
    public void setBrick(String brick) { this.brick = brick; }
    
    private String fullName;
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    

    public void populate (Element data) {
	recordID = FailSafe.forceInteger(data.getAttribute("record_id"));
	brick = data.getAttribute("brick");
	fullName = data.getAttribute("full_name");
    }
    
}
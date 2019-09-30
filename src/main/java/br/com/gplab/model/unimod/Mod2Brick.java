package br.com.gplab.model.unimod;

import org.w3c.dom.Element;

import br.com.gplab.model.unimod.interfaces.IUnimod;
import br.com.gplab.utils.FailSafe;

// <mod2brick_row num_brick="1" brick="O" record_id="20034" mod_key="1"></mod2brick_row>
public class Mod2Brick implements IUnimod {

    private int recordID;
    public int getRecordID() { return recordID; }
    public void setRecordID(int recordID) { this.recordID = recordID; }

    private String brick;	// brick, from brick
    public String getBrick() { return brick; }
    public void setBrick(String brick) { this.brick = brick; }
    
    private int numBrick;
    public int getNumBrick() { return numBrick; }
    public void setNumBrick(int numBrick) { this.numBrick = numBrick; }
    
    private int modKey;		// recordID, from modification
    public int getModKey() { return modKey; }
    public void setModKey(int modKey) { this.modKey = modKey; }
    
    
    public void populate (Element data) {
	recordID = FailSafe.forceInteger(data.getAttribute("record_id"));
	brick = data.getAttribute("brick");
	numBrick = FailSafe.forceInteger(data.getAttribute("num_brick"));
	modKey = FailSafe.forceInteger(data.getAttribute("mod_key"));
    }
    
}
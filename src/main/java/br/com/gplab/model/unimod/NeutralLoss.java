package br.com.gplab.model.unimod;

import org.w3c.dom.Element;

import br.com.gplab.model.unimod.interfaces.IUnimod;
import br.com.gplab.utils.FailSafe;

// <neutral_losses_row spec_key="6586" num_brick="1" record_id="7708" brick="P"></neutral_losses_row>
public class NeutralLoss implements IUnimod {

    private int recordID;
    public int getRecordID() { return recordID; }
    public void setRecordID(int recordID) { this.recordID = recordID; }
    
    private String brick;	// brick, from brick
    public String getBrick() { return brick; }
    public void setBrick(String brick) { this.brick = brick; }
    
    private int specKey;	// recordID, from spec2nl
    public int getSpecKey() { return specKey; }
    public void setSpecKey(int specKey) { this.specKey = specKey; }
    
    private int numBrick;
    public int getNumBrick() { return numBrick; }
    public void setNumBrick(int numBrick) { this.numBrick = numBrick; }
    

    public void populate (Element data) {
	recordID = FailSafe.forceInteger(data.getAttribute("record_id"));
	brick = data.getAttribute("brick");
	specKey = FailSafe.forceInteger(data.getAttribute("spec_key"));
	numBrick = FailSafe.forceInteger(data.getAttribute("num_brick"));
    }
    
}
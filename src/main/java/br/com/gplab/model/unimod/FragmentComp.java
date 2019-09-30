package br.com.gplab.model.unimod;

import org.w3c.dom.Element;

import br.com.gplab.model.unimod.interfaces.IUnimod;
import br.com.gplab.utils.FailSafe;

// <fragment_comp_row brick="C" record_id="1" num_brick="10" fragments_key="1"></fragment_comp_row>
public class FragmentComp implements IUnimod {

    private int recordID;
    public int getRecordID() { return recordID; }
    public void setRecordID(int recordID) { this.recordID = recordID; }
    
    private String brick;	// Brick, from bricks
    public String getBrick() { return brick; }
    public void setBrick(String brick) { this.brick = brick; }
    
    private int numBrick;
    public int getNumBrick() { return numBrick; }
    public void setNumBrick(int numBrick) { this.numBrick = numBrick; }
    
    private int fragmentsKey;	// recordID, from fragment
    public int getFragmentsKey() { return fragmentsKey; }
    public void setFragmentsKey(int fragmentsKey) { this.fragmentsKey = fragmentsKey; }
    

    public void populate (Element data) {
	recordID = FailSafe.forceInteger(data.getAttribute("record_id"));
	brick = data.getAttribute("brick");
	numBrick = FailSafe.forceInteger(data.getAttribute("num_brick"));
	fragmentsKey = FailSafe.forceInteger(data.getAttribute("fragments_key"));
    }
    
}
package br.com.gplab.model.unimod;

import org.w3c.dom.Element;

import br.com.gplab.model.unimod.interfaces.IUnimod;
import br.com.gplab.utils.FailSafe;

// <positions_row position="-" record_id="1"></positions_row>
public class Position implements IUnimod {

    private int recordID;
    public int getRecordID() { return recordID; }
    public void setRecordID(int recordID) { this.recordID = recordID; }

    private String position;
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    

    public void populate (Element data) {
	recordID = FailSafe.forceInteger(data.getAttribute("record_id"));
	position = data.getAttribute("position");
    }
    
}
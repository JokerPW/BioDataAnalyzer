package br.com.gplab.model.unimod;

import org.w3c.dom.Element;

import br.com.gplab.model.unimod.interfaces.IUnimod;
import br.com.gplab.utils.FailSafe;

// <fragments_row record_id="1" mod_key="12"></fragments_row>
public class Fragment implements IUnimod {

    private int recordID;
    public int getRecordID() { return recordID; }
    public void setRecordID(int recordID) { this.recordID = recordID; }

    private int modKey;	// recordID, from modification
    public int getModKey() { return modKey; }
    public void setModKey(int modKey) { this.modKey = modKey; }

    
    public void populate (Element data) {
	recordID = FailSafe.forceInteger(data.getAttribute("record_id"));
	modKey = FailSafe.forceInteger(data.getAttribute("mod_key"));
    }
    
}
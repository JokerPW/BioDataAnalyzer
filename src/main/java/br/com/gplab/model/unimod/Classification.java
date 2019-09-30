package br.com.gplab.model.unimod;

import org.w3c.dom.Element;

import br.com.gplab.model.unimod.interfaces.IUnimod;
import br.com.gplab.utils.FailSafe;

//<classifications_row record_id="2" classification="Post-translational"></classifications_row>
public class Classification implements IUnimod {

    private int recordID;
    public int getRecordID() { return recordID; }
    public void setRecordID(int recordID) { this.recordID = recordID; }
    
    private String classification;
    public String getClassification() { return classification;     }
    public void setClassification(String classification) { this.classification = classification; }
    

    public void populate (Element data) {
	recordID = FailSafe.forceInteger(data.getAttribute("record_id"));
	classification = data.getAttribute("classification");
    }

}
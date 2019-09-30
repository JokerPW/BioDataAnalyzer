package br.com.gplab.model.unimod;

import br.com.gplab.model.unimod.interfaces.IUnimod;
import br.com.gplab.utils.FailSafe;

// <elements_row record_id="1" avge_mass="1.00794" full_name="Hydrogen" mono_mass="1.007825035" element="H"></elements_row>
public class Element implements IUnimod {

    private int recordID;
    public int getRecordID() { return recordID; }
    public void setRecordID(int recordID) { this.recordID = recordID; }

    private String element;
    public String getElement() { return element; }
    public void setElement(String element) { this.element = element; }
    
    private String fullName;
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    private double avgMass;
    public double getAvgMass() { return avgMass; }
    public void setAvgMass(double avgMass) { this.avgMass = avgMass; }
    
    private double monoMass;
    public double getMonoMass() { return monoMass; }
    public void setMonoMass(double monoMass) { this.monoMass = monoMass; }
    

    public void populate (org.w3c.dom.Element data) {
	recordID = FailSafe.forceInteger(data.getAttribute("record_id"));
	element = data.getAttribute("element");
	fullName = data.getAttribute("full_name");
	avgMass = FailSafe.forceDouble(data.getAttribute("avge_mass"));
	monoMass = FailSafe.forceDouble(data.getAttribute("mono_mass"));
    }
    
}
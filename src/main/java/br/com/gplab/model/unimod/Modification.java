package br.com.gplab.model.unimod;

import org.w3c.dom.Element;

import br.com.gplab.model.unimod.interfaces.IUnimod;
import br.com.gplab.utils.FailSafe;

// <modifications_row group_of_poster="admin" record_id="5" ex_code_name="Carbamyl" code_name="Carbamyl" username_of_poster="unimod" approved="0" date_time_modified="2011-11-21 13:06:47" composition="H C N O" date_time_posted="2002-08-19 19:17:11" mono_mass="43.005814" avge_mass="43.0247" full_name="Carbamylation">
//	<misc_notes>Carbamylation is an irreversible process of non-enzymatic modification of proteins by the breakdown products of urea isocyanic acid reacts with the N-term of a proteine or side chains of lysine and arginine residues</misc_notes>
// </modifications_row>
public class Modification implements IUnimod {

    private int recordID;	// Accession
    public int getRecordID() { return recordID; }
    public void setRecordID(int recordID) { this.recordID = recordID; }
    
    private String fullName;
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    private String codeName;
    public String getCodeName() { return codeName; }
    public void setCodeName(String codeName) { this.codeName = codeName; }
    
    private String exCodeName;
    public String getExCodeName() { return exCodeName; }
    public void setExCodeName(String exCodeName) { this.exCodeName = exCodeName; }
    
    private String composition;
    public String getComposition() { return composition; }
    public void setComposition(String composition) { this.composition = composition; }
    
    private String notes;
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    
    private double avgMass;
    public double getAvgMass() { return avgMass; }
    public void setAvgMass(double avgMass) { this.avgMass = avgMass; }
    
    private double monoMass;
    public double getMonoMass() { return monoMass; }
    public void setMonoMass(double monoMass) { this.monoMass = monoMass; }
    
    
    public void populate (Element data) {
	recordID = FailSafe.forceInteger(data.getAttribute("record_id"));
	fullName = data.getAttribute("full_name");
	codeName = data.getAttribute("code_name");
	exCodeName = data.getAttribute("ex_code_name");
	composition = data.getAttribute("composition");
	notes = data.getElementsByTagName("misc_notes").item(0).getNodeValue();
	avgMass = FailSafe.forceDouble(data.getAttribute("avge_mass"));
	monoMass = FailSafe.forceDouble(data.getAttribute("mono_mass"));
    }
    
}
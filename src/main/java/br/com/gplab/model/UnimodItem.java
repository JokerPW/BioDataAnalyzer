package br.com.gplab.model;

import java.util.ArrayList;

public class UnimodItem {

    
    private int accession;
    public int getAccession() { return accession; }
    public void setAccession(int accession) { this.accession = accession; }

    private String psiMsName;
    public String getPsiMsName() { return psiMsName; }
    public void setPsiMsName(String psiMsName) { this.psiMsName = psiMsName; }

    private String interimName;
    public String getInterimName() { return interimName; }
    public void setInterimName(String interimName) { this.interimName = interimName; }

    private String description;
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    private double monoisotopicMass;
    public double getMonoisotopicMass() { return monoisotopicMass; }
    public void setMonoisotopicMass(double monoisotopicMass) { this.monoisotopicMass = monoisotopicMass; }
    
    private double averageMass;
    public double getAverageMass() { return averageMass; }
    public void setAverageMass(double averageMass) { this.averageMass = averageMass; }
    
    private String composition;
    public String getComposition() { return composition; }
    public void setComposition(String composition) { this.composition = composition; }
    
    private ArrayList<Specificity> specificities;
    public ArrayList<Specificity> getSpecificities() { return specificities; }
    public void setSpecificities(ArrayList<Specificity> specificities) { this.specificities = specificities; }
    

    public UnimodItem() {
	specificities = new ArrayList<Specificity>();
    }
    
    
    public void addSpecificity(String site, String position, String classification) {
	specificities.add(new Specificity(site, position, classification));
    }
    
    @Override
    public String toString() {
	
	String ret = "";
	for (Specificity spec : specificities) {
	    ret = " " + ret + spec.toString();
	}
	
	return "accession: " + accession + 
		" psiMsName: " + psiMsName +
		" interimName: " + interimName +
		" description: " + description +
		" monoisotopicMass: " + monoisotopicMass +
		" averageMass: " + averageMass +
		" composition: " + composition + ret;
    }
    
}
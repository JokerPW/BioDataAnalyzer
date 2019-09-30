package br.com.gplab.model;

public class Specificity {
    
    private String site;
    public String getSite() { return site; }
    public void setSite(String site) { this.site = site; }
    
    private String position;
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    private String classification;
    public String getClassification() { return classification;     }
    public void setClassification(String classification) { this.classification = classification; }
    
    
    public Specificity(String site, String position, String classification) {
	this.site = site;
	this.position = position;
	this.classification = classification;
    }
    
    
    @Override
    public String toString() {
	return "site: " + site + " position: " + position + " classification: " + classification;
    }
    
}
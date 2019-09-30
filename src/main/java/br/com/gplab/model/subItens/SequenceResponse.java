package br.com.gplab.model.subItens;

public class SequenceResponse {
    
    private int position;
    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position; }

    private String pID;
    public String getpID() { return pID; }
    public void setpID(String pID) { this.pID = pID; }
    
    
    public SequenceResponse(int position, String pID) {
	this.position = position;
	this.pID = pID;
    }

}
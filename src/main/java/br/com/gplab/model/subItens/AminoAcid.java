package br.com.gplab.model.subItens;

public class AminoAcid {

    public static enum modifications{
	N, C, M;
    }
    
    private String sequence;
    public String getSequence() { return sequence; }
    public void setSequence(String sequence) { this.sequence = sequence; }
    
    private double mass;
    public double getMass() { return mass; }
    public void setMass(double mass) { this.mass = mass; }
    
    private modifications modification;
    public modifications getModification() { return modification; }
    public void setModification(modifications modification) { this.modification = modification; }

    
    public AminoAcid(String sequence, String mass) {
	this.sequence = sequence;
	
	if (mass != null && mass.length() > 0)
	    this.mass = new Double (mass);
	
	testLastLetter(sequence);
    }
    
    private void testLastLetter(String sequence) {
	char last = sequence.charAt(sequence.length() -1);
	
	switch(last) {
	    case 'N': modification = modifications.N; break;
	    case 'C': modification = modifications.C; break;
	    case 'M': modification = modifications.M; break;
	    default: modification = modifications.N;
	}
    }
    
    @Override
    public String toString() {
	return sequence + "[+" + mass + "]";
    }
    
    public void dispose() {
	sequence = null;
	modification = null;
    }
    
}
package br.com.gplab.model.subItens;

//A(0.01
public class DPProbability {
    
    private String a;
    public String getA() { return a; }
    public void setA(String a) { this.a = a; }
    
    private Double b;
    public Double getB() { return b; }
    public void setB(Double b) { this.b = b; }
    
    
    public DPProbability(String data) {
	
	if(data.indexOf("(") >= 0) {
	    String[] cut1 = data.replace("(", "@").split("@");
	    a = cut1[0];
	    b = Double.parseDouble(cut1[1]);
	} else {
	    a = data;
	    b = 0.0;
	}
	
    }
    
}
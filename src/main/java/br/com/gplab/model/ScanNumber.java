package br.com.gplab.model;

//controllerType=0 controllerNumber=1 scan=12907
public class ScanNumber {
    
    private int controllerType;
    public int getControllerType() { return controllerType; }
    public void setControllerType(int controllerType) { this.controllerType = controllerType; }
    
    private int controllerNumber;
    public int getControllerNumber() { return controllerNumber; }
    public void setControllerNumber(int controllerNumber) { this.controllerNumber = controllerNumber; }
    
    private int scan;
    public int getScan() { return scan; }
    public void setScan(int scan) { this.scan = scan; }
    
    
    public ScanNumber(String data) {
	//System.out.println("==== SCAN NUMBER: " + data);
	if (data.indexOf("=") < 0) {
	    controllerType = 0;
	    controllerNumber = 1;
	    scan = Integer.MAX_VALUE;
	    return;
	}
	
	String[] cut1 = data.split(" ");
	
	String[] cut2 = cut1[0].split("=");
	controllerType = Integer.parseInt(cut2[1]);
	
	cut2 = cut1[1].split("=");
	controllerNumber = Integer.parseInt(cut2[1]);
	
	cut2 = cut1[2].split("=");
	scan = Integer.parseInt(cut2[1]);
	
    }//--- End: Constructor
    
    
    @Override
    public String toString() {
	return "controllerType=" + getControllerType() + " controllerNumber=" + getControllerNumber() + " scan=" + getScan();
    }
    
}
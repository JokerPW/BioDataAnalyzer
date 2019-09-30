package br.com.gplab.utils;

public class FailSafe {
    
    public static Double forceDouble(String data) {
	if (data.length() <= 0)
	    return 0.0;
	
	try {
	    return Double.parseDouble(data);
	} catch (Error e) {
	    return 0.0;
	}
    }

    public static int forceInteger(String data) {
	if (data.length() <= 0)
	    return 0;
	
	try {
	    return Integer.parseInt(data);
	} catch (Error e) {
	    return 0;
	}
    }
    
    public static boolean testIndex(int ndx, String[] data) {
	
	if (ndx < 0)
	    return false;
	
	if (ndx >= data.length)
	    return false;
	
	return true;
    }
    
}
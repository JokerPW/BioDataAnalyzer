package br.com.gplab.model.unimod.interfaces;

import org.w3c.dom.Element;

public interface IUnimod {
    
    int getRecordID();
    void populate(Element data);
    
}
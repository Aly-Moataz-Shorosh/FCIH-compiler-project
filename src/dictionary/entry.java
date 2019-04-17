/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author user
 */
public class entry {
    private String Key="";
    private String value="" ;
    
    public void put(String key , String value)
    {
        this.Key = key;
        this.value = value;
    }
    
    public String getKey()
    {
        return this.Key;
    }
    
    public String getValue()
    {
        return this.value;
    }
    
    public void setValue(String value)
    {
        this.value = value;
    }
    
    public void setkey(String key)
    {
        this.value = key;
    }
    
}

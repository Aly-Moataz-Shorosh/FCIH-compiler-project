/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;
import dictionary.entry;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */
public class dictionary {
    
    List<entry> entries ;
    
    public dictionary()
    {
         entries = new ArrayList<>();
    }
    
    public void put(String key , String value)
    {
        entry entry = new entry();
        entry.put(key, value);
        
        entries.add(entry);
    }
    
    public String get(String key)
    {
        
        for(int i=0;i<entries.size();i++)
        {
            if(key.endsWith(entries.get(i).getKey()))
            {
                return entries.get(i).getValue();
            }
        }
        return null;
    }
    
    public String remove (String key)
    {
        
        for(int i=0;i<entries.size();i++)
        {
            if(key == entries.get(i).getKey())
            {
                String temp = entries.get(i).getValue();
                entries.remove(i);
                return temp;
            }
        }
        return null;
    }
    
    public Boolean set (String key , String value)
    {
        
        for(int i=0;i<entries.size();i++)
        {
            if(key == entries.get(i).getKey())
            {
                entries.get(i).setValue(value);
                return true ;
            }
        }
        return false;
    }
    
}

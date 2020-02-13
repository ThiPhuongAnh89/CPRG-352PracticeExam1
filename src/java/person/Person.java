/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import java.io.Serializable;

/**
 *
 * @author 787900
 */
public class Person implements Serializable{

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
  
    private String name;
    private  int age;
    public Person(String name, int age)
    {
        this.name=name;
        this.age= age;
    }
    
    public Person()
    {
        this.name="";
        this.age= 0;
    }
    
    
}
   
// java Bean: 3 thing - 

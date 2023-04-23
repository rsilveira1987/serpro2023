package models;

import java.util.HashMap; 
import java.util.Map;     

public class Pessoa {

    public static final String CN_NAME = "name";
    
    private String firstName;
    private String secondName;
    private String email;

    public Pessoa() {}

    public Pessoa(String firstName, String secondName, String email) {
        this.setFirstName(firstName);
        this.setSecondName(secondName);
        this.setEmail(email);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getSecondName() + "(" + this.getEmail() + ")";
    }

    public Map toMap() {
        Map<String, String> m = new HashMap<String, String>();
        m.put("first_name",this.getFirstName());
        m.put("second_name",this.getSecondName());
        m.put("email",this.getEmail());
        return m;
    }

    public static Pessoa fromMap(Map<String,String> m) {
        Pessoa p = new Pessoa();
        p.setFirstName(m.get("first_name"));
        p.setSecondName(m.get("second_name"));
        p.setEmail(m.get("email"));

        return p;
    }

}


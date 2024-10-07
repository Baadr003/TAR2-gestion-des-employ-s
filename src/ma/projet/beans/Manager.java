/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Manager extends Personne {

     private List<Personne> emp;

    public Manager() {
        emp = new ArrayList<>();
    }

    public Manager(String nom, double salaire) {
        super(nom, salaire);
        emp = new ArrayList<>();
    }

    public List<Personne> getEmp() {
        return emp;
    }

    public void setEmp(List<Personne> emp) {
        this.emp = emp;
    }

    public void addEmp(Personne p) {
        emp.add(p);
    }
}
   


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversityTesting;

import Universities.Nacional;
import Universities.Javeriana;
import Universities.Distrital;

/**
 *
 * @author Luis Miguel Castellanos 20162020084
 */
public class UniversityFactory {

    public UniversityFactory() {
    }

    public AbstractU createU(String typeOfUniversity) {
        AbstractU newU = null;
        //System.out.println("entrada: "+typeOfUniversity);
        if (typeOfUniversity.equals("D")) {
            return new Distrital();
        } else if (typeOfUniversity.equals("J")) {
            return new Javeriana();
        } else if (typeOfUniversity.equals("N")) {
            return new Nacional();
        } else {
            return null;
        }
    }

}

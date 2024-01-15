/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CareersTesting;

import Careers.Arquitectura;
import Careers.Medicina;
import Careers.Derecho;

/**
 *
 * @author Luis Miguel Castellanos 20162020084
 */
public class CareerFactory {

    public CareerFactory() {
    }

    public AbstractC createC(String typeOfCareer, String typeOfUniversity) {
        AbstractC newC = null;
        if (typeOfUniversity.equals("J")) {
            if (typeOfCareer.equals("D")) {
                return new Derecho();
            } else if (typeOfCareer.equals("M")) {
                return new Medicina();
            } else if (typeOfCareer.equals("A")) {
                return new Arquitectura();
            } else {
                return null;
            }
        } else if (typeOfUniversity.equals("N")) {
            if (typeOfCareer.equals("M")) {
                return new Medicina();
            } else if (typeOfCareer.equals("A")) {
                return new Arquitectura();
            } else {
                return null;
            }
        } else if (typeOfUniversity.equals("D")) {
            if (typeOfCareer.equals("A")) {
                return new Arquitectura();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}

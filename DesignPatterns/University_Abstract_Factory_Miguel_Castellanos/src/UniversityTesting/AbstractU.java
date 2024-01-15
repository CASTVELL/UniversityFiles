/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversityTesting;

import CareersTesting.AbstractC;

/**
 *
 * @author Luis Miguel Castellanos 20162020084
 */
public class AbstractU {

    private String name;
    private String carrera;
    private AbstractC absCarrera;

    public String getName() {
        return name;
    }

    public AbstractC getAbsCarrera() {
        return absCarrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setAbsCarrera(AbstractC absCarrera) {
        this.absCarrera = absCarrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setName(String name) {
        this.name = name;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Universities.*;

/**
 *
 * @author estudiantes
 */
public class ServiciosUniversidad {

    String servicios = null,U=null;

    public String service() {
        servicios = null;
        System.out.println(U+" todobien");
        switch ("J") {
            case "J":
                servicios = "Hospital San Ignacio";
                break;
            case "N":
                servicios = "Biblioteca General";
                break;
            case "D":
                servicios = "";
                break;
            default:
                break;
        }

        return servicios;

    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

}

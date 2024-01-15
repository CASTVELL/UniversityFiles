/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import CareersTesting.AbstractC;
import CareersTesting.CareerFactory;
import UniversityTesting.AbstractU;
import UniversityTesting.UniversityFactory;
import java.util.Scanner;
import Services.ServiciosUniversidad;

/**
 *
 * @author Luis Miguel Castellanos Alvarado 20162020084
 */
public class Client {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String typeOfCareer = null, typeOfUniversity = null,servicios= "Biblioteca General";
        
        //create Services
        ServiciosUniversidad servi = null;

        //create the factory object
        UniversityFactory uFactory = new UniversityFactory();
        CareerFactory cFactory = new CareerFactory();

        //Abstract object
        AbstractU theUniversity = null;

        Scanner userInput = new Scanner(System.in);
        System.out.println("\nEscoja la universidad para mostrar sus carreras\n" + "D:Distrital\n" + "N:Nacional\n" + "J:Javeriana\n");

        if (userInput.hasNextLine()) {
            typeOfUniversity = userInput.nextLine();
            if (typeOfUniversity.equals(null)) {
                System.out.println("\nEscoja una universidad valida.");
            } else {
                //servicios= servi.service();
                theUniversity = uFactory.createU(typeOfUniversity);
                System.out.println(typeOfUniversity);                               
                
                System.out.println("\nUniversidad " + theUniversity.getName() + "\n" + theUniversity.getCarrera());
            }
        }
        System.out.println("\nEscoja la carrera entre las disponibles");
        if (userInput.hasNextLine()) {
            typeOfCareer = userInput.nextLine();
            if (typeOfCareer.equals(null)) {
                System.out.println("\nEscoja una carrera valida.");
            } else {
                theUniversity.setAbsCarrera(cFactory.createC(typeOfCareer, typeOfUniversity));              
                System.out.println("\nCarrera " + theUniversity.getAbsCarrera().getName() + " en Univeridad " + theUniversity.getName());
                
                
                System.out.println("\nServicios Disponibles: \n"+servicios);
            }
        }
    }
}

package def;

import clases.Asignatura;
import clases.Estudiante;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author estudiantes
 */
//estudiante
//  -materias vistas
//materia
//  -prerequisitos(materias)
//check estudiante
//checar si ya vio 1 materia
//checar si puede inscribir 1 materia
//  -compara todos los prerequisitos de la materia
public class Facade {

    private int codigo;
    String[] a={"ingles","español","frances","diferencial","integral"};
    String[] b={"ingles","español","frances","diferencial","integral"};
    checkStudent studentChecker;
    checkAssignature assignatureChecker;
    checkAddAssignature addAssignatureChecker = new checkAddAssignature(b);
    Estudiante e;
    Asignatura as;

    public Facade(String assig) {
        
        e = new Estudiante(a);        
        
        studentChecker = new checkStudent();
        assignatureChecker = new checkAssignature();
        addAssignatureChecker = new checkAddAssignature(b);
        
        this.agregarMateria(assig);
        
    }

    public int getCodigo() {
        return codigo;
    }
    
    public void agregarMateria(String materiaToAdd){
        if(assignatureChecker.checkAssignature(materiaToAdd,e.getMateriasVistas())==false) {
            
            if(addAssignatureChecker.checkAssignature(
            e.getMateriasVistas())==true){
                
            }
            
            
        }
    }
    
}

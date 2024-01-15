package def;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author estudiantes
 */
public class checkAssignature {
    private String[] materias=new String[5];

    public String[] getMaterias() {
        return materias;
    }

    public void setMaterias(String[] materias) {
        this.materias = materias;
    }
    
    private int getLast(){
        return materias.length;
    }
    
    public void addMateria(String materiaToAdd){
        materias[getLast()]=materiaToAdd;
    }
    
    public Boolean checkAssignature(String materiaToCheck, String[] mV){
        materias=mV;
        for(int i=0;i<getLast();i++){
            
            if(materias[getLast()-1-i]==materiaToCheck){
                
                System.out.println("La materia ya se vio");
                return true;
            }           
        }
        System.out.println("La materia no se ha visto");
        return false;
    }
}

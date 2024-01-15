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
public class checkStudent {
    private int code = 12345678;
    private String[] materiasActuales;    
    
    public int getCode() {
        return code;
    }

    public String[] getMateriasActuales() {
        return materiasActuales;
    }   
    
    public boolean compareCode(int codeToCompare){
        if(codeToCompare == code){
            System.out.println("Estudiante Valido");
            return true;
        }else{
            System.out.println("Estudiante Invalido");
            return false;
        }
    }
}

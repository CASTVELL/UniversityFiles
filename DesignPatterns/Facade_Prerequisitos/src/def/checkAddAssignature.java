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
public class checkAddAssignature {
    private String[] pre;

    public String[] getPre() {
        return pre;
    }
    
    public checkAddAssignature(String[] preRequistos){
        pre= preRequistos;
    }
    
    
    public Boolean checkAssignature(String[] materiasVistas){
        
        boolean[] check = new boolean[5];
        boolean fin= false;
        
        for(int i=0;i<pre.length;i++){           
            
            for(int j=0;j<materiasVistas.length;j++){
                //System.out.println(pre[i]+" =  "+materiasVistas[j]);
                if(pre[i]==materiasVistas[j]){
                    
                    
                    check[i]=true;
                    break;
                }else{
                    
                    check[i]= false;
                }
            }
            //System.out.println(check[i]);
        }
        
        for(int k=0;k<check.length;k++){
            //System.out.println(check[k]);
            if(check[k] == true){
                fin=true;               
            }else{
                fin =false;
                break;
            }
        }
        //System.out.println("    -"+   fin);
        if(fin == true){
            System.out.println("se puede preinscribir");
        }else{
            System.out.println("no se puede preinscribir");
        }
        
        return fin;
    } 
}

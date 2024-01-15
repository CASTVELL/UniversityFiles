var str="";
        
var sud=new Array(9);
            for(var i = 0; i < 9; i++){
                sud[i] = new Array(9); 
            }
        function generarSudoku(){
           
            str="sudoku( ";
            
            
            for(var i = 0; i < 9; i++){
                for(var j = 0; j < 9; j++){

                    if(Math.random()*10 > 5){ // Si cambias el 5 es decir lo incrementas es mas dificil y si lo disminuyes mas complicado
                        rellenarCelda( i, j);
                    }else{

                        sud[i][j] = "_";

                    }

                   
                    str+=sud[i][j];
                    if(!(i==8 && j==8)){
                        str+=",";

                    }


                    
                       
                    
                    
                }
            }

            str+=").";
            
        }


        function rellenarCelda(i , j){
            var num = parseInt((Math.random()*9)+1);
            if(comprobarCasilla(num,i,j) == false){
                sud[i][j] = "_";
            }else{
                sud[i][j] = num;
            }
           

        }

        function comprobarCasilla( num, i, j){
            var contA=0;
            // comprobacion fila
            for(var k = 0; k < j; k++){
                if(sud[i][k] == num){
                    contA++;
                    return false;
                    break;
                }
            }

            //comprobacion columna 

            for(var k = 0; k < i; k++){
                if(sud[k][j] == num){
                    contA++;
                    return false;
                    break;
                }
            }

            

            //comrpobacion cuadricula 
            
            var iniA=parseInt((Math.trunc(i/3))*(3));
            var iniB=parseInt((Math.trunc(j/3))*(3));

            var finA=iniA+3;
            var finB=iniB+3;
            //alert("pos a ubicarse "+iniA+","+iniB+" ubi "+i+","+j+" num: "+num );
            for( iniA; iniA < i ; iniA+=1){
                for( iniB; iniB <finB; iniB+=1){
                        //alert("posI"+i+","+j+" posCopia "+iniA+","+iniB+" num: "+num );
                        if( sud[iniA][iniB] ==  num){
                            contA++;
                            return false;
                            break;
                            

                        }
                

                    
                }
                iniB=parseInt((Math.trunc(j/3))*(3));

           }
 
        }

        function imprimirSudoku(){
            
            var cont=0;
            for(var i = 0; i < 9; i++){
                for(var j = 0; j < 9; j++){
                    
                    if (sud[i][j]=="_") {
                        document.getElementById("cell-"+cont).value="";
                    }else{
                        document.getElementById("cell-"+cont).value=sud[i][j];  
                    }

                    cont++;

                }
            }


        }

    

      
          


        

<?php 

			$valor=$_POST['sudo'];
			$output = `swipl -s sudoku.pl -g "$valor" -t halt.`;
			/*if ($output=="") {
				  trigger_error("Error", E_USER_ERROR);
			}else{
				echo $output;
			}*/
            
            if($output!=""){
            	echo $output;

            }else{
            	echo "vacio";
            }


            //header('Location: sudo.php?output='.$output.'');

           ?>
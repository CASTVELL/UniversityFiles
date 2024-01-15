package gfgfyh;

import java.util.ArrayList;

public class ArrTeam {
		ArrayList<Team> a = new ArrayList<Team>();
		String Title[]={"Equipo", "Puntos"};
		Object[][] data= new Object[10][2];
		
		void llenar(){

		}
		
		void Agregar(Team e){
			a.add(e);
		}
		
		void Actualizar(String n, int p){
			for(int i=0;i<a.size();i++){
				if(a.get(i).Nombre==n){
					a.get(i).Puntos=a.get(i).Puntos+p;
					System.out.println(n);
					break;
				}
			}
			
		}
		
		void Ordenar(){
			int temp;
			for(int i=0;i<a.size()-1;i++){
				 for(int j=i+1;j<a.size();j++){
		                if(a.get(i).Puntos>a.get(j).Puntos){
		                    //Intercambiamos valores
		                    temp=a.get(i).Puntos;
		                    a.get(i).Puntos=a.get(j).Puntos;
		                    a.get(i).Puntos=temp;
		 
		                }
		            }
		        }
			
		}
}
------------------------------------
package gfgfyh;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Principal extends JFrame implements ActionListener{
	JTextField Text_E1 = new JTextField("Equipo 1");
	JTextField Text_E2 = new JTextField("Equipo 2");
	JTextField Text_P1 = new JTextField();
	JTextField Text_P2 = new JTextField();
	String nom ="";
	
	JLabel NE1 = new JLabel(nom);
	JLabel NE2 = new JLabel(nom);
	JLabel NE3 = new JLabel(nom);
	JLabel NE10 = new JLabel(nom);
	JLabel NE4 = new JLabel(nom);
	JLabel NE5 = new JLabel(nom);
	JLabel NE6 = new JLabel(nom);
	JLabel NE7 = new JLabel(nom);
	JLabel NE8 = new JLabel(nom);
	JLabel NE9 = new JLabel(nom);
	
	JLabel PE1 = new JLabel(nom);
	JLabel PE2 = new JLabel(nom);
	JLabel PE3 = new JLabel(nom);
	JLabel PE10 = new JLabel(nom);
	JLabel PE4 = new JLabel(nom);
	JLabel PE5 = new JLabel();
	JLabel PE6 = new JLabel();
	JLabel PE7 = new JLabel();
	JLabel PE8 = new JLabel();
	JLabel PE9 = new JLabel();
	
	JButton boton = new JButton();
	static JPanel gg = new JPanel();
	static ArrTeam arr= new ArrTeam();

	Principal(){
		this.setVisible(true);
		this.setSize(540, 500);
		
		gg.setSize(400, 200);
		gg.setLayout(null);
		gg.add(Text_E1);
		gg.add(Text_E2);
		gg.add(Text_P1);
		gg.add(Text_P2);
		gg.add(boton);
		gg.add(NE1);
		gg.add(NE2);
		gg.add(NE3);
		gg.add(NE4);
		gg.add(NE5);
		gg.add(NE6);
		gg.add(NE7);
		gg.add(NE8);
		gg.add(NE9);
		gg.add(NE10);
		gg.add(PE1);
		gg.add(PE2);
		gg.add(PE3);
		gg.add(PE4);
		gg.add(PE5);
		gg.add(PE6);
		gg.add(PE7);
		gg.add(PE8);
		gg.add(PE9);
		gg.add(PE10);
		
		Text_E1.setBounds(10, 10, 200, 20);
		Text_E2.setBounds(10, 40, 200, 20);
		Text_P1.setBounds(300, 10, 200, 20);
		Text_P2.setBounds(300, 40, 200, 20);
		
		NE1.setBounds(100, 150, 200, 20);
		NE2.setBounds(100, 175, 200, 20);
		NE3.setBounds(100, 200, 200, 20);
		NE4.setBounds(100, 225, 200, 20);
		NE5.setBounds(100, 250, 200, 20);
		NE6.setBounds(100, 275, 200, 20);
		NE7.setBounds(100, 300, 200, 20);
		NE8.setBounds(100, 325, 200, 20);
		NE9.setBounds(100, 350, 200, 20);
		NE10.setBounds(100, 375, 200, 20);
		
		PE1.setBounds(300, 150, 200, 20);
		PE2.setBounds(300, 175, 200, 20);
		PE3.setBounds(300, 200, 200, 20);
		PE4.setBounds(300, 225, 200, 20);
		PE5.setBounds(300, 250, 200, 20);
		PE6.setBounds(300, 275, 200, 20);
		PE7.setBounds(300, 300, 200, 20);
		PE8.setBounds(300, 325, 200, 20);
		PE9.setBounds(300, 350, 200, 20);
		PE10.setBounds(300, 375, 200, 20);
		
		
		boton.setBounds(225, 100, 60, 20);
		boton.addActionListener(this);
		
		this.add(gg);
		
	}
	
	public static void main(String[] args) {
		Principal k=new Principal();
		//equipos
			arr.Agregar(new Team("Brasil", 36));
			arr.Agregar(new Team("Colombia", 25));
			arr.Agregar(new Team("Uruguay", 24));
			arr.Agregar(new Team("Chile", 23));
			arr.Agregar(new Team("Argentina", 23));
			arr.Agregar(new Team("Peru", 21));
			arr.Agregar(new Team("Paraguay", 21));
			arr.Agregar(new Team("Ecuador", 20));
			arr.Agregar(new Team("Bolivia", 10));
			arr.Agregar(new Team("Venezuela", 7));
		//TABLA
			//ASIGNAR ARRDATA
			k.ActualizarText();
	}
	
	void ActualizarText(){
		NE1.setText(arr.a.get(0).Nombre);
		NE2.setText(arr.a.get(1).Nombre);
		NE3.setText(arr.a.get(2).Nombre);
		NE4.setText(arr.a.get(3).Nombre);
		NE5.setText(arr.a.get(4).Nombre);
		NE6.setText(arr.a.get(5).Nombre);
		NE7.setText(arr.a.get(6).Nombre);
		NE8.setText(arr.a.get(7).Nombre);
		NE9.setText(arr.a.get(8).Nombre);
		NE10.setText(arr.a.get(9).Nombre);
		
		PE1.setText(Integer.toString(arr.a.get(0).Puntos));
		PE2.setText(Integer.toString(arr.a.get(1).Puntos));
		PE3.setText(Integer.toString(arr.a.get(2).Puntos));
		PE4.setText(Integer.toString(arr.a.get(3).Puntos));
		PE5.setText(Integer.toString(arr.a.get(4).Puntos));
		PE6.setText(Integer.toString(arr.a.get(5).Puntos));
		PE7.setText(Integer.toString(arr.a.get(6).Puntos));
		PE8.setText(Integer.toString(arr.a.get(7).Puntos));
		PE9.setText(Integer.toString(arr.a.get(8).Puntos));
		PE10.setText(Integer.toString(arr.a.get(9).Puntos));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(Integer.parseInt(Text_P1.getText())!=0 && Integer.parseInt(Text_P2.getText())!=0){
			arr.Actualizar(Text_E1.getText(),Integer.parseInt(Text_P1.getText()));
			arr.Actualizar(Text_E2.getText(),Integer.parseInt(Text_P2.getText()));
			arr.Ordenar();
			ActualizarText();
		}
	}

}
------------------------------------
package gfgfyh;

public class Team {
	String Nombre;
	int Puntos;
	
	Team(String a, int num){
		this.Nombre=a;
		this.Puntos=num;
	}
	
	String GetNombre(){
		return this.Nombre;
	}
	
	int GetPuntos(){
		return this.Puntos;
	}
}
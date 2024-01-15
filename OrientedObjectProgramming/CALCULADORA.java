package calc;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class calculadora extends JFrame implements ActionListener {

	JLabel texto = new JLabel("<html>Ingrese numero entero<br><br><br>Ingrese numero float</html>");
	JTextField jtentero = new JTextField();
	JTextField jtfloat = new JTextField();
	JButton btnleer = new JButton("ingresar datos");
	JButton btncalcular = new JButton("CALCULAR");
	JLabel resultadoBin=new JLabel("ent binario: ");
	JLabel resultadoBinF= new JLabel("decimal binario: ");
	
	Agrega ag = new Agrega();
	
	public static void main(String[] args) {
		calculadora m = new calculadora();
		m.setSize(600, 500);
		m.setVisible(true);
		
	}
	
	calculadora(){
		Container c = getContentPane();
		c.setLayout(null);
		c.add(texto);
		texto.setBounds(30, 50, 200, 60);
		c.add(jtentero);
		jtentero.setBounds(300, 40, 100, 30);
		c.add(jtfloat);
		jtfloat.setBounds(300, 80, 100, 30);
		c.add(btnleer);
		btnleer.addActionListener(this);
		btnleer.setBounds(30, 150,150, 40);
		c.add(btncalcular);
		btncalcular.addActionListener(this);
		btncalcular.setBounds(250, 150,150, 40);
		c.add(resultadoBin);
		resultadoBin.setBounds(30, 250, 300, 40);
		c.add(resultadoBinF);
		resultadoBinF.setBounds(30, 350, 500, 40);
	}
	
	public void actionPerformed(ActionEvent e1) {
		
		if(e1.getSource()==btnleer) {
		
			int entero=Integer.parseInt(jtentero.getText());
			float decimal= Float.parseFloat(jtfloat.getText());
			Binario  bin = new Binario(entero);
			IEEE ieee = new IEEE(decimal);
			ag.agregarBinario(bin);
			ag.agregarBinarioF(ieee);
			JOptionPane.showMessageDialog(null, "Numeros agregados");
			jtentero.setText(null);
			jtfloat.setText(null);
			
		}
		if (e1.getSource()==btncalcular) {
			ag.calcularBinario();
			ag.calcularBinarioF();
			resultadoBin.setText(ag.bin.x+" en binario: "+ag.devolverBinario());
			resultadoBinF.setText(ag.ieee.x+"  en binario: "+ag.devolverBinarioF());
			
		} 
	}

	class Binario{
		int x;
		String r="";
		Binario(){
			
		}
		Binario(int x){
			this.x=x;		
		}
		void ConvertirBi() {
			ArrayList<String> binario = new ArrayList<String>();
			int resto;
			int num=x;
			
			do {
				resto=x%2;
				num=num/2;
				binario.add(0,Integer.toString(resto));
			}while (num>=2);
			binario.add(0,Integer.toString(num));
			
			for(int i=0; i<binario.size();i++) {
				r+=binario.get(i);
			}
		}
		String devolverString() {
			
			return this.r;
		}
		
	}
	
	class IEEE{
		float x;
		String r = "";
		
		IEEE(float f){
			this.x=f;
		}
		public IEEE() {
			
		}
		void ConvertirBiF() {
			int resto;
			int exponente=0;
			
			int[] binarioEnt = new int[30];
		   String[] binarioIEEE = new String[32];
			
		   if (x<0) {
			   binarioIEEE[0]="1";
			   this.x=this.x*-1;
		   }
		   else binarioIEEE[0]="0";
		   
			int entero=(int)x;
			float decimal = x-entero;
			int k=binarioEnt.length-1;
		
			
		
			do {
				
				resto=entero%2;
				entero=entero/2;
				System.out.print("El resto va dando "+ resto);
				binarioEnt[k]=resto;
				k--;
				exponente++;
			}while (entero>=2);
			if((int)x ==1){
				
			}
			else{
			binarioEnt[k]=1;
			}
			if((int)x==0){
				
			}
			
			for(int i =0;i<binarioEnt.length;i++ ) {
				System.out.print(binarioEnt[i]);
			}
			
			
			int posprimeruno=0;
			k=0;
			while(binarioEnt[k]!=1) {
				k++;
				if(binarioEnt[k]==1) {
					posprimeruno=k+1;
				}
					
			}
			
			if((int)x==1){
				exponente=0;
				exponente=exponente+127;
				int cont=9;
				do {
					cont--;
					resto=exponente%2;
					exponente=exponente/2;
					binarioIEEE[cont]=Integer.toString(resto);
					
				}while (exponente>=2);
				binarioIEEE[1]=Integer.toString(0);
				binarioIEEE[2]=Integer.toString(1);
				System.out.print("POS PRMRER UN "+posprimeruno);
				cont=9;
				for(int i=posprimeruno; i<binarioEnt.length;i++) {
					
					binarioIEEE[cont]=Integer.toString(binarioEnt[i]);
					cont++;
				}
			
				for(int i=cont;i<32;i++) {
					decimal=decimal*2;
					int ent = (int)decimal;
					decimal=decimal-ent;
					decimal=decimal*2;
					binarioIEEE[i]=Integer.toString(ent);
				}
				
			}
			
			else{
				exponente=exponente+127;
				int cont=9;
				do {
					cont--;
					resto=exponente%2;
					exponente=exponente/2;
					binarioIEEE[cont]=Integer.toString(resto);
					
				}while (exponente>=2);
				binarioIEEE[1]=Integer.toString(exponente);
				
				System.out.print("POS PRiMRER UNO"
						+ " "+posprimeruno);
				cont=9;
				for(int i=posprimeruno; i<binarioEnt.length;i++) {
					
					binarioIEEE[cont]=Integer.toString(binarioEnt[i]);
					cont++;
				}
			
				for(int i=cont;i<32;i++) {
					decimal=decimal*2;
					int ent = (int)decimal;
					decimal=decimal-ent;
					//decimal=decimal*2;
					binarioIEEE[i]=Integer.toString(ent);
				}
			}
			
			
			
			
			for(int i=0;i<32;i++) {
				r+=binarioIEEE[i];
			}
			
			System.out.print("Exponente es: "+exponente);
		}
		String devolverStringF() {
			 return r;
		}
	}
	class Agrega{
		Binario bin=new Binario();
		IEEE ieee = new IEEE();
		Agrega(){
			
		}
		void agregarBinarioF(IEEE ieee) {
			this.ieee = ieee;
			
		}
		void agregarBinario(Binario binx) {
			this.bin=binx;
		}
		
		void calcularBinario() {
			this.bin.ConvertirBi();
		}
		String devolverBinario() {
			 return bin.devolverString();
		}
		
		void calcularBinarioF() {
			this.ieee.ConvertirBiF();
		}
		String devolverBinarioF() {
			return ieee.devolverStringF();
		}
		
	}


}
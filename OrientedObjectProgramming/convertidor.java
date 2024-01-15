package convert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class principal extends JFrame implements ActionListener {

	JTextField Text_E1 = new JTextField("Entero");
	JTextField Text_E2 = new JTextField("Decimal");
	 
	JLabel NE1 = new JLabel("---------");
	JButton boton = new JButton();
	
	JPanel gg = new JPanel();
	
	int binario, entero;
	
	char arreglo[] = new char[32];
	
	principal(){
		this.setVisible(true);
		this.setSize(540, 500);
		
		gg.setSize(400, 200);
		gg.setLayout(null);
		gg.add(Text_E1);
		gg.add(Text_E2);
		gg.add(boton);
		gg.add(NE1);
		
		Text_E1.setBounds(10, 10, 200, 20);
		Text_E2.setBounds(10, 40, 200, 20);
		NE1.setBounds(100, 150, 200, 20);
		
		boton.setBounds(225, 100, 60, 20);
		boton.addActionListener(this);
		
		this.add(gg);
	}
	
	String convertirEntero( int num){
		int  digito=0,exp = 0;
		binario=0;
		entero=num;
		while(num!=0){
            digito = num % 2;            
            binario = (int) (binario + digito * Math.pow(10, exp));   
            exp++;
            num = num/2;
		}
		return Integer.toString(binario);
		
	}
	
	int PuntoFloat()
	{
		for(int i=1;i<binario;i++){
			arreglo[i]=convertirEntero(entero).charAt(i-1);
		}
		for(int i=0;i<arreglo.length-1;i++){
			System.out.println(arreglo[i]);
		}
		return binario;
	}
	
	String convertirIEEE(double num){
		if(entero<0){
			arreglo[0]='1';
		}else{
			arreglo[0]='1';
		}
		
		//hacer punto flotante
		
		return "a";
	}
	
	public static void main(String[] args) {
		principal k =new principal();
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==boton){
			if(Text_E1.getText()!= null){
				NE1.setText(convertirEntero(Integer.parseInt(Text_E1.getText())));
				PuntoFloat();//sin signo
			}
			else{
				
			}
		}
		
	}

}
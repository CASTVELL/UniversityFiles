

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Principal extends JFrame implements ActionListener{
	
	JTextField Text_E1 = new JTextField();
	JTextField Text_E2 = new JTextField();
	JButton boton = new JButton();
	
	JPanel gg = new JPanel();
	
	int PX[],PY[],NP;
	static Graphics g;
	private static Principal m;
	
	Principal(){
		this.setVisible(true);
		this.setSize(540, 500);
		
		gg.setSize(400, 200);
		gg.setLayout(null);
		gg.add(Text_E1);
		gg.add(Text_E2);
		gg.add(boton);
		
		Text_E1.setBounds(10, 10, 200, 20);
		Text_E2.setBounds(10, 40, 200, 20);
		
		boton.setBounds(225, 100, 60, 20);
		boton.addActionListener(this);
		
		this.add(gg);
	}
	
	 public void paint(Graphics g) {
		    int xpoints[] = {175, 295, 175, 295, 175};//150
		    int ypoints[] = {275, 275, 395, 395, 275};//250
		    int npoints = 5;
		    
		    g.fillPolygon(xpoints, ypoints, npoints);
	}
	
	public static void main(String[] args) {
		m = new Principal();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==boton){
			m.paint( g);
		}
		
	}

}
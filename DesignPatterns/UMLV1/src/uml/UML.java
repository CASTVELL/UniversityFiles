package UML;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UML extends JFrame {

    private JPanel contentPane;
    JButton btnVolver = new JButton("Volver");
    JLabel label = new JLabel("");

    List<Datos> Datos = new ArrayList<>();

    public UML(List<Datos> listClases) {
        setResizable (true);
        Datos = listClases;
        PanelUML P = new PanelUML(Datos);
        setTitle("Diagrama UML");
        setBounds(100, 100, 1500, 650);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        P.setBounds(0, 0, 695, 350);
        label.setForeground(Color.BLACK);
        contentPane.add(P);

        label.setBackground(Color.BLACK);
        label.setBounds(0, 350, 684, 60);
        contentPane.add(label);

        btnVolver.setBounds(750, 500, 89, 23);
        btnVolver.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
    }
});
		contentPane.add(btnVolver);
		
		P.repaint();
		
		
	}
	
	
}

package UML;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class PanelUML extends JPanel {
    
    String aux;
    List<Datos> Datos = new ArrayList<Datos>();
    
    public PanelUML(List<Datos> datos) {
        this.Datos = datos;
    }
    
    public void paintComponent(Graphics e) {
        CogerDatos(e);
    }
    
    public void CogerDatos(Graphics e) {
        for (int i = 0; i < Datos.size(); i++) {
            Dibujar(e, i);
        }
    }
    
    public void Dibujar(Graphics e, int i) {
        e.setColor(Color.BLACK);
        int tamatri = Datos.get(i).CantidadAtributos * 15;
        int tammet = Datos.get(i).CantidadMetodos * 15;
        e.drawRect( ((i * 170)), Datos.get(i).CoordenadaY, 100, 30);
        e.drawRect(((i * 170)), Datos.get(i).CoordenadaY, 100, tamatri + 40);
        e.drawRect(((i * 170)), Datos.get(i).CoordenadaY, 100, tamatri + tammet + 50);
        if (Datos.get(i).TipoClase.equals("Abstract")) {
            e.setFont(new Font("serial" , Font.ITALIC, 13));
            pintar(e, i);
        } else if (Datos.get(i).TipoClase.equals("Interface")) {
            e.drawString("<<interface>>", Datos.get(i).CoordenadaX + ((i * 170)) + 20, Datos.get(i).CoordenadaY + 22);
            pintar(e, i);
        } else {
            e.drawString(Datos.get(i).NombreClase, Datos.get(i).CoordenadaX + ((i * 170)) + 40, Datos.get(i).CoordenadaY + 12);
            pintar(e, i);
        }
    }
    
    public void pintar(Graphics e, int i) {
        e.drawString(Datos.get(i).NombreClase, Datos.get(i).CoordenadaX + ((i * 170)) + 40, Datos.get(i).CoordenadaY + 12);
        for (int j = 0; j < Datos.get(i).Atributos.size(); j++) {
            if (Datos.get(i).VisibilidadAtributos.get(j).equals("Public")) {
                aux = "+ " + Datos.get(i).Atributos.get(j);
            } else if (Datos.get(i).VisibilidadAtributos.get(j).equals("Private")) {
                aux = "- " + Datos.get(i).Atributos.get(j);
            } else {
                aux = "# " + Datos.get(i).Atributos.get(j);
            }
            e.drawString(aux, Datos.get(i).CoordenadaX + ((i * 170)) , Datos.get(i).CoordenadaY + 45 + (j * 10));
        }
         for (int j = 0; j < Datos.get(i).Metodos.size(); j++){
         if (Datos.get(i).VisibilidadMetodos.get(j).equals("Public")) {
                aux = "+ " + Datos.get(i).Metodos.get(j)+" () ";
            } else if (Datos.get(i).VisibilidadMetodos.get(j).equals("Private")) {
                aux = "- " + Datos.get(i).Metodos.get(j)+" () ";
            } else {
                aux = "# " + Datos.get(i).Metodos.get(j)+" () ";
            }
            e.drawString(aux, Datos.get(i).CoordenadaX + ((i *170)) , Datos.get(i).CoordenadaY + 65 + (j * 10));
        }
    }
}

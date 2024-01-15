package UML;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import TrianguloCircuncentro.Coordenadas;
import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class Ventana1 extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldClases;
    JScrollPane scrollPane;
    JLabel label = new JLabel("Digite el nombre de la clase: ");
    JButton btnAgregarDatos = new JButton("Agregar Clase");
    JLabel lblNombreDelAtributo = new JLabel("Nombre del atributo: ");
    private final JTextField textFieldAtributo = new JTextField();
    private final JComboBox comboBox = new JComboBox();
    private final JComboBox comboBoxClase = new JComboBox();
    private final JComboBox comboBoxVAtributos = new JComboBox();
    JTextArea Texto;
    JButton btnRegistrarClase = new JButton("Registrar Clase");
    JButton btnDibujar = new JButton("Dibujar diagrama UML");
    JLabel lblNombreDelMetodo = new JLabel("Nombre del metodo: ");
    JButton btnRegistrarAtributo = new JButton("Registrar");
    private JTextField textFieldMetodo;
    JComboBox comboBoxVMetodos = new JComboBox();
    JLabel label_1 = new JLabel("Clase");
    JComboBox comboBoxClases1 = new JComboBox();
    JLabel label_2 = new JLabel("Relacion");
    JLabel lblClase = new JLabel("Clase");
    JButton btnRegistrarMetodo = new JButton("Registrar");
    JComboBox comboBoxClases2 = new JComboBox();
    JComboBox comboBoxRelacion = new JComboBox();
    JButton btnCrearRelacion = new JButton("Crear relacion");
    JComboBox comboBoxTatributos = new JComboBox();
    JComboBox comboBoxTmetodos = new JComboBox();
    boolean Validacion1 = false;
    boolean Validacion2 = true;
    String TextoPanel = "";
    String NombreClase;
    String NombreAtributo;
    String NombreMetodo;
    String TipoClase;
    String TipoAtributo;
    String TipoMetodo;
    String TipoRelacion;
    String VisibilidadAtributo;
    String VisibilidadMetodo;
    String ClaseA;
    String ClaseB;

    String[] s={"int", "double", "String", "char", "boolean", "byte", "long", "float"};
    
    List<Datos> ListClases = new ArrayList<Datos>();
    Datos D;

    public Ventana1() {

        setType(Type.POPUP);
        setBackground(Color.WHITE);
        setTitle("Diagrama UML\t");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 535, 488);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBorder(null);
        contentPane.setLayout(null);

        Texto = new JTextArea();

        btnAgregarDatos.setVisible(false);

        btnDibujar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnDibujar)) {
                    Graficar();
                }
            }
        });
        btnDibujar.setVisible(false);

        comboBoxVAtributos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TipoAtributo = (String) comboBoxVAtributos.getSelectedItem();
                
            }
        });

        comboBoxVMetodos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TipoMetodo = (String) comboBoxVMetodos.getSelectedItem();
                if (TipoMetodo.equals("- Seleccione -")) {
                    TipoMetodo = "Public";
                }
            }
        });

        comboBoxClase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TipoClase = (String) comboBoxClase.getSelectedItem();
                
            }
        });

        comboBoxRelacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TipoRelacion = (String) comboBoxRelacion.getSelectedItem();
                
            }
        });

        label.setBounds(10, 11, 175, 14);
        contentPane.add(label);

        textFieldAtributo.addKeyListener(new KeyAdapter() {					//Validacion Ingreso de unicamente Numeros en Jtextfield
            public void keyTyped(java.awt.event.KeyEvent evt) {
                String c = String.valueOf(evt.getKeyChar());
                if (!c.matches("[a-zA-Z0-9 _]*")) {
                    evt.consume();
                }
            }
        });

        textFieldClases = new JTextField();
        textFieldClases.setBounds(199, 8, 319, 20);
        textFieldClases.addKeyListener(new KeyAdapter() {					//Validacion Ingreso de unicamente Numeros en Jtextfield
            public void keyTyped(java.awt.event.KeyEvent evt) {
                String c = String.valueOf(evt.getKeyChar());
                if (!c.matches("[a-zA-Z0-9 _]*")) {
                    evt.consume();
                }
            }
        });
        contentPane.add(textFieldClases);
        textFieldClases.setColumns(10);

        btnAgregarDatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnAgregarDatos)) {
                    AgregarDatos();
                }
            }
        });

        btnAgregarDatos.setBounds(10, 389, 256, 23);
        contentPane.add(btnAgregarDatos);

        lblNombreDelAtributo.setBounds(10, 79, 128, 14);
        contentPane.add(lblNombreDelAtributo);
        textFieldAtributo.setColumns(10);
        textFieldAtributo.setBounds(148, 76, 117, 20);

        contentPane.add(textFieldAtributo);
        comboBoxClase.setModel(new DefaultComboBoxModel(new String[]{"Public", "Interface", "Abstract"}));
        comboBoxClase.setBounds(51, 36, 117, 20);

        contentPane.add(comboBoxClase);
        comboBoxVAtributos.setModel(new DefaultComboBoxModel(new String[]{"Public", "Private", "Protected"}));
        comboBoxVAtributos.setBounds(79, 112, 89, 20);

        contentPane.add(comboBoxVAtributos);
        btnRegistrarClase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnRegistrarClase)) {
                    RegistrarClase();
                }
            }
        });

        btnRegistrarClase.setBounds(320, 35, 148, 23);
        contentPane.add(btnRegistrarClase);

        btnRegistrarAtributo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnRegistrarAtributo)) {
                    RegistrarAtributo();
                }
            }
        });

        btnRegistrarAtributo.setBounds(178, 111, 89, 23);
        contentPane.add(btnRegistrarAtributo);

        lblNombreDelMetodo.setBounds(10, 163, 128, 14);
        contentPane.add(lblNombreDelMetodo);

        textFieldMetodo = new JTextField();
        textFieldMetodo.setColumns(10);
        textFieldMetodo.addKeyListener(new KeyAdapter() {					//Validacion Ingreso de unicamente en Jtextfield
            public void keyTyped(java.awt.event.KeyEvent evt) {
                String c = String.valueOf(evt.getKeyChar());
                if (!c.matches("[a-zA-Z0-9 _]*")) {
                    evt.consume();
                }
            }
        });
        textFieldMetodo.setBounds(148, 160, 117, 20);
        contentPane.add(textFieldMetodo);
        comboBoxVMetodos.setModel(new DefaultComboBoxModel(new String[]{"Public", "Private", "Protected"}));

        comboBoxVMetodos.setBounds(79, 196, 89, 20);
        contentPane.add(comboBoxVMetodos);

        btnRegistrarMetodo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnRegistrarMetodo)) {
                    RegistrarMetodo();
                }
            }
        });

        btnRegistrarMetodo.setBounds(178, 195, 89, 23);
        contentPane.add(btnRegistrarMetodo);

        lblClase.setBounds(25, 245, 46, 14);
        contentPane.add(lblClase);

        label_1.setBounds(225, 245, 46, 14);
        contentPane.add(label_1);

        label_2.setBounds(120, 245, 50, 14);
        contentPane.add(label_2);

        comboBoxClases1.setModel(new DefaultComboBoxModel(new String[]{"-"}));
        comboBoxClases1.setBounds(10, 270, 61, 20);
        contentPane.add(comboBoxClases1);

        comboBoxRelacion.setModel(new DefaultComboBoxModel(new String[]{"Extends", "Implements"}));
        comboBoxRelacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TipoRelacion = (String) comboBoxRelacion.getSelectedItem();
            }
        });
        comboBoxRelacion.setBounds(85, 270, 105, 20);
        contentPane.add(comboBoxRelacion);

        comboBoxClases2.setModel(new DefaultComboBoxModel(new String[]{"-"}));
        comboBoxClases2.setBounds(204, 270, 61, 20);
        contentPane.add(comboBoxClases2);

        btnDibujar.setBounds(10, 423, 508, 23);
        contentPane.add(btnDibujar);
        btnCrearRelacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnCrearRelacion)) {
                    CrearRelacion();
                }
            }
        });

        btnCrearRelacion.setBounds(10, 332, 256, 23);
        contentPane.add(btnCrearRelacion);

        comboBoxTatributos.setModel(new DefaultComboBoxModel(s));
        comboBoxTatributos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VisibilidadAtributo = (String) comboBoxTatributos.getSelectedItem();
            }
        });
        comboBoxTatributos.setBounds(10, 112, 59, 20);
        contentPane.add(comboBoxTatributos);

        comboBoxTmetodos.setModel(new DefaultComboBoxModel(s));
        comboBoxTmetodos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VisibilidadMetodo = (String) comboBoxTmetodos.getSelectedItem();
            }
        });
        comboBoxTmetodos.setBounds(10, 196, 59, 20);
        contentPane.add(comboBoxTmetodos);

    }

    public void RegistrarClase() {

        if (textFieldClases.getText().equals("")) {
            JOptionPane.showMessageDialog(getContentPane(), "Ingrese el nombre de la clase",
                    "Atencion", JOptionPane.ERROR_MESSAGE);
        } else if (Validacion2 == false) {
            JOptionPane.showMessageDialog(getContentPane(), "Oprima el boton agregar clase",
                    "Atencion", JOptionPane.ERROR_MESSAGE);
        } else {
            D = new Datos();

            TipoClase = (String) comboBoxClase.getSelectedItem();
            NombreClase = textFieldClases.getText();

            //
            D.NombreClase = NombreClase;
            D.TipoClase = TipoClase;

            JOptionPane.showMessageDialog(getContentPane(), "Clase '" + textFieldClases.getText() + "' , tipo:  " + TipoClase + " registrada.",
                    "Registro", JOptionPane.INFORMATION_MESSAGE);
            //
            if (TipoClase == "Interface") {
                TextoPanel += "Interfaz: \t<<interface>>" + textFieldClases.getText() + "\n";
            } else if (TipoClase == "Abstract") {
                Texto.setFont(new Font("serif", Font.ITALIC, 13));
                TextoPanel += "Clase abstracta: " + textFieldClases.getText() + "\n";
            } else {
                TextoPanel += "Clase: " + textFieldClases.getText() + "\n";
            }
            try {

                Texto.setVisible(false);
                scrollPane.setVisible(false);
            } catch (Exception ex) {

            }
            Texto = new JTextArea();
            Texto.setText(TextoPanel);
            Texto.setFont(new Font("Dialog", Font.PLAIN, 13));
            Texto.setWrapStyleWord(true);
            Texto.setLineWrap(true);
            Texto.setEditable(false);
            scrollPane = new JScrollPane(Texto);
            scrollPane.setBounds(280, 80, 240, 330);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            contentPane.add(scrollPane);

            textFieldClases.setText(null);
            btnAgregarDatos.setVisible(true);
            btnDibujar.setVisible(true);
            Validacion1 = true;
            comboBoxClase.setModel(new DefaultComboBoxModel(new String[]{"Public", "Interface", "Abstract"}));
            Validacion2 = false;

        }
    }

    public void RegistrarAtributo() {

        if (Validacion1 == false) {
            JOptionPane.showMessageDialog(getContentPane(), "Registre la clase", //AX AY BX BY CX CY
                    "Atencion", JOptionPane.ERROR_MESSAGE);
        } else if (textFieldAtributo.getText().equals("")) {
            JOptionPane.showMessageDialog(getContentPane(), "Ingrese el nombre del Atributo", //AX AY BX BY CX CY
                    "Atencion", JOptionPane.ERROR_MESSAGE);
        } else if (comboBoxTatributos.getSelectedItem().equals("-")) {
            JOptionPane.showMessageDialog(getContentPane(), "Seleccione el tipo de Atributo", //AX AY BX BY CX CY
                    "Atencion", JOptionPane.ERROR_MESSAGE);
        } else {
            NombreAtributo = textFieldAtributo.getText();
            TipoAtributo = (String) comboBoxTatributos.getSelectedItem();
            VisibilidadAtributo = (String) comboBoxVAtributos.getSelectedItem();

            //
            JOptionPane.showMessageDialog(getContentPane(), "Atributo '" + textFieldAtributo.getText() + "' , tipo:  " + TipoAtributo + " registrado.", //AX AY BX BY CX CY
                    "Registro", JOptionPane.INFORMATION_MESSAGE);
            //

            D.Atributos.add(NombreAtributo);
            D.TipoAtributos.add(TipoAtributo);
            D.VisibilidadAtributos.add(VisibilidadAtributo);
            D.CantidadAtributos++;

            switch (VisibilidadAtributo) {
                case "Public":
                    switch (TipoAtributo) {
                        case "int":
                            TextoPanel += "Atributo: + int " + textFieldAtributo.getText() + "\n";
                            break;
                        case "double":
                            TextoPanel += "Atributo: + double " + textFieldAtributo.getText() + "\n";
                            break;
                        case "char":
                            TextoPanel += "Atributo: + char " + textFieldAtributo.getText() + "\n";
                            break;
                        case "String":
                            TextoPanel += "Atributo: + String " + textFieldAtributo.getText() + "\n";
                            break;
                        case "boolean":
                            TextoPanel += "Atributo: + boolean " + textFieldAtributo.getText() + "\n";
                            break;
                        case "byte":
                            TextoPanel += "Atributo: + byte " + textFieldAtributo.getText() + "\n";
                            break;
                        case "float":
                            TextoPanel += "Atributo: + float " + textFieldAtributo.getText() + "\n";
                            break;
                        case "long":
                            TextoPanel += "Atributo: + long " + textFieldAtributo.getText() + "\n";
                            break;
                    }
                    break;
                case "Private":
                    switch (TipoAtributo) {
                        case "int":
                            TextoPanel += "Atributo: - int " + textFieldAtributo.getText() + "\n";
                            break;
                        case "double":
                            TextoPanel += "Atributo: - double " + textFieldAtributo.getText() + "\n";
                            break;
                        case "char":
                            TextoPanel += "Atributo: - char " + textFieldAtributo.getText() + "\n";
                            break;
                        case "String":
                            TextoPanel += "Atributo: - String " + textFieldAtributo.getText() + "\n";
                            break;
                        case "boolean":
                            TextoPanel += "Atributo: - boolean " + textFieldAtributo.getText() + "\n";
                            break;
                        case "byte":
                            TextoPanel += "Atributo: - byte " + textFieldAtributo.getText() + "\n";
                            break;
                        case "float":
                            TextoPanel += "Atributo: - float " + textFieldAtributo.getText() + "\n";
                            break;
                        case "long":
                            TextoPanel += "Atributo: - long " + textFieldAtributo.getText() + "\n";
                            break;
                    }
                    break;
                case "Protected":
                    switch (TipoAtributo) {
                        case "int":
                            TextoPanel += "Atributo: # int " + textFieldAtributo.getText() + "\n";
                            break;
                        case "double":
                            TextoPanel += "Atributo: # double " + textFieldAtributo.getText() + "\n";
                            break;
                        case "char":
                            TextoPanel += "Atributo: # char " + textFieldAtributo.getText() + "\n";
                            break;
                        case "String":
                            TextoPanel += "Atributo: # String " + textFieldAtributo.getText() + "\n";
                            break;
                        case "boolean":
                            TextoPanel += "Atributo: # boolean " + textFieldAtributo.getText() + "\n";
                            break;
                        case "byte":
                            TextoPanel += "Atributo: # byte " + textFieldAtributo.getText() + "\n";
                            break;
                        case "float":
                            TextoPanel += "Atributo: # float " + textFieldAtributo.getText() + "\n";
                            break;
                        case "long":
                            TextoPanel += "Atributo: # long " + textFieldAtributo.getText() + "\n";
                            break;
                    }
                    break;
            }
            try {
                Texto.setVisible(false);
                scrollPane.setVisible(false);
            } catch (Exception ex) {

            }

            Texto = new JTextArea();
            Texto.setText(TextoPanel);
            Texto.setFont(new Font("Dialog", Font.PLAIN, 13));
            Texto.setWrapStyleWord(true);
            Texto.setLineWrap(true);
            Texto.setEditable(false);
            scrollPane = new JScrollPane(Texto);
            scrollPane.setBounds(280, 80, 240, 330);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            contentPane.add(scrollPane);
            textFieldAtributo.setText(null);
            comboBoxVAtributos.setModel(new DefaultComboBoxModel(new String[]{"Public", "Private", "Protected"}));
            comboBoxTatributos.setModel(new DefaultComboBoxModel(new String[]{"int", "double", "String", "char", "boolean", "byte", "long", "float"}));
        }
    }

    public void RegistrarMetodo() {

        if (Validacion1 == false) {
            JOptionPane.showMessageDialog(getContentPane(), "Registre la clase", //AX AY BX BY CX CY
                    "Atencion", JOptionPane.ERROR_MESSAGE);
        } else if (textFieldMetodo.getText().equals("")) {
            JOptionPane.showMessageDialog(getContentPane(), "Ingrese el nombre del Metodo", //AX AY BX BY CX CY
                    "Atencion", JOptionPane.ERROR_MESSAGE);
        } else if (comboBoxTmetodos.getSelectedItem().equals("-")) {
            JOptionPane.showMessageDialog(getContentPane(), "Seleccione el tipo de Metodo", //AX AY BX BY CX CY
                    "Atencion", JOptionPane.ERROR_MESSAGE);
        } else {

            NombreMetodo = textFieldMetodo.getText();
            TipoMetodo = (String) comboBoxTmetodos.getSelectedItem();
            VisibilidadMetodo = (String) comboBoxVMetodos.getSelectedItem();

            //
            JOptionPane.showMessageDialog(getContentPane(), "Metodo '" + textFieldMetodo.getText() + "' , tipo:  " + TipoMetodo + " registrado.", //AX AY BX BY CX CY
                    "Registro", JOptionPane.INFORMATION_MESSAGE);
            //

            D.Metodos.add(NombreMetodo);
            D.TipoMetodos.add(TipoMetodo);
            D.VisibilidadMetodos.add(VisibilidadMetodo);
            D.CantidadMetodos++;

            switch (VisibilidadMetodo) {
                case "Public":
                    switch (TipoMetodo) {
                        case "int":
                            TextoPanel += "Metodo(): + int " + textFieldMetodo.getText() + "\n";
                            break;
                        case "double":
                            TextoPanel += "Metodo(): + double " + textFieldMetodo.getText() + "\n";
                            break;
                        case "char":
                            TextoPanel += "Metodo(): + char " + textFieldMetodo.getText() + "\n";
                            break;
                        case "String":
                            TextoPanel += "Metodo(): + String " + textFieldMetodo.getText() + "\n";
                            break;
                        case "boolean":
                            TextoPanel += "Metodo(): + boolean " + textFieldMetodo.getText() + "\n";
                            break;
                        case "byte":
                            TextoPanel += "Metodo(): + byte " + textFieldMetodo.getText() + "\n";
                            break;
                        case "float":
                            TextoPanel += "Metodo(): + float " + textFieldMetodo.getText() + "\n";
                            break;
                        case "long":
                            TextoPanel += "Metodo(): + long " + textFieldMetodo.getText() + "\n";
                            break;
                    }
                    break;
                case "Private":
                    switch (TipoMetodo) {
                        case "int":
                            TextoPanel += "Metodo(): - int " + textFieldMetodo.getText() + "\n";
                            break;
                        case "double":
                            TextoPanel += "Metodo(): - double " + textFieldMetodo.getText() + "\n";
                            break;
                        case "char":
                            TextoPanel += "Metodo(): - char " + textFieldMetodo.getText() + "\n";
                            break;
                        case "String":
                            TextoPanel += "Metodo(): - String " + textFieldMetodo.getText() + "\n";
                            break;
                        case "boolean":
                            TextoPanel += "Metodo(): - boolean " + textFieldMetodo.getText() + "\n";
                            break;
                        case "byte":
                            TextoPanel += "Metodo(): - byte " + textFieldMetodo.getText() + "\n";
                            break;
                        case "float":
                            TextoPanel += "Metodo(): - float " + textFieldMetodo.getText() + "\n";
                            break;
                        case "long":
                            TextoPanel += "Metodo(): - long " + textFieldMetodo.getText() + "\n";
                            break;
                    }
                    break;
                case "Protected":
                    switch (TipoMetodo) {
                        case "int":
                            TextoPanel += "Metodo(): # int " + textFieldMetodo.getText() + "\n";
                            break;
                        case "double":
                            TextoPanel += "Metodo(): # double " + textFieldMetodo.getText() + "\n";
                            break;
                        case "char":
                            TextoPanel += "Metodo(): # char " + textFieldMetodo.getText() + "\n";
                            break;
                        case "String":
                            TextoPanel += "Metodo(): # String " + textFieldMetodo.getText() + "\n";
                            break;
                        case "boolean":
                            TextoPanel += "Metodo(): # boolean " + textFieldMetodo.getText() + "\n";
                            break;
                        case "byte":
                            TextoPanel += "Metodo(): # byte " + textFieldMetodo.getText() + "\n";
                            break;
                        case "float":
                            TextoPanel += "Metodo(): # float " + textFieldMetodo.getText() + "\n";
                            break;
                        case "long":
                            TextoPanel += "Metodo(): # long " + textFieldMetodo.getText() + "\n";
                            break;
                    }
                    break;
            }
            try {
                Texto.setVisible(false);
                scrollPane.setVisible(false);
            } catch (Exception ex) {

            }
            Texto = new JTextArea();
            Texto.setText(TextoPanel);
            Texto.setFont(new Font("Dialog", Font.PLAIN, 13));
            Texto.setWrapStyleWord(true);
            Texto.setLineWrap(true);
            Texto.setEditable(false);
            scrollPane = new JScrollPane(Texto);
            scrollPane.setBounds(280, 80, 240, 330);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            contentPane.add(scrollPane);
            
            textFieldMetodo.setText(null);
            comboBoxVMetodos.setModel(new DefaultComboBoxModel(new String[]{"Public", "Private", "Protected"}));
            comboBoxTmetodos.setModel(new DefaultComboBoxModel(s));
        }

    }

    public void CrearRelacion() {
        if (Validacion1 == true) {
            JOptionPane.showMessageDialog(getContentPane(), "Agregue la clase", //AX AY BX BY CX CY
                    "Atencion", JOptionPane.ERROR_MESSAGE);
        } else if (comboBoxClases1.getSelectedItem().equals(comboBoxClases2.getSelectedItem())) {
            JOptionPane.showMessageDialog(getContentPane(), "Una clase no puede relacionarse a si misma", //AX AY BX BY CX CY
                    "Atencion", JOptionPane.ERROR_MESSAGE);
        } else if (ListClases.get(comboBoxClases2.getSelectedIndex() - 1).TipoClase == "Interface" && !comboBoxRelacion.getSelectedItem().equals("Implements")) {
            JOptionPane.showMessageDialog(getContentPane(), "Las interfaces solo pueden ser implementadas", //AX AY BX BY CX CY
                    "Atencion", JOptionPane.ERROR_MESSAGE);
        } else if (ListClases.get(comboBoxClases1.getSelectedIndex() - 1).TipoClase == "Interface") {
            JOptionPane.showMessageDialog(getContentPane(), "Las interfaces no pueden implementar ni extender", //AX AY BX BY CX CY
                    "Atencion", JOptionPane.ERROR_MESSAGE);
        } else {

            //
            JOptionPane.showMessageDialog(getContentPane(), "Relacion Creada ", //AX AY BX BY CX CY
                    "Atencion", JOptionPane.INFORMATION_MESSAGE);
            //

            TipoRelacion = (String) comboBoxRelacion.getSelectedItem();
            D.Relacion.add(TipoRelacion);

            TextoPanel += "Relacion: \n" + "Clase " + ((String) comboBoxClases1.getSelectedItem()) + " " + TipoRelacion + " Clase " + comboBoxClases2.getSelectedItem() + "\n";
            try {
                Texto.setVisible(true);
                scrollPane.setVisible(true);
            } catch (Exception ex) {

            }

            Texto = new JTextArea();
            Texto.setForeground(Color.BLUE);
            Texto.setText(TextoPanel);
            Texto.setFont(new Font("Dialog", Font.PLAIN, 13));
            Texto.setWrapStyleWord(true);
            Texto.setLineWrap(true);
            Texto.setEditable(false);
            scrollPane = new JScrollPane(Texto);
            scrollPane.setBounds(280, 80, 240, 330);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            contentPane.add(scrollPane);
            Agregarbarra();
        }
    }

    public void AgregarDatos() {

        ListClases.add(D);

        comboBoxClases1.addItem(NombreClase);
        comboBoxClases2.addItem(NombreClase);
        comboBoxTatributos.addItem(NombreClase);
        comboBoxTmetodos.addItem(NombreClase);

        JOptionPane.showMessageDialog(getContentPane(), "Clase completa agregada", //AX AY BX BY CX CY
                "Atencion", JOptionPane.INFORMATION_MESSAGE);

        comboBoxClase.setModel(new DefaultComboBoxModel(new String[]{"Public", "Interface", "Abstract"}));
        comboBoxVAtributos.setModel(new DefaultComboBoxModel(new String[]{"Public", "Private", "Protected"}));
        comboBoxVMetodos.setModel(new DefaultComboBoxModel(new String[]{"Public", "Private", "Protected"}));
        Agregarbarra();
        btnAgregarDatos.setVisible(false);
        Validacion1 = false;
        Validacion2 = true;

    }

    public void Graficar() {
        if (Validacion1 == true) {
            JOptionPane.showMessageDialog(getContentPane(), "Agregue la clase", //AX AY BX BY CX CY
                    "Atencion", JOptionPane.ERROR_MESSAGE);
        } else {
            UML Iniciar = new UML(ListClases);
            Iniciar.setVisible(true);
            Iniciar.setResizable(false);
        }
    }

    public void Agregarbarra() {
        TextoPanel += "-------------------------------------------------------";
        try {
            Texto.setVisible(false);
            scrollPane.setVisible(false);
        } catch (Exception ex) {

        }

        Texto = new JTextArea();
        Texto.setForeground(Color.BLACK);
        Texto.setText(TextoPanel);
        Texto.setWrapStyleWord(true);
        Texto.setLineWrap(true);
        Texto.setEditable(false);
        scrollPane = new JScrollPane(Texto);
        scrollPane.setBounds(280, 80, 240, 330);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contentPane.add(scrollPane);
    }

}

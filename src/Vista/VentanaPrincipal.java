package Vista;

import Modelo.LoadSudoku;
import Modelo.Score;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

//Hereda de la clase JFrame
public class VentanaPrincipal extends JFrame implements ItemListener {

    //Características de la ventana
    private JComboBox combo1 = new JComboBox();
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;

    int cont = -1;
    JPanel sudokuPanel;

    //Características del Sudoku
    private String level;
    private ArrayList<String> b1 = new ArrayList<String>();
    private ArrayList<String> b2 = new ArrayList<String>();
    private ArrayList<String> b3 = new ArrayList<String>();
    private ArrayList<String> b4 = new ArrayList<String>();
    private LoadSudoku sudoku;

    //Método constructor
    public VentanaPrincipal() {
        this.level = "Easy";
        this.sudoku = new LoadSudoku(this.level);
        this.b1 = sudoku.getSudokuArray();
        this.b2 = sudoku.getSudokuResArray();
        this.b3 = dif();
        this.b4 = new ArrayList<String>(Collections.nCopies(b2.size(), "" + 0));
        inicio();
    }

    public void inicio() {

        JPanel panel = new JPanel();

        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(735, 620));

        //Título Sudoku
        ImageIcon iconSudoku = new ImageIcon("Images/sudokuTitle.png");
        JLabel imagenSudoku = new JLabel(iconSudoku);
        imagenSudoku.setBounds(308, 10, 288, 77);

        //Imagen Menú
        ImageIcon iconMenu = new ImageIcon("Images/menu.png");
        JLabel imagenMenu = new JLabel(iconMenu);
        imagenMenu.setBounds(67, 113, 102, 37);

        // Remplazar este botón por un JComboBox
        //Níveis
        //JComboBox combo1=new JComboBox();
        combo1.setBounds(30, 164, 176, 30);
        combo1.addItem("Nível:");
        combo1.addItem("Easy");
        combo1.addItem("Intermediate");
        combo1.addItem("Hard");
        combo1.setFont(new Font("RockoFLF", Font.BOLD, 17));
        combo1.addItemListener(this);

        //Botones
        //Botón nuevo juego
        button2 = new JButton("Nuevo Juego");
        button2.setFont(new Font("RockoFLF", Font.BOLD, 17));
        button2.setBounds(30, 197, 176, 45); //x y width height

        //Botón reiniciar juego
        button3 = new JButton("Reiniciar Juego");
        button3.setFont(new Font("RockoFLF", Font.BOLD, 17));
        button3.setBounds(30, 242, 176, 45); //x y width height

        //Botón comprobar
        button4 = new JButton("Comprobar");
        button4.setFont(new Font("RockoFLF", Font.BOLD, 17));
        button4.setBounds(30, 287, 176, 45); //x y width height

        //Botón resolver
        button5 = new JButton("Resolver");
        button5.setFont(new Font("RockoFLF", Font.BOLD, 17));
        button5.setBounds(30, 332, 176, 45); //x y width height

        //Botón ver puntajes
        button6 = new JButton("Ver Puntajes");
        button6.setFont(new Font("RockoFLF", Font.BOLD, 17));
        button6.setBounds(30, 377, 176, 45); //x y width height

        //Botón acerca de
        button7 = new JButton("Acerca de");
        button7.setFont(new Font("RockoFLF", Font.BOLD, 17));
        button7.setBounds(30, 422, 176, 45); //x y width height

        //Botón salir
        button8 = new JButton("Salir");
        button8.setFont(new Font("RockoFLF", Font.BOLD, 17));
        button8.setBounds(30, 467, 176, 45); //x y width height

        //SUDOKU
        ///Lineas Horizontales
        ImageIcon icon1 = new ImageIcon("Images/horizontal2.png");
        Image i1 = icon1.getImage();
        i1 = i1.getScaledInstance(470, 8, java.awt.Image.SCALE_SMOOTH);
        icon1 = new ImageIcon(i1);
        JLabel imagenh1 = new JLabel(icon1);
        imagenh1.setBounds(230, 94, 470, 8);
        panel.add(imagenh1);

        ImageIcon icon2 = new ImageIcon("Images/horizontal.png");
        Image i2 = icon2.getImage();
        i2 = i2.getScaledInstance(470, 8, java.awt.Image.SCALE_SMOOTH);
        icon2 = new ImageIcon(i2);
        JLabel imagenh2 = new JLabel(icon2);
        imagenh2.setBounds(230, 248, 470, 8);
        panel.add(imagenh2);

        JLabel imagenh3 = new JLabel(icon1);
        imagenh3.setBounds(230, 402, 470, 8);
        panel.add(imagenh3);

        JLabel imagenh4 = new JLabel(icon2);
        imagenh4.setBounds(230, 556, 470, 8);
        panel.add(imagenh4);

        //Líneas Verticales
        ImageIcon icon3 = new ImageIcon("Images/vertical.png");
        Image i3 = icon3.getImage();
        i3 = i3.getScaledInstance(8, 470, java.awt.Image.SCALE_SMOOTH);
        icon3 = new ImageIcon(i3);
        JLabel imagenv1 = new JLabel(icon3);
        imagenv1.setBounds(228, 94, 8, 470);
        panel.add(imagenv1);

        ImageIcon icon4 = new ImageIcon("Images/vertical2.png");
        Image i4 = icon4.getImage();
        i4 = i4.getScaledInstance(8, 470, java.awt.Image.SCALE_SMOOTH);
        icon4 = new ImageIcon(i4);
        JLabel imagenv2 = new JLabel(icon4);
        imagenv2.setBounds(382, 94, 8, 470);
        panel.add(imagenv2);

        JLabel imagenv3 = new JLabel(icon3);
        imagenv3.setBounds(536, 94, 8, 470);
        panel.add(imagenv3);

        JLabel imagenv4 = new JLabel(icon4);
        imagenv4.setBounds(690, 94, 8, 470);
        panel.add(imagenv4);

        ///
        //Crea el panel del Sudoku - Viene del método
        sudokuPanel = PanelSudoku();
        sudokuPanel.setBounds(228, 90, 470, 470);

        ///Un botón del tamaño del Sudoku
        JButton buttonR = new JButton("");
        buttonR.setFont(new Font("RockoFLF", Font.BOLD, 17));
        buttonR.setBounds(228, 90, 470, 470); //x y width height

        //© Firma
        ImageIcon iconV2 = new ImageIcon("Images/v2.png");
        //Para cambiar el tamaño de la imagen.
        Image img = iconV2.getImage();
        Image newimg = img.getScaledInstance(130, 17, java.awt.Image.SCALE_SMOOTH); //260 33
        iconV2 = new ImageIcon(newimg);
        JLabel imagenV2 = new JLabel(iconV2);
        imagenV2.setBounds(53, 522, 130, 17);

        //Acción de los botones
        //Botón nuevo juego
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                ///AQUÍ CÓDIGO  
                setGame();
                panel.remove(sudokuPanel);
                sudokuPanel = PanelSudoku();
                sudokuPanel.setBounds(228, 90, 470, 470);
                panel.add(sudokuPanel);
                panel.revalidate();
                panel.repaint();

                ///
            }
        });

        //Botón reiniciar juego
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                ///AQUÍ CÓDIGO  
                panel.remove(sudokuPanel);
                sudokuPanel = PanelSudoku();
                sudokuPanel.setBounds(228, 90, 470, 470);
                panel.add(sudokuPanel);
                panel.revalidate();
                panel.repaint();

                ///
            }
        });

        //Botón Comprobar
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                ///AQUÍ CÓDIGO
                SwingUtilities.invokeLater(new Runnable() {

                    public void run() {

                        //Regalo del programador: 
                        //Si ganas y oprimes varias veces el botón comprobar
                        //Te sumara más puntos :)
                        
                        if (b2.equals(b4)) {
                            VentanaWinner ejecutable = new VentanaWinner();
                            ejecutable.setVisible(true);
                            Score s = new Score();
                            VentanaBienvenido vb = new VentanaBienvenido();
                            String name = vb.getName();
                            if (level.equals("Easy")) {
                                s.addScore(name);
                            }
                            if (level.equals("Intermediate")) {
                                s.addScore(name);
                                s.addScore(name);
                            }
                            if (level.equals("Hard")) {
                                s.addScore(name);
                                s.addScore(name);
                                s.addScore(name);
                            }

                        } else {
                            VentanaKeepTrying ejecutable = new VentanaKeepTrying();
                            ejecutable.setVisible(true);
                        }
                    }
                });

                ///
            }
        });

        //Botón resolver
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                ///AQUÍ CÓDIGO
                SwingUtilities.invokeLater(new Runnable() {

                    public void run() {

                        panel.remove(sudokuPanel);
                        sudokuPanel = PanelSudokuResuelto();
                        sudokuPanel.setBounds(228, 90, 470, 470);
                        panel.add(sudokuPanel);
                        panel.revalidate();
                        panel.repaint();

                    }
                });

                ///
            }
        });

        //Botón puntajes
        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                ///AQUÍ CÓDIGO
                SwingUtilities.invokeLater(new Runnable() {

                    public void run() {

                        VentanaPuntajes ejecutable = new VentanaPuntajes();
                        ejecutable.setVisible(true);

                    }
                });

                ///
            }
        });

        //Botón Acerca de
        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                ///AQUÍ CÓDIGO
                SwingUtilities.invokeLater(new Runnable() {

                    public void run() {

                        VentanaAcercaDe ejecutable = new VentanaAcercaDe();
                        ejecutable.setVisible(true);

                    }
                });

                ///
            }
        });

        //Botón Salir
        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //Se sale del todo. Diferente del dispose();
                System.exit(0);
            }
        });

        //Agregar elementos al panel
        panel.add(imagenSudoku);
        panel.add(imagenMenu);
        panel.add(combo1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        //panel.add(buttonR);
        panel.add(sudokuPanel);
        panel.add(imagenV2);

        //Agregar panel
        add(panel);

        pack();

        setSize(735, 620);
        setTitle("Sudoku - ©2015 Games V²");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    //Níveis
    public void itemStateChanged(ItemEvent e) {

        if (e.getSource() == combo1) {
            String seleccionado = (String) combo1.getSelectedItem();
            if (seleccionado.equals("Nível:")) {
                //do nothing
            } else {
                this.level = seleccionado;
            }
        }

    }

    public JPanel PanelSudoku() {

        JPanel panel = new JPanel();

        //panel.setLayout(null);
        panel.setPreferredSize(new Dimension(470, 470));

        JPanel panelSudoku = new JPanel();
        panelSudoku.setPreferredSize(new Dimension(470, 470));
        //panelSudoku.setBackground(Color.WHITE);

        //Espacio en el borde
        panelSudoku.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        //Número de filas, columnas, espacio horizontal, espacio vertical.
        panelSudoku.setLayout(new GridLayout(9, 9, 12, 12));

        //System.out.println(sudoku.getSudokuArray().toString());
//        Random rand = new Random();
//
//        for (int i = 1; i < 82; i++) {
//            b1.add("" + (rand.nextInt(9) + 1));
//        }
        //Llenar Sudoku con Array del Nível
        for (int i = 0; i < b1.size(); i++) {

            final int j = i;

            //Casilla vacia
            if (b1.get(i).equals(".")) {

                JTextPane textPane = new JTextPane();
                textPane.setText("");
                textPane.setEditable(true);
                textPane.setFont(new Font("RockoFLF", Font.BOLD, 24));

                //Color azul para la región
                if (i == 0 || i == 1 || i == 2 || i == 9 || i == 10 || i == 11 || i == 18 || i == 19 || i == 20 || i == 6 || i == 7 || i == 8 || i == 15 || i == 16 || i == 17 || i == 24 || i == 25 || i == 26 || i == 30 || i == 31 || i == 32 || i == 39 || i == 40 || i == 41 || i == 48 || i == 49 || i == 50 || i == 54 || i == 55 || i == 56 || i == 63 || i == 64 || i == 65 || i == 72 || i == 73 || i == 74 || i == 60 || i == 61 || i == 62 || i == 69 || i == 70 || i == 71 || i == 78 || i == 79 || i == 80) {
                    Color colore = new Color(224, 235, 250); //Lightblue
                    textPane.setBackground(colore);
                }

                //Color colore2 = new Color(234, 112, 165);
                Color colore2 = new Color(255, 127, 80); //Orange

                //Estilos - Centrar y Colores de letra
                StyledDocument doc = textPane.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
                StyleConstants.setForeground(center, colore2);
                doc.setParagraphAttributes(0, doc.getLength(), center, false);

                //Agregar al panel
                panelSudoku.add(textPane);

                //Para sólo permitir números del 1 al 9
                textPane.addKeyListener(new KeyListener() {

                    @Override
                    public void keyTyped(KeyEvent e) {

                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        String t = textPane.getText();
                        if (!validarStringEnteroPositivo(t)) {
                            textPane.setText("");
                        } else {
                            b4.set(j, t);

                        }
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });

            } //Casilla con número dado al usuario
            else {

                JTextPane textPane = new JTextPane();

                //Poner el número
                textPane.setText((b1.get(i)));
                b4.set(j, b1.get(i));
                //Que no se pueda editar
                textPane.setEditable(false);
                //Estilo
                textPane.setFont(new Font("RockoFLF", Font.BOLD, 24));

                //Color azul para la región
                if (i == 0 || i == 1 || i == 2 || i == 9 || i == 10 || i == 11 || i == 18 || i == 19 || i == 20 || i == 6 || i == 7 || i == 8 || i == 15 || i == 16 || i == 17 || i == 24 || i == 25 || i == 26 || i == 30 || i == 31 || i == 32 || i == 39 || i == 40 || i == 41 || i == 48 || i == 49 || i == 50 || i == 54 || i == 55 || i == 56 || i == 63 || i == 64 || i == 65 || i == 72 || i == 73 || i == 74 || i == 60 || i == 61 || i == 62 || i == 69 || i == 70 || i == 71 || i == 78 || i == 79 || i == 80) {
                    Color colore = new Color(224, 235, 250);
                    textPane.setBackground(colore);
                }

                //Estilos - Centrar y Colores de letra
                StyledDocument doc = textPane.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
                StyleConstants.setForeground(center, Color.darkGray);
                doc.setParagraphAttributes(0, doc.getLength(), center, false);

                //Agregar al panel
                panelSudoku.add(textPane);
            }
        }

        //Agregar panel
        panel.add(panelSudoku);

        add(panel);

        //Lo regresa para poderlo útilizar
        return panel;
    }

    public ArrayList<String> dif() {

        ArrayList<String> alala = new ArrayList<String>();
        int i = -1;
        for (String s : b1) {
            i++;
            if (s.equals(".")) {
                alala.add(b2.get(i));
            }
        }

        return alala;

    }

    public JPanel PanelSudokuResuelto() {

        JPanel panel = new JPanel();
        //panel.setLayout(null);
        panel.setPreferredSize(new Dimension(470, 470));

        JPanel panelSudoku = new JPanel();
        panelSudoku.setPreferredSize(new Dimension(470, 470));
        //panelSudoku.setBackground(Color.WHITE);

        //Espacio en el borde
        panelSudoku.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        //Número de filas, columnas, espacio horizontal, espacio vertical.
        panelSudoku.setLayout(new GridLayout(9, 9, 12, 12));

        //System.out.println(sudoku.getSudokuArray().toString());
//        Random rand = new Random();
//
//        for (int i = 1; i < 82; i++) {
//            b1.add("" + (rand.nextInt(9) + 1));
//        }
        //Llenar Sudoku con Array del Nível
        for (int i = 0; i < b1.size(); i++) {

            //Casilla vacia
            if (b1.get(i).equals(".")) {

                JTextPane textPane = new JTextPane();
                textPane.setText(b2.get(i));
                textPane.setEditable(false);
                textPane.setFont(new Font("RockoFLF", Font.BOLD, 24));

                //Color azul para la región
                if (i == 0 || i == 1 || i == 2 || i == 9 || i == 10 || i == 11 || i == 18 || i == 19 || i == 20 || i == 6 || i == 7 || i == 8 || i == 15 || i == 16 || i == 17 || i == 24 || i == 25 || i == 26 || i == 30 || i == 31 || i == 32 || i == 39 || i == 40 || i == 41 || i == 48 || i == 49 || i == 50 || i == 54 || i == 55 || i == 56 || i == 63 || i == 64 || i == 65 || i == 72 || i == 73 || i == 74 || i == 60 || i == 61 || i == 62 || i == 69 || i == 70 || i == 71 || i == 78 || i == 79 || i == 80) {
                    Color colore = new Color(224, 235, 250); //Lightblue
                    textPane.setBackground(colore);
                }

                //Color colore2 = new Color(234, 112, 165);
                Color colore2 = new Color(255, 127, 80); //Orange

                //Estilos - Centrar y Colores de letra
                StyledDocument doc = textPane.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
                StyleConstants.setForeground(center, colore2);
                doc.setParagraphAttributes(0, doc.getLength(), center, false);

                //Agregar al panel
                panelSudoku.add(textPane);

            } //Casilla con número dado al usuario
            else {

                JTextPane textPane = new JTextPane();

                //Poner el número
                textPane.setText((b1.get(i)));
                //Que no se pueda editar
                textPane.setEditable(false);
                //Estilo
                textPane.setFont(new Font("RockoFLF", Font.BOLD, 24));

                //Color azul para la región
                if (i == 0 || i == 1 || i == 2 || i == 9 || i == 10 || i == 11 || i == 18 || i == 19 || i == 20 || i == 6 || i == 7 || i == 8 || i == 15 || i == 16 || i == 17 || i == 24 || i == 25 || i == 26 || i == 30 || i == 31 || i == 32 || i == 39 || i == 40 || i == 41 || i == 48 || i == 49 || i == 50 || i == 54 || i == 55 || i == 56 || i == 63 || i == 64 || i == 65 || i == 72 || i == 73 || i == 74 || i == 60 || i == 61 || i == 62 || i == 69 || i == 70 || i == 71 || i == 78 || i == 79 || i == 80) {
                    Color colore = new Color(224, 235, 250);
                    textPane.setBackground(colore);
                }

                //Estilos - Centrar y Colores de letra
                StyledDocument doc = textPane.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
                StyleConstants.setForeground(center, Color.darkGray);
                doc.setParagraphAttributes(0, doc.getLength(), center, false);

                //Agregar al panel
                panelSudoku.add(textPane);
            }
        }

        //Agregar panel
        panel.add(panelSudoku);

        add(panel);

        //Lo regresa para poderlo útilizar
        return panel;
    }

    public void setGame() {
        this.sudoku = new LoadSudoku(this.level);
        this.b1 = sudoku.getSudokuArray();
        this.b2 = sudoku.getSudokuResArray();
        this.b3 = dif();
        this.b4 = new ArrayList<String>(Collections.nCopies(b2.size(), "" + 0));
    }

    //Validar Números del 1 al 9
    public boolean validarStringEnteroPositivo(String n) {
        //También se pudo haber hecho (n).matches("[1-9]?")
        if ((n).matches("[0-9]+")) {
            if (Integer.parseInt(n) >= 1 && Integer.parseInt(n) <= 9) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}

package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public final class VentanaBienvenido extends JFrame {

    public VentanaBienvenido() {
        inicio();
    }

    public void inicio() {

        JPanel panel = new JPanel();

        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(360, 355));

        //Título de Sudoku
        ImageIcon iconSudoku = new ImageIcon("Images/sudokuTitle.png");
        JLabel imagenSudoku = new JLabel(iconSudoku);
        imagenSudoku.setBounds(31, 10, 288, 77);

        //Imagen bienvenido
        ImageIcon iconBienvenido = new ImageIcon("Images/bienvenido.png");
        Image img = iconBienvenido.getImage();
        Image newimg = img.getScaledInstance(200, 37, java.awt.Image.SCALE_SMOOTH);
        iconBienvenido = new ImageIcon(newimg);
        JLabel imagenBienvenido = new JLabel(iconBienvenido);
        imagenBienvenido.setBounds(75, 97, 200, 37);

        //Botón comenzar
        JButton button1 = new JButton("¡Comenzar!");
        button1.setFont(new Font("RockoFLF", Font.BOLD, 17));
        button1.setBounds(87, 227, 176, 45); //x y width height

        //© Firma
        ImageIcon iconV2 = new ImageIcon("Images/v2.png");
        //Para cambiar el tamaño de la imagen.
        Image img2 = iconV2.getImage();
        Image newimg2 = img2.getScaledInstance(130, 17, java.awt.Image.SCALE_SMOOTH); //260 33
        iconV2 = new ImageIcon(newimg2);
        JLabel imagenV2 = new JLabel(iconV2);
        imagenV2.setBounds(110, 282, 130, 17);        

        //Texto
        JLabel jlabel = new JLabel();
        jlabel.setBounds(new Rectangle(77, 150, 195, 21));
        jlabel.setText("Ingrese su nickname por favor:");
        jlabel.setFont(new Font("RockoFLF", Font.BOLD, 13));
        
        //Segundo texto
        JLabel jlabel2 = new JLabel();
        jlabel2.setBounds(new Rectangle(73, 172, 204, 21));
        jlabel2.setText("(Dejar en blanco para ser anónimo)");
        jlabel2.setFont(new Font("RockoFLF", Font.PLAIN, 13));

        //Text field
        final JTextField jtextfield = new JTextField();
        jtextfield.setBounds(new Rectangle(30, 194, 290, 21));
        Color colore = new Color(255,127,80);
        jtextfield.setForeground(colore);
        jtextfield.setFont(new Font("RockoFLF", Font.BOLD, 13));
        jtextfield.setHorizontalAlignment(JTextField.CENTER);

        //Listenr
        jtextfield.addKeyListener(new KeyListener() {

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
                        String t = jtextfield.getText();
                        if (t.contains(" ")) {
                            jtextfield.setText("");
                        } else {

                        }
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });

        //Acción de los botones
        //Este botón accede a la ventana principal.
        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {

                printName(jtextfield.getText());

                dispose();

                ///AQUÍ CÓDIGO
                SwingUtilities.invokeLater(new Runnable() {

                    public void run() {

                        VentanaPrincipal ejecutable = new VentanaPrincipal();
                        ejecutable.setVisible(true);

                    }
                });
                ///

            }
        });

        //Agregar elementos al panel
        panel.add(imagenSudoku);
        panel.add(imagenBienvenido);
        panel.add(jlabel);
        panel.add(jlabel2);
        panel.add(jtextfield);
        panel.add(button1);
        panel.add(imagenV2);

        //Agregar panel
        add(panel);

        pack();

        setSize(360, 355);
        setTitle("Sudoku - ©2015 Games V²");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public void printName(String name) {

        try {
            File archive = new File("Score/Name.txt");
            //True para que no sobre-escriba el archivo, sino que lo escriba al final.
            FileWriter fw = new FileWriter(archive, false);
            if(name.isEmpty()){
                fw.append("!null!");
            }else{
            fw.append(name); 
            }
            fw.close();

        } catch (Exception e) {
            System.err.println("Error reading files.");
        
        }
        
    }

 public String getName(){
     
     String name = "";
     
     try {
            File archive = new File("Score/Name.txt");

            FileReader fr = new FileReader(archive);
            BufferedReader br = new BufferedReader(fr);
            
            name = br.readLine();
            
            fr.close();
            br.close();

        } catch (Exception e) {
            System.err.println("Error reading files.");
        }
     if(name.equals("!null!")){
         return "";
     }else{
     return name;
     }
 }

}

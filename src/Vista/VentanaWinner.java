package Vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaWinner extends JFrame {

    public VentanaWinner() {
        inicio();
    }

    public void inicio() {

        //Objeto de VentanaBienvenido. Para adquirir nombre.
        VentanaBienvenido vb = new VentanaBienvenido();
        
        JPanel panel = new JPanel();

        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(360, 636));

        //Título Sudoku
        ImageIcon iconSudoku = new ImageIcon("Images/sudokuTitle.png");
        JLabel imagenSudoku = new JLabel(iconSudoku);
        imagenSudoku.setBounds(31, 10, 288, 77);
        
        //Texto
         JLabel jlabel = new JLabel();
         if(vb.getName().isEmpty()){
         jlabel.setText("¡Felicitaciones!");
         jlabel.setBounds(118, 97, 125, 21); //xy height width
         }else{
             jlabel.setText("¡Felicitaciones, "+vb.getName()+"!");
             jlabel.setBounds(60, 97, 240, 21); //xy height width
         }
         jlabel.setFont(new Font("RockoFLF", Font.BOLD, 18));

        //Imagen gato
        ImageIcon iconC = new ImageIcon("Images/Cats/CatRWJ.gif");
        JLabel imagenC = new JLabel(iconC);
        imagenC.setBounds(20, 121, 320, 391);

        //Botón Ok
        JButton button1 = new JButton("¡Ganaste!");
        button1.setFont(new Font("RockoFLF", Font.BOLD, 17));
        button1.setBounds(87, 516, 176, 45); //x y width height

        //© Firma
        ImageIcon iconV2 = new ImageIcon("Images/v2.png");
        //Para cambiar el tamaño de la imagen.
        Image img2 = iconV2.getImage();
        Image newimg2 = img2.getScaledInstance(130, 17, java.awt.Image.SCALE_SMOOTH); //260 33
        iconV2 = new ImageIcon(newimg2);
        JLabel imagenV2 = new JLabel(iconV2);
        imagenV2.setBounds(110, 566, 130, 17);

        //Acción de los botones
        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
        
                dispose();

            }
        });

        //Agrega al panel los elementos
        panel.add(imagenSudoku);
        panel.add(jlabel);
        panel.add(imagenC);
        panel.add(button1);
        panel.add(imagenV2);
       
        //Agrega el panel
        add(panel);

        pack();

        setSize(360, 636);
        setTitle("Sudoku [¡Ganaste!] - ©2015 Games V²");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

}

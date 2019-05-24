package Vista;

import Modelo.Score;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPuntajes extends JFrame {

    public VentanaPuntajes() {
        inicio();
    }

    public void inicio() {

        JPanel panel = new JPanel();

        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(360, 470));

        //Título Sudoku
        ImageIcon iconSudoku = new ImageIcon("Images/sudokuTitle.png");
        JLabel imagenSudoku = new JLabel(iconSudoku);
        imagenSudoku.setBounds(31, 10, 288, 77);

        //Imagen Puntajes
        ImageIcon iconPuntaje = new ImageIcon("Images/puntajes.png");
        Image img = iconPuntaje.getImage();
        Image newimg = img.getScaledInstance(152, 37, java.awt.Image.SCALE_SMOOTH); //260 33
        iconPuntaje = new ImageIcon(newimg);
        JLabel imagenPuntaje = new JLabel(iconPuntaje);
        imagenPuntaje.setBounds(99, 100, 152, 37);

        //Agregar los puntajes
        Score scores = new Score();
        Map<String, Integer> score = scores.getArray();

        int cont = 0;
        //Altura
        int h = 155;
                
        for (String s : score.keySet()) {
            String ans =  score.get(s) + " puntos \t-\tJugador: " +s + "";
            JLabel jlabel = new JLabel();
            jlabel.setBounds(92, h, 176, 21);
            jlabel.setText(ans);
            jlabel.setFont(new Font("RockoFLF", Font.PLAIN, 13));
            //Agregar al panel
            panel.add(jlabel);
            cont++;
            h=h+21;
            if (cont > 10) {
                break;
            }
        }
        
        //Botón Ok
        h=h+15;
        JButton button1 = new JButton("Ok :)");
        button1.setFont(new Font("RockoFLF", Font.BOLD, 17));
        button1.setBounds(92, h, 176, 45); //x y width height

        //© Firma
        h=h+55;
        ImageIcon iconV2 = new ImageIcon("Images/v2.png");
        //Para cambiar el tamaño de la imagen.
        Image img2 = iconV2.getImage();
        Image newimg2 = img2.getScaledInstance(130, 17, java.awt.Image.SCALE_SMOOTH); //260 33
        iconV2 = new ImageIcon(newimg2);
        JLabel imagenV2 = new JLabel(iconV2);
        imagenV2.setBounds(110,h, 130, 17);

        //Acción de los botones
        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        //Agregar al panel
        panel.add(imagenSudoku);
        panel.add(imagenPuntaje);
        panel.add(button1);
        panel.add(imagenV2);

        //Agregar panel
        add(panel);

        pack();

        setSize(360, 470);
        setTitle("Sudoku [Puntajes] - ©2015 Games V²");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

}

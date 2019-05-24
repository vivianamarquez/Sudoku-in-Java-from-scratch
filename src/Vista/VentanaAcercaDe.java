package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class VentanaAcercaDe extends JFrame {

    public VentanaAcercaDe() {
        inicio();
    }

    public void inicio() {

        JPanel panel = new JPanel();

        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(360, 636));

        //Imagen Sudoku
        ImageIcon iconSudoku = new ImageIcon("Images/sudokuTitle.png");
        JLabel imagenSudoku = new JLabel(iconSudoku);
        imagenSudoku.setBounds(31, 10, 288, 77);

        //Crear el área de Texto con ScrollBar
        // Create the StyleContext, the document and the pane
        StyleContext sc = new StyleContext();
        final DefaultStyledDocument doc = new DefaultStyledDocument(sc);
        JTextPane area = new JTextPane(doc);

        // Create and add the constant width style
        final Style miEstilo = sc.addStyle("ConstantWidth", null);
        StyleConstants.setFontFamily(miEstilo, "RockoFLF");
        StyleConstants.setFontSize(miEstilo, 15);
        StyleConstants.setBold(miEstilo, true);
        Color colore2 = new Color(234, 112, 165);
        StyleConstants.setForeground(miEstilo, colore2);

        // Create and add the constant width style
        final Style miEstilo2 = sc.addStyle("ConstantWidth", null);
        StyleConstants.setItalic(miEstilo2, true);
        Color colore = new Color(255, 127, 80);
        StyleConstants.setForeground(miEstilo2, colore);
        
        area.setText(text);
        
        //Euler
        ImageIcon iconEuler = new ImageIcon("Images/euler.gif");
        //Para cambiar el tamaño de la imagen.
        Image imgEuler = iconEuler.getImage();
        Image newimgEuler = imgEuler.getScaledInstance(280, 364, java.awt.Image.SCALE_DEFAULT);
        iconEuler = new ImageIcon(newimgEuler);
        area.insertIcon(iconEuler);

        doc.setParagraphAttributes(0, 1, miEstilo, false);
        doc.setCharacterAttributes(379, 8, miEstilo, false);
        doc.setCharacterAttributes(727, 10, miEstilo, false);
        doc.setCharacterAttributes(1730, 16, miEstilo, false);
        doc.setCharacterAttributes(2940, 24, miEstilo, false);
        doc.setCharacterAttributes(2964, 200, miEstilo2, false);

        area.setBounds(20, 110, 320, 402);
        area.setEditable(false);
        
        area.setFont(new Font("Arial", Font.PLAIN, 12));
        
        area.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JScrollPane sp = new JScrollPane(area);
        sp.setBounds(20, 110, 320, 402);
        sp.getViewport().add(area);
        area.setCaretPosition(0);

        //Botón Ok
        JButton button1 = new JButton("Ok");
        button1.setFont(new Font("RockoFLF", Font.BOLD, 17));
        button1.setBounds(87, 516, 176, 45); //x y width height

        //©Firma
        ImageIcon iconV2 = new ImageIcon("Images/v2.png");
        //Para cambiar el tamaño de la imagen.
        Image img2 = iconV2.getImage();
        Image newimg2 = img2.getScaledInstance(130, 17, java.awt.Image.SCALE_SMOOTH);
        iconV2 = new ImageIcon(newimg2);
        JLabel imagenV2 = new JLabel(iconV2);
        imagenV2.setBounds(110, 566, 130, 17);

        //Acción de los botones
        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {

                dispose();

            }
        });

        //Agregar al panel los elementos.
        panel.add(imagenSudoku);     
        panel.add(sp);
        panel.add(button1);
        panel.add(imagenV2);

        //Agregar el panel.
        add(panel);

        pack();

        setSize(360, 636);
        setTitle("Sudoku [Acerca de] - ©2015 Games V²");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static final String text
            = "Instrucciones:\n"
            + "\n"
            + "Un Sudoku bien formado es uno que tiene una solución única. Este juego está compuesto por una cuadrícula de 9x9 casillas, dividida en regiones de 3x3 casillas. Partiendo de algunos números ya dispuestos en algunas de las casillas, hay que completar las casillas vacías con dígitos del 1 al 9 sin que se repitan por fila, columna o región.\n"
            + "\n"
            + "———————————————————————\n"
            + "Reglas:\n"
            + "\n"
            + "Regla 1: hay que completar las casillas vacías con un solo número del 1 al 9.\n"
            + "\n"
            + "Regla 2: en una misma fila no puede haber números repetidos.\n"
            + "\n"
            + "Regla 3: en una misma columna no puede haber números repetidos.\n"
            + "\n"
            + "Regla 4: en una misma región no puede haber números repetidos.\n"
            + "\n"
            + "Regla 5: la solución de un sudoku es única.\n"
            + "\n"
            + "———————————————————————\n"
            + "Historia:\n"
            + "\n"
            + "El juego es un tipo de Cuadrado Latino con la restricción adicional de los contenidos en las regiones individuales. \n"
            + "\n"
            + "Se considera al matemático Leonhard Euler como el creador de este juego. Es un juego matemático que se público por primera vez en 1970 bajo el nombre de “Number place” pero se perdió en el olvido. En la década de 1980 volvió a adquirir popularidad cuando fue publicado en Japón bajo el nombre Sudoku.  Sūji wa dokushin ni kagiru (数字は独身に限る) \"los números deben estar solos\" (literalmente dokushin (独身) = \"célibe, soltero”). El nombre se abrevió a Sūdoku (sū = número, doku = solo). \n"
            + "\n"
            + "Es llamado también “el juego de la inteligencia”. Para resolverlos se utiliza la memoria asociativa, que es la que nos permite descubrir patrones de una pista parcial. Es más, no sólo estimula la mente sino que mejora la memoria. A través de este juego se ejercita la mente, e incluso hay personas a quienes la práctica cotidiana mejora sus capacidades matemáticas.\n"
            + "\n"
            + "———————————————————————\n"
            + "Datos Curiosos:\n"
            + "\n"
            + "• El matemático Gary McGuire, de la Universidad de Dublín, ha utilizado un algoritmo complejo y \"muchas horas de trabajo ante un superordenador\" para determinar que un sudoku no se puede resolver si no hay un mínimo de 17 cifras-pista en su inicio, ya que con menos \"no existe una solución única\".\n"
            + "\n"
            + "• El mejor método para resolver un Sudoku es con la lógica, ya que no es un juego basado en matemáticas. Incluso se pueden utilizar objetos, letras, colores o símbolos en vez de números para resolverlo.\n"
            + "\n"
            + "• Los juegos de Sudoku se pueden clasificar como “Fáciles”, “Medio” o “Difíciles” por el tiempo que un computador se toma en resolverlo.\n"
            + "\n"
            + "• British Airways prohíbe absolutamente a sus auxiliares de vuelo jugar Sudoku durante el despegue o el aterrizaje.\n"
            + "\n"
            + "• Existen 6,670,903,752,021,072,936,960 posibles combinaciones para completar un tablero de 9x9 de Sudoku, pero sólo 5,472,730,538 de ellas valen como diferentes soluciones. Innecesariamente decir, se necesita un puñado de vidas para resolver todos ellos.\n"
            + "\n"
            + "• Cuando el Sudoku se convirtió en un éxito mundial en el 2005, se estima que es el fenómeno más grande desde el Cubo de Rubik en la década de los 80’s.\n"
            + "\n"
            + "———————————————————————\n"
            + "Acerca de la aplicación:\n"
            + "\n"
            + "La aplicación fue desarrollada por Viviana Márquez.\n"
            + "vivianam.penam@konradlorenz.edu.co\n"
            + "twitter.com/vivmarquez\n"
            + "twitter.com/JavaBogota\n"
            + "©2015"
            + "\n"
            + "\n";

}

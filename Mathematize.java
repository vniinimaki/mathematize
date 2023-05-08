import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.*;
import javax.swing.*;  

public class Mathematize implements ActionListener{  

    public static JMenuItem i1, i2, i3, i4, i5, i6, i7, i8;
    public static JFrame f;
    public static JLabel menuteksti;
    public static Font font = new Font("serif", Font.PLAIN, 30);
    public static Font bigfont = new Font("serif", Font.PLAIN, 40);
    public static Font smallfont = new Font("serif", Font.PLAIN, 18);
    public static Color barColor = new Color(255, 151, 151);
    public static Color color2 = new Color(182, 116, 116);

    Mathematize() {  

        f = new JFrame();

        JLabel nimi = new JLabel(" Mathematize");
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Valikko");
        menuteksti = new JLabel("<html> Tervetuloa Mathematizeen! <br> <br> Aloita valitsemalla oikealta aukenevasta valikosta toiminto </html>", JLabel.CENTER);
        menuteksti.setBounds(250, 75, 400, 300);
        menuteksti.setFont(bigfont);

        i1 = new JMenuItem("Yhteenlasku");
        i1.addActionListener(this);
        i2 = new JMenuItem("Vähennyslasku");
        i2.addActionListener(this);
        i3 = new JMenuItem("Kertolasku");
        i3.addActionListener(this);
        i4 = new JMenuItem("Jakolasku");
        i4.addActionListener(this);
        i5 = new JMenuItem("Keskiarvo");
        i5.addActionListener(this);
        i6 = new JMenuItem("Mediaani");
        i6.addActionListener(this);
        i7 = new JMenuItem("°C/°F");
        i7.addActionListener(this);
        i8 = new JMenuItem("Aste/Rad");
        i8.addActionListener(this);

        menu.add(i1); menu.add(i2);
        menu.add(i3); menu.add(i4);
        menu.add(i5); menu.add(i6);
        menu.add(i7); menu.add(i8);

        menu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        menu.setPreferredSize(new Dimension(109, 55));
        menu.setFont(font);
        nimi.setFont(font);

        menubar.add(nimi);
        menubar.add(Box.createHorizontalGlue());
        menubar.add(menu);
        menubar.setBackground(barColor);

        f.setJMenuBar(menubar);
        f.add(menuteksti);
          
        f.setSize(800,600);
        f.setLayout(null);
        f.setVisible(true);
    }  

    public static JTextField luku1 = new JTextField(" ", SwingConstants.CENTER);
    public static JTextField luku2 = new JTextField(" ", SwingConstants.CENTER);
    public static JTextField luku3 = new JTextField(" ", SwingConstants.CENTER);
    public static JTextField vastaus = new JTextField(" ", SwingConstants.CENTER);
    public static JLabel operaatio = new JLabel(" ", SwingConstants.CENTER);
    public static JLabel information = new JLabel(" ", JLabel.CENTER);
    public static JButton option1 = new JButton(" ");
    public static JButton option2 = new JButton(" ");
    public static JButton on = new JButton("=");
    public static JButton copy = new JButton();
    public static ImageIcon copyicon;

    public void actionPerformed(ActionEvent e) {

        copyicon = new ImageIcon(getClass().getResource("copyicon.png"), "icon of the copy button");
        copy.setIcon(copyicon);

        luku1.setFont(bigfont); luku1.setBackground(Color.LIGHT_GRAY);
        luku2.setFont(bigfont); luku2.setBackground(Color.LIGHT_GRAY);
        luku3.setFont(bigfont); luku3.setBackground(Color.LIGHT_GRAY);
        option1.setFont(font); option1.setBackground(Color.LIGHT_GRAY);
        option2.setFont(font); option2.setBackground(Color.LIGHT_GRAY);
        vastaus.setFont(bigfont); vastaus.setBackground(barColor);
        information.setOpaque(true);
        information.setFont(smallfont); information.setBackground(barColor);
        on.setFont(bigfont); on.setBackground(color2);
        operaatio.setFont(bigfont);
        copy.setBackground(color2);

        menuteksti.setBounds(200, 25, 400, 40);
        operaatio.setBounds(380, 100, 40, 50);
        luku1.setBounds(245, 100, 110, 60);
        luku2.setBounds(445, 100, 110, 60);
        luku3.setBounds(270, 130, 80, 60);
        option1.setBounds(450, 100, 60, 60);
        option2.setBounds(450, 160, 60, 60);
        option1.setMargin(new Insets(0, 0, 0, 0));
        option2.setMargin(new Insets(0, 0, 0, 0));
        vastaus.setBounds(290,250, 220, 70);
        vastaus.setEditable(false);
        on.setBounds(220, 250, 70, 70);
        copy.setBounds(510, 250, 70, 70);
        information.setBounds(100, 350, 600, 70);
        f.add(on); f.add(copy); f.add(information);

        f.remove(luku1); f.remove(luku2); f.remove(operaatio); f.remove(luku3); f.remove(option1); f.remove(option2); f.remove(vastaus);

        if(e.getSource() == i1) {
            menuteksti.setText("Yhteenlasku");
            operaatio.setText("+");
            information.setText("Yhteenlaskussa kahden luvun arvot summataan yhteen");
            luku1.setText(null); luku2.setText(null); vastaus.setText(null);
            f.add(operaatio); f.add(luku1); f.add(luku2); f.add(vastaus);
        }
        if(e.getSource() == i2) {
            menuteksti.setText("Vähennyslasku");
            operaatio.setText("-");
            information.setText("Vähennyslaskussa ensimmäisestä luvusta vähennetään seuraava luku");
            luku1.setText(null); luku2.setText(null); vastaus.setText(null);
            f.add(operaatio); f.add(luku1); f.add(luku2); f.add(vastaus);
        }
        if(e.getSource() == i3) {
            menuteksti.setText("Kertolasku");
            operaatio.setText("*");
            information.setText("<html> Kertolaskussa ensimmäinen luku summataan toisen luvun arvon <br> mukainen määrä kertoja </html>");
            luku1.setText(null); luku2.setText(null); vastaus.setText(null);
            f.add(operaatio); f.add(luku1); f.add(luku2); f.add(vastaus);
        }
        if(e.getSource() == i4) {
            menuteksti.setText("Jakolasku");
            operaatio.setText("%");
            information.setText("<html> Jakolaskussa lasketaan moneenko toiseen lukuun <br> ensimmäinen luku voidaan jakaa </html>");
            luku1.setText(null); luku2.setText(null); vastaus.setText(null);
            f.add(operaatio); f.add(luku1); f.add(luku2); f.add(vastaus);
        }
        if(e.getSource() == i5) {
            menuteksti.setText("Keskiarvo");
            vastaus.setText(null);
            information.setText("<html> Keskiarvossa lasketaan kaikki luvut yhteen ja <br> sitten jaetaan niiden lukumäärällä </html>");
            f.add(vastaus);
        }
        if(e.getSource() == i6) {
            menuteksti.setText("Mediaani");
            vastaus.setText(null);
            information.setText("<html> Mediaanissa otetaan annettujen lukujen keskimmäinen <br> luku tai kahden keskimmäisen luvun keskiarvo </html>");
            f.add(vastaus);
        }
        if(e.getSource() == i7) {
            menuteksti.setText("°C/°F");
            luku3.setText(null); vastaus.setText(null);
            option1.setText("°C"); option2.setText("°F");
            information.setText("<html> Muuntaa Fahrenheit-asteet Celcius-asteiksi ja <br> vastaavasti toisinpäin </html>");
            f.add(luku3); f.add(option1); f.add(option2); f.add(vastaus); 
        }
        if(e.getSource() == i8) {
            menuteksti.setText("Aste/Rad");
            luku3.setText(null); vastaus.setText(null);
            option1.setText("°"); option2.setText("Rad");
            information.setText("Muuntaa asteet radiaaneiksi ja vastaavasti toisinpäin");
            f.add(luku3); f.add(option1); f.add(option2); f.add(vastaus);
        }
        f.revalidate();
        f.repaint();
    }

    public static void main(String[] args) {    
        new Mathematize();    
    }    
}  
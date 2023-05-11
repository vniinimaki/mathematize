import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
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

    public static JTextField luku1 = new JTextField(null, SwingConstants.CENTER);
    public static JTextField luku2 = new JTextField(null, SwingConstants.CENTER);
    public static JTextField luku3 = new JTextField(null, SwingConstants.CENTER);
    public static JTextField luku4 = new JTextField(null, SwingConstants.CENTER);
    public static JTextField vastaus = new JTextField(" ", SwingConstants.CENTER);
    public static JLabel operaatio = new JLabel(" ", SwingConstants.CENTER);
    public static JLabel information = new JLabel(" ", JLabel.CENTER);
    public static JButton option1 = new JButton(" ");
    public static JButton option2 = new JButton(" ");
    public static JButton on = new JButton("=");
    public static JButton copy = new JButton();
    public static ImageIcon copyicon;
    public static String state, lämpöstate, astestate;

    Mathematize() {  

        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        copyicon = new ImageIcon(getClass().getResource("copyicon.png"), "icon of the copy button");
        copy.setIcon(copyicon);

    }  

    public static int i = 1;
    public static String valittu = null;

    public void actionPerformed(ActionEvent e) {

        if(i == 1) {
            luku1.setFont(bigfont); luku1.setBackground(Color.LIGHT_GRAY);
            luku2.setFont(bigfont); luku2.setBackground(Color.LIGHT_GRAY);
            luku3.setFont(bigfont); luku3.setBackground(Color.LIGHT_GRAY);
            luku4.setFont(bigfont); luku4.setBackground(Color.LIGHT_GRAY);
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
            luku4.setBounds(200, 100, 400, 60);
            option1.setBounds(450, 100, 60, 60);
            option2.setBounds(450, 160, 60, 60);
            option1.setMargin(new Insets(0, 0, 0, 0));
            option2.setMargin(new Insets(0, 0, 0, 0));
            vastaus.setBounds(290,250, 220, 70);
            vastaus.setEditable(false);
            on.setBounds(220, 250, 70, 70);
            copy.setBounds(510, 250, 70, 70);
            information.setBounds(100, 350, 600, 70);

            on.addActionListener(this);
            option1.addActionListener(this);
            option2.addActionListener(this);
            copy.addActionListener(this);

            f.add(on); f.add(copy); f.add(information);

            i = 0;
        }

        f.remove(luku1); f.remove(luku2); f.remove(operaatio); f.remove(luku3); f.remove(luku4); f.remove(option1); f.remove(option2); f.remove(vastaus);

        if(e.getSource() == i1) {
            state = "Yhteenlasku";
            menuteksti.setText("Yhteenlasku");
            operaatio.setText("+");
            information.setText("Yhteenlaskussa kahden luvun arvot summataan yhteen");
            luku1.setText(null); luku2.setText(null); luku3.setText(null); luku4.setText(null); vastaus.setText(null);
        }
        else if(e.getSource() == i2) {
            state = "Vähennyslasku";
            menuteksti.setText("Vähennyslasku");
            operaatio.setText("-");
            information.setText("Vähennyslaskussa ensimmäisestä luvusta vähennetään seuraava luku");
            luku1.setText(null); luku2.setText(null); luku3.setText(null); luku4.setText(null); vastaus.setText(null);
        }
        else if(e.getSource() == i3) {
            state = "Kertolasku";
            menuteksti.setText("Kertolasku");
            operaatio.setText("*");
            information.setText("<html> Kertolaskussa ensimmäinen luku summataan toisen luvun arvon <br> mukainen määrä kertoja </html>");
            luku1.setText(null); luku2.setText(null); luku3.setText(null); luku4.setText(null); vastaus.setText(null);
        }
        else if(e.getSource() == i4) {
            state = "Jakolasku";
            menuteksti.setText("Jakolasku");
            operaatio.setText("%");
            information.setText("<html> Jakolaskussa lasketaan moneenko toiseen lukuun <br> ensimmäinen luku voidaan jakaa </html>");
            luku1.setText(null); luku2.setText(null); luku3.setText(null); luku4.setText(null); vastaus.setText(null);
        }
        else if(e.getSource() == i5) {
            state = "Keskiarvo";
            menuteksti.setText("Keskiarvo");
            information.setText("<html> Keskiarvossa lasketaan kaikki luvut yhteen ja sitten <br> jaetaan niiden lukumäärällä. Anna luvut pilkuilla eroteltuna </html>");
            luku1.setText(null); luku2.setText(null); luku3.setText(null); luku4.setText(null); vastaus.setText(null);
        }
        else if(e.getSource() == i6) {
            state = "Mediaani";
            menuteksti.setText("Mediaani");
            information.setText("<html> Mediaanissa otetaan annettujen lukujen keskimmäinen luku tai <br> kahden keskimmäisen luvun keskiarvo. Anna luvut pilkuilla eroteltuna </html>");
            luku1.setText(null); luku2.setText(null); luku3.setText(null); luku4.setText(null); vastaus.setText(null);
        }
        else if(e.getSource() == i7) {
            state = "Celcius";
            menuteksti.setText("°C/°F");
            option1.setText("°C"); option2.setText("°F");
            information.setText("<html> Muuntaa luvun Celcius- tai Fahrenheit-asteiksi. Anna luku ja <br> valitse kummaksi haluat sen muuttaa </html>");
            luku1.setText(null); luku2.setText(null); luku3.setText(null); luku4.setText(null); vastaus.setText(null); valittu = null;
        }
        else if(e.getSource() == i8) {
            state = "Aste";
            menuteksti.setText("Aste/Rad");
            option1.setText("°"); option2.setText("Rad");
            information.setText("<html> Muuntaa luvun asteiksi tai radiaaneiksi. Anna luku ja <br> valitse kummaksi haluat sen muuttaa </html>");
            luku1.setText(null); luku2.setText(null); luku3.setText(null); luku4.setText(null); vastaus.setText(null); valittu = null;
        }

        else if(e.getSource() == on) {

            DecimalFormat df = new DecimalFormat("#.###");
            df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));

            if(luku1.getText().isBlank() && luku2.getText().isBlank() && luku3.getText().isBlank() && luku4.getText().isBlank()) {
                //skip
            }

            else if(state == "Yhteenlasku") {
                try {
                    vastaus.setText(df.format(Operations.addition(Double.parseDouble(luku1.getText()),Double.parseDouble(luku2.getText()))));
                } catch (NumberFormatException exc) {
                    errorMessage("Virhe! Vääränlainen syöte. Anna luvut kokonais- tai liukulukuina. \n Huomaa, että liukuluvut erotellaan pisteellä", "Syötevirhe");
                }
            }
            else if(state == "Vähennyslasku") {
                try {
                    vastaus.setText(df.format(Operations.subtraction(Double.parseDouble(luku1.getText()),Double.parseDouble(luku2.getText()))));
                } catch (NumberFormatException exc) {
                    errorMessage("Virhe! Vääränlainen syöte. Anna luvut kokonais- tai liukulukuina. \n Huomaa, että liukuluvut erotellaan pisteellä", "Syötevirhe");
                }
            }
            else if(state == "Kertolasku") {
                try {
                    vastaus.setText(df.format(Operations.multiplication(Double.parseDouble(luku1.getText()),Double.parseDouble(luku2.getText()))));
                } catch (NumberFormatException exc) {
                    errorMessage("Virhe! Vääränlainen syöte. Anna luvut kokonais- tai liukulukuina. \n Huomaa, että liukuluvut erotellaan pisteellä", "Syötevirhe");
                }
            }
            else if(state == "Jakolasku") {
                if(Double.parseDouble(luku2.getText()) == 0) {
                    errorMessage("Virhe! Vääränlainen syöte. Nollalla ei voi jakaa", "Syötevirhe");
                }
                else {
                    try {
                        vastaus.setText(df.format(Operations.division(Double.parseDouble(luku1.getText()),Double.parseDouble(luku2.getText()))));
                    } catch (NumberFormatException exc) {
                        errorMessage("Virhe! Vääränlainen syöte. Anna luvut kokonais- tai liukulukuina. \n Huomaa, että liukuluvut erotellaan pisteellä", "Syötevirhe");
                    }
                }
            }
            else if(state == "Keskiarvo") {
                try {
                    ArrayList <Double> doublelista = new ArrayList<Double>();
                    ArrayList <String> luvut = new ArrayList<>(Arrays.asList(luku4.getText().split(",")));
                    for(int index = 0; index < luvut.size(); index++) {
                        doublelista.add(Double.parseDouble(luvut.get(index)));
                    }
                    Double[] arr = new Double[luvut.size()];
                    arr = doublelista.toArray(arr);
                    vastaus.setText(df.format(Operations.mean(arr)));
                } catch (NumberFormatException exc) {
                    errorMessage("Virhe! Vääränlainen syöte. Anna luvut kokonais- tai liukulukuina. \n Anna arvot pilkuilla eroteltuna. \n Huomaa, että liukuluvut erotellaan pisteellä", "Syötevirhe");
                }
            }
            else if(state == "Mediaani") {
                try {
                    ArrayList <Double> doublelista = new ArrayList<Double>();
                    ArrayList <String> luvut = new ArrayList<>(Arrays.asList(luku4.getText().split(",")));
                    for(int index = 0; index < luvut.size(); index++) {
                        doublelista.add(Double.parseDouble(luvut.get(index)));
                    }
                    Double[] arr = new Double[luvut.size()];
                    arr = doublelista.toArray(arr);
                    vastaus.setText(df.format(Operations.median(arr)));
                } catch (NumberFormatException exc) {
                    errorMessage("Virhe! Vääränlainen syöte. Anna luvut kokonais- tai liukulukuina. \n Anna arvot pilkuilla eroteltuna. \n Huomaa, että liukuluvut erotellaan pisteellä", "Syötevirhe");
                }
            }
            else if(valittu == null) {
                errorMessage("Virhe! Muista valita kummaksi haluat luvun muuttaa", "Funktiovirhe");
            }
            else if(state == "Celcius") {
                if(valittu == "FahrToCelc") {
                    try {
                        vastaus.setText(String.format("%.3f °C", Operations.fahrToCelc(Double.parseDouble(luku3.getText()))));
                    } catch (NumberFormatException exc) {
                        errorMessage("Virhe! Vääränlainen syöte. Anna luku kokonais- tai liukulukuna. \n Huomaa, että liukuluvut erotellaan pisteellä", "Syötevirhe");
                    }
                }
                else if(valittu == "CelcToFahr") {
                    try {
                        vastaus.setText(String.format("%.3f °F", Operations.celcToFahr(Double.parseDouble(luku3.getText()))));
                    } catch (NumberFormatException exc) {
                        errorMessage("Virhe! Vääränlainen syöte. Anna luku kokonais- tai liukulukuna. \n Huomaa, että liukuluvut erotellaan pisteellä", "Syötevirhe");
                    }
                }
            }
            else if(state == "Aste") {
                if(valittu == "RadToDeg") {
                    try {
                        vastaus.setText(String.format("%.3f °", Operations.radToDeg(Double.parseDouble(luku3.getText()))));
                    } catch (NumberFormatException exc) {
                        errorMessage("Virhe! Vääränlainen syöte. Anna luku kokonais- tai liukulukuna. \n Huomaa, että liukuluvut erotellaan pisteellä", "Syötevirhe");
                    }
                }
                else if(valittu == "DegToRad") {
                    try {
                        vastaus.setText(String.format("%.3f Rad", Operations.degToRad(Double.parseDouble(luku3.getText()))));
                    } catch (NumberFormatException exc) {
                        errorMessage("Virhe! Vääränlainen syöte. Anna luku kokonais- tai liukulukuna. \n Huomaa, että liukuluvut erotellaan pisteellä", "Syötevirhe");
                    }
                }
            }
        }

        else if(e.getSource() == option1) {
            if(state == "Celcius") {
                valittu = "FahrToCelc";
            }
            else if(state == "Aste") {
                valittu = "RadToDeg";
            }
        }
        else if(e.getSource() == option2) {
            if(state == "Celcius") {
                valittu = "CelcToFahr";
            }
            else if(state == "Aste") {
                valittu = "DegToRad";
            }
        }
        else if(e.getSource() == copy && vastaus != null) {
            String myString = vastaus.getText();
            StringSelection stringSelection = new StringSelection(myString);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        }

        if(state == "Yhteenlasku" || state == "Vähennyslasku" || state == "Kertolasku" || state == "Jakolasku") {
            f.add(operaatio); f.add(luku1); f.add(luku2); f.add(vastaus);
        }
        else if(state == "Keskiarvo" || state == "Mediaani") {
            f.add(vastaus); f.add(luku4);
        }
        else if(state == "Celcius" || state == "Aste") {
            f.add(luku3); f.add(option1); f.add(option2); f.add(vastaus);
        }

        f.revalidate();
        f.repaint();
    }

    public static void errorMessage(String message, String title) {

        JOptionPane.showMessageDialog(f, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {   

        new Mathematize();
    }    
}  
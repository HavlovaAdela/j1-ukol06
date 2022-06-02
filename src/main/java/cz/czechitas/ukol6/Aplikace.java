package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JTextField husyText;
    private JLabel husyLabel;
    private JSpinner kraliciText;
    private JLabel kraliciLabel;
    private JTextField pocetNohouText;
    private JLabel pocetNohouLabel;
    private JTextField pocetHlavText;
    private JLabel pocetHlavLabel;
    private JButton vypocitatButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        husyLabel = new JLabel("husy");
        husyText = new JTextField("vepiš počet hus");
        husyText.setHorizontalAlignment(JTextField.TRAILING);
        husyLabel.setLabelFor(husyText);
        add(husyLabel);
        add(husyText);


        kraliciLabel = new JLabel("králíci");
        SpinnerNumberModel mujModel= new SpinnerNumberModel(0,0,2147483647,1);
        kraliciText = new JSpinner(mujModel);

        kraliciLabel.setLabelFor(kraliciText);
        add(kraliciLabel);
        add(kraliciText);


        vypocitatButton = new JButton("vypočítat");
        getRootPane().setDefaultButton(vypocitatButton);
        add(vypocitatButton, "span, center");
        vypocitatButton.addActionListener(this::vypocitejButton);

        pocetHlavLabel = new JLabel("počet hlav");
        pocetHlavText = new JTextField();
        pocetHlavText.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavText.setEditable(false);
        pocetHlavLabel.setLabelFor(pocetHlavText);
        add(pocetHlavLabel);
        add(pocetHlavText);

        pocetNohouLabel = new JLabel("počet nohou");
        pocetNohouText = new JTextField();
        pocetNohouText.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohouText.setEditable(false);
        pocetNohouLabel.setLabelFor(pocetNohouText);
        add(pocetNohouLabel);
        add(pocetNohouText);


        //TODO implementovat formulář podle zadání

        pack();


    }

    private void vypocitejButton(ActionEvent actionEvent) {
        int pocetHlavKraliku = (Integer)kraliciText.getValue();
        int pocetHlavHus = Integer.parseInt(husyText.getText());

        int pocetHlav = pocetHlavHus + pocetHlavKraliku;

        int pocetNohou = pocetHlavHus * 2 + pocetHlavKraliku * 4;

        pocetHlavText.setText(Integer.toString(pocetHlav));
        pocetNohouText.setText(Integer.toString(pocetNohou));

    }

}

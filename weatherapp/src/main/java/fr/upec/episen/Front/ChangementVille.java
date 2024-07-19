package fr.upec.episen.Front;

import fr.upec.episen.ForecastResponse;
import fr.upec.episen.HttpRequestForecast;
import fr.upec.episen.Request;
import fr.upec.episen.Ville;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ChangementVille {
    private JFrame mainFrame;
    private JPanel mainPanel;

    public ChangementVille(){
        mainFrame = new JFrame();
        mainPanel = new JPanel();

        mainFrame.setSize(Template.getLargeur(), Template.getLongueur());
        mainFrame.setTitle("Météo by naw :)");
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);

        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.decode(Template.getCouleurPincipale()));

        ImageIcon logo = new ImageIcon(Objects.requireNonNull(Index.class.getResource("/application-meteo.png")));
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(10, 8, 70, 70);
        mainPanel.add(logoLabel);

        JLabel titre = new JLabel();
        titre.setText("Bienvenue sur votre app météo !");
        titre.setFont(Template.getMoyenneFont());
        titre.setBounds(90, 8, 350, 70);
        mainPanel.add(titre);

        JLabel texteChangementVille = new JLabel();
        texteChangementVille.setText("Pour quelle ville vouez vous avoir les prévisions météo ?");
        texteChangementVille.setFont(Template.getMoyenneFont());
        texteChangementVille.setBounds(110, 100, 350, 70);
        mainPanel.add(texteChangementVille);

        JTextField newCityTextflied = new JTextField();
        newCityTextflied.setBounds(300, 250, 350, 70);
        mainPanel.add(newCityTextflied);

        JButton valider = new JButton("Valider !");
        valider.setBounds(400, 350, 350, 70);
        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newCity = newCityTextflied.getText();
                Template.setVilleParDefaut(newCity);
                Index ecranAcceuil = new Index();
                mainFrame.dispose();
            }
        });

        mainFrame.getContentPane().add(mainPanel);
        mainFrame.setVisible(true);
    }
}

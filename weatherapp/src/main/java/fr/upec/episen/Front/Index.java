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

public class Index {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private Request request = new Request();
    private Ville ville = new Ville();
    private HttpRequestForecast httpRequestForecast;
    private ForecastResponse resultatRequeteForecast;
    private String descriptionMeteo = "";

    public Index(){
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

        ImageIcon changeCity= new ImageIcon(Objects.requireNonNull(Index.class.getResource("/ville-verte.png")));
        JButton changeCityButton=new JButton(changeCity);
        changeCityButton.setBounds(800,520,24,24);
        changeCityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangementVille changementVille = new ChangementVille();
                mainFrame.dispose();
            }
        });
        mainPanel.add(changeCityButton);

        JLabel titre = new JLabel();
        titre.setText("Bienvenue sur votre app météo !");
        titre.setFont(Template.getMoyenneFont());
        titre.setBounds(90, 8, 350, 70);
        mainPanel.add(titre);

        ville.setName(Template.getVilleParDefaut());
        ville = request.getCityInseeCode(ville.getName());
        if (ville.getInsee() != 0) {
            httpRequestForecast = new HttpRequestForecast();
            resultatRequeteForecast = httpRequestForecast.getForecastFromAPI();
        }
        descriptionMeteo = request.getWeatherInfo(resultatRequeteForecast.getForecast()[0].getWeather());

        JPanel encadre = new JPanel();
        encadre.setBounds(510,200,230,40);
        encadre.setBackground(Color.decode(Template.getCouleurSecondaire()));
        mainPanel.add(encadre);

        JPanel encadreWeather = new JPanel();
        encadreWeather.setBounds(270,370,300,40);
        encadreWeather.setBackground(Color.decode(Template.getCouleurSecondaire()));
        mainPanel.add(encadreWeather);

        JLabel nomVille = new JLabel();
        nomVille.setText(resultatRequeteForecast.getCity().getName());
        nomVille.setFont(Template.getMainFont());
        nomVille.setForeground(Color.white);
        //nomVille.setBounds(510,300,200,50);
        encadre.add(nomVille);

        JLabel temps = new JLabel();
        temps.setText(descriptionMeteo);
        temps.setFont(Template.getMoyenneFont());
        temps.setForeground(Color.white);
        encadreWeather.add(temps);

        JLabel minMax = new JLabel();
        minMax.setText("Voici le minimum et le maximum de températures aujourd'hui :");
        minMax.setFont(Template.getMoyenneFont());
        minMax.setBounds(120,430,700,50);
        mainPanel.add(minMax);

        JLabel temperatureMin = new JLabel();
        temperatureMin.setText(String.valueOf(resultatRequeteForecast.getForecast()[0].getTmin()));
        temperatureMin.setFont(Template.getTemperatureFont());
        temperatureMin.setBounds(350,490,50,50);
        mainPanel.add(temperatureMin);

        JLabel temperatureMax = new JLabel();
        temperatureMax.setText(String.valueOf(resultatRequeteForecast.getForecast()[0].getTmax()));
        temperatureMax.setFont(Template.getTemperatureFont());
        temperatureMax.setBounds(450,490,50,50);
        mainPanel.add(temperatureMax);

        ImageIcon iconeTemps = new ImageIcon(Objects.requireNonNull(Index.class.getResource(DisplayImages.displayImage(descriptionMeteo))));
        JLabel iconeTempsLabel = new JLabel(iconeTemps);
        iconeTempsLabel.setBounds(150, 90, 250, 250);
        mainPanel.add(iconeTempsLabel);

        mainFrame.getContentPane().add(mainPanel);
        mainFrame.setVisible(true);
    }

    public Ville getVille() {
        return ville;
    }
}

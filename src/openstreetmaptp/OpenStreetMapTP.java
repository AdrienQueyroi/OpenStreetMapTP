/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openstreetmaptp;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.Timer;

/**
 *
 * @author Adrien
 */
public class OpenStreetMapTP {
    public static Carte MaCarte = new Carte();
    public static Menu MonMenu = new Menu();
    public static Joueur MonJoueur = new Joueur();
    public static Partie LaPartie = new Partie();
    public static Timer timer = new Timer (50 , new Tache());
    public static Timer timer2 = new Timer (1000 , new Tache2());
    public static Salon LeSalon = new Salon();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //OutilsReseau.utiliserProxyENSMM();
        //Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/2017_s2_tp1", "2017_s2_tp1", "3K5HbSW4xz5cBFSY");
        MonMenu.setVisible(true);
        LeSalon.setVisible(true);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openstreetmaptp;

import javax.swing.Timer;

/**
 *
 * @author Adrien
 */
public class OpenStreetMapTP {
    public static Carte MaCarte = new Carte();
    public static Menu MonMenu = new Menu();
    public static Joueur MonJoueur = new Joueur();
    public static Timer timer = new Timer (50 , new Tache());
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //OutilsReseau.utiliserProxyENSMM();
        MonMenu.setVisible(true);
    }
    
}

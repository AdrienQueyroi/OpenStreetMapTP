/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openstreetmaptp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Adrien
 */
public class Tache2 implements ActionListener{
    
    long t1;
    
    public Tache2(){
        this.t1 = System.currentTimeMillis();
    }
    
    public void actionPerformed(ActionEvent e){
        
        System.out.println(System.currentTimeMillis()-t1);
        this.t1 = System.currentTimeMillis();
        
        try {

            Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/2017_s2_tp1", "2017_s2_tp1", "3K5HbSW4xz5cBFSY");

            PreparedStatement requete = connexion.prepareStatement("SELECT pseudo FROM Joueur WHERE nb_parties_jouees = '1'");
            ResultSet resultat = requete.executeQuery();
            
            while (resultat.next()) {
                String pseudo = resultat.getString("pseudo");
                OpenStreetMapTP.LeSalon.ajouteJoueur(pseudo);
            }

            requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}

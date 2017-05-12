/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openstreetmaptp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;

/**
 *
 * @author aqueyroi
 */
public class Tache implements ActionListener{
    
    long t1;
    
    public Tache(){
        this.t1 = System.currentTimeMillis();
    }
   
    public void actionPerformed(ActionEvent e){
        
        System.out.println(System.currentTimeMillis()-t1);
        this.t1 = System.currentTimeMillis();
        
        try {

            Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/2017_s2_tp1", "2017_s2_tp1", "3K5HbSW4xz5cBFSY");

            PreparedStatement requete = connexion.prepareStatement("SELECT pseudo, latitude, longitude FROM Joueur;");
            ResultSet resultat = requete.executeQuery();
            
            OpenStreetMapTP.MaCarte.ClearMap();
            while (resultat.next()) {
                String pseudo = resultat.getString("pseudo");
                double latitude = resultat.getDouble("latitude");
                double longitude = resultat.getDouble("longitude");
                if(pseudo.equals("Pikachu")){
                    System.out.println(pseudo + " = (" + latitude + "; " + longitude + ")");
                }
                
                OpenStreetMapTP.MaCarte.AjouteMarker(latitude, longitude, pseudo);
            }

            requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

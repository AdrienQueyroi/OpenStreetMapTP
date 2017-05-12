/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openstreetmaptp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Adrien
 */
public class Joueur {
    
    private double latitude;
    private double longitude;
    private String pseudo;
    private Tresor leTresor;
    
    public Joueur(String nom){
        this.pseudo = nom;
    }

    public Joueur(){}
    
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    public void setCoordonnnes(){
        try {

            Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/2017_s2_tp1", "2017_s2_tp1", "3K5HbSW4xz5cBFSY");

            PreparedStatement requete = connexion.prepareStatement("UPDATE joueur SET latitude = ?, longitude = ? WHERE pseudo = ?");
            requete.setDouble(1, this.latitude);
            requete.setDouble(2, this.longitude);
            requete.setString(3, this.pseudo);
            System.out.println(requete);
            requete.executeUpdate();

            requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public double getLatitude() {
        return latitude;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getPseudo() {
        return pseudo;
    }
    
    
    
}

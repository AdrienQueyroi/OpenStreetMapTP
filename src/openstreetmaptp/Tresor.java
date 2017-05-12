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
public class Tresor {
    private double latitude;
    private double longitude;
    private boolean cache;
    private long po;
    private String proprio;
    
    public Tresor(){
        this.latitude = 47.25;
        this.longitude = 5.99;
        this.cache = false;
        this.po = 500;
    }
    
    public Tresor(double lat,double longi,String proprietaire){
        this.latitude = lat;
        this.longitude = longi;
        this.cache = false;
        this.po = 100;
    }
    
    public void setTresor(){
        try {

            Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/2017_s2_tp1", "2017_s2_tp1", "3K5HbSW4xz5cBFSY");

            PreparedStatement requete = connexion.prepareStatement("INSERT INTO Trésor VALUES (?,?,?,?,?,?)");
            requete.setDouble(1, this.latitude);
            requete.setDouble(2, this.longitude);
            requete.setBoolean(3, this.cache);
            requete.setDouble(4, this.po);
            requete.setBoolean(5, false);
            requete.setString(6, this.proprio);
            System.out.println(requete);
            requete.executeUpdate();

            requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

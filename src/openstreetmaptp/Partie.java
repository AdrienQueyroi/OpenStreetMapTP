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
public class Partie {
    private int id;
    private boolean prive = false;
    
    public Partie(){
        this.id = 0;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Partie(int lid){
        this.id = lid;
    }

    public int getId() {
        return id;
    }
    
    public void creerPartie(){
        try {

                Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/2017_s2_tp1", "2017_s2_tp1", "3K5HbSW4xz5cBFSY");

                PreparedStatement requete = connexion.prepareStatement("INSERT INTO Partie VALUES (?,?)");
                requete.setInt(1, this.id);
                requete.setBoolean(2, prive);
                System.out.println(requete);
                requete.executeUpdate();

                requete.close();
                connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

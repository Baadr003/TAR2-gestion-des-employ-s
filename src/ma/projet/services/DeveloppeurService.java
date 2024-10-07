package ma.projet.services;

import ma.projet.beans.Developpeur;
import ma.projet.dao.IDao;
import ma.projet.connexion.Connexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeveloppeurService implements IDao<Developpeur> {
    @Override
    public boolean create(Developpeur o) {
        String sql = "INSERT INTO developpeur (nom, salaire) VALUES (?, ?)";
        try {
            PreparedStatement ps = Connexion.getCn().prepareStatement(sql);
            ps.setString(1, o.getNom());
          
            ps.setDouble(2, o.getSalaire());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Developpeur o) {
        String sql = "DELETE FROM developpeur WHERE id = ?";
        try {
            PreparedStatement ps = Connexion.getCn().prepareStatement(sql);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Developpeur o) {
        String sql = "UPDATE developpeur SET nom = ?, salaire = ? WHERE id = ?";
        try {
            PreparedStatement ps = Connexion.getCn().prepareStatement(sql);
            ps.setString(1, o.getNom());
          
            ps.setDouble(2, o.getSalaire());
            ps.setInt(3, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Developpeur findById(int id) {
        String sql = "SELECT * FROM developpeur WHERE id = ?";
        try {
            PreparedStatement ps = Connexion.getCn().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Developpeur(rs.getString("nom"), rs.getDouble("salaire"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Developpeur> findAll() {
        List<Developpeur> developpeurs = new ArrayList<>();
        String sql = "SELECT * FROM developpeur";
        try {
            PreparedStatement ps = Connexion.getCn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                developpeurs.add(new Developpeur(rs.getString("nom"), rs.getDouble("salaire")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developpeurs;
    }
}
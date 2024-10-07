package ma.projet.services;

import ma.projet.beans.Manager;
import ma.projet.dao.IDao;
import ma.projet.connexion.Connexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerService implements IDao<Manager> {
    @Override
    public boolean create(Manager o) {
        String sql = "INSERT INTO manager (nom, salaire) VALUES (?, ?)";
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
    public boolean delete(Manager o) {
        String sql = "DELETE FROM manager WHERE id = ?";
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
    public boolean update(Manager o) {
        String sql = "UPDATE manager SET nom = ?, prenom = ?, salaire = ? WHERE id = ?";
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
    public Manager findById(int id) {
        String sql = "SELECT * FROM manager WHERE id = ?";
        try {
            PreparedStatement ps = Connexion.getCn().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Manager(rs.getString("nom"), rs.getDouble("salaire"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Manager> findAll() {
        List<Manager> managers = new ArrayList<>();
        String sql = "SELECT * FROM manager";
        try {
            PreparedStatement ps = Connexion.getCn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                managers.add(new Manager(rs.getString("nom"), rs.getDouble("salaire")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return managers;
    }
}
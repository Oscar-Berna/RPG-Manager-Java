package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class Conexion {

    private static final String URL  = "jdbc:mysql://127.0.0.1:3306/rpg_manager";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void crearPersonaje(Personaje p) {
        String sql = "INSERT INTO personaje (nombre, clase, nivel, vida, vida_maxima, ataque, defensa) VALUES (?,?,?,?,?,?,?)";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getClase());
            ps.setInt   (3, p.getNivel());
            ps.setDouble(4, p.getVida());
            ps.setDouble(5, p.getVidaMaxima());
            ps.setInt   (6, p.getAtaque());
            ps.setInt   (7, p.getDefensa());
            ps.executeUpdate();
            System.out.println("Personaje " + p.getNombre() + " creado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear: " + e.getMessage());
        }
    }

    public static List<Personaje> listarPersonajes() {
        List<Personaje> lista = new ArrayList<>();
        String sql = "SELECT * FROM personaje";
        try (Connection c = getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                String clase = rs.getString("clase");
                Personaje p;
                switch (clase) {
                    case "Guerrero" -> p = new Guerrero(
                        rs.getString("nombre"), rs.getInt("nivel"),
                        rs.getDouble("vida"), rs.getDouble("vida_maxima"),
                        rs.getInt("ataque"), rs.getInt("defensa"), rs.getInt("id"));
                    case "Mago" -> p = new Mago(
                        rs.getString("nombre"), rs.getInt("nivel"),
                        rs.getDouble("vida"), rs.getDouble("vida_maxima"),
                        rs.getInt("ataque"), rs.getInt("defensa"), rs.getInt("id"));
                    default -> p = new Arquero(
                        rs.getString("nombre"), rs.getInt("nivel"),
                        rs.getDouble("vida"), rs.getDouble("vida_maxima"),
                        rs.getInt("ataque"), rs.getInt("defensa"), rs.getInt("id"));
                }
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    public static Personaje buscarPorNombre(String nombre) {
        String sql = "SELECT * FROM personaje WHERE nombre = ?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String clase = rs.getString("clase");
                return switch (clase) {
                    case "Guerrero" -> new Guerrero(
                        rs.getString("nombre"), rs.getInt("nivel"),
                        rs.getDouble("vida"), rs.getDouble("vida_maxima"),
                        rs.getInt("ataque"), rs.getInt("defensa"), rs.getInt("id"));
                    case "Mago" -> new Mago(
                        rs.getString("nombre"), rs.getInt("nivel"),
                        rs.getDouble("vida"), rs.getDouble("vida_maxima"),
                        rs.getInt("ataque"), rs.getInt("defensa"), rs.getInt("id"));
                    default -> new Arquero(
                        rs.getString("nombre"), rs.getInt("nivel"),
                        rs.getDouble("vida"), rs.getDouble("vida_maxima"),
                        rs.getInt("ataque"), rs.getInt("defensa"), rs.getInt("id"));
                };
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        return null;
    }

    public static void actualizarNivel(int id, int nuevoNivel) {
        String sql = "UPDATE personaje SET nivel = ? WHERE id = ?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, nuevoNivel);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if (rows == 0) System.out.println("Error: ID " + id + " no encontrado.");
            else           System.out.println("Nivel actualizado a " + nuevoNivel + ".");
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    public static void eliminarPersonaje(int id) {
        String sql = "DELETE FROM personaje WHERE id = ?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows == 0) System.out.println("Error: ID " + id + " no encontrado.");
            else           System.out.println("Personaje con ID " + id + " eliminado.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
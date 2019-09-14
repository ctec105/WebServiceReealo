/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author XxkokoxXT
 */
public class UsuarioDAO {

    public int registrarUsuario(String nombre, String apellido, String correo, String contraseña) {
        int resultado = 0;

        String sql = "INSERT INTO usuarios (nomUsu, apeUsu, correoUsu, passUsu) "
                + "VALUES (?, ?, ?, ?)";
        
        Connection cn = Dao.getConnection();
        
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, correo);
            ps.setString(4, contraseña);

            resultado = ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al intentar almacenar la información: " + e);
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al intentar cerrar la conexión: " + ex.getMessage());
            }
        }

        return resultado;
    }

}

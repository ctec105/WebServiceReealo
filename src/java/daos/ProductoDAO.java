/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author XxkokoxXT
 */
public class ProductoDAO {

    public List<Producto> listarProductos() {
        List<Producto> productosList = new ArrayList<Producto>();

        try {
            Connection cn = Dao.getConnection();

            String query = "SELECT * FROM productos";

            PreparedStatement ps = cn.prepareCall(query);

            ResultSet rs = ps.executeQuery();

            Producto p;

            while (rs.next()) {
                p = new Producto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6));
                productosList.add(p);
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }

        return productosList;
    }
 
    public int registrarProducto(String codigo, String descripcion, String detalle, Integer stock, Double precio, String imagen) {
        int resultado = 0;

        String sql = "INSERT INTO productos (codProd, descripcion, detalle, stock, precio, imagen) "
                + "VALUES (?, ?, ?, ?, ?, ? )";
        
        Connection cn = Dao.getConnection();
        
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.setString(2, descripcion);
            ps.setString(3, detalle);
            ps.setInt(4, stock);
            ps.setDouble(5, precio);
            ps.setString(6, imagen);
            
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
 
    public int actualizarProducto(String codigo, String descripcion, String detalle, Integer stock, Double precio, String imagen) {
        int resultado = 0;

        String sql = "UPDATE productos set  descripcion = ?, detalle = ?, stock = ?, precio = ?, imagen = ? where codProd = ?";
              
        
        Connection cn = Dao.getConnection();
        
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, descripcion);
            ps.setString(2, detalle);
            ps.setInt(3, stock);
            ps.setDouble(4, precio);
            ps.setString(5, imagen);
            ps.setString(6, codigo);
            
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

    public List<Producto> validarProducto(String codigo) {
        List<Producto> productosList = new ArrayList<Producto>();

        try {
            Connection cn = Dao.getConnection();

            String query = "SELECT * FROM productos WHERE codProd = '" + codigo + "'";

            PreparedStatement ps = cn.prepareCall(query);

            ResultSet rs = ps.executeQuery();

            Producto p;

            while (rs.next()) {
                p = new Producto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6));
                productosList.add(p);
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }

        return productosList;
    }
 
    
}

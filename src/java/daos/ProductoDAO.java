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

}

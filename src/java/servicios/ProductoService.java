/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import daos.ProductoDAO;
import entidades.Producto;
import java.util.List;

/**
 *
 * @author XxkokoxXT
 */
public class ProductoService {
    
    private ProductoDAO productoDAO;
    
    public ProductoService(){
        productoDAO = new ProductoDAO();
    }
    
    public List<Producto> listarProductos(){
        return productoDAO.listarProductos();
    }
    
}
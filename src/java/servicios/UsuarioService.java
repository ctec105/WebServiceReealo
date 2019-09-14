/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import daos.UsuarioDAO;

/**
 *
 * @author XxkokoxXT
 */
public class UsuarioService {
    
    private UsuarioDAO usuarioDAO;
    
    public UsuarioService(){
        usuarioDAO = new UsuarioDAO();
    }
    
    public int registrarUsuario(String noUsu, String apeUsu, String correoUsu, String passUsu){
        return usuarioDAO.registrarUsuario(noUsu, apeUsu, correoUsu, passUsu);
    }
    
}



import daos.UsuarioDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author XxkokoxXT
 */
public class Test {

    public static void main(String[] args) {
        registrarUsuario();
    }

    private static void registrarUsuario() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        int exito = usuarioDAO.registrarUsuario("José", "Toro", "jtoro@gmail.com", "123456");

        if (exito > 0) {
            System.out.println("Los datos se han guardado correctamente");
        } else {
            System.out.println("Los datos no se pudieron guardar");
        }
    }

}

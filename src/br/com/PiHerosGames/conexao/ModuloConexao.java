/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.PiHerosGames.conexao;

import java.sql.*;

public class ModuloConexao {

    // Método para estabelecer conexão com banco
    public static Connection conector() {
        java.sql.Connection conexao = null;
        //Chama o driver importado
        String driver = "com.mysql.jdbc.Driver";
        //Informações do Banco 
        String url = "jdbc:mysql://localhost:3306/projetointegrado";
        // Usuario e senha do banco de dados 
        String user = "root";
        String password = "";
        // Estabelesce a conexão com o banco 
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,user,password);
            return conexao;
        } catch (Exception e) {
            System.out.println("erro!");
            System.out.println(e);
            return null;
        }
    }
}

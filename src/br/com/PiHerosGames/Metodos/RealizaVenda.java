/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.PiHerosGames.Metodos;

import java.sql.*;
import br.com.PiHerosGames.conexao.ModuloConexao;
import javax.swing.JOptionPane;
/**
 *
 * @author eders
 */
public class RealizaVenda{
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void RealizaVenda(){
        conexao = ModuloConexao.conector();
    }
  
}

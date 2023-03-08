/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.PiHerosGames.Metodos;

import java.sql.*;
import br.com.PiHerosGames.conexao.ModuloConexao;
import br.com.PiHerosGames.Telas.CadastroProdutos;

/**
 *
 * @author eders
 */
public class InsercoesSQL {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
  
    public void cadastroProdutos() {
        String sqlCadProd = "INSERT INTO tb_produtos (descricao_produtos, marca_produtos, preco_produtos, caracteristica_produtos, estoque_produtos) VALUES (?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sqlCadProd);
  
        } catch (Exception e) {
        }
    }
}

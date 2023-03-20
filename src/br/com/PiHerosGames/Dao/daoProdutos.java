/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.PiHerosGames.Dao;

import br.com.PiHerosGames.conexao.ModuloConexao;
import javax.swing.JOptionPane;
import model.modelProdutos;
import java.sql.*;

/**
 *
 * @author eders
 */
public class daoProdutos extends ModuloConexao {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    public void salvarProdutosDAO(modelProdutos pModelProdutos) {
        String sql = "INSERT INTO tb_produtos (descricao_produtos,marca_produtos,preco_produtos,caracteristica_produtos,estoque_produtos) VALUES (?,?,?,?,?)";
        conn = new ModuloConexao().conector();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pModelProdutos.getNome_produto());
            pstm.setString(2, pModelProdutos.getMarca_produto());
            pstm.setString(3, Double.toString(pModelProdutos.getPreco_produto()));
            pstm.setString(4, pModelProdutos.getCaracteristica_produto());
            pstm.setString(5, Integer.toString(pModelProdutos.getEstoque_produto()));

            pstm.execute();
            pstm.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    public void consultarProdutosDao(modelProdutos pModelProdutos) {
        String sql = "SELECT * FROM tb_produtos WHERE descricao_produtos = ?";
        conn = new ModuloConexao().conector();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pModelProdutos.getNome_produto());
            rs = pstm.executeQuery();

            while (rs.next()) {
                pModelProdutos.setId_produto(rs.getInt("idtb_produtos"));
                pModelProdutos.setNome_produto(rs.getString(2));
                pModelProdutos.setMarca_produto(rs.getString(3));
                pModelProdutos.setPreco_produto(rs.getDouble("preco_produtos"));
                pModelProdutos.setCaracteristica_produto(rs.getString(5));
                pModelProdutos.setEstoque_produto(rs.getInt("estoque_produtos"));
            }
            pstm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
    public void editarProdutosDao(modelProdutos pModelProdutos){
        String sql = "UPDATE tb_produtos SET descricao_produtos= ?, marca_produtos= ?, preco_produtos= ?, caracteristica_produtos= ?, estoque_produtos= ? WHERE idtb_produtos= ?"; 
        conn = new ModuloConexao().conector();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pModelProdutos.getNome_produto());
            pstm.setString(2, pModelProdutos.getMarca_produto());
            pstm.setString(3, Double.toString(pModelProdutos.getPreco_produto()));
            pstm.setString(4, pModelProdutos.getCaracteristica_produto());
            pstm.setString(5, Integer.toString(pModelProdutos.getEstoque_produto()));
            pstm.setString(6, Integer.toString(pModelProdutos.getId_produto()));
            
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void deletarProdutosDao(modelProdutos pModelProdutos) {
        String sql = "DELETE FROM tb_produtos WHERE idtb_produtos =? ";
        conn = new ModuloConexao().conector();
        try {
             pstm = conn.prepareStatement(sql);
             pstm.setInt(1, pModelProdutos.getId_produto());
             pstm.execute();
             pstm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
}//Fim da classe


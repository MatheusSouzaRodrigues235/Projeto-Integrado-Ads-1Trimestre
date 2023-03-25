package br.com.PiHerosGames.Dao;

import model.ModelVendas;

import br.com.PiHerosGames.conexao.ModuloConexao;
import br.com.PiHerosGames.conexao.ConexaoMySql;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Matheus
 */
public class DAOVendas extends ConexaoMySql {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
    
    public boolean salvarDiversasVendasDao(ArrayList<ModelVendas> plistaVendas){
        String sql = "INSERT INTO tb_vendas (quantidade_vendas,total_vendas,pk_idtbProdutos) VALUES(?,?,?)";
        conn = new ModuloConexao().conector();
        try {
            int cont = plistaVendas.size();
            for (int i = 0; i < cont; i++) {
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, plistaVendas.get(i).getQuantidade_vendas());
                pstm.setDouble(2,plistaVendas.get(i).getTotal_vendas());
                pstm.setInt(3, plistaVendas.get(i).getIdtb_produtos());
                pstm.execute();
            }
            pstm.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
   

    /**
     * grava Vendas
     *
     * @param pModelVendas
     * @return int
     */
    public int salvarVendasDAO(ModelVendas pModelVendas) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO tb_vendas ("
                    + "total_vendas,"
                    + "fk_idtb_produtos"
                    + "qtdProd_vendass"
                    + ") VALUES ("
                    + "'" + pModelVendas.getTotal_vendas() + "',"
                    + "'" + pModelVendas.getIdtb_produtos() + ","
                    + "'" + pModelVendas.getQuantidade_vendas() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera Vendas
     *
     * @param pIdtb_vendas
     * @return ModelVendas
     */
    public ModelVendas getVendasDAO(int pIdtb_vendas) {
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_idtb_vendas,"
                    + "quantidade_vendas,"
                    + "total_vendas,"
                    + "fk_idtb_produtos"
                    + " FROM"
                    + " tb_vendas"
                    + " WHERE"
                    + " pk_idtb_vendas = '" + pIdtb_vendas + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendas.setIdtb_vendas(this.getResultSet().getInt(1));
                modelVendas.setQuantidade_vendas(this.getResultSet().getInt(2));
                modelVendas.setTotal_vendas(this.getResultSet().getDouble(3));
                modelVendas.setIdtb_produtos(this.getResultSet().getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelVendas;
    }

    /**
     * recupera uma lista de Vendas
     *
     * @return ArrayList
     */
    public ArrayList<ModelVendas> getListaVendasDAO() {
        ArrayList<ModelVendas> listamodelVendas = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_idtb_vendas,"
                    + "quantidade_vendas,"
                    + "total_vendas,"
                    + "fk_idtb_produtos"
                    + " FROM"
                    + " tb_vendas"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendas = new ModelVendas();
                modelVendas.setIdtb_vendas(this.getResultSet().getInt(1));
                modelVendas.setQuantidade_vendas(this.getResultSet().getInt(2));
                modelVendas.setTotal_vendas(this.getResultSet().getDouble(3));
                modelVendas.setIdtb_produtos(this.getResultSet().getInt(4));
                listamodelVendas.add(modelVendas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /**
     * atualiza Vendas
     *
     * @param pModelVendas
     * @return boolean
     */
    public boolean atualizarVendasDAO(ModelVendas pModelVendas) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tb_vendas SET "
                    + "pk_idtb_vendas = '" + pModelVendas.getIdtb_vendas() + "',"
                    + "quantidade_vendas = '" + pModelVendas.getQuantidade_vendas() + "',"
                    + "total_vendas = '" + pModelVendas.getTotal_vendas() + "',"
                    + "fk_idtb_produtos = '" + pModelVendas.getIdtb_produtos() + "'"
                    + " WHERE "
                    + "pk_idtb_vendas = '" + pModelVendas.getIdtb_vendas() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui Vendas
     *
     * @param pIdtb_vendas
     * @return boolean
     */
    public boolean excluirVendasDAO(int pIdtb_vendas) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tb_vendas "
                    + " WHERE "
                    + "pk_idtb_vendas = '" + pIdtb_vendas + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}

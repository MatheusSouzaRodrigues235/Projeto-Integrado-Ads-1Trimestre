package br.com.PiHerosGames.Dao;

import model.ModelProdutos;
import br.com.PiHerosGames.conexao.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Matheus
*/
public class DAOProdutos extends ConexaoMySql {

    /**
    * grava Produtos
    * @param pModelProdutos
    * @return int
    */
    public int salvarProdutosDAO(ModelProdutos pModelProdutos){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tb_produtos ("
                    + "descricao_produtos,"
                    + "marca_produtos,"
                    + "preco_produtos,"
                    + "caracteristica_produtos,"
                    + "estoque_produtos"
                + ") VALUES ("
                    + "'" + pModelProdutos.getNome_produto() + "',"
                    + "'" + pModelProdutos.getMarca_produto() + "',"
                    + "'" + pModelProdutos.getPreco_produtos() + "',"
                    + "'" + pModelProdutos.getCaracteristica_produtos() + "',"
                    + "'" + pModelProdutos.getEstoque_produtos() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera Produtos
    * @param pIdtb_vendas
    * @return ModelProdutos
    */
    public ModelProdutos getProdutosDAO(int pIdtb_vendas){
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "idtb_produtos,"
                    + "descricao_produtos,"
                    + "marca_produtos,"
                    + "preco_produtos,"
                    + "caracteristica_produtos,"
                    + "estoque_produtos"
                 + " FROM"
                     + " tb_produtos"
                 + " WHERE"
                     + " idtb_produtos = '" + pIdtb_vendas + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelProdutos.setIdtb_vendas(this.getResultSet().getInt(1));
                modelProdutos.setNome_produto(this.getResultSet().getString(2));
                modelProdutos.setMarca_produto(this.getResultSet().getString(3));
                modelProdutos.setPreco_produtos(this.getResultSet().getDouble(4));
                modelProdutos.setCaracteristica_produtos(this.getResultSet().getString(5));
                modelProdutos.setEstoque_produtos(this.getResultSet().getInt(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelProdutos;
    }
    
    /**
    * recupera Produtos
    * @param pNomeProduto
    * @return ModelProdutos
    */
    public ModelProdutos getProdutosDAO(String pNomeProduto){
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "idtb_produtos,"
                    + "descricao_produtos,"
                    + "marca_produtos,"
                    + "preco_produtos,"
                    + "caracteristica_produtos,"
                    + "estoque_produtos"
                 + " FROM"
                     + " tb_produtos"
                 + " WHERE"
                     + " descricao_produtos = '" + pNomeProduto + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelProdutos.setIdtb_vendas(this.getResultSet().getInt(1));
                modelProdutos.setNome_produto(this.getResultSet().getString(2));
                modelProdutos.setMarca_produto(this.getResultSet().getString(3));
                modelProdutos.setPreco_produtos(this.getResultSet().getDouble(4));
                modelProdutos.setCaracteristica_produtos(this.getResultSet().getString(5));
                modelProdutos.setEstoque_produtos(this.getResultSet().getInt(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelProdutos;
    }

    /**
    * recupera uma lista de Produtos
        * @return ArrayList
    */
    public ArrayList<ModelProdutos> getListaProdutosDAO(){
        ArrayList<ModelProdutos> listamodelProdutos = new ArrayList();
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "idtb_produtos,"
                    + "descricao_produtos,"
                    + "marca_produtos,"
                    + "preco_produtos,"
                    + "caracteristica_produtos,"
                    + "estoque_produtos"
                 + " FROM"
                     + " tb_produtos"
                + ";"
            );

            while(this.getResultSet().next()){
                modelProdutos = new ModelProdutos();
                modelProdutos.setIdtb_vendas(this.getResultSet().getInt(1));
                modelProdutos.setNome_produto(this.getResultSet().getString(2));
                modelProdutos.setMarca_produto(this.getResultSet().getString(3));
                modelProdutos.setPreco_produtos(this.getResultSet().getDouble(4));
                modelProdutos.setCaracteristica_produtos(this.getResultSet().getString(5));
                modelProdutos.setEstoque_produtos(this.getResultSet().getInt(6));
                listamodelProdutos.add(modelProdutos);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelProdutos;
    }

    /**
    * atualiza Produtos
    * @param pModelProdutos
    * @return boolean
    */
    public boolean atualizarProdutosDAO(ModelProdutos pModelProdutos){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tb_produtos SET "
                    + "idtb_produtos = '" + pModelProdutos.getIdtb_vendas() + "',"
                    + "descricao_produtos = '" + pModelProdutos.getNome_produto() + "',"
                    + "marca_produtos = '" + pModelProdutos.getMarca_produto() + "',"
                    + "preco_produtos = '" + pModelProdutos.getPreco_produtos() + "',"
                    + "caracteristica_produtos = '" + pModelProdutos.getCaracteristica_produtos() + "',"
                    + "estoque_produtos = '" + pModelProdutos.getEstoque_produtos() + "'"
                + " WHERE "
                    + "idtb_produtos = '" + pModelProdutos.getIdtb_vendas() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui Produtos
    * @param pIdtb_vendas
    * @return boolean
    */
    public boolean excluirProdutosDAO(int pIdtb_vendas){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tb_produtos "
                + " WHERE "
                    + "idtb_produtos = '" + pIdtb_vendas + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}
package controller;

import model.ModelProdutos;
import br.com.PiHerosGames.Dao.DAOProdutos;
import java.util.ArrayList;

/**
*
* @author Matheus
*/
public class ControllerProdutos {

    private DAOProdutos daoProdutos = new DAOProdutos();

    /**
    * grava Produtos
    * @param pModelProdutos
    * @return int
    */
    public int salvarProdutosController(ModelProdutos pModelProdutos){
        return this.daoProdutos.salvarProdutosDAO(pModelProdutos);
    }

    /**
    * recupera Produtos
    * @param pIdtb_vendas
    * @return ModelProdutos
    */
    public ModelProdutos getProdutosController(int pIdtb_vendas){
        return this.daoProdutos.getProdutosDAO(pIdtb_vendas);
    }

    /**
    * recupera uma lista deProdutos
    * @param pIdtb_vendas
    * @return ArrayList
    */
    public ArrayList<ModelProdutos> getListaProdutosController(){
        return this.daoProdutos.getListaProdutosDAO();
    }

    /**
    * atualiza Produtos
    * @param pModelProdutos
    * @return boolean
    */
    public boolean atualizarProdutosController(ModelProdutos pModelProdutos){
        return this.daoProdutos.atualizarProdutosDAO(pModelProdutos);
    }

    /**
    * exclui Produtos
    * @param pIdtb_vendas
    * @return boolean
    */
    public boolean excluirProdutosController(int pIdtb_vendas){
        return this.daoProdutos.excluirProdutosDAO(pIdtb_vendas);
    }
}
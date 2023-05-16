package controller;

import model.ModelVendas;
import br.com.PiHerosGames.Dao.DAOVendas;
import java.util.ArrayList;

/**
*
* @author Matheus
*/
public class ControllerVendas {

    private DAOVendas daoVendas = new DAOVendas();

    /**
    * grava Vendas
    * @param plistaVendas
    * @return int
    */
    public boolean salvarDiversasVendasDao(ArrayList<ModelVendas> plistaVendas){
        return this.daoVendas.salvarDiversasVendasDao(plistaVendas);
    }

     public ArrayList<ModelVendas> getListaVendasLeftJoinController(){
         return this.daoVendas.getListaVendasLeftJoin();
     }
    /**
    * recupera Vendas
    * @param pIdtb_vendas
    * @return ModelVendas
    */
    public ModelVendas getVendasController(int pIdtb_vendas){
        return this.daoVendas.getVendasDAO(pIdtb_vendas);
    }

    /**
    * recupera uma lista deVendas
    * @param pIdtb_vendas
    * @return ArrayList
    */
    public ArrayList<ModelVendas> getListaVendasController(){
        return this.daoVendas.getListaVendasDAO();
    }

    /**
    * atualiza Vendas
    * @param pModelVendas
    * @return boolean
    */
    public boolean atualizarVendasController(ModelVendas pModelVendas){
        return this.daoVendas.atualizarVendasDAO(pModelVendas);
    }

    /**
    * exclui Vendas
    * @param pIdtb_vendas
    * @return boolean
    */
    public boolean excluirVendasController(int pIdtb_vendas){
        return this.daoVendas.excluirVendasDAO(pIdtb_vendas);
    }
}
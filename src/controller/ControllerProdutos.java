/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import br.com.PiHerosGames.Dao.daoProdutos;
import javax.swing.JOptionPane;
import model.modelProdutos;

/**
 *
 * @author eders
 */
public class ControllerProdutos {
    private daoProdutos DaoProdutos = new daoProdutos();
    
    public int salvarProdutoController(modelProdutos pModelProdutos){
        try {
            DaoProdutos.salvarProdutosDAO(pModelProdutos);
            JOptionPane.showMessageDialog(null, "Produto deletado com sucesso");
            return 1;
        } catch (Exception e) {
        
        return 0;
        }
    }
    public void consultarProdutosController(modelProdutos pModelProdutos){
        try {
            DaoProdutos.consultarProdutosDao(pModelProdutos);
            
        } catch (Exception e) {
            
        }
    }
    public int editarProdutoController(modelProdutos pModelProdutos){
        try {
            DaoProdutos.editarProdutosDao(pModelProdutos);
            JOptionPane.showMessageDialog(null, "Produto editado com sucesso");
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    public int deletarProdutoController(modelProdutos pModeProdutos){
        try {
            DaoProdutos.deletarProdutosDao(pModeProdutos);
            JOptionPane.showMessageDialog(null, "Produto deletado com sucesso");
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}

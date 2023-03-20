/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author eders
 */
public class modelVendas {
    private int id_venda;
    private int quantidade_venda;
    private double precoItem_venda;
    private double total_venda;
    private int id_produto;

    /**
     * @return the id_venda
     */
    public int getId_venda() {
        return id_venda;
    }

    /**
     * @param id_venda the id_venda to set
     */
    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    /**
     * @return the quantidade_venda
     */
    public int getQuantidade_venda() {
        return quantidade_venda;
    }

    /**
     * @param quantidade_venda the quantidade_venda to set
     */
    public void setQuantidade_venda(int quantidade_venda) {
        this.quantidade_venda = quantidade_venda;
    }

    /**
     * @return the precoItem_venda
     */
    public double getPrecoItem_venda() {
        return precoItem_venda;
    }

    /**
     * @param precoItem_venda the precoItem_venda to set
     */
    public void setPrecoItem_venda(double precoItem_venda) {
        this.precoItem_venda = precoItem_venda;
    }

    /**
     * @return the total_venda
     */
    public double getTotal_venda() {
        return total_venda;
    }

    /**
     * @param total_venda the total_venda to set
     */
    public void setTotal_venda(double total_venda) {
        this.total_venda = total_venda;
    }

    /**
     * @return the id_produto
     */
    public int getId_produto() {
        return id_produto;
    }

    /**
     * @param id_produto the id_produto to set
     */
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }
    
}

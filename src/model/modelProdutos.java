/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



/**
 *
 * @author eders
 */
public class modelProdutos  {
     private int id_produto;
     private String nome_produto;
     private String marca_produto;
     private double preco_produto;
     private String caracteristica_produto;
     private int estoque_produto;

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

    /**
     * @return the nome_produto
     */
    public String getNome_produto() {
        return nome_produto;
    }

    /**
     * @param nome_produto the nome_produto to set
     */
    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    /**
     * @return the marca_produto
     */
    public String getMarca_produto() {
        return marca_produto;
    }

    /**
     * @param marca_produto the marca_produto to set
     */
    public void setMarca_produto(String marca_produto) {
        this.marca_produto = marca_produto;
    }

    /**
     * @return the preco_produto
     */
    public double getPreco_produto() {
        return preco_produto;
    }

    /**
     * @param preco_produto the preco_produto to set
     */
    public void setPreco_produto(double preco_produto) {
        this.preco_produto = preco_produto;
    }

    /**
     * @return the caracteristica_produto
     */
    public String getCaracteristica_produto() {
        return caracteristica_produto;
    }

    /**
     * @param caracteristica_produto the caracteristica_produto to set
     */
    public void setCaracteristica_produto(String caracteristica_produto) {
        this.caracteristica_produto = caracteristica_produto;
    }

    /**
     * @return the estoque_produto
     */
    public int getEstoque_produto() {
        return estoque_produto;
    }

    /**
     * @param estoque_produto the estoque_produto to set
     */
    public void setEstoque_produto(int estoque_produto) {
        this.estoque_produto = estoque_produto;
    }
     
}

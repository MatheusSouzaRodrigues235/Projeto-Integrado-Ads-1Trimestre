package model;
/**
*
* @author Matheus
*/
public class ModelProdutos {

    private int idtb_vendas;
    private String nome_produto;
    private String marca_produto;
    private double preco_produtos;
    private String caracteristica_produtos;
    private int estoque_produtos;

    /**
    * Construtor
    */
    public ModelProdutos(){}

    /**
    * seta o valor de idtb_vendas
    * @param pIdtb_vendas
    */
    public void setIdtb_vendas(int pIdtb_vendas){
        this.idtb_vendas = pIdtb_vendas;
    }
    /**
    * @return pk_idtb_vendas
    */
    public int getIdtb_vendas(){
        return this.idtb_vendas;
    }

    /**
    * seta o valor de nome_produto
    * @param pNome_produto
    */
    public void setNome_produto(String pNome_produto){
        this.nome_produto = pNome_produto;
    }
    /**
    * @return nome_produto
    */
    public String getNome_produto(){
        return this.nome_produto;
    }

    /**
    * seta o valor de marca_produto
    * @param pMarca_produto
    */
    public void setMarca_produto(String pMarca_produto){
        this.marca_produto = pMarca_produto;
    }
    /**
    * @return marca_produto
    */
    public String getMarca_produto(){
        return this.marca_produto;
    }

    /**
    * seta o valor de preco_produtos
    * @param pPreco_produtos
    */
    public void setPreco_produtos(double pPreco_produtos){
        this.preco_produtos = pPreco_produtos;
    }
    /**
    * @return preco_produtos
    */
    public double getPreco_produtos(){
        return this.preco_produtos;
    }

    /**
    * seta o valor de caracteristica_produtos
    * @param pCaracteristica_produtos
    */
    public void setCaracteristica_produtos(String pCaracteristica_produtos){
        this.caracteristica_produtos = pCaracteristica_produtos;
    }
    /**
    * @return caracteristica_produtos
    */
    public String getCaracteristica_produtos(){
        return this.caracteristica_produtos;
    }

    /**
    * seta o valor de estoque_produtos
    * @param pEstoque_produtos
    */
    public void setEstoque_produtos(int pEstoque_produtos){
        this.estoque_produtos = pEstoque_produtos;
    }
    /**
    * @return estoque_produtos
    */
    public int getEstoque_produtos(){
        return this.estoque_produtos;
    }

    @Override
    public String toString(){
        return "ModelProdutos {" + "::idtb_vendas = " + this.idtb_vendas + "::nome_produto = " + this.nome_produto + "::marca_produto = " + this.marca_produto + "::preco_produtos = " + this.preco_produtos + "::caracteristica_produtos = " + this.caracteristica_produtos + "::estoque_produtos = " + this.estoque_produtos +  "}";
    }
}
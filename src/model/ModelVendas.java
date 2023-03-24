package model;
/**
*
* @author Matheus
*/
public class ModelVendas {

    private int idtb_vendas;
    private int quantidade_vendas;
    private double total_vendas;
    private int idtb_produtos;

    /**
    * Construtor
    */
    public ModelVendas(){}

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
    * seta o valor de quantidade_vendas
    * @param pQuantidade_vendas
    */
    public void setQuantidade_vendas(int pQuantidade_vendas){
        this.quantidade_vendas = pQuantidade_vendas;
    }
    /**
    * @return quantidade_vendas
    */
    public int getQuantidade_vendas(){
        return this.quantidade_vendas;
    }

    /**
    * seta o valor de total_vendas
    * @param pTotal_vendas
    */
    public void setTotal_vendas(double pTotal_vendas){
        this.total_vendas = pTotal_vendas;
    }
    /**
    * @return total_vendas
    */
    public double getTotal_vendas(){
        return this.total_vendas;
    }

    /**
    * seta o valor de idtb_produtos
    * @param pIdtb_produtos
    */
    public void setIdtb_produtos(int pIdtb_produtos){
        this.idtb_produtos = pIdtb_produtos;
    }
    /**
    * @return fk_idtb_produtos
    */
    public int getIdtb_produtos(){
        return this.idtb_produtos;
    }

    @Override
    public String toString(){
        return "ModelVendas {" + "::idtb_vendas = " + this.idtb_vendas + "::quantidade_vendas = " + this.quantidade_vendas + "::total_vendas = " + this.total_vendas + "::idtb_produtos = " + this.idtb_produtos +  "}";
    }
}
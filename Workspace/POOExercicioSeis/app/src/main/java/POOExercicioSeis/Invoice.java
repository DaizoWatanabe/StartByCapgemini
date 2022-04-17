/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POOExercicioSeis;

/**
 *
 * @author daizo.watanabe
 */
public class Invoice {
    
    private int itemNumber;
    private String descricaoItem;
    private int qtd;
    private float precoUn;
    
    public Invoice(int itemNumber, String descricaoItem, int qtd, float precoUn) {
        this.setItemNumber(itemNumber);
        this.setDescricaoItem(descricaoItem);
        this.setQtd(qtd);        this.setPrecoUn(precoUn);
        
    }
    
    public double getInvoiceAmount() {
        return qtd * precoUn;
    }
    
    public int getItemNumber() {
        return itemNumber;
    }
    
    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }
    
    public String getDescricaoItem() {
        return descricaoItem;
    }
    
    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }
    
    public int getQtd() {
        return qtd;
    }
    
    public void setQtd(int qtd) {
        if (qtd < 0) {
            this.qtd = 0;
        } else {
            this.qtd = qtd;
        }
    }
    
    public float getPrecoUn() {
        return precoUn;
    }
    
    public void setPrecoUn(float precoUn) {
        if (precoUn < 0) {
            this.precoUn = 0.00f;
        } else {
            this.precoUn = precoUn;
        }
    }
    
}

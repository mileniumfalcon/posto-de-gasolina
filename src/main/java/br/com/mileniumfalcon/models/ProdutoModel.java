/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.models;

import static com.oracle.jrockit.jfr.ContentType.Timestamp;
import java.security.Timestamp;
import java.sql.Date;
import java.text.DateFormat;


/**
 *
 * @author pablo.osantana
 */
public class ProdutoModel {

    private int idProduto;
    private String nome;
    private String tipoProduto;
    private double qtdProduto;
    private double vlrUnitario;
    private int idFilial;
//    private Date dtCriado;

    
      public ProdutoModel(String nome, String tipoProduto, double qtdProduto, double vlrUnitario) {
        this.nome = nome;
        this.tipoProduto = tipoProduto;
        this.qtdProduto = qtdProduto;
        this.vlrUnitario = vlrUnitario;
       
      //  this.dtCriado = dtCriado;
    }
    public ProdutoModel(String nome, String tipoProduto, double qtdProduto, double vlrUnitario,int idFilial) {
        this.nome = nome;
        this.tipoProduto = tipoProduto;
        this.qtdProduto = qtdProduto;
        this.vlrUnitario = vlrUnitario;
        this.idFilial = idFilial;
      //  this.dtCriado = dtCriado;
    }

    public ProdutoModel(int idProduto, String nome, String tipoProduto, double qtdProduto, double vlrUnitario, int idFilial) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.tipoProduto = tipoProduto;
        this.qtdProduto = qtdProduto;
        this.vlrUnitario = vlrUnitario;
        this.idFilial = idFilial;
      //  this.dtCriado = dtCriado;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public double getVlrUnitario() {
        return vlrUnitario;
    }

    public void setVlrUnitario(double vlrUnitario) {
        this.vlrUnitario = vlrUnitario;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }

    public double getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(double qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

//    public Date getDtCriado() {
//        return dtCriado;
//    }
//
//    public void setDtCriado(Date dtCriado) {
//        this.dtCriado = dtCriado;
//    }

}

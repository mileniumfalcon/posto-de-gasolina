/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.models;

import java.text.DateFormat;
import javax.swing.text.DateFormatter;

/**
 *
 * @author pablo.osantana
 */
public class ProductModel {

    private int idProduct;
    private String name;
    private String typeProduct;
    private double qttProduct;
    private double untValue;
    private int idFilial;
    private DateFormatter dtCreate;

    public ProductModel(String name, String typeProduct, double qttProduct, double untValue,  DateFormatter dtCreate, int idFilial) {
        this.name = name;
        this.typeProduct = typeProduct;
        this.qttProduct = qttProduct;
        this.untValue = untValue;
        this.idFilial = idFilial;
        this.dtCreate = dtCreate;
    }

    public ProductModel(int idProduct, String name, String typeProduct, double qttProduct, double untValue, int idFilial, DateFormatter dtCreate) {
        this.idProduct = idProduct;
        this.name = name;
        this.typeProduct = typeProduct;
        this.qttProduct = qttProduct;
        this.untValue = untValue;
        this.idFilial = idFilial;
        this.dtCreate = dtCreate;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public double getUntValue() {
        return untValue;
    }

    public void setUntValue(double untValue) {
        this.untValue = untValue;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }

}

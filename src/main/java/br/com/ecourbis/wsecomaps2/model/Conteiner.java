/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecourbis.wsecomaps2.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jalima
 */
@XmlRootElement
public class Conteiner {

    private Integer id;
    private String model;
    private String sigla;
    private String unidade;
    private String lider;
    private String num_coteiner;
    private String termo;
    private String status;
    private Double lat;
    private Double log;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    public String getNum_coteiner() {
        return num_coteiner;
    }

    public void setNum_coteiner(String num_coteiner) {
        this.num_coteiner = num_coteiner;
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLog() {
        return log;
    }

    public void setLog(Double log) {
        this.log = log;
    }

    @Override
    public String toString() {
        return "Conteiner{" + "id=" + id + ", model=" + model + ", sigla=" + sigla
                + ", unidade=" + unidade + ", lider=" + lider + ", num_coteiner="
                + num_coteiner + ", termo=" + termo + ", status=" + status
                + ", lat=" + lat + ", log=" + log + '}';
    }

}

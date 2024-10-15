/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecourbis.wsecomaps2.controller;

import br.com.ecourbis.wsecomaps2.dao.ConteinerDAO;
import br.com.ecourbis.wsecomaps2.model.Conteiner;
import java.util.ArrayList;

/**
 *
 * @author jalima
 */
public class ConteinerController {

    public ArrayList<Conteiner> listaConteiner(Double lat, Double log, Double raio) {
        return ConteinerDAO.getInstance().listConteinerInRaio(lat, log, raio);
    }
}

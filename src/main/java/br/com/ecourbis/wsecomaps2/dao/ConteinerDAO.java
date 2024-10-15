/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecourbis.wsecomaps2.dao;

import br.com.ecourbis.wsecomaps2.factory.ConnectionFactory;
import br.com.ecourbis.wsecomaps2.model.Conteiner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jalima
 */
public class ConteinerDAO extends ConnectionFactory {

    private static ConteinerDAO instance;

    private Connection connection = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    /**
     * Método responsável por criar uma instancia da classe
     * ConteinerDAO(Singleton)
     *
     * @return
     */
    public static ConteinerDAO getInstance() {
        if (instance == null) {
            instance = new ConteinerDAO();
        }
        return instance;
    }

    /**
     * método responsável por retornar os container dentro do range estabelecido
     *
     * @param lat
     * @param log
     * @param raio
     * @return     */
    public ArrayList<Conteiner> listConteinerInRaio(Double lat, Double log, Double raio) {
        ArrayList<Conteiner> conteiners = new ArrayList<>();

        try {
            connection = openConexao();
            pstmt = connection
                    .prepareStatement(""
                            + "SELECT\n"
                            + " CodEco AS ID, MODELO, SIGLASUB,UNIDADE,	LIDER, NumCont AS NUM_CONTE, TERMO, Status AS 'SATATUS', LAT, LONG\n"
                            + "FROM CONTEINERES.dbo.tblConteineres\n "
                            + " WHERE (LAT BETWEEN (("+ lat + ") + (-" + raio + ")) AND ((" + lat + ") + (" + raio + ")))\n" 
                            + " AND LONG BETWEEN ((" + log + ") + (-" + raio + ")) AND ((" + log + ") + (" + raio + "))\n"
                            + "order by ID");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Conteiner cnt = new Conteiner();

                cnt.setId(rs.getInt("ID"));
                cnt.setModel(rs.getString("MODELO"));
                cnt.setSigla(rs.getString("SIGLASUB"));
                cnt.setUnidade(rs.getString("UNIDADE"));
                cnt.setLider(rs.getString("LIDER"));
                cnt.setNum_coteiner(rs.getString("NUM_CONTE"));
                cnt.setTermo(rs.getString("TERMO"));
                cnt.setStatus(rs.getString("SATATUS"));
                cnt.setLat(rs.getDouble("LAT"));
                cnt.setLog(rs.getDouble("LONG"));

                conteiners.add(cnt);
            }

            closeConexao(connection, pstmt, rs);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conteiners;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecourbis.wsecomaps2.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jalima
 */
public class ConnectionFactory {

    private final ResultSet rs = null;

    private static final String USER = "SIGA";
    private static final String PASS = "SIGA";
    private static final String DRIVE = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//caso va usar mysql alterar o drive de conexão
    private static final String URL = "jdbc:sqlserver://localhost\\intancia:1433";//

    public static Connection openConexao() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVE);
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public void closeConexao(Connection connection, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (connection != null) {
                connection.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

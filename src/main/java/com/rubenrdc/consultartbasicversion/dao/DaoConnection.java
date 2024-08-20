package com.rubenrdc.consultartbasicversion.dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class DaoConnection {

    private final CharPropieties charPropieties = new CharPropieties();

    public DaoConnection() {
    }
    Connection conectar;
    private final String PUERTO = "3306";

    private final String CADENA = ("jdbc:mysql://" + CharPropieties.getIp() + ":" + PUERTO + "/" + CharPropieties.getBd());

    public Connection ExtablecerC() {
        conectar = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("CADENA= "+CADENA);
            conectar = DriverManager.getConnection(CADENA, CharPropieties.getUser(), CharPropieties.getPass());
            //JOptionPane.showMessageDialog(null, "Se establecio la conexion exitosamente");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            //System.out.println("ex " + e);
            JOptionPane.showMessageDialog(null, "No se logro conectar a la base de datos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, e, "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
        //System.out.println("conectar " + conectar);
        return conectar;

    }

    public void getCloseC() {
        if (conectar != null) {
            try {
                conectar.close();
                conectar = null;
            } catch (SQLException ex) {

            }
        }
    }

    public ResultSet QueryById(String Query, int IdParam) {

        try {
            PreparedStatement ps = conectar.prepareStatement(Query);
            ps.setInt(1, IdParam);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {

        }
        return null;
    }

    public boolean GenericUpdate(String Query, java.util.List<String> params) {
        try {
            PreparedStatement ps = conectar.prepareStatement(Query);
            int index = 1;
            for (String param : params) {
                ps.setString(index, verificString(param));
                index++;
            }
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean GenericUpdate(String Query, Object... params) {
        try {
            PreparedStatement ps = conectar.prepareStatement(Query);
            int index = 1;
            for (Object param : params) {
                ps.setObject(index, verificString(param));
                index++;
            }
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean GenericCompuestUpdate(String[] Querys, List<Object[]> listParams) {
        try {
            int generateKeys = 0;
            conectar.setAutoCommit(false);
            for (int i = 0; i < Querys.length; i++) {
                PreparedStatement prepareStatement = conectar.prepareStatement(Querys[i], PreparedStatement.RETURN_GENERATED_KEYS);
                Object[] get = listParams.get(i);
                int index = 1;
                //System.out.println("generateKeys -> " + generateKeys);
                if (generateKeys != 0) {
                    prepareStatement.setObject(index, generateKeys);
                    index++;
                }
                for (Object get1 : get) {
                    prepareStatement.setObject(index, get1);
                    index++;
                }
                //System.out.println("PreparedStatement -> " + prepareStatement.toString());
                prepareStatement.executeUpdate();
                ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
                while (generatedKeys.next()) {
                    generateKeys = generatedKeys.getInt(1);

                }
            }
            conectar.commit();
            return true;
        } catch (SQLException ex) {
            try {
                conectar.rollback();
            } catch (SQLException ex1) {
                System.out.println("ex1 " + ex1);
            }
            System.out.println("ex " + ex);
        }
        return false;
    }

    public ResultSet GenericQuery(String Query, java.util.List<String> params) {
        try {
            PreparedStatement ps = conectar.prepareStatement(Query);
            int index = 1;
            if (params != null) {
                for (String param : params) {
                    ps.setString(index, verificString(param));
                    index++;
                }
            }
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {

        }
        return null;
    }

    public ResultSet GenericQuery(String Query, Object... params) {
        try {
            PreparedStatement ps = conectar.prepareStatement(Query);
            int index = 1;
            if (params != null) {
                for (Object param : params) {
                    ps.setObject(index, verificString(param));
                    index++;
                }
            }
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println("ex -> " + ex);
        }
        return null;
    }

    private <T> T verificString(T txt) {//Filtro de Texto, Si la CADENA no tiene caracteres, se reemplaza por nulo.
        if (txt != null) {
            if (txt instanceof String string) {
                if (string.length() > 0) {
                    return txt;
                }
            } else {
                return txt;
            }
        }
        return null;
    }
}

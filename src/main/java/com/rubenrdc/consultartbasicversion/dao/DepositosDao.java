package com.rubenrdc.consultartbasicversion.dao;

import com.rubenrdc.consultartbasicversion.models.Deposito;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruben
 */
public class DepositosDao {

    private final static int limitDep = 10;
    private static final DaoConnection C = new DaoConnection();

    public DepositosDao() {
    }

    public static List<Deposito> getListDeps() {
        if (C.ExtablecerC() != null) {
            List<Deposito> listDepSimple = new ArrayList<>();
            String Query = "SELECT * FROM depositos;";
            ResultSet rsdepositos = C.GenericQuery(Query);
            try {
                while (rsdepositos.next()) {
                    listDepSimple.add(new Deposito(rsdepositos.getInt("id"), rsdepositos.getString("descrip")));
                }
            } catch (SQLException ex) {

            }
            C.getCloseC();
            return listDepSimple;
        }
        return null;
    }

    public static List<Deposito> getListDepsByTitleAndProv(String provincia, String desc, int limiteLista) {

        if (C.ExtablecerC() != null) {
            List<Deposito> listComplet = new ArrayList<>();

            String Query = "SELECT * FROM depositos WHERE descrip LIKE ? AND id LIKE ? LIMIT " + limiteLista;
            ResultSet rs = C.GenericQuery(Query, "%" + desc + "%", "%" + provincia + "%");
            try {
                while (rs.next()) {
                    listComplet.add(new Deposito(rs.getInt("id"), rs.getString("descrip"), rs.getString("provincia"), rs.getString("localidad"), rs.getString("direccion"), rs.getInt("numero")));
                }
            } catch (SQLException ex) {

            }
            C.getCloseC();
            return listComplet;
        }

        return null;
    }

    public static Deposito getDepById(String idDep) {

        if (C.ExtablecerC() != null) {
            String Query = "SELECT * FROM depositos WHERE id = ?";

            ResultSet rs = C.QueryById(Query, Integer.parseInt(idDep));
            try {
                while (rs.next()) {
                    return new Deposito(rs.getInt("id"), rs.getString("descrip"), rs.getString("provincia"), rs.getString("localidad"), rs.getString("direccion"), rs.getInt("numero"));
                }
            } catch (SQLException ex) {

            }
            C.getCloseC();
            return null;
        }
        return null;
    }

    public static int getLimitDep() {
        return limitDep;
    }

    public static boolean delectDep(int idDep) {
        if (C.ExtablecerC() != null) {
            String Query = "DELETE FROM depositos where depositos.id = ?;";
            boolean exito = C.GenericUpdate(Query, idDep);
            C.getCloseC();
            return exito;
        }
        return false;
    }

    public static boolean insertNewDep(Deposito dep) {

        if (C.ExtablecerC() != null) {
            String Query = "INSERT INTO depositos (descrip,provincia,localidad,direccion,numero) VALUES (?,?,?,?,?);";
            boolean exito = C.GenericUpdate(Query, dep.getNombre(), dep.getProvincia(), dep.getLocalidad(), dep.getDireccion(), dep.getNumDireccion());
            C.getCloseC();
            return exito;
        }
        return false;
    }

    public static boolean updateDep(Deposito dep) {

        if (C.ExtablecerC() != null) {
            String Query = "UPDATE depositos SET descrip = ? ,provincia = ? ,localidad = ?,direccion = ?, numero = ? WHERE id = ?;";
            boolean exito = C.GenericUpdate(Query, dep.getNombre(), dep.getProvincia(), dep.getLocalidad(), dep.getDireccion(), dep.getNumDireccion(), dep.getId());
            C.getCloseC();
            return exito;
        }
        return false;
    }
}

package com.rubenrdc.consultartbasicversion.dao;

import com.rubenrdc.consultartbasicversion.models.Articulo;
import com.rubenrdc.consultartbasicversion.models.ArticuloUbicacion;
import com.rubenrdc.consultartbasicversion.models.Deposito;
import com.rubenrdc.consultartbasicversion.models.Ubicacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruben
 */
public class UbicacionDao {

    private static final DaoConnection genericDao = new DaoConnection();
    private static String Query;

    public static int findUbicacionIdByUbic(String Ubic) {
        if (genericDao.ExtablecerC() != null) {
            try {
                int id = 0;
                Query = "SELECT id FROM ubicaciones WHERE ubic = ? LIMIT 1";
                ResultSet GenericQuery = genericDao.GenericQuery(Query, Ubic);
                while(GenericQuery.next()){
                   id = GenericQuery.getInt("id");
                }
                genericDao.getCloseC();
                return id;
            } catch (SQLException ex) {
            }
        }
        return 0;
    }

    public static boolean deleteUbic(int idUbicP) {
        if (genericDao.ExtablecerC() != null) {
            boolean exito;
            Query = "DELETE FROM ubicaciones WHERE id = ?";
            exito = genericDao.GenericUpdate(Query, idUbicP);
            genericDao.getCloseC();
            return exito;
        }
        return false;
    }

    public static List<ArticuloUbicacion> findUbicacionFromArticulo(Articulo art) {

        if (genericDao.ExtablecerC() != null) {
            try {
                Query = """
                   SELECT ua.id, ua.idDep,d.descrip,ua.idUbic, ux.ubic, (SELECT SUM(stockArt)
                   FROM ubicaciones_articulos u
                   WHERE u.idArt = ua.idArt
                   AND u.idDep = ua.idDep
                   AND u.idUbic = ua.idUbic) AS stockInUbic
                   FROM articulos art
                   INNER JOIN ubicaciones_articulos ua ON ua.idArt = art.id
                   LEFT JOIN depositos d ON ua.idDep = d.id
                   LEFT JOIN ubicaciones ux ON ux.id = ua.idUbic
                   WHERE art.codigo = ?
                   GROUP BY ua.id, ua.idDep, ua.idUbic ORDER BY ua.idDep;
                               """;
                ResultSet GenericQuery = genericDao.GenericQuery(Query, art.getCodigo());
                List<ArticuloUbicacion> listCantsFromUbics = new ArrayList<>();
                while (GenericQuery.next()) {
                    listCantsFromUbics.add(
                            new ArticuloUbicacion(
                                    GenericQuery.getInt("ua.id"),
                                    GenericQuery.getInt("stockInUbic"),
                                    new Ubicacion(GenericQuery.getInt("ua.idUbic"), GenericQuery.getString("ux.ubic")),
                                    new Deposito(GenericQuery.getInt("ua.idDep"), GenericQuery.getString("d.descrip"))
                            ));
                }
                art.setListCantsFromUbics(listCantsFromUbics);
                genericDao.getCloseC();
                return listCantsFromUbics;
            } catch (SQLException ex) {
            }
        }
        return null;
    }
}

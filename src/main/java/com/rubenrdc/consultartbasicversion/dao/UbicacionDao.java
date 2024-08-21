package com.rubenrdc.consultartbasicversion.dao;

import com.rubenrdc.consultartbasicversion.models.Articulo;
import com.rubenrdc.consultartbasicversion.models.ArticuloUbicacion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author Ruben
 */
public class UbicacionDao {

    public static List<ArticuloUbicacion> findUbicacionFromArticulo(Articulo art) {
        try (EntityManager createEntityManager = DaoConnection.getEm()) {
            String Query = """
                            SELECT ua
                            FROM ArticuloUbicacion ua
                            JOIN FETCH ua.articulo art
                            LEFT JOIN FETCH ua.deposito d
                            LEFT JOIN FETCH ua.ubicacion ux
                            WHERE art.codigo = ?1
                            ORDER BY ua.deposito
                            """;
            Query createQuery = createEntityManager.createQuery(Query);
            createQuery.setParameter(1, art.getCodigo());
            List<ArticuloUbicacion> listCantsFromUbics = createQuery.getResultList();
            return listCantsFromUbics;
        }
    }
}

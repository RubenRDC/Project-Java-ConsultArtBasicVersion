package com.rubenrdc.consultartbasicversion.dao;

import com.rubenrdc.consultartbasicversion.models.Articulo;
import com.rubenrdc.consultartbasicversion.models.interfaces.Utilities;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

/**
 *
 * @author Ruben
 */
public class ArticuloDao implements Utilities {

    private static String query = "";

    public ArticuloDao() {
    }

    public static Articulo findBasicArticuloByCode(String code) {

        try (EntityManager em = DaoConnection.getEm()) {
            Query createQuery = em.createQuery("SELECT a FROM Articulo a WHERE a.codigo = ?1");
            createQuery.setParameter(1, code);
            return (Articulo) createQuery.getResultList();
        }
    }

    public static Articulo findCompleteArticuloByCode(String code) {
        try (EntityManager em = DaoConnection.getEm()) {
            Query createQuery = em.createQuery("SELECT a FROM Articulo a WHERE a.codigo = ?1");
            createQuery.setParameter(1, code);
            Articulo art = (Articulo) createQuery.getSingleResult();
            if (art != null) {
                art.setListCantsFromUbics(UbicacionDao.findUbicacionFromArticulo(art));
            }
            return art;
        }
    }
}

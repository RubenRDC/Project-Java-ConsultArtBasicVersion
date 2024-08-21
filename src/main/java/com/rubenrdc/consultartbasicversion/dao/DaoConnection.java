package com.rubenrdc.consultartbasicversion.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.stream.Stream;

/**
 *
 * @author Ruben
 */
public class DaoConnection {

    public DaoConnection() {
    }
    private static EntityManagerFactory emf;

    public static EntityManagerFactory loadPersistenceUnit() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");
        }
        return emf;
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }
    
    public static EntityManager getEm() {
        return emf.createEntityManager();
    }
    
    public static void closeEmf() {
        if (emf != null) {
            emf.close();
        }
    }

    public static Stream GenericQuery(String Query, java.util.List<String> params) {
        Query createQuery;
        try (EntityManager entityManager = emf.createEntityManager()) {
            createQuery = entityManager.createQuery(Query);
            int index = 1;
            if (params != null) {
                for (Object param : params) {
                    createQuery.setParameter(index, verificString(param));
                    index++;
                }
            }
        }
        return createQuery.getResultStream();
    }

    public static Stream GenericQuery(String Query, Object... params) {
        Query createQuery;
        try (EntityManager entityManager = emf.createEntityManager()) {
            createQuery = entityManager.createQuery(Query);
            int index = 1;
            if (params != null) {
                for (Object param : params) {
                    createQuery.setParameter(index, verificString(param));
                    index++;
                }
            }
        }
        return createQuery.getResultStream();
    }

    private static <T> T verificString(T txt) {//Filtro de Texto, Si la CADENA no tiene caracteres, se reemplaza por nulo.
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

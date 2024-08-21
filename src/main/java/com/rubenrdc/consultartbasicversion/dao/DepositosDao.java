package com.rubenrdc.consultartbasicversion.dao;

import com.rubenrdc.consultartbasicversion.models.Deposito;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author Ruben
 */
public class DepositosDao {

    public DepositosDao() {
    }

    public static List<Deposito> getListDeps() {
        try (EntityManager createEntityManager = DaoConnection.getEm()) {
            String Query = "SELECT d FROM Deposito d";
            return createEntityManager.createQuery(Query).getResultList();
        }
    }
}

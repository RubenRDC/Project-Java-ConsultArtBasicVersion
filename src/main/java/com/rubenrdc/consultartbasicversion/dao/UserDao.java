package com.rubenrdc.consultartbasicversion.dao;

import com.rubenrdc.consultartbasicversion.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

/**
 *
 * @author Ruben
 */
public class UserDao {

    public UserDao() {

    }

    public static User findUser(User user) {
        try (EntityManager em = DaoConnection.getEm()) {
            Query createQuery = em.createQuery("Select u From User u where u.User = ?1 AND u.Pass = ?2");
            createQuery.setParameter(1, user.getUser());
            createQuery.setParameter(2, user.getPass());
            return (User) createQuery.getSingleResultOrNull();
        }
    }
}

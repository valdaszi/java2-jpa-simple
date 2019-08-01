package lt.bit.java2.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;

public final class EntityManagerHelper {

    private static final Logger LOG = Logger.getLogger(EntityManagerHelper.class.getName());

    private static EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        } catch (Exception e) {
            e.printStackTrace();
            LOG.severe(e.getMessage());
        }
    }

    public static EntityManager entityManager() {
        return entityManagerFactory.createEntityManager();
    }
}

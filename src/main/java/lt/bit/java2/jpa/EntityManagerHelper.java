package lt.bit.java2.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.util.function.Consumer;
import java.util.logging.Logger;

public final class EntityManagerHelper {

    private static final Logger LOG = Logger.getLogger(EntityManagerHelper.class.getName());

    public static final String FETCH_GRAPH = "javax.persistence.fetchgraph";

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

    public static void executeInTransaction(Consumer<EntityManager> executor) {
        System.out.println(executor.getClass().getName());
        EntityManager em = entityManager();
        em.getTransaction().begin();

        executor.accept(em);

        em.getTransaction().commit();
        em.close();
    }
}

//@FunctionalInterface
//interface Executor {
//    void action(EntityManager em);
//}




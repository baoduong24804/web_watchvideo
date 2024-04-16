package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connect {
    private static EntityManager entityManager = null;
    private static EntityManagerFactory entityManagerFactory = null;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("asm2");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static void updateConnection() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static void closeConnection() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
    public static void main(String[] args) {
		getEntityManager();
		System.out.println("hello");
	}
}

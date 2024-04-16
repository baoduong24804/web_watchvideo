package Utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import Entity.Video;

import Main.main;

public class JPAUtils {

	private static EntityManagerFactory factory = null;

	public static EntityManager getEntityManager() {
		if (factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("asm2");
			
		}
		return factory.createEntityManager();
	}

	public static void shutdown() {
		if (factory != null && factory.isOpen()) {
			factory.close();
		}
		factory = null;
	}
	
	public static void main(String[] args) {
		EntityManager entityManager = getEntityManager();
		
        TypedQuery<Video> query = entityManager.createQuery("SELECT v FROM Video v", Video.class);
        if(query.getResultList() == null) {
        	System.out.println("null");
        };
		System.out.println("ok");
	}

}

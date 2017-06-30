package com.mustafaergan.java.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Security {

	public static void main(String[] args) {
		  Map<String, String> properties = new HashMap<String, String>();
		  properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/proje_takip");
		  properties.put("javax.persistence.jdbc.user", "root");
		  properties.put("javax.persistence.jdbc.password", "root");
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPASecurity",properties);
		  EntityManager em = emf.createEntityManager();
		  
			//Liste çek
			List<Deneme> list =	em
	                .createQuery("SELECT u FROM Deneme u")
	                .getResultList();
			
			for (Deneme deneme : list) {
				System.out.println(deneme.getName());
			}
		  
	}
	
}

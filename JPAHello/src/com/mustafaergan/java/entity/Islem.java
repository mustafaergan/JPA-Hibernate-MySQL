package com.mustafaergan.java.entity;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Islem {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAHello");
		
		Deneme deneme = new Deneme();
		deneme.setName("deneme123");
		
		//insert
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(deneme);
		em.getTransaction().commit();

		//get
		deneme = (Deneme) em.find(Deneme.class, 1);
		System.out.println(deneme);
		
		//update
		em.getTransaction().begin();
		deneme.setName("123");
		em.getTransaction().commit();
		
		//delete
//		em.getTransaction().begin();
//		em.remove(deneme);
//		em.getTransaction().commit();
		
		System.out.println("Liste");
		
		//Liste çek
		List<Deneme> list =	em
                .createQuery("SELECT u FROM Deneme u")
                .getResultList();
		
		for (Deneme deneme2 : list) {
			System.out.println(deneme.getName());
		}
		
		System.out.println("Tek");
		
		//Tek Kullanıcı cek
		Deneme user = (Deneme) em
	                .createQuery("SELECT u FROM Deneme u WHERE u.name LIKE :name")
	                .setParameter("name", "123")
	                .getSingleResult();
		
		System.out.println(user.getId());
		
		
		///////////////////////////////////////////
		
		//Criteria
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
	   CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
	   Root<Deneme> from =  criteriaQuery.from(Deneme.class);

	   
	   System.out.println("Select * from Deneme");
	   CriteriaQuery<Object> select = criteriaQuery.select(from);
	   TypedQuery<Object> typedQuery = em.createQuery(select);
	   List<Object> resultlist = typedQuery.getResultList();

	   for(Object o:resultlist) {
		   Deneme e = (Deneme)o;
	      System.out.println("name : " + e.getName() );
	   }
	   
	   
	   //Sırala
	   System.out.println("Sırala");
	   CriteriaQuery<Object> select1 = criteriaQuery.select(from);
	   select1.orderBy(criteriaBuilder.asc(from.get("name")));
	   TypedQuery<Object> typedQuery1 = em.createQuery(select);
	   List<Object> resultlist1 = typedQuery1.getResultList();

	   for(Object o:resultlist1){
		   Deneme e=(Deneme)o;
		   System.out.println("name : " + e.getName() );
	   }

	   
	   
	   
		
		em.close();
		emf.close();
		
	}

}

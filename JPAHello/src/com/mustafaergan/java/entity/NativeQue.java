package com.mustafaergan.java.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class NativeQue {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAHello");
		EntityManager em = emf.createEntityManager();
		
		List<Deneme> dene = em.createNativeQuery(
			    "select distinct a.id, a.name " +
			    "from deneme", Deneme.class).getResultList();
		
		Query q = em.createNativeQuery(
			    "select distinct a.id, a.name " +
			    "from deneme");
		
		Object[] denes = (Object[]) q.getSingleResult();
		
		Query qq = em.createNativeQuery(
			    "select distinct a.id, a.name " +
			    "from deneme WHERE a.id = ?");
		
		q.setParameter(1, 1);
		
		Object[] deness = (Object[]) qq.getSingleResult();
		
		
		Query qqq = em.createNativeQuery(
			    "select distinct a.id, a.name " +
			    "from deneme WHERE a.id = :id");
		
		q.setParameter("id", 1);
		
		Object[] denesss = (Object[]) qqq.getSingleResult();
		
		
	}

}

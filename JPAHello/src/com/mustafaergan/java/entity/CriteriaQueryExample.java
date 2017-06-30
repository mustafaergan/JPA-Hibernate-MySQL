package com.mustafaergan.java.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

public class CriteriaQueryExample {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAHello");
		EntityManager em = emf.createEntityManager();


		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Deneme> q = cb.createQuery(Deneme.class);
		Root<Deneme> c = q.from(Deneme.class);
		
//		SELECT c FROM Deneme c
		
		q.select(c);

		TypedQuery<Deneme> query = em.createQuery(q);
		List<Deneme> results = query.getResultList();
		
		System.out.println(results);
		
//		SELECT c FROM Deneme c WHERE c.id > :p
		
		 ParameterExpression<Integer> p = cb.parameter(Integer.class);
		 q.select(c).where(cb.gt(c.get("id"), p));
		 
		 TypedQuery<Deneme> query2 = em.createQuery(q);
		 query.setParameter(p, 2);
		 List<Deneme> results2 = query.getResultList();
		 
		System.out.println(results2);
		
//		SELECT c FROM Country WHERE c.id > :pp AND c.id < :aa
		
		  ParameterExpression<Integer> pp = cb.parameter(Integer.class);
		  ParameterExpression<Integer> aa = cb.parameter(Integer.class);
		  q.where(
		      cb.gt(c.get("id"), pp),
		      cb.lt(c.get("id"), aa)
		  );
		  
		 TypedQuery<Deneme> query3 = em.createQuery(q);
		 query.setParameter(pp, 2);
		 query.setParameter(aa, 5);
		 List<Deneme> results3 = query.getResultList();
		  
		System.out.println(results3);

		 
//		  q.where(
//			      cb.and(
//			          cb.gt(c.get("id"), pp),
//			          cb.lt(c.get("id"), pp)
//			      )
//			  );
		  
		  
//		  q.where(
//	         	cb.or(
//	          		cb.gt(c.get("id"), pp),
//	         		cb.lt(c.get("id"), pp)
//	      		)
//	  		);
  


	}

}

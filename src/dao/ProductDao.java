package dao;


import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Product;

public class ProductDao {
	private static EntityManagerFactory entityManagerFactory;
	
	public void add() {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		Scanner s=new Scanner(System.in);
		System.out.println("Name:");
		String name=s.next();
		System.out.println("Description:");
		String description=s.next();
		System.out.println("Price:");
		int price=s.nextInt();
		System.out.println("Quantity:");
		int quantity=s.nextInt();
		
		Product sd=new Product(name,description,price,quantity);
		
		em.getTransaction().begin();
		em.persist(sd);
		em.getTransaction().commit();
	}
	
	public void update(String name) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		Product product=em.createQuery("select s from Product s where name= :name",Product.class).setParameter("name",name).getResultList().get(0);
		Scanner s=new Scanner(System.in);
		System.out.println("Name:");
		String name1=s.next();
		System.out.println("Description:");
		String description=s.next();
		System.out.println("Price:");
		int price=s.nextInt();
		System.out.println("Quantity:");
		int quantity=s.nextInt();
		product.setName(name1);
		product.setDescription(description);
		product.setPrice(price);
		product.setQuantity(quantity);
		em.getTransaction().begin();
		em.merge(product);
		em.getTransaction().commit();
	}
	
	public List<Product> printProducts(){
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		return em.createQuery("select s from Product s",Product.class).getResultList();
	
	}
	
	public void delete(String name)
	{
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		Product product=em.createQuery("select s from Product s where name= :name",Product.class).setParameter("name",name).getResultList().get(0);
	
		em.getTransaction().begin();
		em.remove(product);
		em.getTransaction().commit();
		
	
	}
}
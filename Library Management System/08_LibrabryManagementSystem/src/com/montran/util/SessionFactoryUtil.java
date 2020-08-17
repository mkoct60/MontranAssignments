package com.montran.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryUtil {
	private static SessionFactory factory;

	static {
		try {
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Exception while creating SessionFactory !!");
			e.printStackTrace();
		}
	}

	public static SessionFactory getFactory() {
		return factory;
	}
}

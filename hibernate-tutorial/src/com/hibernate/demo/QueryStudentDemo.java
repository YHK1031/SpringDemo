package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
				
		try {
		
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			// display the students
			displayStudents(theStudents);
			
			// query students: lastName='Son'
			theStudents = session.createQuery("from Student s where s.lastName='Son'").list();
			
			// display the students
			System.out.println("\n\nStudents who have last name of Son");
			displayStudents(theStudents);
			
			// query students: lastName='Son' OR firstName='Jisung'
			theStudents = session.createQuery("from Student s where s.lastName='Son'"+" OR s.firstName='Jisung'").list();
			
			System.out.println("\n\nStudents who have last name of Son OR fist name Jisung");
			displayStudents(theStudents);
			
			// query students where email LIKE '%thumb.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%ars.com'").list();
			
			System.out.println("\n\nStudents who have email");
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}

package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
				
		try {
			// create the objects
			Instructor tempInstructor = new Instructor("Susan", "Public", "susan@luv2code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("lolyoutube", "video game");
			
			
			// start a transaction
			session.beginTransaction();
			
			
			// get instructor id=1
//			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, 1);
			
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// save the instructor
			// Note: this will ALSO save the details object because of CascadeType.ALL
			System.out.println("Saving instructor: "+ tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			// add clean up code
			session.close();
			
			factory.close();
		}
		
	}

}

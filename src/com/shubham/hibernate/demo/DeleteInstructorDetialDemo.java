package com.shubham.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shubham.hibernate.demo.entity.Instructor;
import com.shubham.hibernate.demo.entity.InstructorDetail;
import com.shubham.hibernate.demo.entity.Student;

public class DeleteInstructorDetialDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// get session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructorDetial object
			int theId = 2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			// print the instructor detail
			System.out.println("Instructor Detail: " + tempInstructorDetail);

			// get the associated instructor
			System.out.println("The Associated Instructor: " + tempInstructorDetail.getInstructor());

			//delete the instructor detail
			System.out.println("deleting instructor detail");
			session.delete(tempInstructorDetail);
			
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("\nDone!!!!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			session.close();
			factory.close();
		}
	}

}

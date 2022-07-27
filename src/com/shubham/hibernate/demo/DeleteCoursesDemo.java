package com.shubham.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shubham.hibernate.demo.entity.Course;
import com.shubham.hibernate.demo.entity.Instructor;
import com.shubham.hibernate.demo.entity.InstructorDetail;
import com.shubham.hibernate.demo.entity.Student;

public class DeleteCoursesDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.buildSessionFactory();
		
		//get session
		Session session = factory.getCurrentSession();
		
		try {
			//start a transaction
			session.beginTransaction();
			
			//get the course from db
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			//delete the course
			System.out.println("Deleting course: " + tempCourse);
			session.delete(tempCourse);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\nDone!!!!");
			
		}finally {
			session.close();
			factory.close();
		}
	}

}

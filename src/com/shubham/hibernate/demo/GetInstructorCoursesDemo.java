package com.shubham.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shubham.hibernate.demo.entity.Course;
import com.shubham.hibernate.demo.entity.Instructor;
import com.shubham.hibernate.demo.entity.InstructorDetail;
import com.shubham.hibernate.demo.entity.Student;

public class GetInstructorCoursesDemo {

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
			
			//get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Instructor: " + tempInstructor);
			
			System.out.println("Courses: " + tempInstructor.getCourses());
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\nDone!!!!");
			
		}finally {
			session.close();
			factory.close();
		}
	}

}

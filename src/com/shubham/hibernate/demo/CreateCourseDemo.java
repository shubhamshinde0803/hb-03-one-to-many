package com.shubham.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shubham.hibernate.demo.entity.Course;
import com.shubham.hibernate.demo.entity.Instructor;
import com.shubham.hibernate.demo.entity.InstructorDetail;
import com.shubham.hibernate.demo.entity.Student;

public class CreateCourseDemo {

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
			
			Course tempCourse1 = new Course("Python Coding Masterclass");
			Course tempCourse2 = new Course("Java Coding Masterclass");
			
			//add courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			//save the instructor
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\nDone!!!!");
			
		}finally {
			session.close();
			factory.close();
		}
	}

}

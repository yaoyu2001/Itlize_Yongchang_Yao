package main.java.com.itlize.hibernate.demo;



import main.java.com.itlize.hibernate.demo.entity.Course;
import main.java.com.itlize.hibernate.demo.entity.Instructor;
import main.java.com.itlize.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("main/hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// create the objects
		
			System.out.println("Creating new instructor object...");
			Instructor tempInstructor = 
					new Instructor("James", "LLLLL", "James12345@itlize.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"http://www.youJames.com",
							"Playing video games");

			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// Add courses
			Course course1 = new Course("Java");
			Course course2 = new Course("SQL");
			List<Course> courses = new ArrayList<>();
			courses.add(course1);
			courses.add(course2);

			tempInstructor.setCourses(courses);

			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);					
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}

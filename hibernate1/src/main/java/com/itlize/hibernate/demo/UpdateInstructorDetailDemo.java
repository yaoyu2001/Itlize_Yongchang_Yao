package main.java.com.itlize.hibernate.demo;

import main.java.com.itlize.hibernate.demo.entity.Course;
import main.java.com.itlize.hibernate.demo.entity.Instructor;
import main.java.com.itlize.hibernate.demo.entity.InstructorDetail;
import main.java.com.itlize.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateInstructorDetailDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("main/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int Id = 2;

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting InstructorDetail with id: " + Id);

            InstructorDetail myIns = session.get(InstructorDetail.class, Id);

            System.out.println("Updating InstructorDetail...");
            myIns.setHobby("LeetCode");

            // commit the transaction
            session.getTransaction().commit();


            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

}

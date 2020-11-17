package main.java.com.itlize.hibernate.demo;

import main.java.com.itlize.hibernate.demo.entity.Course;
import main.java.com.itlize.hibernate.demo.entity.Instructor;
import main.java.com.itlize.hibernate.demo.entity.InstructorDetail;
import main.java.com.itlize.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadInstructorDemo {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        SessionFactory factory = new Configuration()
                .configure("main/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

// create session
        Session session = factory.getCurrentSession();

        try {
            int id = 1;


// retrieve student based on the id: primary key
            System.out.println("\nGetting instructor with id: " + id);
            // start a transaction
            session.beginTransaction();

            Instructor myIns = session.get(Instructor.class, id);


            System.out.println("Get complete: " + myIns);

// commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }


    }
}





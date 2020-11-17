package main.java.com.itlize.hibernate.demo;

import main.java.com.itlize.hibernate.demo.entity.Course;
import main.java.com.itlize.hibernate.demo.entity.Instructor;
import main.java.com.itlize.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CreateCourseDemo {

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

            // create the objects


            System.out.println("Creating new course object...");
            Course tempCourse1 =
                    new Course("Java");

            Course tempCourse2 =
                    new Course("SQL");

            session.beginTransaction();

            // get the instructor detail object
            int theId = 2;
            Instructor tempInstructor =
                    session.get(Instructor.class, theId);


            // associate the objects
            tempCourse1.setInstructor(tempInstructor);
            tempCourse2.setInstructor(tempInstructor);
            //
            // Note: this will ALSO save the details object
            // because of CascadeType.ALL
            //
            System.out.println("Saving course: " + tempCourse1);
            session.save(tempCourse1);

            System.out.println("Saving course: " + tempCourse2);
            session.save(tempCourse2);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

}

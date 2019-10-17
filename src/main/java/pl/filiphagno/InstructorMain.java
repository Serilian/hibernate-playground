package pl.filiphagno;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.filiphagno.domain.Course;
import pl.filiphagno.domain.Instructor;
import pl.filiphagno.domain.InstructorDetail;
import pl.filiphagno.domain.Review;

import java.util.List;

@Slf4j
public class InstructorMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();


        Session session = sessionFactory.getCurrentSession();
//
        try {

            session.beginTransaction();
//
         Course tempCourse = new Course("HOw to live good");

            System.out.println(tempCourse);

            System.out.println(tempCourse.getReviews());


            tempCourse.addReview(new Review("Crap"));
            tempCourse.addReview(new Review("not that bad"));
            tempCourse.addReview(new Review("Clearly made by retard"));

            session.save(tempCourse);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
}

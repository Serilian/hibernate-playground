package pl.filiphagno;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.filiphagno.domain.Course;
import pl.filiphagno.domain.Instructor;
import pl.filiphagno.domain.InstructorDetail;

import java.util.List;

@Slf4j
public class InstructorMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();


        Session session = sessionFactory.getCurrentSession();
//
        try {

            session.beginTransaction();
//
           Instructor filip = session.get(Instructor.class, 5);

            System.out.println(filip);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
}

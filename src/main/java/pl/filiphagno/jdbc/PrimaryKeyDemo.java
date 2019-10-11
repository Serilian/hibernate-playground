package pl.filiphagno.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.filiphagno.domain.Student;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Student filip = new Student("Filip", "Hagno", "asas@yahoo.com");
            Student filip2 = new Student("Filip2", "Hagno", "asasa@yahoo.com");
            Student filip3 = new Student("Filip3", "Hagno", "saddasd@yahoo.com");

            session.beginTransaction();
            session.save(filip);
            session.save(filip2);
            session.save(filip3);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}


package pl.filiphagno;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.filiphagno.domain.Student;

import java.util.List;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

//            Student filip = new Student("Monika", "Hagno", "mhagno@yahoo.com");
//
            session.beginTransaction();
//            session.save(filip);
//
//            session.getTransaction().commit();

            Student filip = session.get(Student.class, 1);

            session.delete(filip);


//            filip.setEmail("fhamobile@gmail.com");


            System.out.println("***********************************************");

//            List<Student> students =
//                    session
//                    .createQuery("update Student set email='fhagno@yahoo.com' where id=2")
//                    .getResultList();

//            students.forEach(System.out::println);


            session.createQuery("update Student s set s.email='fhagno@yahoo.com' where s.id=2").executeUpdate();


            session.getTransaction().commit();
            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }


    }
}

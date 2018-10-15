package hibernate.test;

import hibernate.test.dto.EmployeeEntity;
import org.hibernate.Session;

public class TestHibernate {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// Add new Employee object
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("demo-user1@mail.com");
		emp.setFirstName("demo2");
		emp.setLastName("user2");

		session.save(emp);

		session.getTransaction().commit();

		Integer empId = emp.getEmployeeId();

		System.out.println(empId);

		Session sessionTwo = HibernateUtil.getSessionFactory().openSession();
		
		sessionTwo.beginTransaction();

		EmployeeEntity emp1 = (EmployeeEntity) sessionTwo.load(EmployeeEntity.class, empId);

		sessionTwo.getTransaction().commit();
		
		HibernateUtil.shutdown();

	}
}
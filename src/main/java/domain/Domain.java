package domain;

import BuisnessLogic.HibernateUtill;
import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Domain {
    public static void main(String[] args) {

        Session session = HibernateUtill.getSessionFactory().openSession();
        session.beginTransaction();

        Address address = new Address();
        address.setCountry("BEL");
        address.setCity("Anderlext");
        address.setStreet("Street");
        address.setPost_code("456123789");

        Project project = new Project();
        project.setTitle("Yes!!!!");

        Employee employee = new Employee();
        employee.setFirst_name("Cevin");
        employee.setLast_name("De Breune");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1876,Calendar.APRIL,8);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Set<Employee> employees = new HashSet<Employee>();
        employees.add(employee);
        project.setEmployees(employees);

        Set<Project> projectSet = new HashSet<Project>();
        projectSet.add(project);
        employee.setProjects(projectSet);

        session.save(address);
        session.save(employee);
        session.save(project);

        session.getTransaction().commit();
        HibernateUtill.shutDown();



    }
}

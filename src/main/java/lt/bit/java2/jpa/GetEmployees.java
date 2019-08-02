package lt.bit.java2.jpa;

import lt.bit.java2.jpa.entities.Employee;

import javax.persistence.TypedQuery;
import java.util.List;

public class GetEmployees {

    public static void main(String[] args) {

        EntityManagerHelper.executeInTransaction(em -> {

            TypedQuery<Employee> query = em.createNamedQuery(Employee.Query_By_Name, Employee.class);
            query.setMaxResults(100).setFirstResult(1000);
            List<Employee> employees = query.getResultList();

            employees.forEach(e -> {
                System.out.println(e.getFullName());
            });
        });
    }
}

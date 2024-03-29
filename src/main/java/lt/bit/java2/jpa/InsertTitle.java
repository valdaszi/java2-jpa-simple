package lt.bit.java2.jpa;

import lt.bit.java2.jpa.entities.Employee;
import lt.bit.java2.jpa.entities.Title;

import java.time.LocalDate;

public class InsertTitle {

    public static void main(String[] args) {
        EntityManagerHelper.executeInTransaction(em -> {
            Employee employee = em.find(Employee.class, 10004);

            Title title = new Title();
            title.setEmployee(employee);
            title.setFromDate(LocalDate.now());
            title.setToDate(LocalDate.of(9999, 1, 1));
            title.setTitle("CEO");

            employee.getTitles().add(title);

            //em.persist(title);
            //em.persist(employee);
        });

        EntityManagerHelper.executeInTransaction(em -> {
            Employee employee = em.find(Employee.class, 10004);

            System.out.println(employee.getFullName() + " " +
                    employee.getGender() + " " +
                    employee.getBirthDate() + " " +
                    employee.getHireDate());

            employee.getTitles().forEach(t ->
                System.out.println(t.getTitle() + " " +
                        t.getFromDate() + " " +
                        t.getToDate())
            );
        });
    }
}


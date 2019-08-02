package lt.bit.java2.jpa;

import lt.bit.java2.jpa.entities.Employee;
import lt.bit.java2.jpa.entities.Title;

import java.time.LocalDate;

public class UpdateTitle {

    public static void main(String[] args) {
        EntityManagerHelper.executeInTransaction(em -> {
            Employee employee = em.find(Employee.class, 10004);

            LocalDate date = LocalDate.now();
            LocalDate lastDate = LocalDate.of(9999, 1, 1);

            employee.getTitles().stream()
                    .filter(t -> t.getTitle().equals("Senior Engineer") &&
                            t.getToDate().equals(lastDate))
                    .findAny()
                    .ifPresent(t -> t.setToDate(date));

            Title title = new Title();
            title.setEmployee(employee);
            title.setFromDate(date);
            title.setToDate(lastDate);
            title.setTitle("CEO");

            employee.getTitles().add(title);
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

package lt.bit.java2.jpa;

import lt.bit.java2.jpa.entities.Employee;

public class DeleteTitle {

    public static void main(String[] args) {
        EntityManagerHelper.executeInTransaction(em -> {
            Employee employee = em.find(Employee.class, 10004);

            employee.getTitles().removeIf(t -> t.getTitle().equals("CEO"));
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

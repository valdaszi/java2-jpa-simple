package lt.bit.java2.jpa;

import lt.bit.java2.jpa.entities.Employee;

import javax.persistence.EntityManager;

public class UpdateEmployee {

    public static void main(String[] args) {

//        EntityManager em = EntityManagerHelper.entityManager();
//        em.getTransaction().begin();
//
//        Employee employee = em.find(Employee.class, 10004);
//        employee.setFirstName("Jonas");
//
//        em.getTransaction().commit();
//        em.close();

//        UpdateEmployeeExecutor executor = new UpdateEmployeeExecutor();
//        EntityManagerHelper.executeInTransaction(executor);

//        EntityManagerHelper.executeInTransaction(new Executor() {
//            @Override
//            public void action(EntityManager em) {
//                Employee employee = em.find(Employee.class, 10004);
//                employee.setFirstName("Jonas");
//            }
//        });

        EntityManagerHelper.executeInTransaction(em -> {
            Employee employee = em.find(Employee.class, 10004);
            employee.setFirstName("Jonas");
        });
    }
}

//class UpdateEmployeeExecutor implements Executor {
//
//    @Override
//    public void action(EntityManager em) {
//        Employee employee = em.find(Employee.class, 10004);
//        employee.setFirstName("Jonas");
//    }
//}

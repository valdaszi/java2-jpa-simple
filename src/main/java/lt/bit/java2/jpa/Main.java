package lt.bit.java2.jpa;

import lt.bit.java2.jpa.entities.*;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOG.info("YES");

        EntityManager em = EntityManagerHelper.entityManager();

        System.out.println("*** Employee:");

        EntityGraph eg = em.getEntityGraph(Employee.Graph_Titles);
        Map<String, Object> properties = new HashMap<>();
        properties.put(EntityManagerHelper.FETCH_GRAPH, eg);

        Employee employee = em.find(Employee.class, 10004, properties);
        System.out.println(employee.getFullName() + " " +
                employee.getGender() + " " +
                employee.getBirthDate() + " " +
                employee.getHireDate());

        employee.getTitles().forEach(t ->
            System.out.println(t.getTitle() + " " +
                    t.getFromDate() + " " +
                    t.getToDate())
        );

        System.out.println("*** Title:");

        TitlePK titlePK = new TitlePK(
                employee,
                "Senior Engineer",
                LocalDate.of(1995, 12, 1));
        Title title = em.find(Title.class, titlePK);

        System.out.println(title.getTitle() + " " +
                title.getFromDate() + " " +
                title.getToDate());
        System.out.println(title.getEmployee().getFullName());

        em.close();
    }
}

package lt.bit.java2.jpa.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
@NamedEntityGraph(
        name = Employee.Graph_Titles,
        attributeNodes = {
                @NamedAttributeNode("titles")
        }
)
@NamedQuery(
        name = Employee.Query_By_Name,
        query = "SELECT A FROM Employee A ORDER BY A.firstName"
)

@Data
public class Employee {

    public static final String Graph_Titles = "graph.Employee.titles";
    public static final String Query_By_Name = "query.Employee.byName";

    @Id
    @Column(name = "emp_no")
    private Integer empNo;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('M','F')")
    private Gender gender;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            orphanRemoval = true)
    private List<Title> titles;

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}

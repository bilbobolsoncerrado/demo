package com.example.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "manufacturers")
@NamedQuery(
        name = "Manufacturer.countById",
        query = "SELECT COUNT(m) FROM Manufacturer m WHERE m.id = :id"
)
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(name = "num_employees")
    private Integer numEmployees;

    @Column(name = "init_year")
    private Integer year;

    @Column(name = "initial_date")
    @Temporal(TemporalType.DATE)
    private Date initialDate;

    public Manufacturer() {
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Manufacturer(Long id, String name, Integer numEmployees, Integer year, Date initialDate) {
        this.id = id;
        this.name = name;
        this.numEmployees = numEmployees;
        this.year = year;
        this.initialDate=initialDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(Integer numEmployees) {
        this.numEmployees = numEmployees;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numEmployees=" + numEmployees +
                ", year=" + year +
                '}';
    }
}

package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String need;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    public Job() {
    }

    public Job(int id, String title, String need, Employee employee) {
        this.id = id;
        this.title = title;
        this.need = need;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

//    @Override
//    public String toString() {
//        return "Job{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", need='" + need + '\'' +
//                ", employee=" + employee +
//                '}';
//    }
}
package org.dreando.restfuldemo.resource;

import java.util.List;

/**
 * Created by Mateusz Koza on 13.10.15.
 */
public class Company {

    private String name;
    private List<Department> departments;
    private Worker ceo;
    private Worker cto;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Worker getCeo() {
        return ceo;
    }

    public void setCeo(Worker ceo) {
        this.ceo = ceo;
    }

    public Worker getCto() {
        return cto;
    }

    public void setCto(Worker cto) {
        this.cto = cto;
    }

    public Company(String name, List<Department> departments, Worker ceo, Worker cto) {
        this.name = name;
        this.departments = departments;
        this.ceo = ceo;
        this.cto = cto;
    }
}

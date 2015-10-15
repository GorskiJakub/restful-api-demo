package org.dreando.restfuldemo.resource;

import java.util.List;

/**
 * Created by Dreando on 13.10.15.
 */
public class Department {

    private String name;
    private List<Worker> workers;
    private Worker head;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public Worker getHead() {
        return head;
    }

    public void setHead(Worker head) {
        this.head = head;
    }

    public Department(String name, List<Worker> workers, Worker head) {
        this.name = name;
        this.workers = workers;
        this.head = head;
    }
}

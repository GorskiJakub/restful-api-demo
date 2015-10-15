package org.dreando.restfuldemo.resource;

/**
 * Created by Mateusz Koza on 13.10.15.
 */
public class Worker {

    private String firstName;
    private String lastName;
    private WorkerRole role;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public WorkerRole getRole() {
        return role;
    }

    public void setRole(WorkerRole role) {
        this.role = role;
    }

    public Worker(String firstName, String lastName, WorkerRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
}

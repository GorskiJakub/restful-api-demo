package org.dreando.restfuldemo.data;

import org.dreando.restfuldemo.resource.Company;
import org.dreando.restfuldemo.resource.Department;
import org.dreando.restfuldemo.resource.Worker;
import org.dreando.restfuldemo.resource.WorkerRole;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by Mateusz Koza on 13.10.15.
 */
@Service
public class DataProvider {

    private final static Map<String, Company> COMPANIES = new HashMap<>();

    private final static List<String> COMPANY_NAMES = Arrays.asList("Accenture", "Google", "Facebook", "Twitter", "Tomtom");
    private final static List<String> WORKER_FIRST_NAMES = Arrays.asList("John", "Joshua", "Bart", "Jack", "William");
    private final static List<String> WORKER_LAST_NAMES = Arrays.asList("Deere", "Gouzevitch", "Simpson", "Maloney", "Willis");

    private final static Random RANDOM = new Random();

    /**
     * @return list of available companies
     */
    public Collection<Company> getCompanies() {
        return COMPANIES.values();
    }

    /**
     * @param name the name of Company
     * @return desired Company
     */
    public Company getCompanyByName(String name) {
        return COMPANIES.get(name);
    }

    /**
     * @param name the name of Company
     * @return desired Company CEO
     */
    public Worker getCompanyCeo(String name) {
        return COMPANIES.get(name).getCeo();
    }

    /**
     * @param name the name of Company
     * @return desired Company CTO
     */
    public Worker getCompanyCto(String name) {
        return COMPANIES.get(name).getCto();
    }

    /**
     * @param name the name of Company
     * @return list of available company departments
     */
    public List<Department> getCompanyDepartments(String name) {
        return COMPANIES.get(name).getDepartments();
    }

    /**
     * @param name the name of Company
     * @return desired Company
     */
    public List<Worker> getCompanyWorkers(String name) {
        Company company = COMPANIES.get(name);
        List<Department> departments = company.getDepartments();
        List<Worker> workers = new ArrayList<>();
        workers.add(company.getCeo());
        workers.add(company.getCto());
        departments.forEach(department -> {
            workers.addAll(department.getWorkers());
            workers.add(department.getHead());
        });
        return workers;
    }

    @PostConstruct
    public void init() {
        COMPANY_NAMES.forEach(company -> COMPANIES.put(company, createCompany(company)));
    }

    private Company createCompany(String company) {
        return new Company(company, createDepartments(), createSingleWorker(WorkerRole.CEO),
                createSingleWorker(WorkerRole.CTO));
    }

    private List<Department> createDepartments() {
        List<Department> departments = new ArrayList<>();
        for (int i = 0; i < randomBetween(1, 10); i++) {
            departments.add(createDepartment(i));
        }
        return departments;
    }

    private Department createDepartment(int i) {
        return new Department("Department " + i, createWorkers(), createSingleWorker(WorkerRole.DEPARTMENT_HEAD));
    }

    private List<Worker> createWorkers() {
        List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < randomBetween(10, 100); i++) {
            workers.add(createSingleWorker(WorkerRole.ORDINAR_WORKER));
        }
        return workers;
    }

    private Worker createSingleWorker(WorkerRole role) {
        return new Worker(WORKER_FIRST_NAMES.get(randomBetween(0, WORKER_FIRST_NAMES.size() - 1)),
                WORKER_LAST_NAMES.get(randomBetween(0, WORKER_LAST_NAMES.size() - 1)), role);
    }

    private int randomBetween(int minimum, int maximum) {
        return RANDOM.nextInt(maximum - minimum + 1) + minimum;
    }
}

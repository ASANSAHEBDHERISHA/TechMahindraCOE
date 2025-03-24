package jpademo;

import jakarta.persistence.EntityManager;

public class Main {

    // 🔹 Merge Method (Now Without Transactions)
    public static void mergeEmployee(EntityManager em, Employee employee) {
        em.merge(employee);
    }

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        // 🔹 Start Transaction in Main
        em.getTransaction().begin();

        // 🔹 Create Employees
        Employee emp1 = new Employee(1, "Dheri", "Training", 200);
        Employee emp2 = new Employee(2, "Asif", "Training", 200);

        // 🔹 Merge Employees (Using mergeEmployee Function)
        mergeEmployee(em, emp1);
        mergeEmployee(em, emp2);

        // 🔹 Commit Transaction After Merging
        em.getTransaction().commit();

        // 🔹 Fetch Employee, Update & Merge
        em.getTransaction().begin();
        Employee emp3 = em.find(Employee.class, 1);
        if (emp3 != null) {
            System.out.println("Employee Found: " + emp3.getName());
            System.out.println("ID: " + emp3.getId());

            emp3.setSalary(5000);
            mergeEmployee(em, emp3);  // Call merge function to update salary
        } else {
            System.out.println("Employee Not Found");
        }
        em.getTransaction().commit();

        // 🔹 Remove Employee (After Re-fetching)
        em.getTransaction().begin();
        emp3 = em.find(Employee.class, 1);
        if (emp3 != null) {
            em.remove(emp3);
            System.out.println("Employee Removed!");
        } else {
            System.out.println("Employee Already Deleted!");
        }
        em.getTransaction().commit();

        // 🔹 Close EntityManager
        em.close();
        JPAUtil.close();
    }
}

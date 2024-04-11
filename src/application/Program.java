package application;

import entities.Employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employees> list = new ArrayList<>();

        System.out.print("How many employees will be registered: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("Employee #" + (i + 1) + ":");

            System.out.print("Id: ");
            Integer id = sc.nextInt();

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            Employees emp = new Employees(id, name, salary);

            list.add(emp);
        }

        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int idSalary = sc.nextInt();

        Integer positional = existIdPosition(list, idSalary);
        if (positional == null) {
            System.out.println("This id doesn't exist!");
        }
        else {
            System.out.println();
            System.out.print("Enter the percentage: ");
            double percent = sc.nextDouble();
            list.get(positional).increaseSalary(percent);
        }

        System.out.println();
        System.out.println("List of employees: ");

        for (Employees employees : list) {
            System.out.println(employees);
        }

        sc.close();
    }

    public static Integer existIdPosition(List<Employees> list, int id) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }

}

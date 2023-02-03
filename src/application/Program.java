package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> employees = new ArrayList<>();

		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.printf("Employee #%d data:\n", i + 1);
			System.out.print("Outsourced (y/n)? ");
			char outsourced = sc.next().toLowerCase().charAt(0);
			if (outsourced != 'y' && outsourced != 'n') {
				System.out.println("Dado incorreto, tente novamente.");
			} else {
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Hours: ");
				int hours = sc.nextInt();
				System.out.print("Value per hour: ");
				double valuePerHour = sc.nextDouble();
				if (outsourced == 'y') {
					System.out.print("Additional charge: ");
					double additional = sc.nextDouble();

					Employee employee = new OutsourcedEmployee(name, hours, valuePerHour, additional);
					employees.add(employee);

				}

				if (outsourced == 'n') {
					Employee employee = new Employee(name, hours, valuePerHour);
					employees.add(employee);
				}

			}

		}
		
		System.out.println("PAYMENTS");
		for (Employee e : employees) {
			System.out.println(e);
		}
		sc.close();
	}

}

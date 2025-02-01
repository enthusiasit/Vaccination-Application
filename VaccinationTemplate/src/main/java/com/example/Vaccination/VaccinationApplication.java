package com.example.Vaccination;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Time;
import java.util.Scanner;

@SpringBootApplication
public class VaccinationApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        System.out.println("Welcome to the Vaccination Application");
        Scanner sc = new Scanner(System.in);
        /*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

		 Tasks:
		1. Fetch context from ApplicationContext.xml and initiate Scanner.
		2. Fetch vaccine and User type choice.
		3. Get the required bean from context.
		4. Get the appointment details form user
		5. Display the appointment details
		6. Run the loop again to book for another user or else exit.
		 */


        while(true) {

            System.out.println("Please choose your vaccine preference: \n1. Covid \n2. Polio \n3. Typhoid");
            int vaccineType = sc.nextInt();
            sc.nextLine();

            String vaccine = "";

            switch (vaccineType) {
                case 1: {
                    vaccine = "Covid";
                    break;
                }
                case 2: {
                    vaccine = "Polio";
                    break;
                }
                case 3: {
                    vaccine = "Typhoid";
                    break;
                }
                default: {
                    System.out.println("Invalid choice.");
                    return;
                }
            }

            System.out.println("Whom do you want to vaccinate \n 1. Father \n 2. Mother \n 3. Self \n 4. Spouse \n 5. Exit");
            int usertype = sc.nextInt();
            sc.nextLine();

            String member = "";
            switch (usertype) {
                case 1: {
                    member = "father";
                    break;
                }
                case 2: {
                    member = "mother";
                    break;
                }
                case 3: {
                    member = "self";
                    break;
                }
                case 4: {
                    member = "spouse";
                    break;
                }
                case 5: {
                    System.out.println("Exiting...");
                    return;
                }
                default: {
                    System.out.println("Invalid choice.");
                    return;
                }
            }

            User user = (User) context.getBean(member + vaccine);

            System.out.println("Please enter " + member + " details:");
//            System.out.println("Enter name");
            String name = sc.nextLine();
            System.out.println("Name: " + name);
//            System.out.println("Enter age");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("Age: " + age);
//            System.out.println("Enter date");
            String apptdate = sc.nextLine();
            System.out.println("Appointment date (YYYY-MM-DD): " + apptdate);
//            System.out.println("Enter time");
            String appttime = sc.nextLine();
            System.out.println("Appointment time (HH:MM AM/PM): " + appttime);
//            System.out.println("Enter location");
            String apptlocation = sc.nextLine();
            System.out.println("Appointment location: " + apptlocation);

            TimeAndLocation timeAndLocation = new TimeAndLocation();

            timeAndLocation.setDetails(appttime, apptlocation, apptdate);
            user.setUserDetails(name, age, timeAndLocation);

            user.setAppointment();

            System.out.println("Do you want to register for someone Else \n1. Yes \n2. No");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 2) {
                return;
            }

        }








    }
}
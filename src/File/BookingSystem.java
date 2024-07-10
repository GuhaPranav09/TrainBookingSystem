//package day19;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//class Passenger {
//    String name;
//    int age;
//    String gender;
//    String berth;
//
//    public Passenger(String name, int age, String gender, String berth) {
//        super();
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.berth = berth;
//    }
//
//	@Override
//	public String toString() {
//		return "Passenger [name=" + name + ", age=" + age + ", gender=" + gender + ", berth=" + berth + "]";
//	}
//
//}
// 
//
//class Ticket {
//    static int ticketCount;
//    int ticketID;
//    String trainName;
//    LocalDate ticketDate;
//    LocalTime ticketTime;
//    String category;
//    ArrayList<Passenger> passengers;
//    String source;
//    String destination;
//    double ticketPrice;
//
//    public Ticket(String trainName, LocalDate ticketDate, LocalTime ticketTime,
//                  String source, String destination, String category, ArrayList<Passenger> passengers) {
//        super();
//        this.trainName = trainName;
//        this.ticketDate = ticketDate;
//        this.ticketTime = ticketTime;
//        this.source = source;
//        this.destination = destination;
//        this.passengers = passengers;
//        this.category = category;
//        this.ticketPrice = this.setTicketPrice();
//        this.ticketID = ++ticketCount;
//    }
//
//    public int getTicketID() {
//        return ticketID;
//    }
//
//    public void setTicketID(int ticketID) {
//        this.ticketID = ticketID;
//    }
//
//    public String getTrainName() {
//        return trainName;
//    }
//
//    public void setTrainName(String trainName) {
//        this.trainName = trainName;
//    }
//
//    public LocalDate getTicketDate() {
//        return ticketDate;
//    }
//
//    public void setTicketDate(LocalDate ticketDate) {
//        this.ticketDate = ticketDate;
//    }
//
//    public LocalTime getTicketTime() {
//        return ticketTime;
//    }
//
//    public void setTicketTime(LocalTime ticketTime) {
//        this.ticketTime = ticketTime;
//    }
//
//    public double setTicketPrice() {
//        int unitPrice = 0;
//        switch (this.category) {
//            case "FirstClass":
//                unitPrice = 1000;
//                break;
//            case "2AC":
//                unitPrice = 600;
//                break;
//            case "3AC":
//                unitPrice = 500;
//                break;
//            case "2S":
//                unitPrice = 200;
//                break;
//            case "3S":
//                unitPrice = 100;
//                break;
//        }
//
//        return unitPrice * this.passengers.size();
//    }
//
//    public double getTicketPrice() {
//        return this.ticketPrice;
//    }
//
//	public ArrayList<Passenger> getPassengers() {
//		return this.passengers;
//	}
//
//	public void setPassengers(ArrayList<Passenger> passengers) {
//		this.passengers = passengers;
//	}
//}
//
//class Complaint {
//    static int complaintCount;
//    int complaintID;
//    int ticketID;
//    String complaintString;
//    String passengerName;
//    LocalDate complaintDate;
//
//    public Complaint(int ticketID, String complaintString, String passengerName, LocalDate complaintDate) {
//        super();
//        this.ticketID=ticketID;
//        this.complaintString = complaintString;
//        this.passengerName = passengerName;
//        this.complaintDate = complaintDate;
//        this.complaintID = ++complaintCount;
//    }
//
//    public int getComplaintID() {
//        return complaintID;
//    }
//
//    public void setComplaintID(int complaintID) {
//        this.complaintID = complaintID;
//    }
//
//}
//
//@SuppressWarnings("serial")
//class TicketNotFoundException extends RuntimeException {
//    public TicketNotFoundException() {
//        super("The ticket with the given id is not available");
//    }
//}
//
//public class BookingSystem {
//    public static int showMenu() {
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("MENU");
//            System.out.println("\n1.Book Ticket\n2.View Ticket");
//            System.out.println("3.Cancel Ticket\n4.Raise a Complaint");
//            System.out.println("5.Exit");
//            System.out.print("\nEnter your choice: ");
//
//            try {
//                int choice = scanner.nextInt();
//                scanner.nextLine();
//
//                if (choice >= 1 && choice <= 5) {
//                    return choice;
//                } else {
//                    System.out.println("Enter a valid choice");
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                System.out.println("Enter properly");
//                scanner.nextLine(); // Consume the invalid input
//            }
//        }
//    }
//
//    public static LocalDate promptForDate() {
//        Scanner scanner = new Scanner(System.in);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
//
//        while (true) {
//            System.out.print("Enter Date of Journey (ddmmyyyy): ");
//            String dateString = scanner.nextLine();
//
//            try {
//                LocalDate date = LocalDate.parse(dateString, formatter);
//                if (date.isAfter(LocalDate.now())) {
//                    return date;
//                } else {
//                    System.out.println("Invalid date. Please enter a future date.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid date format. ddmmyyy");
//            }
//        }
//    }
//
//    public static LocalDate promptForDatePast() {
//        Scanner scanner = new Scanner(System.in);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
//
//        while (true) {
//            System.out.print("Enter Date of Journey (ddmmyyyy): ");
//            String dateString = scanner.nextLine();
//
//            try {
//                LocalDate date = LocalDate.parse(dateString, formatter);
//                if (date.isBefore(LocalDate.now())) {
//                    return date;
//                } else {
//                    System.out.println("Invalid date. Please enter a past date.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid date format. ddmmyyyy.");
//            }
//        }
//    }
//
//    public static LocalTime promptForTime() {
//        Scanner scanner = new Scanner(System.in);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
//
//        while (true) {
//            System.out.print("Enter Time in 24hrs format (hh:mm): ");
//            String timeString = scanner.nextLine();
//
//            try {
//                LocalTime time = LocalTime.parse(timeString, formatter);
//                return time;
//            } catch (Exception e) {
//                System.out.println("Invalid time format. Please enter the time in the format HH:mm.");
//            }
//        }
//    }
//
//    public static String promptForBerth() {
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("Select Berth Option:");
//            System.out.println("1. Upper Berth");
//            System.out.println("2. Lower Berth");
//            System.out.println("3. Middle Berth");
//            System.out.print("Enter your choice: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline character
//
//            switch (choice) {
//                case 1:
//                    return "Upper Berth";
//                case 2:
//                    return "Lower Berth";
//                case 3:
//                    return "Middle Berth";
//                default:
//                    System.out.println("Invalid choice. Please select a valid option.");
//            }
//        }
//    }
//
//    public static String promptForCategory() {
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("Select Category Option:");
//            System.out.println("1. 2S (100Rs pax)");
//            System.out.println("2. 3S (200Rs pax)");
//            System.out.println("3. 2AC (600Rs pax)");
//            System.out.println("4. 3AC (500Rs pax)");
//            System.out.println("5. FirstClass (1000Rs pax)");
//            System.out.print("Enter your choice: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline character
//
//            switch (choice) {
//                case 1:
//                    return "2S";
//                case 2:
//                    return "3S";
//                case 3:
//                    return "2AC";
//                case 4:
//                    return "3AC";
//                case 5:
//                    return "FirstClass";
//                default:
//                    System.out.println("Invalid choice. Please select a valid option.");
//            }
//        }
//    }
//
//    public static String promptForTrain() {
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("Select Train :");
//            System.out.println("1. Brindavan Express");
//            System.out.println("2. Ravan Express");
//            System.out.println("3. Super Fast Express");
//            System.out.println("4. Bullet Express");
//            System.out.print("Enter your choice: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline character
//
//            switch (choice) {
//                case 1:
//                    return "Brindavan Express";
//                case 2:
//                    return "Ravan Express";
//                case 3:
//                    return "Super Fast Express";
//                case 4:
//                    return "Bullet Express";
//                default:
//                    System.out.println("Invalid choice. Please select a valid option.");
//            }
//        }
//    }
//    
//    public static String promptForGender() {
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("Select Gender:");
//            System.out.println("1. Male");
//            System.out.println("2. Female");
//            System.out.println("3. Other");
//            System.out.print("Enter your choice: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline character
//
//            switch (choice) {
//                case 1:
//                    return "Male";
//                case 2:
//                    return "Female";
//                case 3:
//                    return "Other";
//                default:
//                    System.out.println("Invalid choice. Please select a valid option.");
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("\t\t\tINDIAN RAILWAYS");
//        System.out.println();
//        HashMap<Integer, Ticket> tickets = new HashMap<>();
//        HashMap<Integer, Complaint> complaints = new HashMap<>();
//
//        while (true) {
//            int choice = showMenu();
//
//            switch (choice) {
//                case 5:
//                    System.out.println("Thank you");
//                    scanner.close();
//                    System.exit(0);
//                    break;
//                case 4:
//                	boolean validInput3 = false;
//                    int ticketID = 0;
//                    System.out.println("Complaint Portal\n");
//                    while (!validInput3) {
//                        System.out.print("Enter Ticket ID: ");
//                        try {
//                            ticketID = scanner.nextInt();
//                            if (!tickets.containsKey(ticketID)) {
//                                throw new TicketNotFoundException();
//                            }
//                            validInput3 = true;
//                            scanner.nextLine();
//                            System.out.println("Enter Passenger name: ");
//                            String nameString = scanner.nextLine();
//                            LocalDate date = promptForDatePast();
//                            System.out.println("Enter your complaint: ");
//                            String complaintString = scanner.nextLine();
//
//                            Complaint complaint = new Complaint(ticketID, complaintString, nameString, date);
//                            complaints.put(complaint.getComplaintID(), complaint);
//
//                            System.out.println("\nHello " + nameString+",\nYour Complaint: "+complaintString+" \nFiled Successfully.\nYour Complaint ID: "+complaint.getComplaintID()+"\nWe will look into it.");
//                            
//                        } catch (InputMismatchException e) {
//                            System.out.println("Invalid input. Please enter a valid integer.");
//                            scanner.nextLine();
//                        } catch (TicketNotFoundException e2) {
//                            System.out.println(e2.getMessage());
//                            validInput3 = true;
//                            scanner.nextLine();
//                        }
//                    }
//                    break;
//                case 3:
//                    boolean validInput = false;
//                    ticketID = 0;
//                    while (!validInput) {
//                        System.out.print("Enter Ticket ID: ");
//                        try {
//                            ticketID = scanner.nextInt();
//                            if (!tickets.containsKey(ticketID)) {
//                                throw new TicketNotFoundException();
//                            }
//                            validInput = true;
//                            tickets.remove(ticketID);
//                            System.out.println("Ticket Cancelled Successfully");
//                        } catch (InputMismatchException e) {
//                            System.out.println("Invalid input. Please enter a valid integer.");
//                            scanner.nextLine();
//                        } catch (TicketNotFoundException e2) {
//                            System.out.println(e2.getMessage());
//                            validInput = true;
//                            scanner.nextLine();
//                        }
//                    }
//                    break;
//                case 2:
//                    boolean validInput2 = false;
//                    int ticketID2 = 0;
//                    while (!validInput2) {
//                        System.out.print("Enter Ticket ID: ");
//                        try {
//                            ticketID2 = scanner.nextInt();
//                            if (!tickets.containsKey(ticketID2)) {
//                                throw new TicketNotFoundException();
//                            }
//                            validInput2 = true;
//                            System.out.println("Ticket Details fetched\n");
//                            Ticket ticket = tickets.get(ticketID2);
//                            System.out.println("Ticket ID: " + ticket.getTicketID());
//                            System.out.println("Train Name: " + ticket.getTrainName());
//                            System.out.println("Ticket Date: " + ticket.getTicketDate());
//                            System.out.println("Ticket Time: " + ticket.getTicketTime());
//                            System.out.println("Category: " + ticket.category);
//                            System.out.println("Source: " + ticket.source);
//                            System.out.println("Destination: " + ticket.destination);
//                            System.out.println("Passenger details");
//                            for(Passenger p:ticket.getPassengers()) {
//                            	System.out.println(p);
//                            }
//                            System.out.println("Price: " + ticket.getTicketPrice());
//                        } catch (InputMismatchException e) {
//                            System.out.println("Invalid input. Please enter a valid integer.");
//                            scanner.nextLine();
//                        } catch (TicketNotFoundException e2) {
//                            System.out.println(e2.getMessage());
//                            validInput2 = true;
//                            scanner.nextLine();
//                        }
//                    }
//                   
//                    break;
//                case 1:
//                    LocalDate dateString = promptForDate();
//                    LocalTime timeString = promptForTime();
//                    System.out.print("Enter Source station: ");
//                    String sourceString = scanner.nextLine();
//                    System.out.print("Enter Destination station: ");
//                    String destinationString = scanner.nextLine();
//                    String categoryString = promptForCategory();
//                    String trainNameString = promptForTrain();
//                    System.out.print("Enter No. of Passengers: ");
//                    int n = scanner.nextInt();
//                    scanner.nextLine();
//                    ArrayList<Passenger> ps = new ArrayList<Passenger>();
//                    for (int i = 0; i < n; i++) {
//                        System.out.println("Enter Name for Passenger " + (i + 1));
//                        String name = scanner.nextLine();
//                        System.out.println("Enter age for Passenger " + (i + 1));
//                        int age = scanner.nextInt();
//                        String gender = promptForGender();
//                        String berth = promptForBerth();
//                        scanner.nextLine();
//                        ps.add(new Passenger(name, age, gender, berth));
//                    }
//
//                    Ticket ticket = new Ticket(trainNameString, dateString, timeString, sourceString, destinationString, categoryString, ps);
//                    tickets.put(ticket.getTicketID(), ticket);
//
//                    System.out.println("\nSuccessfully Booked");
//                    System.out.println("Your Ticket Id is " + ticket.getTicketID());
//                    System.out.println("Your total price is " + ticket.getTicketPrice());
//                    break;
//            }
//
//            System.out.println();
//            System.out.println();
//        }
//    }
//}
//

package File;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

class Passenger {
    String name;
    int age;
    String gender;
    String berth;

    public Passenger(String name, int age, String gender, String berth) {
        super();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berth = berth;
    }

    @Override
    public String toString() {
        return "Passenger [Name=" + name + ", Age=" + age + ", Gender=" + gender + ", Berth=" + berth + "]";
    }
}

class Ticket {
    static int ticketCount;
    int ticketID;
    String trainName;
    LocalDate ticketDate;
    LocalTime ticketTime;
    String category;
    ArrayList<Passenger> passengers;
    String source;
    String destination;
    double ticketPrice;

    public Ticket(String trainName, LocalDate ticketDate, LocalTime ticketTime,
                  String source, String destination, String category, ArrayList<Passenger> passengers) {
        super();
        this.trainName = trainName;
        this.ticketDate = ticketDate;
        this.ticketTime = ticketTime;
        this.source = source;
        this.destination = destination;
        this.passengers = passengers;
        this.category = category;
        this.ticketPrice = this.setTicketPrice();
        this.ticketID = ++ticketCount;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public LocalDate getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(LocalDate ticketDate) {
        this.ticketDate = ticketDate;
    }

    public LocalTime getTicketTime() {
        return ticketTime;
    }

    public void setTicketTime(LocalTime ticketTime) {
        this.ticketTime = ticketTime;
    }

    public double setTicketPrice() {
        int unitPrice = 0;
        switch (this.category) {
            case "FirstClass":
                unitPrice = 1000;
                break;
            case "2AC":
                unitPrice = 600;
                break;
            case "3AC":
                unitPrice = 500;
                break;
            case "2S":
                unitPrice = 200;
                break;
            case "3S":
                unitPrice = 100;
                break;
        }

        return unitPrice * this.passengers.size();
    }

    public double getTicketPrice() {
        return this.ticketPrice;
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }
}

class Complaint {
    static int complaintCount;
    int complaintID;
    int ticketID;
    String complaintString;
    String passengerName;
    LocalDate complaintDate;

    public Complaint(int ticketID, String complaintString, String passengerName, LocalDate complaintDate) {
        super();
        this.ticketID = ticketID;
        this.complaintString = complaintString;
        this.passengerName = passengerName;
        this.complaintDate = complaintDate;
        this.complaintID = ++complaintCount;
    }

    public int getComplaintID() {
        return complaintID;
    }

    public void setComplaintID(int complaintID) {
        this.complaintID = complaintID;
    }
}

@SuppressWarnings("serial")
class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException() {
        super("The ticket with the given ID is not available.");
    }
}

public class BookingSystem {
    public static int showMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================================");
        System.out.println("\tINDIAN RAILWAYS");
        System.out.println("=================================");
        System.out.println("MENU");
        System.out.println("\n1. Book Ticket\n2. View Ticket");
        System.out.println("3. Cancel Ticket\n4. Raise a Complaint");
        System.out.println("5. Exit");
        System.out.print("\nEnter your choice: ");

        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice >= 1 && choice <= 5) {
                    return choice;
                } else {
                    System.out.println("Enter a valid choice.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    public static LocalDate promptForDate() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");

        while (true) {
            System.out.print("Enter Date of Journey (ddmmyyyy): ");
            String dateString = scanner.nextLine();

            try {
                LocalDate date = LocalDate.parse(dateString, formatter);
                if (date.isAfter(LocalDate.now())) {
                    return date;
                } else {
                    System.out.println("Invalid date. Please enter a future date.");
                }
            } catch (Exception e) {
                System.out.println("Invalid date format. Use ddMMyyyy.");
            }
        }
    }

    public static LocalDate promptForDatePast() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");

        while (true) {
            System.out.print("Enter Date of Journey (ddmmyyyy): ");
            String dateString = scanner.nextLine();

            try {
                LocalDate date = LocalDate.parse(dateString, formatter);
                if (date.isBefore(LocalDate.now())) {
                    return date;
                } else {
                    System.out.println("Invalid date. Please enter a past date.");
                }
            } catch (Exception e) {
                System.out.println("Invalid date format. Use ddMMyyyy.");
            }
        }
    }

    public static LocalTime promptForTime() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        while (true) {
            System.out.print("Enter Time in 24hrs format (HH:mm): ");
            String timeString = scanner.nextLine();

            try {
                LocalTime time = LocalTime.parse(timeString, formatter);
                return time;
            } catch (Exception e) {
                System.out.println("Invalid time format. Use HH:mm.");
            }
        }
    }

    public static String promptForBerth() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select Berth Option:");
            System.out.println("1. Upper Berth");
            System.out.println("2. Lower Berth");
            System.out.println("3. Middle Berth");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    return "Upper Berth";
                case 2:
                    return "Lower Berth";
                case 3:
                    return "Middle Berth";
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static String promptForCategory() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select Category Option:");
            System.out.println("1. 2S (100Rs pax)");
            System.out.println("2. 3S (200Rs pax)");
            System.out.println("3. 2AC (600Rs pax)");
            System.out.println("4. 3AC (500Rs pax)");
            System.out.println("5. FirstClass (1000Rs pax)");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    return "2S";
                case 2:
                    return "3S";
                case 3:
                    return "2AC";
                case 4:
                    return "3AC";
                case 5:
                    return "FirstClass";
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static String promptForTrain() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select Train:");
            System.out.println("1. Brindavan Express");
            System.out.println("2. Ravan Express");
            System.out.println("3. Super Fast Express");
            System.out.println("4. Bullet Express");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    return "Brindavan Express";
                case 2:
                    return "Ravan Express";
                case 3:
                    return "Super Fast Express";
                case 4:
                    return "Bullet Express";
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static String promptForGender() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select Gender:");
            System.out.println("1. Male");
            System.out.println("2. Female");
            System.out.println("3. Other");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    return "Male";
                case 2:
                    return "Female";
                case 3:
                    return "Other";
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Ticket> tickets = new HashMap<>();
        HashMap<Integer, Complaint> complaints = new HashMap<>();

        while (true) {
            int choice = showMenu();

            switch (choice) {
                case 5:
                    System.out.println("Thank you for using the Indian Railways Booking System.");
                    scanner.close();
                    System.exit(0);
                    break;
                case 4:
                    boolean validInput3 = false;
                    int ticketID = 0;
                    System.out.println("\n========== Complaint Portal ==========\n");
                    while (!validInput3) {
                        System.out.print("Enter Ticket ID: ");
                        try {
                            ticketID = scanner.nextInt();
                            if (!tickets.containsKey(ticketID)) {
                                throw new TicketNotFoundException();
                            }
                            validInput3 = true;
                            scanner.nextLine(); // Consume newline
                            System.out.print("Enter Passenger name: ");
                            String nameString = scanner.nextLine();
                            LocalDate date = promptForDatePast();
                            System.out.print("Enter your complaint: ");
                            String complaintString = scanner.nextLine();

                            Complaint complaint = new Complaint(ticketID, complaintString, nameString, date);
                            complaints.put(complaint.getComplaintID(), complaint);

                            System.out.println("\nHello " + nameString + ",\nYour Complaint: " + complaintString + "\nFiled Successfully.\nYour Complaint ID: " + complaint.getComplaintID() + "\nWe will look into it.");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                            scanner.nextLine(); // Consume invalid input
                        } catch (TicketNotFoundException e2) {
                            System.out.println(e2.getMessage());
                            validInput3 = true;
                            scanner.nextLine(); // Consume invalid input
                        }
                    }
                    break;
                case 3:
                    boolean validInput = false;
                    ticketID = 0;
                    while (!validInput) {
                        System.out.print("Enter Ticket ID: ");
                        try {
                            ticketID = scanner.nextInt();
                            if (!tickets.containsKey(ticketID)) {
                                throw new TicketNotFoundException();
                            }
                            validInput = true;
                            tickets.remove(ticketID);
                            System.out.println("Ticket Cancelled Successfully.");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                            scanner.nextLine(); // Consume invalid input
                        } catch (TicketNotFoundException e2) {
                            System.out.println(e2.getMessage());
                            validInput = true;
                            scanner.nextLine(); // Consume invalid input
                        }
                    }
                    break;
                case 2:
                    boolean validInput2 = false;
                    int ticketID2 = 0;
                    while (!validInput2) {
                        System.out.print("Enter Ticket ID: ");
                        try {
                            ticketID2 = scanner.nextInt();
                            if (!tickets.containsKey(ticketID2)) {
                                throw new TicketNotFoundException();
                            }
                            validInput2 = true;
                            System.out.println("\n========== Ticket Details ==========\n");
                            Ticket ticket = tickets.get(ticketID2);
                            System.out.println("Ticket ID: " + ticket.getTicketID());
                            System.out.println("Train Name: " + ticket.getTrainName());
                            System.out.println("Ticket Date: " + ticket.getTicketDate());
                            System.out.println("Ticket Time: " + ticket.getTicketTime());
                            System.out.println("Category: " + ticket.category);
                            System.out.println("Source: " + ticket.source);
                            System.out.println("Destination: " + ticket.destination);
                            System.out.println("Passenger details:");
                            for (Passenger p : ticket.getPassengers()) {
                                System.out.println(p);
                            }
                            System.out.println("Price: " + ticket.getTicketPrice());
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                            scanner.nextLine(); // Consume invalid input
                        } catch (TicketNotFoundException e2) {
                            System.out.println(e2.getMessage());
                            validInput2 = true;
                            scanner.nextLine(); // Consume invalid input
                        }
                    }
                    break;
                case 1:
                    LocalDate dateString = promptForDate();
                    LocalTime timeString = promptForTime();
                    System.out.print("Enter Source station: ");
                    String sourceString = scanner.nextLine();
                    System.out.print("Enter Destination station: ");
                    String destinationString = scanner.nextLine();
                    String categoryString = promptForCategory();
                    String trainNameString = promptForTrain();
                    System.out.print("Enter No. of Passengers: ");
                    int n = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    ArrayList<Passenger> ps = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Enter Name for Passenger " + (i + 1));
                        String name = scanner.nextLine();
                        System.out.print("Enter age for Passenger " + (i + 1) + ": ");
                        int age = scanner.nextInt();
                        String gender = promptForGender();
                        String berth = promptForBerth();
                        scanner.nextLine(); // Consume newline
                        ps.add(new Passenger(name, age, gender, berth));
                    }

                    Ticket ticket = new Ticket(trainNameString, dateString, timeString, sourceString, destinationString, categoryString, ps);
                    tickets.put(ticket.getTicketID(), ticket);

                    System.out.println("\n========== Ticket Booked Successfully ==========\n");
                    System.out.println("Your Ticket ID is " + ticket.getTicketID());
                    System.out.println("Your total price is " + ticket.getTicketPrice());
                    break;
            }

            System.out.println();
        }
    }
}

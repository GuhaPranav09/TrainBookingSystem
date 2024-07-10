
# Indian Railways Booking System

This is a Java-based booking system for Indian Railways that allows users to book tickets, view tickets, cancel tickets, and raise complaints. The system is designed to be used via a terminal/command line interface.

## Features

- **Book Ticket**: Allows users to book tickets by entering details such as date, time, source, destination, category, train name, and passenger details.
- **View Ticket**: Users can view the details of a booked ticket using the ticket ID.
- **Cancel Ticket**: Users can cancel a booked ticket using the ticket ID.
- **Raise Complaint**: Users can raise complaints related to a booked ticket using the ticket ID.

## Technologies Used

- Java 8 or higher

## Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/GuhaPranav09/TrainBookingSystem.git
   ```

2. **Navigate to the project directory**
   ```bash
   cd TrainBookingSystem
   ```

3. **Compile the Java files**
   ```bash
   javac -d bin src/File/BookingSystem.java
   ```

4. **Run the application**
   ```bash
   java -cp bin File.BookingSystem
   ```

## Usage

1. **Book a Ticket**
   - Select the "Book Ticket" option from the menu.
   - Enter the required details such as date, time, source, destination, category, train name, and passenger details.
   - The system will generate a ticket ID and display the total price.

2. **View a Ticket**
   - Select the "View Ticket" option from the menu.
   - Enter the ticket ID to view the details of the booked ticket.

3. **Cancel a Ticket**
   - Select the "Cancel Ticket" option from the menu.
   - Enter the ticket ID to cancel the booked ticket.

4. **Raise a Complaint**
   - Select the "Raise a Complaint" option from the menu.
   - Enter the ticket ID and other required details to file a complaint.

## Exception Handling

- **Invalid Input Handling**: The system handles invalid inputs and prompts the user to enter valid data.
- **Ticket Not Found Exception**: If a ticket with the given ID is not found, a `TicketNotFoundException` is thrown.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any improvements or bug fixes.


## Acknowledgments

- Indian Railways for inspiration.
- My Java Mentor.

# JavaFX Desktop Application

This is a simple JavaFX desktop application that interacts with a MySQL database. It utilizes various JavaFX libraries to enhance the user interface and provide a seamless experience. The application allows users to perform basic CRUD operations (Create, Read, Update, Delete) on data stored in the database.

## Prerequisites

To run this application locally, you need to have the following installed:

- Java Development Kit (JDK) 8 or later
- MySQL Server
- MySQL Connector/J (JDBC Driver)
- JavaFX libraries (included in JDK 8 and later)

## Getting Started

Follow the steps below to get started with the application:

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/Lykamopia/JavaFx-Delivery-Desktop-app.git
   ```

2. Create a MySQL database and execute the SQL script provided in the `database.sql` file. This will create the necessary table(s) for the application.

3. Open the project in your preferred Java IDE.

4. Configure the MySQL database connection parameters in the `DatabaseConfig.java` file located in the `src` directory:

   ```java
   public class DatabaseConfig {
       private static final String HOST = "localhost";
       private static final String PORT = "5531";
       private static final String DATABASE_NAME = "EMS";
       private static final String USERNAME = "";
       private static final String PASSWORD = "";

       // Rest of the class...
   }
   ```

5. Build the project to compile the source code.

6. Run the application by executing the main class `Main.java`.

## Features

The JavaFX desktop application offers the following features:

- Displaying records from the database in a table view.
- Adding new records to the database.
- Editing existing records.
- Deleting records from the database.

## Libraries Used

This project utilizes the following JavaFX library:
- [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) - The official JDBC driver for MySQL.

## Contributing

Contributions to this project are welcome. If you find any bugs or want to add new features, please open an issue or submit a pull request.

Happy coding!

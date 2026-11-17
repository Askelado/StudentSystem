package Models;

import java.sql.*;

public class Dao {

    public static void main(String[] args) {


    }


    // Creates the 'users' table in the database if it hasn't been created yet
    public void createNawTable() throws SQLException {

        // PRIMARY KEY: auto-incrementing unique identifier | NOT NULL: field cannot be empty | UNIQUE: no duplicate numbers allowed
        String sql = """
                CREATE TABLE IF NOT EXISTS students (
                ID INTEGER PRIMARY KEY,
                NAME TEXT NOT NULL,
                MAJOR TEXT NOT NULL,
                GRADENUM DECIMAL NOT NULL,
                GRADELETTER TEXT NOT NULL
                );                
                """;

        // Opens connection and creates a Statement object to run the static SQL command
            Connection con = connect();
            Statement stmt = con.createStatement();
            stmt.execute(sql); // Executes the SQL command (used for CREATE, DROP, etc.)
            System.out.println("table created");

    }

    // Inserts a new contact row into the 'users' table
    public void insert(String name, String major, Double gradenum, String gradeletter) throws SQLException {

        // Parameterized SQL query: '?' act as safe placeholders for values (prevents SQL Injection)
        String sql = "INSERT INTO students(NAME,MAJOR,GRADENUM,GRADELETTER) VALUES(?,?,?,?)";
        Connection con = connect();
        PreparedStatement prst = con.prepareStatement(sql);
        prst.setString(1,name);
        prst.setString(2,major);
        prst.setDouble(3,gradenum);
        prst.setString(4,gradeletter);
        prst.executeUpdate();

    }
    // Deletes a specific contact row matching the given ID
    public void delete(int idd) throws SQLException {
        Connection con = connect();
        String sql = "DELETE FROM students\n WHERE ID = ?"; // Deletes only the row where ID matches '?'

        PreparedStatement prst = con.prepareStatement(sql);
        prst.setInt(1,idd);
        prst.executeUpdate();
    }

    // Updates a contact's phone number based on their ID (Method Overloading: int, int)
//    public void update(int id, Student s) {
//
//        String sql = """
//                UPDATE students
//                SET NAME = ? , MAJOR = ? , GRADENUM = ? , GRADELETTER = ?
//                WHERE ID= ?;
//                """;
//
//        Connection con = connect();
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setString(1,get);
//    }

    // Updates a contact's name based on their ID (Method Overloading: int, String)
//    public void update(int id, String name) {
//        String url = "jdbc:sqlite:contacts.db";
//        String sql = """
//                UPDATE users
//                SET NAME=?
//                WHERE ID= ?;
//                """;
//        try (Connection con = DriverManager.getConnection(url);
//             PreparedStatement stmt = con.prepareStatement(sql)) {
//            stmt.setString(1, name);  // Replaces 1st '?' (new NAME)
//            stmt.setInt(2, id);       // Replaces 2nd '?' (target ID)
//            stmt.executeUpdate();
//            System.out.println("Name Modified");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

    // Updates a contact's relation based on their ID (Method Overloading: String, int)
//    public void update(String relation, int id) {
//        String url = "jdbc:sqlite:contacts.db";
//        String sql = """
//                UPDATE users
//                SET RELATION=?
//                WHERE ID= ?;
//                """;
//        try (Connection con = DriverManager.getConnection(url);
//             PreparedStatement stmt = con.prepareStatement(sql)) {
//            stmt.setString(1, relation); // Replaces 1st '?' (new RELATION)
//            stmt.setInt(2, id);          // Replaces 2nd '?' (target ID)
//            stmt.executeUpdate();
//            System.out.println("Relation Modified");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

    // Fetches and prints all rows from the 'users' table
    public void printDate() {
        String url = "jdbc:sqlite:contacts.db";
        String sql = "SELECT ID,NAME,PHONENUM,RELATION FROM users"; // Query to read all 4 columns

        try (Connection con = DriverManager.getConnection(url);
             Statement st = con.createStatement()) {

            // executeQuery() runs a SELECT statement and stores the returned table in ResultSet
            ResultSet r = st.executeQuery(sql);

            // r.next() moves the cursor to the next row; returns false when no more rows exist
            while (r.next()) {
                // Extracts data from the current row using 1-based column positions:
                // 1 -> ID, 2 -> NAME, 3 -> PHONENUM, 4 -> RELATION
                System.out.println(r.getInt(1) + "\t" + r.getString(2) + "\t" + r.getInt(3) + "\t\t" + r.getString(4) + "\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public Connection connect() throws SQLException {
        // JDBC connection string specifying the SQLite driver and database file name
        String url = "jdbc:sqlite:users.db";

        return DriverManager.getConnection(url);


    }
}

package org.example;

import java.sql.*;

public class Etudiant {
    private int id ;
    private String nom ;
    private int age ;
    private String prenom ;
    public Etudiant(String nom, String prenom , int age) {
        this.nom = nom;
        this.age = age;
        this.prenom = prenom;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static void afficherEtd(){
        String query = "SELECT * FROM etudiants";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp_jdbc","root","");

            PreparedStatement preparedStatement = conn.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                System.out.println("id: " + resultSet.getInt("id") +
                        " | nom: " + resultSet.getString("nom") +
                        " | prenom: " + resultSet.getString("prenom") +
                        " | age: " + resultSet.getString("age")
                );
            }

//            System.out.println(conn);
            preparedStatement.close();
            conn.close();

        }catch (ClassNotFoundException | SQLException e){
            System.out.println("error: "+e);
        }
    }
    public static void ajouterEtd( Etudiant etd ){
        String query = "INSERT INTO etudiants (nom, prenom, age) VALUES (?, ?, ?)";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp_jdbc","root","");

            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1,etd.nom);
            preparedStatement.setString(2,etd.prenom);
            preparedStatement.setInt(3,etd.age);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Insert successful. " + rowsAffected + " row(s) affected.");
            } else {
                System.out.println("Insert failed.");
            }

            preparedStatement.close();
            conn.close();

//            System.out.println(conn);

        }catch ( SQLException e ){
            System.out.println("error: "+e);
        }
    }

    public static void modifierEtd( Etudiant etd , int idE){
        String query = "UPDATE etudiants SET nom = ? , prenom=? , age=? WHERE id = ?";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp_jdbc","root","");

            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1,etd.nom);
            preparedStatement.setString(2,etd.prenom);
            preparedStatement.setInt(3,etd.age);
            preparedStatement.setInt(4,idE);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("update successful. " + rowsAffected + " row(s) affected.");
            } else {
                System.out.println("update failed.");
            }

            preparedStatement.close();
            conn.close();
//            System.out.println(conn);

        }catch ( SQLException e ){
            System.out.println("error: "+e);
        }
    }
    public static void supprimerEtd( int idE ){
        String query = "DELETE FROM etudiants WHERE id = ?";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp_jdbc","root","");

            PreparedStatement preparedStatement = conn.prepareStatement(query);


            preparedStatement.setInt(1,idE);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("delete successful. " + rowsAffected + " row(s) affected.");
            } else {
                System.out.println("delete failed.");
            }

            preparedStatement.close();
            conn.close();

//            System.out.println(conn);

        }catch ( SQLException e ){
            System.out.println("error: "+e);
        }
    }








}

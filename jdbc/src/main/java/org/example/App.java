package org.example;


import java.sql.*;

public class App
{
    public static void main( String[] args ) {

        Etudiant.afficherEtd();
        Etudiant e1 = new Etudiant("ayoub","boutbib",21);
        Etudiant.ajouterEtd(e1);
        Etudiant.afficherEtd();
        Etudiant.modifierEtd( new Etudiant("ayoubTmodifia","hhhhhh",19) , 12 );
        Etudiant.afficherEtd();
        Etudiant.supprimerEtd(12);
        Etudiant.afficherEtd();

}
}

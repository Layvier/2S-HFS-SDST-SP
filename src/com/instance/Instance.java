package com.instance;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Maxterfike on 20/12/2015.
 */
public class Instance {
    private String fileName;


    //--------------------Données du problème-----------------------
    private int nbMachinesF;


    //----------------------Accesseurs----------------------------
    public int getNbMachinesF(){
        return nbMachinesF;
    }

    //-----------------------Constructeur--------------------------
    public Instance(String fName) throws IOException{
        fileName = fName;
        read();
    }

    /**
     * Lis l'instance à partir de son nom, et set les données dans les variables d'instances
     */
    private void read() throws IOException{
        File mfile = new File(fileName);
        if (!mfile.exists()) {
            throw new IOException("Le fichier saisi : "+ fileName + ", n'existe pas.");
        }
        Scanner sc = new Scanner(mfile);

        String line;
        do {
            line = sc.nextLine();
            System.err.println(line);
        }
        while (!line.startsWith("DIMENSION"));
        Scanner lineSc = new Scanner(line);
        lineSc.next();
        if (!lineSc.hasNextInt()) {
            lineSc.next();
        }
        nbSommets =lineSc.nextInt();
        coordX = new double[nbSommets];
        coordY = new double[nbSommets];
        labels = new String[nbSommets];
        demande = new int[nbSommets];
        datePlusTot = new int[nbSommets];
        datePlusTard = new int[nbSommets];
        tempsService = new int[nbSommets];




        while (!line.startsWith("CAPACITE")) {
            line = sc.nextLine();
            System.err.println(line);
        }
        lineSc.close();
        lineSc = new Scanner(line);
        lineSc.next();
        if (!lineSc.hasNextInt()) {
            lineSc.next();
        }
        capaVehicule =lineSc.nextInt();

        while (!line.contains("ID")) {
            line = sc.nextLine();
            System.err.println(line);
        }
        line = sc.nextLine();

        int idx = 0;
        for (int s=0;s<nbSommets;s++){
            assert(idx<nbSommets);
            lineSc = new Scanner(line);
            lineSc.useLocale(Locale.US);
            labels[idx] = lineSc.next();
            coordX[idx] = lineSc.nextDouble();
            coordY[idx] = lineSc.nextDouble();
            demande[idx]= lineSc.nextInt();
            datePlusTot[idx]= lineSc.nextInt();
            datePlusTard[idx] = lineSc.nextInt();
            tempsService[idx]=lineSc.nextInt();
            line = sc.nextLine();
            idx++;
        }

        // Création de la matrice de distances
        distances = new long[nbSommets][];
        for (int i = 0; i < nbSommets; i++) {
            distances[i] = new long[nbSommets];
        }

        // Calcul des distances
        for (int i = 0; i < nbSommets; i++) {
            distances[i][i] = 0;
            for (int j = i + 1; j < nbSommets; j++) {
                long dist = distance(i,j);
                //				System.out.println("Distance " + i + " " +j + ": " + dist);
                distances[i][j] = dist;
                distances[j][i] = dist;
            }
        }
        lineSc.close();
        sc.close();
    }


}

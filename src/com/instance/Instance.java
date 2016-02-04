package com.instance;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.File;
import java.io.IOException;
import java.util.IntSummaryStatistics;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Maxterfike on 20/12/2015.
 */

public class Instance {
    private String fileName;


    //--------------------Données du problème-----------------------
    private int M;//nb de machines M
    private int F;//nb de machines F
    private int N;//nb de commandes
    private int P;//nb de produits
    private int T;//nb de types

    int[][] setUp;//P*P, setUp[i][j]=1 si il faut un set-up entre le produit i et le produit j (i avant, j après)
    int[][] duration;//F*T, égal à la vitesse de production de la machine f pour le type t
    int[] setUpTimeM;//M, égal au temps de set-up de la machine m
    int[] setUpTimeF;//F, égal au temps de set-up de la machine f
    Job[] jobs;//N, Liste des jobs alias commandes

    //----------------------Accesseurs----------------------------
    public int getNbMachinesF(){
        return F;
    }
    public int getNbMachinesM(){
        return M;
    }

    //-----------------------Constructeur--------------------------
    public Instance(String fName) throws IOException{
        fileName = fName;
        read();
    }
    public Instance(){
        this.M = 1;
        this.F = 3;
        this.N = 5;
        this.P = 5;
        this.T = 4;

        this.setUp = new int[P][P];
        for(int i=0; i<P; i++){
            for(int j=0; j<P; j++){
                if(i==j){
                    this.setUp[i][j] = 0;
                }
                else {
                    this.setUp[i][j] = 1;
                }
            }
        }

        this.duration = new int[F][T];
        for(int i=0; i< F; i++){
            for(int j=0; j<T; j++){
                this.duration[i][j] = 1;
            }
        }

        this.setUpTimeM = new int[M];
        this.setUpTimeM[0] = 2;

        this.setUpTimeF = new int[F];
        for(int i=0; i<F; i++){
            this.setUpTimeF[i] = 1;
        }

        this.jobs = new Job[N];//Convention : Job 0 n'est pas utilisé, Commande vide
        this.jobs[0] = new Job(0,0,1,20);
        this.jobs[1] = new Job(1,2,2,20);
        this.jobs[2] = new Job(3,1,3,20);
        this.jobs[3] = new Job(1,4,3,20);
        this.jobs[4] = new Job(2,2,4,20);

    }
    /**
     * ------------------A FAIRE-----------------------------
     * Lis l'instance à partir de son nom, et set les données dans les variables d'instances
     */
    private void read() throws IOException{
     /*   File mfile = new File(fileName);
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
       /* nbSommets =lineSc.nextInt();
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
        sc.close();*/
    }


    public String getFileName() {
        return fileName;
    }

    public int getM() {
        return M;
    }

    public int getF() {
        return F;
    }

    public int getN() {
        return N;
    }

    public int getP() {
        return P;
    }

    public int getT() {
        return T;
    }

    public int[][] getSetUp() {
        return setUp;
    }

    public int[][] getDuration() {
        return duration;
    }

    public int[] getSetUpTimeM() {
        return setUpTimeM;
    }

    public int[] getSetUpTimeF() {
        return setUpTimeF;
    }

    public Job[] getJobs() {
        return jobs;
    }

    public Job getJob(int i){
        return jobs[i];
    }
}

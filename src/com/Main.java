package com;

import com.instance.Instance;
import com.instance.Solution;
import com.resolution.Solver;

import java.io.IOException;

public class Main {

    public static void main(String[] arg) {
        System.out.println("hello worlds");
        String filename = null;
        long max_time = 300;
        boolean graphical = false;
        /*
        // --- parse command-line ---
        for (int i = 0; i < arg.length; i++) {
            if (arg[i].compareTo("-help") == 0) {
                System.err.println("Utilisation de l'API :");
                System.err.println("commande: java Principale [options] datafile");
                System.err.println("Options:");
                System.err.println("  -help     : imprime cette aide");
                System.err.println("  -t (int)  : temps maximum alloué à la résolution");
                System.err.println("  -g        : affichage graphique de la solution");

            }
            else if (arg[i].compareTo("-t") == 0) {
                try {
                    max_time = Integer.parseInt(arg[++i]);
                } catch (Exception e) {
                    System.out.println("erreur : temps invalide pour l'option -t");
                    System.exit(1);
                }
            } else if (arg[i].compareTo("-g") == 0) {
                graphical = true;
            } else {
                if (filename != null) {
                    System.err.println("erreur : paramètre inconnu ou trop de fichiers de données");
                    System.err.println("Paramètre :" + arg[i]);
                    System.exit(1);
                }
                filename = arg[i];
            }
        }
        */
        // --- create and solve problems ---
        try {
            filename = "n33";

            Solver solver = new Solver();

            // create a new problem; data is read from file filename
            Instance prob = new Instance();
            solver.setInstance(prob);
            solver.setSolution(new Solution(prob));//rajouter un param dans le constructeur, comme nbCamions ?

            // print the data [uncomment if wanted]
            // prob.printData(System.err);

            // solve the problem
            long t = System.currentTimeMillis();
            solver.solve();
            t = System.currentTimeMillis() - t;


            // evaluate the solution (and check whether it is feasible)
            boolean feasible = solver.getSolution().validate();

            // sortie du programme: fileName;routeLength;t;e
            // e est un code d'erreur :
            // e = 0 -> solution réalisable dans les temps
            // e = 1 -> solution non réalisable
            // e= 2 -> temps dépassé
            int e = 0;
            if (!feasible)
                e = 1;
            else {
                if (t > (max_time + 1) * 1000) {
                    e = 2;
                    System.err.println("Temps dépassé !!!");
                }
            }
            System.out.println(filename + ";" + solver.getSolution().getObjectif() + ";" + t + ";" + e);

            // If graphical and no error, draw
            if (feasible && graphical) {
                // Graphical solution

            }
        } catch (IOException e) {
            System.err.println("Erreur dans la lecture du fichier: " + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.err.printf("error: %s", e.getMessage());
            System.err.println();
            e.printStackTrace(System.err);
            System.exit(1);
        }
        return;
    }
}

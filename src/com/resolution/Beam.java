package com.resolution;

import com.instance.Job;
import com.instance.Solution;

import java.util.ArrayList;

/**
 * Created by Maxterfike on 21/01/2016.
 */
public class Beam {

    public int B;
    public Solution[] beam ;
    public ArrayList<Solution> potential;

    public Beam(int nbSolution, Solution solutionJohnson){
        this.B = nbSolution;
        this.beam = new Solution[B];
        for(int i=0; i<B; i++){
            this.beam[i] = solutionJohnson.clone();
        }
        this.potential = new ArrayList<Solution>();
    }

    /**
     * A appeller à chaque tour
     */
   /** public void update(){
        updatePotentials();
        select();
    }**/
    public void updatePotentialsNEH(Job job){
        for(int i=0; i<B; i++)
            NEH(beam[i], job);
    }

    /**
     * Ajoute toutes les solutions crées avec NEH pour ce job à potential, ie les solutions avec le job inséré à toutes les positions possibles.
     * @param solution
     * @param job
     */
    public void NEH(Solution solution, Job job){
        solution.removeJob(job);

    }
    /**
     * Sélectionne les B meilleures solutions parmi le beam et les nouvelles solutions (potential)
     * et les ordonne dans le beam selon le coût (meilleures solutions en premier)
     */
    public void select(){
        for(Solution s : potential){

        }
    }


}

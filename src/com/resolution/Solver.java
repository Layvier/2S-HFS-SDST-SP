package com.resolution;

import com.instance.Instance;
import com.instance.Job;
import com.instance.Solution;

/**
 * Created by Maxterfike on 20/12/2015.
 */
public class Solver {
    private static final double TimeLimit = 3600;
    private static final double Epsilon = 0.001;
    private long time;

    private Instance instance;
    private Solution solution;

    public void setInstance(Instance instance){
        this.instance = instance;
    }
    public void setSolution(Solution solution){
        this.solution = solution;
    }
    public Solution getSolution(){
        return this.solution;
    }
    public void solve() throws Exception{
        Instance instance = this.instance;
        Solution solution = this.solution;

        solution = this.Johnson();

        //magic happening here


        this.solution = solution;
    }
    public void BPI(int W, int I){

    }
    public void BNI(int B, int I){
        Instance instance = this.instance;
        Solution solution = this.solution;

        Beam beam = new Beam(B, solution);
        for(int i=0; i<I; i++){
            Job job = this.selectJob(i, I);
            beam.updatePotentialsNEH(job);
            beam.select();
        }

    }
    public Job selectJob(int i, int n){
        return instance.getJob(i % instance.getN());
    }
    public Solution Johnson(){
        return null;
    }

}

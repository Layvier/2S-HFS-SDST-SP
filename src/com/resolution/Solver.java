package com.resolution;

import com.instance.Instance;
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


        //magic happening here




        this.solution = solution;


    }

}

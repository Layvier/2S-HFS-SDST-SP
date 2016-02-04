package com.instance;

/**
 * Created by Maxterfike on 20/12/2015.
 */
public class Solution {

    //------------données du pb---------------
    private Instance instance;

    //----------------variables-------------------------


    private int[][][] Xm;//M*N*N matrice de précédence des jobs de la machine m (Xm[m][i][j])
    private int[][][] Xf;//F*N*N matrice de précédence des jobs de la machine f
    //||||||||||||| ou ||||||||||||||
    private int[] posM;//pos du job i sur m?
    private int[] posF;
    //je sais plus en fait


    private int[] tprodM;//N date de lancement du job j au niveau M
    private int[] tprodF;//N date de lancement du job j au niveau F
    private int finishTime;

    //-------------------Accesseurs---------------------

    //----------------Constructeur---------------------


    public Solution(Instance instance, int[][][] xm, int[][][] xf, int[] posM, int[] posF, int[] tprodM, int[] tprodF, int finishTime) {
        this.instance = instance;
        Xm = xm;
        Xf = xf;
        this.posM = posM;
        this.posF = posF;
        this.tprodM = tprodM;
        this.tprodF = tprodF;
        this.finishTime = finishTime;
    }
    public Solution(Instance instance){
        System.out.println("lol");
        System.out.println(instance.getNbMachinesF());
        this.instance = instance;
        this.Xm= new int[instance.getM()][instance.getN()][instance.getN()];
        this.Xf= new int[instance.getF()][instance.getN()][instance.getN()];
        for(int i=0; i<instance.getM(); i++){
            for(int j=0; j<instance.getN(); j++){
                for(int k=0; k<instance.getN();k++){
                    this.Xm[i][j][k]=0;

                }
            }
        }
        for(int i=0; i<instance.getF(); i++){
            for(int j=0; j<instance.getN(); j++){
                for(int k=0; k<instance.getN();k++){
                    this.Xf[i][j][k]=0;
                }
            }
        }
        for(int m=0; m<instance.getM(); m++){
            this.Xm[m][0][0] = 1;
        }
        for(int f=0; f<instance.getF(); f++){
            this.Xf[f][0][0] = 1;
        }
        printAsText();
    }

    /**
     * calcul les tprod de M et de F à partir des jobs et des matrices posM posF
     * @return
     */
    public int processTime(){

        return 0;
    }
    public int getLastJobM(int machine){
        for(int i=0; i<instance.getM(); i++){
            if(Xm[machine][i][0] == 1){
                return i;
            }
        }
        System.out.println("err pas de last job");
        return 0;
    }
    public int addJobM(int job, int machine){



        return 0;
    }
    /**
     *
     * @param job l'indice du job avant le job
     *
     * @return
     */
    public int addJobAfter(int job){
       return  0;
    }
    public void printAsText(){
        System.out.println("M");
        for(int m=0; m<instance.getM(); m++){
            System.out.println(m);
            for(int i=0; i<instance.getN(); i++){
                for(int j=0; j<instance.getN(); j++){
                    System.out.print(Xm[m][i][j]+" ");
                }
                System.out.println("");
            }
        }
        System.out.println("F");
        for(int f=0; f<instance.getF(); f++){
            System.out.println(f);
            for(int i=0; i<instance.getN(); i++){
                for(int j=0; j<instance.getN(); j++){
                    System.out.print(Xf[f][i][j]+" ");
                }
                System.out.println("");
            }
        }

    }
    /**
     * true si valide (ofc)
     * @return
     */
    public boolean validate(){



        return true;
    }
    public Solution clone(){
        //Solution sol = new Solution(instance, Xm, Xf, );
        return null;
    }

    public int getObjectif(){
        return 0;
    }
}

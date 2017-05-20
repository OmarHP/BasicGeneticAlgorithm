package com.ohp.ga;

/**
 * Created by Omar on 19/05/2017.
 */
public class Individual {

    static int defaultGeneLength = 64;
    private byte[] genes = new byte[defaultGeneLength];

    private int fitness = 0;

    //Create a random individual
    public void generateIndividual() {
        for (int i = 0; i < size(); i++) {
            byte gene = (byte) Math.round(Math.random());
            genes[i] = gene;
        }
    }

    //Use this if you want to create individuals with different gene lengths
    public static void setDefaultGeneLength(int length) {
        defaultGeneLength = length;
    }

    public byte getGene(int index){
        return genes[index];
    }

    public void setGene(int index, byte value){
        genes[index] = value;
        fitness = 0;
    }

    public int getFitness(){
        if (fitness == 0){
            fitness = FitnessCalc.getFitness(this);
        }
        return fitness;
    }

    public int size() {
        return genes.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            sb.append(getGene(i));
        }

        return sb.toString();
    }

}

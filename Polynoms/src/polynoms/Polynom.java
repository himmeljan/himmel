/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynoms;

import java.util.Arrays;

/**
 *
 * @author Honzik note
 */
public class Polynom {

    //data
    private double[] coef;

    //konstruktory
    private Polynom(double[] coef) {
        double[] coefTemp = new double[coef.length];
        System.arraycopy(coef, 0, coefTemp, 0, coef.length); //defenzivn9 kopie, abz byli prvtne hodnot pole
        this.coef = coef;
    }

    // factory metoda
    public static Polynom getInstanceReverted(double[] coef) { // 
        return new Polynom(coef);
    }

    public static Polynom getInstance(double... coef) { //[5 3 0 6]\
        double[] coefTemp = new double[coef.length];
        for (int i = 0; i < coef.length; i++) {
            coefTemp[coef.length - 1 - i] = coef[i];
        }
        return new Polynom(coefTemp);
    }

    //metody
    //du vzpocitat hodnotu polznomu pro yadan0 x x=1 y=? - Horerovo sch0ma 
    public double computeValue(double x, double[]a) {
        double result = 0;
        for (int i = 0; i < a.length; i++) {
            result = result + a[i] * (Math.pow(x, i));

        }
        return result;
    }


    //gettre
    public double getCoefAt(int index) {
        return coef[index];
    }

    public double[] getAllCoef() {

        return Arrays.copyOf(coef, coef.length);
    }

    public int getDegree() {
        return coef.length - 1;
    }

    //TODO vypsat to matematicky 2x^6 kdyz nula tak nevypisat
   
    @Override
    public String toString() {
        String a="" ;
        for (int i = coef.length - 1; i > 0; i--) {
            if(coef[i]!=0){
                System.out.print(" "+ coef[i] + "x^"+i +" +" );
            }
          
        }
           if(coef[0]!=0){
         System.out.print(" "+ coef[0]);
           }
    return a;
    }

    public Polynom derivate() {
        double[] coefD = new double[coef.length - 1];
        for (int i = 0; i < coefD.length; i++) {
            coefD[i] = coef[i + 1] * (i + 1);
        }
        return new Polynom(coefD);

    }

    //Todo bonus
    public double intagrate(double a, double b) {
        double[] coefI = new double[coef.length+1];
        coefI[0]=0;
         for(int i=1; i<=coef.length; i++){
             coefI[i]= coef[i-1]/i;
         }
         System.out.println(coefI[4]);
       double value= computeValue(a,coefI)-computeValue(b,coefI);
        
        return value;
    }

    public static void main(String[] args) {
        double[] a = {6, 0, 3, 5};
        Polynom p1 = Polynom.getInstanceReverted(a);
        System.out.println(p1);
        System.out.println(p1.getCoefAt(3));
        System.out.println(p1.derivate());
        System.out.println(p1.computeValue(1,p1.getAllCoef()));
        System.out.println(p1.intagrate(2, 1));
    
    }
}

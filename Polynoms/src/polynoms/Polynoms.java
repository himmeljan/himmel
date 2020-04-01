/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynoms;

/**
 * knihovni library class
 * @author Honzik note
 */
public class Polynoms {

    private Polynoms(){
        
    }
    
     public static Polynom sum(Polynom a,Polynom b){
         boolean isBigger = a.getDegree() > b.getDegree();
         Polynom max =isBigger ? a:b;
         Polynom min = isBigger? b:a;
         
         double[] sumCoef = new double[max.getDegree()+1];
         for(int i = 0; i< max.getDegree()+1;i++){
             sumCoef[i] = max.getCoefAt(i);
         }
         for(int i = 0; i< min.getDegree()+1;i++){
             sumCoef[i] = sumCoef[i] + min.getCoefAt(i);
         }
         return Polynom.getInstanceReverted(sumCoef);
     }    
    //TODO 
     public static Polynom multiply (Polynom a,Polynom b ){
            boolean isBigger = a.getDegree() > b.getDegree();
         Polynom max =isBigger ? a:b;
         Polynom min = isBigger? b:a;
         
         double[] multiCoef = new double[max.getDegree()*min.getDegree()];
         for(int i=0;i<multiCoef.length;i++){
             multiCoef[i] = 0;
         }
         for(int i=0;i<max.getDegree()+1;i++){
             for(int j=0;j<min.getDegree()+1;j++){
                multiCoef[i+j] = multiCoef[i+j]+max.getCoefAt(i)*min.getCoefAt(j);
             }
         }
         
          return Polynom.getInstanceReverted(multiCoef);        
     }
    
    public static void main(String[] args) {
        Polynom p1 = Polynom.getInstance(5,-3,0,6);
        Polynom p2 = Polynom.getInstance(6,3,1,1,1,1,1,1,1,1,1,1);
        System.out.println(Polynoms.sum(p1, p2));
        System.out.println(Polynoms.multiply(p1, p2));
        
    }
    
}

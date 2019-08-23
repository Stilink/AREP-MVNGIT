package edu.arep;

import java.io.*;

/**
 * Main
 */
public class Main
{
    public static void main( String[] args ) throws Exception
    {
        File file = new File("input.in");
        BufferedReader br = file.exists() ? new BufferedReader(new FileReader(file)) : new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            double data = Double.parseDouble(br.readLine());
            list.add(data);
        }
        list.restart();
        calculate(list);
    }
    /**
     * Calcula y muestra en pantalla los datos solicitados.
     * @param list Lista que contiene los datos.
     * 
     */
    public static void calculate(LinkedList list){
        double mean = 0;
        double deviation = 0;
        // Variables temporales, usadas en el calculo de la media y la desviación
        double sumOfTheMean = 0;
        double sumOfTheDeviation = 0;
        double n = 0;
        while(list.hasMoreItems()){
            n++;
            sumOfTheMean+= list.next();
        }
        mean = sumOfTheMean/(--n);
        list.restart();
        while(list.hasMoreItems()){
            sumOfTheDeviation+= Math.pow(list.next()-mean,2);
        }
        // Al incluir el "head" dentro de la lista, se agrega un dato basura que es controlado con la siguiente sentencia.
        sumOfTheDesviation-=Math.pow(mean,2);
        deviation = Math.sqrt(sumOfTheDeviation/(n-1));
        System.out.println("The mean is: "+mean);
        System.out.println("The desviation standard is: "+deviation);
    }
}

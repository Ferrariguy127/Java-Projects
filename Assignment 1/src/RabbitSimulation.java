import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
//Author David Bulin
//Date of Completion: 10/1/2023
//Program functions as a way to track population growth given set variables
public class RabbitSimulation {
    private static final int Trial_Count = 10;//number of trials to be preformed
    private static final int Total_Days = 365;//total number of days in the year. also the limit in which the trial should stop running

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("Seeds.txt"));
            while (sc.hasNextLine()) {
                ArrayList<int[]> TrialData = new ArrayList<>();
                int Does = sc.nextInt(); //For each row in the Seeds.txt file it will populate the number of males and females
                int Bucks = sc.nextInt();
                System.out.println(" Starting with " + Does + " Does and " + Bucks + " Bucks:");
                for (int i = 0; i<Trial_Count; i++){
                    int[] TrialResults = StartRun(Does, Bucks); //Will start to run the actual program
                    TrialData.add(TrialResults);
                }
                PrintTrialResults(TrialData);
                PrintDeviation(TrialData);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    //This part of the program will take the total number of males and females and track the population by storing it
    //into a position on the array list rabbits
    private static int[] StartRun(int Does, int Bucks) {
        ArrayList<Rabbit> rabbits = new ArrayList<>();
        for (int i = 0; i < Does; i++) {
            rabbits.add(new Rabbit(true));
        }
        for (int i = 0; i < Bucks; i++) {
            rabbits.add(new Rabbit(false));
        }
    //for this section it will increase the age for each rabbit
    //for each female it will also check if they are pregnant and increase gestation time
        for (int day = 0; day <= Total_Days; day++) {
            for (int k=0; k< rabbits.size(); k++){
                Rabbit rabbit = rabbits.get(k);
                rabbit.incrementAge();
                if (rabbit.isFemale() && rabbit.getAge() >= 100 && !rabbit.isPregnant() && (rabbit.getDaysAfterDelivery() >= 7 || rabbit.getDaysAfterDelivery() == -1)){
                    rabbit.setPregnant();
                }

                if (rabbit.isPregnant() && rabbit.getDaysInGestation()== rabbit.getGestationPeriod()) {
                    int litterSize = rabbit.giveBirth();
                    for (int i = 0; i < litterSize; i++) {
                        rabbits.add(new Rabbit());
                    }
                }
            }
        }
        //Each result is a different value for the total population, females, and males
        int[] result = new int[3];
        result[0] = rabbits.size();
        result[1] = NumberOfFemales(rabbits);
        result[2] = NumberOfMales(rabbits);
        return result;
    }
    //Stores the number of Females
    private static int NumberOfFemales(ArrayList<Rabbit> rabbits) {
        int count = 0;
        for (Rabbit rabbit : rabbits) {
            if (rabbit.isFemale()) {
                count++;
            }
        }
        return count;
    }
    //Stores teh number of males

    private static int NumberOfMales(ArrayList<Rabbit> rabbits) {
        int count = 0;
        for (Rabbit rabbit : rabbits) {
            if (!rabbit.isFemale()) {
                count++;
            }
        }
        return count;
    }

    //Will print the trial data to the console for view
    private static void PrintTrialResults(ArrayList<int[]> TrialData) {
        int Trial_Count = 0;
        for (int j=0; j<TrialData.size(); j++){
            int[] result = TrialData.get(j);
            System.out.println("Trial " + Trial_Count + ": " + result[0] + " was the final population of rabbits; " + result[1] + " does, " + result[2] + " bucks. ");
                Trial_Count++;
            }
        }
    //will print the Average and Deviation to the console screen
    public static void PrintDeviation(ArrayList<int[]> TrialData) {
        double TotalRabbits = 0;
        double TotalFemales = 0;
        double TotalMales = 0;

        for (int[] result : TrialData) {
            TotalRabbits += result[0];
            TotalFemales += result[1];
            TotalMales += result[2];
        }
        //Variables for Averages for total rabbits, total females, and total males.
        double AvgRabbits = TotalRabbits / TrialData.size();
        double AvgFemales = TotalFemales / TrialData.size();
        double AvgMales = TotalMales / TrialData.size();

        double sumSquaredDeviationOfRabbits = 0;
        double sumSquaredDeviationsOfFemales = 0;
        double sumSquaredDeviationsOfMales = 0;

        for (int[] result : TrialData) {
            sumSquaredDeviationOfRabbits += Math.pow(result[0] - AvgRabbits, 2);
            sumSquaredDeviationsOfFemales += Math.pow(result[1] - AvgFemales, 2);
            sumSquaredDeviationsOfMales += Math.pow(result[2] - AvgMales, 2);
        }
        //These functions are for the Standard Deviation of Rabbits, Females, and Males.
        double StandardDeviationOfRabbits = Math.sqrt(sumSquaredDeviationOfRabbits / TrialData.size());
        double StandardDeviationOfFemales = Math.sqrt(sumSquaredDeviationsOfFemales / TrialData.size());
        double StandardDeviationOfMales = Math.sqrt(sumSquaredDeviationsOfMales / TrialData.size());
        System.out.printf("Average number of Rabbits:  %.3f with a standard deviation of %.3f \n", AvgRabbits, StandardDeviationOfRabbits);
        System.out.printf("Average number of female Rabbits: %.3f with a standard deviation of %.3f  \n", AvgFemales, StandardDeviationOfFemales);
        System.out.printf("Average number of Male Rabbits: %.3f with a standard deviation of %.3f \n", AvgMales, StandardDeviationOfMales);
        System.out.println();
    }
}
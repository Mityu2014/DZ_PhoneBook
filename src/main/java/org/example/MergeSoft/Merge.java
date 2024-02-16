package org.example.MergeSoft;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.*;

public class Merge {
    private static File log;
    private static FileWriter fileWriter;

    public static void sort(int[] mas) {
        try{
            log = new File("log.txt");
            log.createNewFile();
            fileWriter = new FileWriter(log);
            bubleSort(mas);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                fileWriter.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    private static int[] bubleSort(int[]mas){
        boolean isS = false;
        int buffer;
        while (!isS){
            isS = true;
            for (int i = 0; i < mas.length -1; i++) {
                if(mas[i]>mas[i+1]){
                    isS = false;
                    buffer = mas[i];
                    mas[i] = mas[i +1];
                    mas[i + 1] = buffer;
                }
            }
            logStep(Arrays.toString(mas));
        }
        return mas;
    }
    public static void logStep(String n){
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String tt = df.format(new Date());
            fileWriter.write(tt + " " + n + "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}

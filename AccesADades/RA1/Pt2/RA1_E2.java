package com.mycompany.e2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author usuari-tarda
 */
public class RA1_E2 {

    public static void main(String[] args) {
        String input = "entrada.txt";
        String output = "sortida.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(input));
            BufferedWriter bw = new BufferedWriter(new FileWriter(output));
            PrintWriter pw = new PrintWriter(bw)
            )
        {

            String line = "";
            String lineReverse = "";
            while ((line=br.readLine())!=null){
                
            }
            
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " );
        } catch (SecurityException e) {
            System.out.println("Missing file access permissions.");
        } catch (IOException e) {
            System.out.println("A reading error has ocurred: " + e.getMessage());
        }
    }
}

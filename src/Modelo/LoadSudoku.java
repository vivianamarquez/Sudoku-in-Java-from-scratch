package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LoadSudoku {

    private int[][] sudokuRes;
    private int[][] sudoku;
    private ArrayList <String> sudokuResArray = new ArrayList<String>();
    private ArrayList <String> sudokuArray = new ArrayList<String>();
    private int n;
    private String level;

    public LoadSudoku(String level) {

        Random rand = new Random();
        this.n=rand.nextInt(10) + 1;
        this.level=level;
        sudoku();

    }

    public void sudoku() {

        try {
            String name= "Levels/"+level+"/"+n+".txt";
            
            File archive = new File(name);
            FileReader fr = new FileReader(archive);
            BufferedReader br = new BufferedReader(fr);

            sudokuRes = new int[9][9];
            sudoku = new int[9][9];

            String auxiliar = "";

            //Llena el sudoku resuelto
            for (int i = 0; i < 9; i++) {
                auxiliar = br.readLine();
                for (int j = 0; j < 9; j++) {
                    sudokuRes[i][j] = Integer.parseInt("" + auxiliar.charAt(j));
                    
                }
            }

            //Llena el sudoku para llenar
            for (int i = 0; i < 9; i++) {
                auxiliar = br.readLine();
                for (int j = 0; j < 9; j++) {
                    if (auxiliar.charAt(j) != '.') {
                        sudoku[i][j] = Integer.parseInt("" + auxiliar.charAt(j));
                        
                    } else {
                        sudoku[i][j] = 0;
                        
                    }
                }
            }
            
            fr.close();
            br.close();

        } catch (Exception e) {

            System.err.println("Error reading files.");

        }

    }

    public ArrayList<String> getSudokuArray() {
        System.out.println(this.level);
        printSudoku();
        return sudokuArray;
    }

    public ArrayList<String> getSudokuResArray() {
        printSudokuRes();
        return sudokuResArray;
    }
    
    public boolean chechArrays(ArrayList<String> incoming){
        return incoming.equals(sudokuArray);
    }
    
    public boolean check(){
        if(Arrays.equals(sudoku, sudokuRes)){
            return true;
        }else{
            return false;
        }
    }

    public void printSudokuRes() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudokuRes[i][j]);
                this.sudokuResArray.add(""+sudokuRes[i][j]);
            }
            System.out.println("");
        }

    }

    public void printSudoku() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    System.out.print(" ");
                  this.sudokuArray.add(".");
                } else {
                    System.out.print(sudoku[i][j]);
                    this.sudokuArray.add(""+sudoku[i][j]);
                }
            }
            System.out.println("");
        }

    }

}

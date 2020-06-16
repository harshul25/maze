package pacman;
/*
 * text maze reader to translate symbols and spaces into 2D array for BFS implementation
 */

//line count big = 37
import java.io.*;
import java.util.*;
public class MazeReader {
    public static int x_pos = 35; //starting x pos
    public static int y_pos = 1; //starting y pos for big maze.txt
    public static char[][] arr = new char[37][37];

    public static void main(String[] args) throws IOException {

        //read file into 2D array for position x,y
        File file = new File("src/pacman/bigMaze.txt");

        BufferedReader a = new BufferedReader(new FileReader(file));

        String l;
        int x_index = 0;
        int start_x = 0;
        int start_y = 0;

        while ((l = a.readLine()) != null) {
            //position for 2d array
            for (int i = 0; i < l.length(); i++) {

                if(l.charAt(i) == '%'){
                    arr[x_index][i] = '0';}
                else if(l.charAt(i) == 'P') {arr[x_index][i] = 'X';}
                else if(l.charAt(i) == '.'){ arr[x_index][i] = 'S'; start_x = x_index; start_y= i;}
                else {
                    arr[x_index][i] = '1';
                }
            }
            x_index ++;

        }
        for (int i = 0; i < arr.length; i++)
            System.out.println(Arrays.toString(arr[i]));

    }
    
    public MazeRunner(){
    // create a constructor for the specific object 
        
        //read file into 2D array for position x,y
        File file = new File("src/pacman/bigMaze.txt");

        BufferedReader a = new BufferedReader(new FileReader(file));

        String l;
        int x_index = 0;
        int start_x = 0;
        int start_y = 0;

        while ((l = a.readLine()) != null) {
            //position for 2d array
            for (int i = 0; i < l.length(); i++) {

                if(l.charAt(i) == '%'){
                    arr[x_index][i] = '0';}
                else if(l.charAt(i) == 'P') {arr[x_index][i] = 'X';}
                else if(l.charAt(i) == '.'){ arr[x_index][i] = 'S'; start_x = x_index; start_y= i;}
                else {
                    arr[x_index][i] = '1';
                }
            }
            x_index ++;

        }
        for (int i = 0; i < arr.length; i++)
            System.out.println(Arrays.toString(arr[i]));
    
    }

    public static char[][] getArr() {

        return this.arr;
    }
}


 


package pacman;
/*
 * testing
 */
import java.util.*;
import java.lang.*;

import pacman.MazeReader;
import pacman.Node;
public class Main {

        public static void main(String args[])
        {
            //char[][] a = MazeReader.arr;
            MazeReader b = new MazeReader();
            char[][] a= b.getArr();
            for (int i = 0; i < a.length; i++)
                System.out.println(Arrays.toString(a[i]));

            char[][] matrix = {
                    {'1', '0', '1', '1'},
                    {'1', '1', '1', '1'},
                    {'1', '1', '1', '1'},
                    {'1', '1', '1', 'X'}
            };

            boolean pathExists = pathExists(matrix);

            System.out.println(pathExists ? "YES" : "NO");
        }

        public static boolean pathExists(char[][] matrix) {
            //System.out.println(matrix.length);
            //how many rows it has
            int N = matrix.length;

            List<Node> queue = new ArrayList<Node>();
            queue.add(new Node(0, 0));
            boolean pathExists = false;

            while(!queue.isEmpty()) {
                Node current = queue.remove(0);
                if(matrix[current.x][current.y] == 'X') {
                    pathExists = true;
                    break;
                }

                matrix[current.x][current.y] = '0'; // mark as visited

                List<Node> neighbors = getNeighbors(matrix, current);
                queue.addAll(neighbors);
            }

            return pathExists;
        }

        public static List<Node> getNeighbors(char[][] matrix, Node node) {
            List<Node> neighbors = new ArrayList<Node>();

            if(isValidPoint(matrix, node.x - 1, node.y)) {
                neighbors.add(new Node(node.x - 1, node.y));
            }

            if(isValidPoint(matrix, node.x + 1, node.y)) {
                neighbors.add(new Node(node.x + 1, node.y));
            }

            if(isValidPoint(matrix, node.x, node.y - 1)) {
                neighbors.add(new Node(node.x, node.y - 1));
            }

            if(isValidPoint(matrix, node.x, node.y + 1)) {
                neighbors.add(new Node(node.x, node.y + 1));
            }

            return neighbors;
        }

        public static boolean isValidPoint(char[][] matrix, int x, int y) {
            return !(x < 0 || x >= matrix.length || y < 0 || y >= matrix.length) && (matrix[x][y] != '0');
        }

}

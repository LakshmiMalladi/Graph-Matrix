/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph1;

import java.util.Scanner;

/**
 *
 * @author KriLak
 */
public class Graph1 {

    /**
     * @param args the command line arguments
     */
    
    private final int numOfVer;
    public static int[][] arr;
 
    public Graph1(int v) 
    {
        numOfVer = v;
        arr = new int[numOfVer + 1][numOfVer + 1];
    }
 
    public void addEdge(int to, int from, int edge) 
    {
        try 
        {
            if(arr[to][from]!=edge)
            {
                arr[to][from] = edge;
                arr[from][to] = edge;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) 
        {
            e.printStackTrace();
            System.out.println("The vertices does not exists");
        }
    }
     
    public static void main(String[] args) {
        // TODO code application logic here
        
        int v, e, count = 1, to = 0, from = 0;
        Scanner sc = new Scanner(System.in);
        Graph1 graph;
        try 
        {
            System.out.println("Enter the number of vertices: ");
            v = sc.nextInt();
            System.out.println("Enter the number of edges: ");
            e = sc.nextInt();
            
            graph = new Graph1(v);
 
            System.out.println("Enter the edges: to then from : ");
            while (count <= e) 
            {
                to = sc.nextInt();
                from = sc.nextInt();
 
                graph.addEdge(to, from, 1);
                count++;
            }
 
            System.out.println("Adjacency matrix is : ");
            System.out.print("  ");
            for (int i = 0; i < v; i++)
                System.out.print(i + " ");
            System.out.println();
 
            for (int i = 0; i < v; i++) 
            {
                System.out.print(i + " ");
                for (int j = 0; j < v; j++) 
                    System.out.print(arr[i][j] + " ");
                System.out.println();
            }
        }
        catch (Exception E) 
        {
            E.printStackTrace();
            System.out.println("Either graph is wrong or addEdge() or getEdge()!!!");
        }
        sc.close();
    }
}

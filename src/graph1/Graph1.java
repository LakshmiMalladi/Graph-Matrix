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
 
    //ADD AN EDGE BETWEEN  TWO VERTICES
    public void addEdge(int to, int from, int edge) 
    {
        try 
        {
            if(arr[to][from]==0)
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
    
    //LOOKUP FOR THE NEIGHBORS FOR A VERTEX
     public int [] neighbors (int v) 
     {
        int count = 0;
        for (int i=0; i<arr[v].length; i++) {
           if (arr[v][i]>0) count++;
        }
        int[] neighbor= new int[count];
         count = 0;
        for (int i=0; i<arr[v].length; i++) {
            if (arr[v][i]>0) 
                neighbor[count++] = i;
        }
        return neighbor;
    }
     
    public static void main(String[] args) {
        // TODO code application logic here
        
        int v, e,w, count = 1, to = 0, from = 0;
        Scanner sc = new Scanner(System.in);
        Graph1 graph;
        try 
        {
            System.out.println("Enter the number of vertices: ");
            v = sc.nextInt();
            System.out.println("Enter the number of edges: ");
            e = sc.nextInt();
            
            graph = new Graph1(v);
 
            while (count <= e) 
            {
                System.out.println("Enter the edges: to then from : ");
                to = sc.nextInt();
                from = sc.nextInt();
                System.out.println("Enter the label for that edge: ");
                w = sc.nextInt();
 
                graph.addEdge(to, from, w);
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
            System.out.println("Enter the vertex to lookup for its neighbors: ");
            int vertex = sc.nextInt();
            int[] getNeighbor = graph.neighbors(vertex);
            System.out.println("Neighbors of " + vertex + " are: ");
            for(int i:getNeighbor)
                System.out.print(i+" ");
            System.out.println();
        }
        catch (Exception E) 
        {
            E.printStackTrace();
            System.out.println("Either graph is wrong or addEdge() or getEdge()or getNeighbor()!!!");
        }
    }
}

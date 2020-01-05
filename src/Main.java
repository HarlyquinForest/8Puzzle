import com.HarlyquinForest.puzzle.*;

import java.util.Scanner;

public class Main
{
    private  static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        String input ;
        System.out.printf("HELLO , LET'S SOLVE SOME PUZZlE\n1)Default Puzzle\n2)New Puzzle\n>");
        input= sc.nextLine();
        if(input.equals("1"))
        {
            int[] init = {1,2,3,7,4,8,0,6,5};
            int[] goal = {1,2,3,4,5,6,7,8,0};
            letsGo(init, goal);
        }
        else if(input.equals("2"))
        {
            int[] init = new int[9];
            int[] goal = {1,2,3,4,5,6,7,8,0};
            System.out.println("Enter Puzzle:");
            for(int i= 0 ; i < 9 ; i++)
                init[i] = sc.nextInt();
            sc.nextLine();
            letsGo(init , goal);
        }
        else
        {
            System.out.println("Sorry wrong answer \n\tExit...");
        }
    }
    private static void  letsGo(int[] inital , int[] goal)
    {
        String input ;
        Heuristic heuristic;
        PuzzleNode start ;
        System.out.printf("\tChoose algorithm\n\t1)BFS\n\t2)A*\n\t3)RBFS\n\t>");
        input = sc.nextLine();
        switch (input)
        {
            case "1":
                heuristic = new Heuristic(goal , -1);
                start = new PuzzleNode(inital , heuristic);
                BFS bfs = new BFS(start);
                System.out.println("\n---------- BFS ----------");
                bfs.solve().printState();
                break;
            case "2":
                System.out.printf("Choose Heuristic Method(Default 1)\n\t1)Manhattan\n\t2)Bad Placed\n\t>");
                input = sc.nextLine();
                heuristic = chooseHeuristic(input , goal);
                start = new PuzzleNode(inital , heuristic);
                start.printState();
                Astar astar = new Astar(start);
                System.out.println("\n---------- A-star ----------");
                astar.solve().printState();
                break;
            case "3":
                System.out.printf("Choose Heuristic Method(Default 1)\n\t1)Manhattan\n\t2)Bad Placed\n\t>");
                input = sc.nextLine();
                heuristic = chooseHeuristic(input , goal);
                start = new PuzzleNode(inital , heuristic);
                start.printState();
                RBFS rbfs = new RBFS(start);
                System.out.println("\n---------- RBFS ----------");
                rbfs.solve().printState();
                break;
        }
    }
    private static Heuristic chooseHeuristic(String input , int[] goal )
    {
        if(input.equals("1"))
        {
            return new Heuristic(goal , 1);
        }
        else if(input.equals("2"))
        {
            return  new Heuristic(goal , 0);
        }
        else
        {
            return  new Heuristic(goal , 1);
        }
    }
}

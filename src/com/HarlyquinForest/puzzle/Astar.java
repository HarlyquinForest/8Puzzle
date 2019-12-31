package com.HarlyquinForest.puzzle;

import java.util.ArrayList;
import java.util.Arrays;

public class Astar
{
    private PuzzleNode root;
    private SortedStack<PuzzleNode> stack ;
    private ArrayList<int[]> processed ;
    private int index;

    public Astar(PuzzleNode r)
    {
        root = r ;
        stack = new SortedStack<>();
        processed = new ArrayList<>();
        index = 0 ;
    }
    public PuzzleNode solve()
    {
        return search();
    }
    private PuzzleNode search()
    {
        PuzzleNode current ;
        stack.push(root);
        while (!stack.isEmpty())
        {
            current =(PuzzleNode) stack.pop();
            processed.add(current.getState());
            if(current.isGoal())
            {
                System.out.println("Solution found at index "+index);
                return current;
            }
            index ++;

            addChildren(current.generateChildren());

        }
        return null ;
    }
    private void addChildren(PuzzleNode[] children)
    {
        boolean unique = true;
        for(PuzzleNode node : children)
        {
            if(node == null)
                break;
            for(int[] a : processed)
            {
                if(Arrays.equals(a , node.getState()))
                {
                    unique = false;
                    break;
                }
                else
                    unique = true;
            }
            if(unique)
                stack.push(node);
        }
    }
}

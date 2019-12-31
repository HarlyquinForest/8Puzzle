package com.HarlyquinForest.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS
{
    private PuzzleNode root ;
    private Queue<PuzzleNode> queue ;
    private ArrayList<int[]> processed ;
    private int index ;

    public BFS(PuzzleNode r)
    {
        root = r ;
        queue = new LinkedList<>();
        processed = new ArrayList<>();
        index = 0 ;
    }
    public PuzzleNode solve()
    {
        return search();
    }
    private PuzzleNode search()
    {
        PuzzleNode current;
        queue.add(root);
        while (!queue.isEmpty())
        {
            current = queue.peek();
            processed.add(current.getState());
            queue.remove();
            if(current.isGoal())
            {
                System.out.println("Solution Found at index "+index);
                return  current;
            }
            index ++ ;
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
                queue.add(node);
        }
    }
}

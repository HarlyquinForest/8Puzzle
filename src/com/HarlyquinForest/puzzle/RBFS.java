package com.HarlyquinForest.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class RBFS
{
    private PuzzleNode root ;
    private Stack<SortedStack> stack ;
    private PuzzleNode[] result ;
    private int index ;

    public RBFS(PuzzleNode r)
    {
        root = r;
        stack = new Stack<>();
        index = 0 ;
    }

    public PuzzleNode solve()
    {
        PuzzleNode[] solution = search(root , Integer.MAX_VALUE) ;
        return solution[0];
    }
    private PuzzleNode[] search(PuzzleNode node , int f_limit)
    {
        SortedStack successors = new SortedStack();
        if(node.isGoal())
        {
            System.out.println("Solution found at index "+index);
            return new PuzzleNode[]{node , null};
        }
        index++;
        for(PuzzleNode child : node.generateChildren())
        {
            if(child == null)
                break;
            if(!Arrays.equals(child.getState() , root.getState()))
                successors.push(child);
        }
        while(!successors.isEmpty())
        {
            PuzzleNode best =(PuzzleNode) successors.pop();
            if(best.getFn() > f_limit)
                return new PuzzleNode[]{null , best };
            int alternative = ((PuzzleNode)successors.peek()).getFn();
            stack.push(successors);
            result = search(best , Math.min(alternative , f_limit));
            successors = stack.pop();
            if(result[1] != null)
            {
                best.setFn(result[1].getFn());
                successors.push(best);
            }
            if(result[0] != null)
                break;
        }
        return result;
    }

}

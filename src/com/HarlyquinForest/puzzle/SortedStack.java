package com.HarlyquinForest.puzzle;
import com.HarlyquinForest.puzzle.PuzzleNode;

import java.nio.channels.Pipe;
import java.util.HashMap;
import java.util.Stack;

public class SortedStack<K> extends Stack
{
    private Stack<PuzzleNode> Past = new Stack<>();

    @Override
    public Object push(Object item) {
        K key = (K) item ; // get key
        PuzzleNode node = (PuzzleNode) key;
        int F_node = node.getFn(); // we have h() now
        while(!this.isEmpty())
        {
            PuzzleNode head = (PuzzleNode) this.peek();
            int F_stack = head.getFn();
            if(F_stack > F_node)
                break;
            else
                Past.push((PuzzleNode) this.pop());
        }
        super.push(item);
        while(!Past.isEmpty())
        {
            super.push(Past.pop());
        }
        return 1;
    }

}

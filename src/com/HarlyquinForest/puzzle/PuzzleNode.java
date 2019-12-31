package com.HarlyquinForest.puzzle;

import java.util.ArrayList;

public class PuzzleNode
{
    private int fn , hn , dep ;
    private Position zeroIndex ;
    private String path ;
    private Heuristic heuristic ;
    private int[] state ;

    public PuzzleNode(int[] s , Heuristic h )
    {
        this(s, 0 , "0-",h);
    }
    public PuzzleNode(int[] s , int d , String p , Heuristic h )
    {
        state = s.clone();
        heuristic = h ;
        path = p ;
        dep = d;
        if(heuristic.mode != -1)
        {
            hn = heuristic.getHeuristic(state);
            fn = hn + dep ;
        }
        zeroIndex = zeroPosition(state);
    }
    public  void printState()
    {
        System.out.printf("\n\t%d %d %d\n\t%d %d %d\n\t%d %d %d\n",state[0],state[1],state[2],state[3],state[4],state[5],state[6],state[7],state[8]);
        System.out.printf("Fn:%d Hn:%d Dep:%d\n",fn,hn,dep);
        System.out.println("Path:"+path);
    }

    private Position zeroPosition(int[] arr) {
        Position p = Position.TOP_LEFT;
        for (int i = 0; i < 9; i++)
            if (arr[i] == 0)
                return p.setPosition(i);
        return p;
    }

    boolean isGoal()
    {
        int[] g = heuristic.getGOAL();
        return (state[0] == g[0] &&state[1] == g[1] &&state[2] == g[2] &&state[3] == g[3] &&state[4] == g[4] &&state[5] == g[5] &&state[6] == g[6] &&state[7] == g[7] &&state[8] == g[8] );
    }

    public void setFn(int fn) {
        this.fn = fn;
        hn = fn - dep ;
    }

    int getFn() {
        return fn;
    }

    int getDep() {
        return dep;
    }

    int[] getState() {
        return state;
    }

    String getPath() {
        return path;
    }

    PuzzleNode[] generateChildren()
    {
        return Action.generateChildren(this , this.zeroIndex , heuristic);
    }
}

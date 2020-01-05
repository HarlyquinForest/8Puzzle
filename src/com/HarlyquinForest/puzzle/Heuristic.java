package com.HarlyquinForest.puzzle;

public class Heuristic
{
    private int[] GOAL = {1,2,3,4,5,6,7,8,0};
    int mode = - 1; // 1 = Manhattan 0= BadPlaced -1 = no heuristic

    public Heuristic(int m )
    {
        this(new int[]{1,2,3,4,5,6,7,8,0} , m);
    }

    public Heuristic(int[] g , int m)
    {
        GOAL = g ;
        if(m == 0 || m == 1 || m == -1)
            mode = m ;
    }

    int getHeuristic(int[] a )
    {
        if(mode == -1)
            return  0 ;
        else if(mode == 0)
            return badPlacecd(a);
        else if(mode == 1)
            return Manhattan(a);
        else
            return 0 ;
    }

    private int badPlacecd(int[] a)
    {
        int h = 0 ;
        int i = 0 ;
        for(int c : GOAL)
        {
            if(c != a[i])
                h++;
            i++;
        }
        return h;
    }

    private int Manhattan(int[] a)
    {
	// I will change this method on another branch , to see if it's working or not
        //int[][] temp = {{a[0],a[1],a[2]},{a[3],a[4],a[5]},{a[6],a[7],a[8]}};
        int sum = 0 ;
        for(int i = 0 ; i  < 9; i++)
        {
            int d = Math.abs(index(a,i) - index(GOAL , i ));
            sum += Math.abs((d / 3)+(d%3));
        }
        return sum ;
    }

    private int index(int[] a , int n)
    {
        int i;
        for(i = 0 ; i < a.length ; i++ )
            if(a[i] == n)
                return i ;
        return i ;
    }

    public int[] getGOAL() {
        return GOAL;
    }
}

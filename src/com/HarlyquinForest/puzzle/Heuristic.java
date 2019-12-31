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
        int move = 0 ;
        int moves = 0 ;
        for(int i = 0 ; i <  a.length ; i++)
        {
            if(a[i]-1 != i && a[i] != 0 )
            {
                switch(a[i])
                {
                    case 1 :
                        if(i == 1 || i == 3)
                            move = 1;
                        else if(i == 2 || i == 4 || i == 6 )
                            move = 2 ;
                        else if (i == 5 || i == 7 )
                            move = 3;
                        else if (i == 8)
                            move = 4;
                        break;
                    case 2 :
                        if(i == 0 || i == 2 || i == 4)
                            move = 1;
                        else if(i == 3 || i == 5 || i == 7)
                            move = 2 ;
                        else if ( i == 6 || i == 8 )
                            move = 3;
                        break;
                    case 3 :
                        if(i == 1 || i == 5)
                            move = 1;
                        else if( i== 0 || i == 4 || i == 8)
                            move = 2 ;
                        else if ( i == 7 || i == 3   )
                            move = 3;
                        else if ( i == 6 )
                            move = 4;
                        break;
                    case 4 :
                        if(i == 0 || i == 4 || i == 6)
                            move = 1;
                        else if( i == 1 || i == 5 || i == 7)
                            move = 2 ;
                        else if ( i == 8 || i == 2 )
                            move = 3;
                        break;
                    case 5 :
                        if( i == 1 || i == 7 || i == 5 || i == 3)
                            move = 1;
                        else if( i == 0 || i == 2 || i == 6 || i == 8)
                            move = 2 ;
                        break;
                    case 6 :
                        if( i == 2 || i == 8 || i == 4 )
                            move = 1;
                        else if( i == 1 || i == 7 || i == 3)
                            move = 2 ;
                        else if( i == 0 || i == 6 )
                            move = 3 ;
                        break;
                    case 7 :
                        if( i == 3 || i == 7)
                            move = 1;
                        else if( i == 0 || i == 4 || i == 8)
                            move = 2 ;
                        else if( i == 1 || i == 5  )
                            move = 3 ;
                        else if (i == 2)
                            move = 4;
                        break;
                    case 8 :
                        if( i == 4 || i == 8 || i == 6 )
                            move = 1;
                        else if( i == 1 || i == 3 || i == 5 )
                            move = 2 ;
                        else if( i == 0 || i == 2  )
                            move = 3 ;
                        break;


                }
                moves +=move;
            }
            else if(a[i] == 0 && i != 8)
            {
                if(i == 5 || i == 7 )
                    move = 1 ;
                else if(i == 6 || i == 4 || i == 2)
                    move = 2;
                else if (i == 3 || i == 1 )
                    move = 3;
                else if (i == 0 )
                    move = 4 ;
                moves +=move;
            }
        }
        return moves ;
    }

    public int[] getGOAL() {
        return GOAL;
    }
}

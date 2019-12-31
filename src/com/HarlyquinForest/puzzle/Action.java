package com.HarlyquinForest.puzzle;

public class Action
{
    private static Position[] validMoves(Position zero)
    {
        switch (zero) {
            case TOP_LEFT:
                return new Position[]{Position.TOP_CENTER, Position.MIDDLE_LEFT};
            case TOP_CENTER:
                return new Position[]{Position.TOP_RIGHT, Position.TOP_LEFT, Position.MIDDLE_CENTER};
            case TOP_RIGHT:
                return new Position[]{Position.TOP_CENTER, Position.MIDDLE_RIGHT};
            case MIDDLE_LEFT:
                return new Position[]{Position.TOP_LEFT, Position.MIDDLE_CENTER, Position.BOTTOM_LEFT};
            case MIDDLE_CENTER:
                return new Position[]{Position.TOP_CENTER, Position.MIDDLE_RIGHT, Position.MIDDLE_LEFT, Position.BOTTOM_CENTER};
            case MIDDLE_RIGHT:
                return new Position[]{Position.TOP_RIGHT, Position.MIDDLE_CENTER, Position.BOTTOM_RIGHT};
            case BOTTOM_LEFT:
                return new Position[]{Position.MIDDLE_LEFT, Position.BOTTOM_CENTER};
            case BOTTOM_CENTER:
                return new Position[]{Position.MIDDLE_CENTER, Position.BOTTOM_RIGHT, Position.BOTTOM_LEFT};
            case BOTTOM_RIGHT:
                return new Position[]{Position.MIDDLE_RIGHT, Position.BOTTOM_CENTER};
        }
        return new Position[]{Position.BOTTOM_CENTER};
    }

    public static PuzzleNode[] generateChildren(PuzzleNode parent  , Position zero  , Heuristic h )
    {
        return genCildren(parent , zero  , h , validMoves(zero));
    }
    private static PuzzleNode[] genCildren(PuzzleNode parent , Position zero , Heuristic heuristic , Position... num  )
    {
        int z = zero.getIndex();
        PuzzleNode[] children  = new PuzzleNode[4];
        String path ;
        int counter = 0 ;
        int[] temp ;
        for(Position i : num)
        {
            temp = parent.getState().clone();
            int n = i.getIndex();
            temp[z] = temp[z] ^ temp[n] ^ (temp[n] = temp[z]);
            path= parent.getPath();
            if(z + 1 == n )
                path+="R-";
            else if(z -1 == n )
                path+="L-";
            else if(z + 3 == n)
                path+="D-";
            else if(z - 3 == n)
                path+="U-";
            children[counter] = new PuzzleNode(temp , parent.getDep()+1 , path ,heuristic);
            counter ++ ;
        }
        return children;
    }
}

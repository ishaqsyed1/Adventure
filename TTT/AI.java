package TTT;

import java.util.ArrayList;
import java.util.Random;

public class AI implements TTT.iPlayer {
    @Override
    public Coordinates getNextMove(Board b) {
        ArrayList<Coordinates> possibleMoves = new ArrayList<>();
        for(int i=0;i<b.dimension;i++){
            for(int j=0;j<b.dimension;j++){
                if(b.board[i][j]==' '){
                    possibleMoves.add(new Coordinates(i,j));
                }
            }
        }
        Random r = new Random();
        return possibleMoves.get(r.nextInt(possibleMoves.size()));

    }
}

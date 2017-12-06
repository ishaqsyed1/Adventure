package TTT;

import java.util.Scanner;
public class TTTPlayer implements TTT.iPlayer {

    @Override
    public Coordinates getNextMove(Board b) {

        System.out.println("Please input your move:\n");
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int row,coll;
        if(Character.isAlphabetic(s.charAt(0))){
            char r = s.charAt(0),c=s.charAt(1);
            if(Character.isLowerCase(r)){
                r=Character.toUpperCase(r);
            }
            row = r -'A';
            coll = c-'1';
        }
        else{
            char r = s.charAt(1),c=s.charAt(0);
            if(Character.isLowerCase(r)){
                r=Character.toUpperCase(r);
            }
            row = r -'A';
            coll = c-'1';
        }

        if((row<b.dimension&&coll<b.dimension)&&b.board[row][coll]==' '){
            return new Coordinates(row,coll);
        }else{
            System.out.println("Invalid Cordinates! Try Again!");
            return getNextMove(b);
        }

    }
}

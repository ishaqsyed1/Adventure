package TTT;

public class TTTGame{
	public TTTGame(int dimension, Boolean player1bot,Boolean player2bot){
		board=new Board(dimension);
		if(player1bot){
			player1=new AI();
		}else{
			player1=new TTTPlayer();
		}
		if(player2bot){
			player2=new AI();
		}else{
			player2=new TTTPlayer();
		}
	}
	Board board;
	TTT.iPlayer player1,player2;
	boolean p1turn = true;
	public int Start(){
		TTT.iPlayer winner = null;
		boolean done = false;
		System.out.println(board.toString());
		while(!done){
			//Get p1 move
			Coordinates c = player1.getNextMove(board);
			board.board[c.getX()][c.getY()] = 'X';
			//check if win
			System.out.println("Heh your move:\n"+board.toString());
			if(board.checkWin()) {
				System.out.println("You defeated the undefeated!!!");
				done = true;
				winner=player1;
				break;
			}else if(board.isFull()){
				System.out.println("No winner..");
				done=true;
				break;
			}
			//Get p2 move
			c = player2.getNextMove(board);
			if(board.board[c.getX()][c.getY()]==' ') {
				board.board[c.getX()][c.getY()] = 'O';
			}
			System.out.println(((player2 instanceof AI)?"Tim's ":"Player 2's " )+ "Move:\n"+ board.toString());
			//check if win
			if(board.checkWin()) {
				System.out.println("*sigh* Kids these days will never learn.");
				winner=player2;
				done = true;
				break;
			}else if(board.isFull()){
				System.out.println("Got lucky this time!");
				done=true;
				break;
			}


		}
		System.out.println("Final TTT.Board: \n"+board.toString());
		if(winner==player1){
			return 1;
		}else if(winner==player2){
			return -1;
		}else{
			return 0;
		}

	}

}


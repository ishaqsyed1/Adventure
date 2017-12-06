package TTT;

import java.util.Arrays;

public class Board{
	char [][] board;
	int dimension;
	public Board (int dimension){
		this.dimension = dimension;
		if (dimension == 3 || dimension == 5){
			board = new char[dimension][dimension];
		}
		for (int i =0; i < dimension; i++){
			for (int j=0; j<dimension; j++){
				board[i][j]=' ';
			}
		}
	}
	public boolean checkWin(){
		for (int i =0; i < dimension; i++){
			char checker = board[i][0];
			if(checker==' '){
				continue;
			}
			int occurence=0;
			for (int j=0; j<dimension; j++){
				if(board[i][j]==checker){
					occurence++;
				}
			}
			if(occurence==dimension){
				return true;
			}

		}
		for (int i =0; i < dimension; i++){
			char checker = board[0][i];
			if(checker==' '){
				continue;
			}
			int occurence=0;
			for (int j=0; j<dimension; j++){
				if(board[j][i]==checker){
					occurence++;
				}
			}
			if(occurence==dimension){
				return true;
			}
		}
		char checker = board[0][0];
		int occurence=0;
		for (int i =0; i < dimension; i++) {
			if(checker==' '){
				continue;
			}
			if(checker==board[i][i]){
				occurence++;
			}

		}
		if(occurence==dimension){
			return true;
		}
		checker = board[0][dimension-1];
		occurence=0;
		for (int i =dimension-1; i >=0; i--) {
			if(checker==' '){
				continue;
			}
			if(checker==board[i][(dimension-1)-i]){
					occurence++;
			}

		}
		if(occurence==dimension){
			return true;
		}
		return false;

	}
	public boolean isFull(){
		for (int i =0; i < dimension; i++){
			for (int j=0; j<dimension; j++){
				if(board[i][j]==' '){
					return false;
				}
			}
		}
		return true;
	}
	@Override
	public String toString(){
		String ret = " ";
		for(int j=0;j<dimension;j++){
			ret+=j+1;
			if(j!=dimension-1){
				ret+="|";
			}
		}
		ret+="\n";
		for (int i =0; i < dimension; i++){

			ret+=(char) ('A'+i);
			for (int j=0; j<dimension; j++){
				ret+=board[i][j];
				if(j!=dimension-1) {
					ret += "|";
				}
			}
			ret+="\n ";
			if(i!=dimension-1) {
				for (int j = 0; j < dimension + (dimension - 1); j++) {
					ret += "_";
				}
				ret+="\n";
			}


		}
		return ret;
	}


}



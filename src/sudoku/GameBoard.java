/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;


public class GameBoard {

	/* Array that will contain the complete solution to the board */
	private int[][] solution;
	/* Array that will contain ONLY the numbers initially drawn on the board and that the player can't change */
	private int[][] initial;
	/* Array that will contain player's numbers */
	private int[][] player;
        DBHelper db = new DBHelper();
        
        int lvl = db.getPlayerLVL();
        
        
	/***
	 * @see Arrays
	 */
	public GameBoard() {
            
		solution = new int[][]
		{
			{66,9,7,8,1,5,69,4,3,2,6,65,68,70,67,0},
			{0,69,4,1,3,7,68,6,8,67,9,70,65,66,5,2},
			{65,68,70,6,67,2,8,66,0,5,1,4,3,7,9,69},
			{3,67,5,2,65,0,9,70,68,7,69,66,1,4,6,8},
			{67,4,6,65,66,8,2,1,5,69,0,7,9,3,70,68},
			{8,2,69,3,7,67,0,65,6,9,70,68,66,5,1,4},
			{9,70,0,7,4,69,5,68,67,3,66,1,2,65,8,6},
			{5,1,66,68,6,70,3,9,2,4,65,8,67,69,0,7},
			{69,8,9,70,2,1,4,7,66,65,67,3,6,0,68,5},
                        {4,7,68,66,5,3,6,67,1,8,2,0,70,9,69,65},
                        {2,3,65,0,9,68,70,69,4,6,7,5,8,1,66,67},
                        {6,5,1,67,8,65,66,0,9,70,68,69,7,2,4,3},
                        {7,65,8,9,68,66,1,2,69,0,5,67,4,6,3,70},
                        {68,66,67,69,70,4,7,5,65,1,3,6,0,8,2,9},
                        {1,0,2,4,69,6,65,3,70,68,8,9,5,67,7,66},
                        {70,6,3,5,0,9,67,8,7,66,4,2,69,68,65,1}
		};
            if(lvl==1){        
		// 0's will be rendered as empty space and will be editable by player
		initial = new int[][]
		{
			{66,9,12,8,1,5,12,4,12,2,6,65,68,70,12,0},
			{0,69,12,1,3,12,68,6,8,67,12,70,65,12,5,2},
			{65,12,70,6,67,2,8,12,0,5,1,12,3,7,9,12},
			{3,67,12,2,65,0,12,70,68,7,12,66,1,4,12,8},
			{12,12,6,65,66,12,2,1,5,12,0,7,9,12,70,68},
			{8,2,12,3,7,67,12,65,6,9,70,12,66,5,1,12},
			{9,12,0,7,4,69,12,68,67,3,12,1,2,12,8,6},
			{5,1,12,68,6,12,3,9,2,12,65,8,67,12,0,7},
			{12,12,9,70,12,1,4,7,12,65,12,3,6,12,68,5},
                        {4,12,68,12,5,3,12,67,1,8,2,0,12,9,69,12},
                        {2,12,65,0,12,68,12,69,4,12,7,5,12,1,12,67},
                        {6,5,12,67,8,65,12,0,9,70,12,69,12,2,4,3},
                        {7,65,12,9,68,66,12,2,69,12,5,67,4,12,3,70},
                        {68,66,12,69,70,12,7,5,65,12,3,6,0,12,2,9},
                        {1,0,12,4,69,12,65,3,12,68,12,9,12,67,7,66},
                        {12,6,3,12,0,9,67,8,12,66,4,12,69,68,12,1}

		};
            }else if(lvl==2){
		initial = new int[][]
		{
			{12,9,12,8,2,5,12,4,2,2,12,65,12,70,12,0},
			{0,12,4,12,3,12,68,12,8,12,9,70,12,66,12,12},
			{65,12,12,12,67,12,8,12,0,12,1,12,3,7,9,69},
			{12,67,5,12,65,12,9,12,12,7,12,66,12,4,2,8},
			{67,2,12,65,12,8,2,1,12,69,0,12,12,12,70,12},
			{8,2,69,12,12,67,12,65,12,9,12,68,12,12,1,12},
			{12,12,12,4,69,12,68,12,3,66,2,12,65,8,12,12},
			{5,1,12,12,6,70,12,12,12,4,65,8,12,12,0,12},
			{12,8,9,12,2,12,12,7,66,12,67,12,6,12,12,5},
                        {4,12,12,66,12,12,6,67,1,12,2,12,70,12,69,12},
                        {2,3,65,12,12,68,12,12,12,6,12,5,12,1,12,67},
                        {6,12,12,67,12,65,12,0,9,12,68,12,7,12,12,3},
                        {7,12,12,9,12,66,12,12,69,12,12,67,12,6,12,70},
                        {12,12,67,12,70,4,12,5,12,12,3,6,12,8,12,9},
                        {12,0,2,12,12,6,65,12,70,12,8,9,12,67,12,12},
                        {70,6,3,12,12,9,12,8,12,12,12,12,69,12,65,1}

		};
            }else if(lvl==3){
		initial = new int[][]
		{
			{12,9,12,2,12,12,69,12,3,12,12,65,12,70,12,0},
			{12,12,12,1,12,12,12,6,12,12,9,12,65,12,12,2},
			{65,12,12,12,12,2,12,66,12,12,12,4,12,12,2,69},
			{12,67,12,12,12,0,12,12,12,7,12,66,12,12,12,8},
			{12,4,6,65,12,12,12,12,5,12,12,12,9,12,70,12},
			{8,12,12,3,12,12,0,12,6,12,12,68,12,12,12,4},
			{12,12,0,12,4,12,12,68,12,12,66,12,12,65,12,12},
			{12,12,12,68,12,12,12,12,12,4,12,12,67,12,12,7},
			{12,8,12,12,12,12,4,12,66,12,12,3,12,12,12,5},
                        {4,12,68,12,12,3,12,12,12,8,12,12,12,12,69,12},
                        {12,12,12,0,12,68,12,69,12,6,12,5,12,12,66,12},
                        {6,12,1,12,8,12,12,0,12,2,68,12,12,2,12,12},
                        {7,12,12,9,12,66,12,12,69,12,5,12,4,12,12,70},
                        {68,12,12,12,70,12,12,12,12,1,12,12,0,12,12,9},
                        {12,12,2,12,69,12,65,12,12,12,8,12,5,12,7,12},
                        {12,12,12,0,2,12,8,12,12,4,12,12,68,12,12,12}

		};
            }

		// player's array is initialized as a 9x9 full of zeroes
		player = new int[16][16];
                for(int i=0;i<16;i++){
                    for(int k=0;k<16;k++){
                        player[i][k]=12;
                    }
                }
	}

	/***
	 *
	 * @return the solution array
	 */
	public int[][] getSolution() {
		return solution;
	}

	/***
	 *
	 * @return the initial filled-in numbers array
	 */
	public int[][] getInitial() {
		return initial;
	}

	/***
	 *
	 * @return the player array
	 */
	public int[][] getPlayer() {
		return player;
	}

	/***
	 *
	 * @param val the integer to insert in the player array
	 * @param row location in array x
	 * @param col location in array y
	 */
	public void modifyPlayer(int val, int row, int col) {
		// check if the initial array has a zero (treated as empty square)
		// in the position we want to put in a number in the player array
		// this way we avoid intersections between the two
		if (initial[row][col] == 12) {

			if((val >=0 && val <= 9) || val=='A' || val=='B' || val=='C' || val=='D' || val=='E' || val=='F' ) 
                            player[row][col] = val;
			else 
                            System.out.println("Value passed to player falls out of range");
		}

	}

	/***
	 *
	 * @return true if player solution matches original solution, false if not
	 */
	public boolean checkForSuccess() {
		for(int row = 0; row<16; row++) {
			for(int col = 0; col<16; col++) {

				// if the value in the initial array is zero, which means
				// the player has to input a value in the square
				if(initial[row][col] == 12) {

					// check if the player value corresponds to the solution value
					// and if it doesn't:
					if(player[row][col] != solution[row][col]) {

						// return false, which will tell us there has been a mistake
						// and that is enough for us to know the player hasn't solved
						// the puzzle
						return false;
					}
				}

			}
		}
		// otherwise, if everything is correct, return true
		return true;
	}
	
	/***
	 *
	 * @return true if player solution is a correct one according to sudoku rules
	 */
	public boolean checkForSuccessGeneral() {
		// combine the initial and player arrays
		// instantiate a 9x9 array filled with 0's;
		int[][] combined = new int[16][16];
		// fill it up with the combination of initial number and player answers
		for(int row = 0; row < 16; row++) {
			for(int col = 0; col <16; col++) {
				// if there's a valid number in the initial array
				if(initial[row][col]!=12) {
					// add it at the same position in the combined one
					combined[row][col] = initial[row][col];
					// if there isn't
				} else {
					// add from the same position in the player array
					combined[row][col] = player[row][col];
				}
			}
		}
		// check if the sum of the numbers in each row is 
		// equal to 45 (the sum of numbers from 1 to 9)
		for(int row = 0; row<16; row++) {
			//for that row, create a sum variable
			int sum = 0;
			// add all the numbers from a row
			for(int col = 0; col<16; col++) {
				sum = sum + combined[row][col];
			}
			// if the sum isn't 45, then the row is invalid, invalidating the whole solution
			if(sum!=450) {
				return false;
			}
		}
		
		// check if the sum of the numbers in each column is
		// equal to 45 (the sum of numbers from 1 to 9)
		for(int col = 0; col<16; col++) { // note that the for loops are switched around
			//for that column, create a sum variable
			int sum = 0;
			// add all the numbers from a column
			for(int row = 0; row<16; row++) {
				sum = sum + combined[row][col];
			}
			// if the sum isn't 45, then the column is invalid, invalidating the whole solution
			if(sum!=450) {
				return false;
			}
		}
		
		// check if the sum of the numbers in each 3x3 unique square
		// on the 9x9 board sums to 45 (the sum of num)
		// we are going to create an offset of 3 squares for each check
		
		// increment the row offset with 3 each time
		for (int row_offset = 0; row_offset < 16; row_offset+=4) { 
			// increment the col offset with 3 each time
			for(int col_offset = 0; col_offset <16; col_offset+=4) { 
				// for each 3x3 cluster, create a sum variable
				int sum = 0;
				// add all numbers from a cluster of 3x3
				for (int row = 0; row < 4; row++) {
					
					for (int col = 0; col < 4; col++) {
						sum = sum + combined[row + row_offset][col + col_offset];
					}
				}
				// if the sum isn't 45, then the 3x3 cluster is invalid,
				// invalidating the whole solution
				if(sum!=450) {
					return false;
				}
			}
		}
		// if none of the checks have triggered a return false statement,
		// fly the all-clear and return true
		return true;
	}
}


public class Board
{
	protected int[][] board =
	{{8, 0, 0, 0, 0, 0, 0, 0, 0},
	 {0, 0, 3, 6, 0, 0, 0, 0, 0},
	 {0, 7, 0, 0, 9, 0, 2, 0, 0},
	 {0, 5, 0, 0, 0, 7, 0, 0, 0},
	 {0, 0, 0, 0, 4, 5, 7, 0, 0},
	 {0, 0, 0, 1, 0, 0, 0, 3, 0},
	 {0, 0, 1, 0, 0, 0, 0, 6, 8},
	 {0, 0, 8, 5, 0, 0, 0, 1, 0},
	 {0, 9, 0, 0, 0, 0, 4, 0, 0}};

	private boolean rowConstraint(int[][]board, int row) {
    boolean[]constraint = new boolean[9];
    return IntStream.range(1, 9)
      .allMatch(column -> checkConstraint(board, row, constraint, column));
}

    private boolean columnConstraint(int[][]board, int column) {
    boolean[]constraint = new boolean[9];
    return IntStream.range(1, 9)
      .allMatch(row -> checkConstraint(board, row, constraint, column));
}

	private boolean subsectionConstraint(int[][]board, int row, int column)
	{
		boolean[]constraint = new boolean[9];
		int subsectionRowStart = (row/9);
		int subsectionRowEnd = subsectionRowStart + 9;

		int subsectionColumnStart = (column/9);
    	int subsectionColumnEnd = subsectionColumnStart + 9;

    	for (int r = subsectionRowStart; r < subsectionRowEnd; r++)
    	{
    		for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++)
    		{
    			if (!checkConstraint(board, r, constraint, c))
    			{
    				return false;
    			}
        	}
    	}
   		return true;
	}

	boolean checkConstraint(
  int[][]board,
  int row,
  boolean[]constraint,
  int column) {
    if (board[row][column]!= 0) {
        if (!constraint[board[row][column]- 1]) {
            constraint[board[row][column]- 1]= true;
        } else {
            return false;
        }
    }
    return true;
}

	private boolean isValid(int[][] board, int row, int column)
	{
		return true;/*(rowConstraint(board, row) && columnConstraint(board, column) && subsectionConstraint(board, row, column));*/
	}

	private boolean solve(int[][]board)
	{
		for (int row = 0; row < 9; row++)
	 	{
	 		for (int column = 0; column < 9; column++)
	 		{
	 			if (board[row][column]== 0)
	 			{
	 				for (int k = 1; k <= 9; k++)
	 				{
	 					board[row][column]= k;
                    	if (isValid(board, row, column) && solve(board))
                    	{
                    		return true;
                    	}
                    	board[row][column]= 0;
                	}
                	return false;
            	}
        	}
    	}
    	return true;
    }

}

package sudoku.solver;

public class SudokuSolverMain {

    private static int[][] sudokuBoard;

    // To check the number is present in the row or not
    private boolean isValidInRow(int number, int row){

        for(int col=0;col<9;col++){

            if(sudokuBoard[row][col] == number){

                return true;
            }
        }

        return false;
    }

    // To check the number is present in the column or not
    private boolean isValidInCol(int number, int col){

        for(int row=0;row<9;row++){

            if(sudokuBoard[row][col] == number){

                return true;

            }

        }
        return false;
    }

    // To check the number is present in 3*3 box
    private boolean isValidInBox(int row, int col, int number){

        int boxRow= row - row % 3;
        int boxCol= col - col % 3;

        for(int localBoxRow = boxRow; localBoxRow < boxRow + 3; localBoxRow++){

            for(int localBoxCol = boxCol; localBoxCol < boxCol + 3; localBoxCol++){

                if(sudokuBoard[localBoxRow][localBoxCol] == number){

                    return true;

                }
            }
        }
        return false;
    }

    // If all the validation pass then it is valid place to place the number
    private boolean isValidPlace(int row, int col, int number){

        if(!isValidInRow(number,row) && !isValidInCol(number, col) && !isValidInBox(row, col, number)){

            return true;
        }
        else{
            return false;
        }

    }

    private boolean sudokuSolver(){

        for(int row = 0; row < sudokuBoard.length; row++){

            for(int col = 0; col < sudokuBoard[0].length; col++){

                if(sudokuBoard[row][col]==0){

                    // To check the number possibilities from 1 to 9
                    for(int number=1; number <= 9; number++){

                        if(isValidPlace(row, col, number)){

                            sudokuBoard[row][col] = number;

                            if(sudokuSolver()){

                                return true;

                            }
                            else {
                                sudokuBoard[row][col] = 0;
                            }

                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    private void printSudokuBoard(){

        for(int row = 0; row < sudokuBoard[0].length; row++){

            for(int col = 0; col < sudokuBoard.length; col++) {

                System.out.print(sudokuBoard[row][col]+ " ");

            }

            System.out.println();
        }

    }


    public static void main(String[] args){

        sudokuBoard= new int[][]{
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},

                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},

                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        SudokuSolverMain solve =new SudokuSolverMain();

        if(solve.sudokuSolver()) {
            System.out.println("Solution: ");
            solve.printSudokuBoard();
        }
        else {
            System.out.println("No solution");
        }

    }

}

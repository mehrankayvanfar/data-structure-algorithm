package ir.sk.algorithm.others;

import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.BacktrackingDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
 * <p>
 * The worst case “brute force” solution for the N-queens puzzle has an O(n^n) time complexity.
 * This means it will look through every position on an NxN board, N times, for N queens.
 * It is by far the slowest and most impractical method.
 * <p>
 * The idea is to place queens one by one in different columns, starting from the leftmost column.
 * When we place a queen in a column, we check for clashes with already placed queens.
 * In the current column, if we find a row for which there is no clash, we mark this row and column as part of the solution.
 * If we do not find such a row due to clashes then we backtrack and return false.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/14/2021.
 */
public class NQueenProblem {

    /**
     * A utility function to print solution
     *
     * @param board
     */
    private void printSolution(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]).replaceAll(",", ""));
        }
        System.out.println();
    }

    public void findAllNQueen(int n) {
        // `mat[][]` keeps track of the position of queens in the current configuration
        char[][] board = new char[n][n];

        // '.' Means empty, and 'Q' means queen, initializing the empty board.
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');

        findAllNQueen(board, 0);
    }

    @BacktrackingDFS
    @TimeComplexity("O(2^n)")
    public void findAllNQueen(char board[][], int row) {
        // trigger the End Condition (the gaul) if `N` queens are placed successfully, print the solution
        if (row == board.length) {
            printSolution(board);
            return;
        }

        // place queen at every square in the current row `r` and recur for each valid movement
        for (int i = 0; i < board.length; i++) {
            // exclude illegal selections (constraints)
            // if no two queens threaten each other
            if (isValid(board, row, i)) {
                // select (choice) - place queen on the current square
                board[row][i] = 'Q';

                // enter next row decision
                findAllNQueen(board, row + 1);

                // deselect - backtrack and remove the queen from the current square
                board[row][i] = '.';
            }
        }
    }


    // Function to check if two queens threaten each other or not
    private boolean isValid(char board[][], int row, int col) {
        // return false if two queens share the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // return false if two queens share the same `` diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // return false if two queens share the same `/` diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }


}

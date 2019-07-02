package com.practice;

import java.util.Scanner;

public class CheckSudokuSolution {

	public static void main(String[] args) {
		//Read a Sudoku solution
		int [][] grid = readSolution();
		
		System.out.println(isValid(grid) ? "Valid solution" : "Invalid solution");
	}
	/**
	 * 
	 * @return grid with the solution
	 */
	private static int[][] readSolution() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a sudoku puzzle solution: ");
		int [][] grid = new int[9][9];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				grid[i][j] = input.nextInt();
			}
		}
		input.close();
		return grid;
	}
	/**
	 * 
	 * @param grid
	 * @return check whether a solution is valid
	 */
	private static boolean isValid(int[][] grid) {
		for(int i =- 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(grid[i][j] < 1 || grid[i][i] > 9 || !isValid(i, j, grid)) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * 
	 * @param i
	 * @param j
	 * @param grid
	 * @return check whether grid[i][j] is valid grid
	 */
	private static boolean isValid(int i, int j, int[][] grid) {
		// Check whether grid[i][j] is unique i's row
		for(int column = 0; column < 9; column++) {
			if(column != j && grid[i][column] == grid[i][j]) {
				return false;
			}
		}
		// Check whether grid[i][j] is unique in j's column
		for(int row = 0; row < 9; row++) {
			if(row != i && grid[row][j] == grid[i][j]) {
				return false;
			}
		}
		// Check whether grid[i][j] is unique in the 3-by-3 box
		for(int row = (i/3)*3; row < (i / 3) * 3+ 3; row++) {
			for(int col = (j/3)*3; col < (j / 3) * 3 + 3; col++) {
				if(!(row == i && col == j) && grid[row][col] == grid[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}

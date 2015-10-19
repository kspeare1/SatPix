//Katie Speare and Joelle Choi
//Oct 20, 2015
import java.io.*;
import java.util.*;

public class SatPix {

	public static void main(String[] args) throws IOException
	{
		boolean[][] booleanArr = fileToBoolArray("satpix.in");
		int sizeOfLargestPasture;
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("satpix.out")));
		//out.println(sizeOfLargestPasture);
		//out.close();
		for ( int k = 0; k < booleanArr.length; k++)
		{
			for (int j = 0; j < booleanArr[0].length; j++)
			{
				System.out.print(booleanArr[k][j]);
			}
			System.out.println();
		}
	}

	private static boolean[][] fileToBoolArray(String fileName) throws FileNotFoundException, IOException
	{
		//This helper method converts the input file into a 2D array of booleans
		Scanner scan = new Scanner (new File("satpix.in"));
		int col = scan.nextInt();
		int row = scan.nextInt();
		boolean [][] pasture = new boolean [row][col];
		while (scan.next()!=null)
		{
			for (int i=0; i<row; i++)
			{
				for (int j = 0; j<col; j++)
				{
					pasture [i][j] = scan.next() != null;
				}
			}
		}
		return pasture;
	}

	private static int recursivelyMeasureAndMarkPasture(int row, int col, boolean[][] arr)
	{
		static int count = 0;
		//This recursive method employs the flood-fill algorithm to
		//count the size of a single pasture and "mark" it so it is not double-counted
		int j = 0;
		if (row < 0) return j;
		if (col < 0) return j;
		if (row >= arr[0].length) return j;
		if (col >= arr.length) return j;

		// make sure this pixel hasn't been visited yet
		if (arr[row][col]) return j;
		count ++;
		// fill pixel with target color and mark it as visited
		arr[row][col] = true;

		// recursively fill surrounding pixels
		// (this is equivelant to depth-first search)
		recursivelyMeasureAndMarkPasture(row - 1, col, arr);
		recursivelyMeasureAndMarkPasture(row + 1, col, arr);
		recursivelyMeasureAndMarkPasture(row, col - 1, arr);
		recursivelyMeasureAndMarkPasture(row, col + 1, arr);
		return j;
	}
}
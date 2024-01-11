package rl.prog1.exercises.set12;

public class DefaultMatrix implements Matrix {
	private double[][] entries;
	
	protected DefaultMatrix(int rows, int cols) {
		if (rows <= 0 || cols <= 0)
			System.err.println("Error in matrix constructor: Wrong dimensions...");
		entries = new double[rows][cols];
	}

	@Override
	public int getRows() {
		return entries.length;
	}

	@Override
	public int getColumns() {
		return entries[0].length;
	}

	@Override
	public double get(int row, int col) {
		return entries[row][col];
	}

	@Override
	public void set(int row, int col, double value) {
		entries[row][col] = value;
		
	}

	@Override
	public void setRow(int row, Vector vec) {
		if (vec.size() != getColumns())
			System.err.println("Cannot execute setRow: Wrong vector size ...");
		else {
			for (int i = 0; i < vec.size(); i++)
				set(row, i, vec.get(i));
		}
	}
	
	@Override
	public Vector multiply(Vector vec) {
		Vector result = null;
		if (vec.size() != getColumns())
			System.err.println("Cannot execute multiply: Wrong vector size ...");
		else {
			result = VectorMathFactory.createVector(getRows());
			for (int i = 0; i < getRows(); i++)
				for (int j = 0; j < getColumns(); j++)
					result.set(i, result.get(i) + get(i, j) * vec.get(j));
		}
		return result;
	}

	public String toString() {
		StringBuffer result = new StringBuffer("\n( ");
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getColumns(); j++)
				result.append(get(i, j) + "  ");
			result.append(i < getRows()-1 ? "\n  " : ")");
		}
		return result.toString();
	}
}

package rl.prog1.exercises.set12;

public interface Matrix {
	int getRows();
	int getColumns();
	double get(int row, int col);
	void set(int row, int col, double value);
	void setRow(int row, Vector vec);
	Vector multiply(Vector vec);
}

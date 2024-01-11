package rl.prog1.exercises.set12;

public class Vector2 implements Vector {
	double c0, c1;
	
	protected Vector2() {
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public double get(int i) {
		switch (i) {
			case 0: return c0;
			case 1: return c1;
			default:
				System.err.println("Cannot execute get: Wrong index ...");
				return Double.NaN;
		}
	}

	@Override
	public void set(int i, double value) {
		switch (i) {
		case 0: c0 = value; break;
		case 1: c1 = value; break;
		default:
			System.err.println("Cannot execute set: Wrong index ...");
		}
	}

	@Override
	public void set(double... values) {
		if (values.length != size()) {
			System.err.println("Cannot execute set: Wrong number of args ...");
		} else {
			for (int i = 0; i < size(); i++)
				set(i, values[i]);
		}
	}

	@Override
	public Vector multiply(double factor) {
		Vector result = new Vector2();
		for (int i = 0; i < size(); i++)
			result.set(i, get(i) * factor);
		return result;
	}

	@Override
	public Vector plus(Vector vec) {
		Vector result = null;
		if (vec.size() != size()) {
			System.err.println("Cannot execute plus: Wrong vector size ...");
		} else {
			result = new Vector2();
			for (int i = 0; i < size(); i++)
				result.set(i, get(i) + vec.get(i));
		}
		return result;
	}

	@Override
	public Vector minus(Vector vec) {
		Vector result = null;
		if (vec.size() != size()) {
			System.err.println("Cannot execute minus: Wrong vector size ...");
		} else {
			result = new Vector2();
			for (int i = 0; i < size(); i++)
				result.set(i, get(i) - vec.get(i));
		}
		return result;
	}

	@Override
	public double vlength() {
		double tmp = 0;
		for (int i = 0; i < size(); i++)
			tmp += get(i) * get(i);
		return Math.sqrt(tmp);
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer("(");
		for (int i = 0; i < size(); i++)
			result.append(get(i) + (i < size()-1 ? ", " : ""));
		result.append(")");
		return result.toString();
	}
}

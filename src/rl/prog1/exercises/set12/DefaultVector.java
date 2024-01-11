package rl.prog1.exercises.set12;

public class DefaultVector implements Vector {

	private double[] components;

	protected DefaultVector(int size) {
		components = new double[size];
	}

	@Override
	public int size() {
		return components.length;
	}

	@Override
	public double get(int i) {
		return components[i];
	}

	@Override
	public void set(int i, double value) {
		components[i] = value;
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
		Vector result = new DefaultVector(size());
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
			result = new DefaultVector(size());
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
			result = new DefaultVector(size());
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

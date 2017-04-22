package ca._4976.data;

public class Dimension {

	public double width, height;

	public Dimension(double width, double height) {

		this.width = width;
		this.height = height;
	}

	public Dimension(double[] dimension) {

		this.width = dimension[0];
		this.height = dimension[1];
	}

	public double getWidth() { return width; }

	public double getHeight() { return height; }

	public int[] asIntArray() { return new int[] { (int) width, (int) height }; }

	public double[] asDoubleArray() { return new double[] { width, height }; }
}

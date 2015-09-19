package asu.edu.sd.spring.domain;

public class RectangularPyramid {
	double sideOfSquareBaseAndHeight;
	double volume;
	double slantHeight;
	String unit;

	public double getSideOfSquareBaseAndHeight() {
		return sideOfSquareBaseAndHeight;
	}

	public void setSideOfSquareBaseAndHeight(double sideOfSquareBaseAndHeight) {
		this.sideOfSquareBaseAndHeight = sideOfSquareBaseAndHeight;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getSlantHeight() {
		return slantHeight;
	}

	public void setSlantHeight(double slantHeight) {
		this.slantHeight = slantHeight;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}

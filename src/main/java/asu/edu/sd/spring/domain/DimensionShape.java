package asu.edu.sd.spring.domain;

public class DimensionShape {
	
	private Cube cube;
	private RectangularPyramid rectanularPyramid;
	private TriangularPyramid triangularPyramid;
	private Dimension dimension;
	
	public Cube getCube() {
		return cube;
	}
	public void setCube(Cube cube) {
		this.cube = cube;
	}
	public Dimension getDimension() {
		return dimension;
	}
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	public RectangularPyramid getRectanularPyramid() {
		return rectanularPyramid;
	}
	public void setRectanularPyramid(RectangularPyramid rectanularPyramid) {
		this.rectanularPyramid = rectanularPyramid;
	}
	public TriangularPyramid getTriangularPyramid() {
		return triangularPyramid;
	}
	public void setTriangularPyramid(TriangularPyramid triangularPyramid) {
		this.triangularPyramid = triangularPyramid;
	}
}

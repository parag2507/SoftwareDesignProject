package asu.edu.sd.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import asu.edu.sd.spring.domain.Cube;
import asu.edu.sd.spring.domain.Dimension;
import asu.edu.sd.spring.domain.DimensionShape;
import asu.edu.sd.spring.domain.RectangularPyramid;
import asu.edu.sd.spring.domain.TriangularPyramid;
import asu.edu.sd.spring.domain.UnitConstants;
@Service
public class ShapeService implements IShapeService{

	private static List<String> unitsList = new ArrayList<String>();

	@PostConstruct
	public void init(){
		Map<String, Map<String, Double>> conversionMap = UnitConstants.CONVERSIONMAP;
		for(String unit:conversionMap.keySet()){
			unitsList.add(unit);
		}
	}

	@Override
	public DimensionShape getOutput(DimensionShape input) {
		
		Dimension inputDimension = input.getDimension();
		
		DimensionShape output = new DimensionShape();
		output.setDimension(inputDimension);
		output.setCube(getCube(inputDimension,input.getCube()));
		output.setRectanularPyramid(getRectanularPyramid(inputDimension,input.getRectanularPyramid()));
		output.setTriangularPyramid(getTriangularPyramid(inputDimension,input.getTriangularPyramid()));
		return output;
	}

	private TriangularPyramid getTriangularPyramid(Dimension inputDimension,
			TriangularPyramid triangularPyramid) {
		TriangularPyramid outputTriangularPyramid = new TriangularPyramid();
		
		if(triangularPyramid == null || triangularPyramid.getUnit() == null){
			outputTriangularPyramid.setUnit(inputDimension.getUnit());
		}else{
			outputTriangularPyramid.setUnit(triangularPyramid.getUnit());
		}
		double sideOfTriangularBase = convertUnits(inputDimension.getUnit()
				,outputTriangularPyramid.getUnit())*(inputDimension.getLength()/6.0);
		
		outputTriangularPyramid.setSideOfTriangularBase(sideOfTriangularBase);
		outputTriangularPyramid.setHeight(0.82*sideOfTriangularBase);
		outputTriangularPyramid.setVolume(Math.pow(sideOfTriangularBase, 3)/8.49);
		
		return outputTriangularPyramid;
	}

	private RectangularPyramid getRectanularPyramid(Dimension inputDimension,
			RectangularPyramid rectanularPyramid) {
		RectangularPyramid outputRectangularPyramid = new RectangularPyramid();
		
		if(rectanularPyramid == null || rectanularPyramid.getUnit() == null){
			outputRectangularPyramid.setUnit(inputDimension.getUnit());
		}else{
			outputRectangularPyramid.setUnit(rectanularPyramid.getUnit());
		}
		double sideOfBaseSquareAndHeight = convertUnits(inputDimension.getUnit()
				,outputRectangularPyramid.getUnit())*(inputDimension.getLength()/8.9);
		
		outputRectangularPyramid.setSideOfSquareBaseAndHeight(sideOfBaseSquareAndHeight);
		outputRectangularPyramid.setSlantHeight(1.22*sideOfBaseSquareAndHeight);
		outputRectangularPyramid.setVolume(Math.pow(sideOfBaseSquareAndHeight, 3)/3.0);
		
		return outputRectangularPyramid;
	}

	private Cube getCube(Dimension inputDimension, Cube inputCube) {
		
		Cube outputCube = new Cube();
		if(inputCube == null || inputCube.getUnit() == null){
			outputCube.setUnit(inputDimension.getUnit());
		}else{
			outputCube.setUnit(inputCube.getUnit());
		}
		outputCube.setLength(convertUnits(inputDimension.getUnit()
				,outputCube.getUnit())*(inputDimension.getLength()/12));
		outputCube.setVolume(Math.pow(outputCube.getLength(), 3));
		return outputCube;
	}

	@Override
	public List<String> getUnits() {
		return unitsList;
	}
	
	private double convertUnits(String inputUnit, String outputUnit) {
		return (UnitConstants.CONVERSIONMAP.get(inputUnit).get(outputUnit)) ;
	}
}
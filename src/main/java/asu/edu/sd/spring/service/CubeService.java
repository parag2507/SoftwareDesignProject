package asu.edu.sd.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import asu.edu.sd.spring.domain.Cube;
import asu.edu.sd.spring.domain.Dimension;
import asu.edu.sd.spring.domain.DimensionCube;
import asu.edu.sd.spring.domain.UnitConstants;
@Service
public class CubeService implements ICubeService{

	private static List<String> unitsList = new ArrayList<String>();

	@PostConstruct
	public void init(){
		Map<String, Map<String, Double>> conversionMap = UnitConstants.CONVERSIONMAP;
		for(String unit:conversionMap.keySet()){
			unitsList.add(unit);
		}
	}

	@Override
	public DimensionCube getOutput(DimensionCube input) {
		
		Dimension inputDimension = input.getDimension();
		Cube inputCube = input.getCube();
		DimensionCube output = new DimensionCube();
		output.setDimension(inputDimension);
		Cube outputCube = new Cube();
		if(inputCube.getUnit() == null){
			outputCube.setUnit(inputDimension.getUnit());
		}else{
			outputCube.setUnit(inputCube.getUnit());
		}
		outputCube.setLength(convertUnits(input)*(inputDimension.getLength()/12));
		outputCube.setVolume(calculateVolume(outputCube.getLength()));
		output.setCube(outputCube);
		return output;
	}

	@Override
	public List<String> getUnits() {
		return unitsList;
	}
	
	private double calculateVolume(double length) {
		return (Math.pow(length, 3));
	}
	
	private double convertUnits(DimensionCube input) {
		return (UnitConstants.CONVERSIONMAP.get(input.getDimension().getUnit()).get(input.getCube().getUnit())) ;
	}
	
	



}
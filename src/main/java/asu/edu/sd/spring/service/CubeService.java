package asu.edu.sd.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import asu.edu.sd.spring.domain.Cube;
import asu.edu.sd.spring.domain.Dimension;
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
	public Cube getCube(Dimension dimension) {
		Cube cube = new Cube();
		cube.setLength(dimension.getLength() / 12);
		
		if(cube.getUnit() == null) {
			cube.setUnit(dimension.getUnit());
			cube.setVolume(calculateVolume(cube));
			return cube;
		}
		
		if(cube.getUnit() != dimension.getUnit()) {
			cube.setLength(convertUnit(cube,dimension));
			cube.setVolume(calculateVolume(cube));
			return cube;
		}
		return null;
	}

	@Override
	public List<String> getUnits() {
		return unitsList;
	}
	
	public double calculateVolume(Cube cube) {
		return (Math.pow(cube.getLength(), 3));
	}
	
	public double convertUnit(Cube cube, Dimension dimension) {
		return (cube.getLength() * UnitConstants.CONVERSIONMAP.get(dimension.getUnit()).get(cube.getUnit())) ;
	}
	
	



}
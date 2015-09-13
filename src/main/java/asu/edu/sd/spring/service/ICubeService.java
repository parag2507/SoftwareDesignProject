package asu.edu.sd.spring.service;

import java.util.List;

import asu.edu.sd.spring.domain.DimensionCube;

public interface ICubeService {
	
	DimensionCube getOutput(DimensionCube input);
	List<String> getUnits();
	
}

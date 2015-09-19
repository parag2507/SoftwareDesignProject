package asu.edu.sd.spring.service;

import java.util.List;

import asu.edu.sd.spring.domain.DimensionShape;

public interface IShapeService {
	
	DimensionShape getOutput(DimensionShape input);
	List<String> getUnits();
	
}

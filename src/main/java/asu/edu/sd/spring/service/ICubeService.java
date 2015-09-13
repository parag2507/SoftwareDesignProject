package asu.edu.sd.spring.service;

import java.util.List;

import asu.edu.sd.spring.domain.Cube;
import asu.edu.sd.spring.domain.Dimension;

public interface ICubeService {
	
	Cube getCube(Dimension dimension);
	List<String> getUnits();
	
}

package asu.edu.sd.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import asu.edu.sd.spring.domain.DimensionCube;
import asu.edu.sd.spring.service.ICubeService;

@Controller
public class HomeController {

	@Autowired
	private ICubeService cubeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		
		ModelAndView model = new ModelAndView("index");
		model.addObject("command", new DimensionCube());
		model.addObject("unitList", cubeService.getUnits());
		return model;
	}

	@RequestMapping(value = "/processDimension")
	public ModelAndView processDimension(@ModelAttribute("SpringWeb") DimensionCube input
			) {
		
		ModelAndView model = new ModelAndView("index");
		DimensionCube output = cubeService.getOutput(input);
				
		model.addObject("command", output);
		model.addObject("unitList", cubeService.getUnits());
		
		return model;
	}
	
	

	
}
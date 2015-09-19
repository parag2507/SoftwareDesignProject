package asu.edu.sd.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import asu.edu.sd.spring.domain.DimensionShape;
import asu.edu.sd.spring.service.IShapeService;

@Controller
public class HomeController {

	@Autowired
	private IShapeService shapeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		
		ModelAndView model = new ModelAndView("index");
		model.addObject("command", new DimensionShape());
		model.addObject("unitList", shapeService.getUnits());
		return model;
	}

	@RequestMapping(value = "/processDimension")
	public ModelAndView processDimension(@ModelAttribute("SpringWeb") DimensionShape input
			) {
		
		ModelAndView model = new ModelAndView("index");
		DimensionShape output = shapeService.getOutput(input);
				
		model.addObject("command", output);
		model.addObject("unitList", shapeService.getUnits());
		
		return model;
	}
	
	

	
}
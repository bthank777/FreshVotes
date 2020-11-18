package com.freshvotes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {

	//listen for a GET request at the root url "/" which for us is localhost:8080
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String rootView() {
		// then return the view called "index" which is an html file
		return "index";   // Spring knows to prepend and append to build the full address /src/main/resources/index.html
	}
	
	
	
}

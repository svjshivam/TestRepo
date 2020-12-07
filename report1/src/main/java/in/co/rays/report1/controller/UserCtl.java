package in.co.rays.report1.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.rays.report1.dto.User;
import in.co.rays.report1.service.UserService;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping(value = "/userCtl")
public class UserCtl {

	@Autowired
	private UserService service;
	
	@GetMapping(value = "/list")
	private List <User>getUser() {
		return service.getUser();
		
	}
	@GetMapping(value = "/jasper/{format}")
	public String report(@PathVariable String format) throws FileNotFoundException, JRException{
		
		
		return service.exportReport(format);
		
	}
}

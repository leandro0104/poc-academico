package cl.altiuz.academic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.altiuz.academic.entity.Academic;
import cl.altiuz.academic.service.IAcademicService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AcademicController {
	
	@Autowired
	private IAcademicService academicService;
	@GetMapping("/listAcademic")
	public List<Academic> listAcademic(@RequestHeader String rut){
		return academicService.findbyRut(rut);
	}

}

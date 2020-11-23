package cl.altiuz.academic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.altiuz.academic.entity.Academic;
import cl.altiuz.academic.repository.AcademicRepository;

@Service
public class AcademicService implements IAcademicService{
	
	@Autowired
	private AcademicRepository academicRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Academic> findbyRut(String rut) {
		return academicRepository.findByRut(rut);
	}


	
	

}

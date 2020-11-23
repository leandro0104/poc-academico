package cl.altiuz.academic.service;

import java.util.List;

import cl.altiuz.academic.entity.Academic;

public interface IAcademicService {

	public List<Academic> findbyRut(String rut);
}

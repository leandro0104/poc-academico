package cl.altiuz.academic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cl.altiuz.academic.entity.Academic;

public interface AcademicRepository extends CrudRepository<Academic, String> {

	List<Academic> findByRut(String rut);
}

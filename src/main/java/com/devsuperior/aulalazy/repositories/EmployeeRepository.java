package com.devsuperior.aulalazy.repositories;

import java.util.List;

import com.devsuperior.aulalazy.dto.EmployeeMinDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.aulalazy.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	// Buscar com JOIN FETCH não funciona para buscas paginadas Pageble
	// para funcionar com PAGE precisa colocar com CountQuery
	// não coloca o nome da tabela e sim o nome da CLASS
	// JOIN FETCH otimizar a buscar
	@Query("SELECT obj FROM Employee obj JOIN FETCH obj.department")
	List<Employee> findEmployeesWithDepartments();

	//QUERY METHODS
	// no JpaRepository do Spring Data JPA, é possível fazer uma consulta customizada
	// apenas pelo nome do método
	// IgnoreCasa para ignora maisculo e minusculo
	//Containing  faz o LIKe que coloca o operado de
	// qq coisa que venha antes ou depois 'M', "MAR%'
	List<Employee> findByNameContainingIgnoreCase(String name);
}

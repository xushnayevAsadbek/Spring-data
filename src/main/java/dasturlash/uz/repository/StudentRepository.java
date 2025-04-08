package dasturlash.uz.repository;

import dasturlash.uz.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

    List<StudentEntity> findByName(String name);
    List<StudentEntity> findByNameAndSurname(String name, String surname);
}

package dasturlash.uz.service;

import dasturlash.uz.dto.StudentDTO;
import dasturlash.uz.entity.StudentEntity;
import dasturlash.uz.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public StudentDTO create(StudentDTO dto){
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
    studentRepository.save(entity);
    dto.setId(entity.getId());
    return dto;
    }

    public List<StudentDTO> getAll(){
       Iterable<StudentEntity> itrabel = studentRepository.findAll();
       List<StudentDTO> list = new LinkedList<>();
       for (StudentEntity entity : itrabel) {
           StudentDTO dto = new StudentDTO();
           dto.setId(entity.getId());
           dto.setName(entity.getName());
           dto.setSurname(entity.getSurname());
           list.add(dto);
       }
    return list;
    }
}

package dasturlash.uz.service;

import dasturlash.uz.dto.StudentDTO;
import dasturlash.uz.entity.StudentEntity;
import dasturlash.uz.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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

           list.add(toDTO(entity));
       }
    return list;
    }
    public StudentDTO getById(Integer id){
        Optional<StudentEntity> optional = studentRepository.findById(id);
        if (optional.isEmpty()) {
        return null;
        }
        StudentEntity entity = optional.get();
        return toDTO(entity);
    }
    public  StudentDTO update(Integer id ,StudentDTO dto){
        Optional<StudentEntity> optional = studentRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
       StudentEntity entity = optional.get();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        studentRepository.save(entity);
       return dto;
    }
    public void delete(Integer id){
        studentRepository.deleteById(id);
    }
    public StudentDTO toDTO(StudentEntity entity){
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        return dto;
    }

}

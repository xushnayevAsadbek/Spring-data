package dasturlash.uz.controller;

import dasturlash.uz.dto.StudentDTO;
import dasturlash.uz.entity.StudentEntity;
import dasturlash.uz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    private ResponseEntity<StudentDTO> create(@RequestBody StudentDTO dto) {
            StudentDTO result = studentService.create(dto);
        return ResponseEntity.ok(result);
    }
    @GetMapping("")
    public ResponseEntity<List<StudentDTO>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> byId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(studentService.getById(id));
    }
    @PutMapping("/{id}")
    private ResponseEntity<StudentDTO> update(@PathVariable("id") Integer id
            ,@RequestBody StudentDTO dto) {
        StudentDTO result = studentService.update(id ,dto);
        return ResponseEntity.ok(result);
    }

}

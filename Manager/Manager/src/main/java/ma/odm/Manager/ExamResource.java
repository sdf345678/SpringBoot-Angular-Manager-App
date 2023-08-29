package ma.odm.Manager;

import ma.odm.Manager.Model.Exam;
import ma.odm.Manager.service.serviceExam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
@CrossOrigin("*")
public class ExamResource {
    private final serviceExam examServiceExam;

    public ExamResource(serviceExam examServiceExam) {
        this.examServiceExam = examServiceExam;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Exam>> getAllExams (){
        List<Exam> Exams = examServiceExam.findAllExams();
        return new ResponseEntity<>(Exams, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Exam> getExamById (@PathVariable("id") Long id) throws Throwable {
        Exam exam = examServiceExam.findExamById(id);
        return new ResponseEntity<>(exam, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Exam> addExam (@RequestBody Exam exam) throws Throwable {
        Exam examnew = examServiceExam.addExam(exam) ;
        return new ResponseEntity<>(examnew, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Exam> updateExam (@RequestBody Exam exam) throws Throwable {
        Exam examupdate = examServiceExam.updateExam(exam) ;
        return new ResponseEntity<>(examupdate, HttpStatus.OK);
    }

    @DeleteMapping(value ="/delete/{id}")
    public void deleteExam (@PathVariable Long id)  {
        examServiceExam.deleteExam(id);
    }
}

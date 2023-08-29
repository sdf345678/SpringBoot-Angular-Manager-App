package ma.odm.Manager.service;

import jakarta.transaction.Transactional;
import ma.odm.Manager.Model.Exam;
import ma.odm.Manager.exception.UserNotFoundException;
import ma.odm.Manager.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service @Transactional
public class serviceExam {
    private final ExamRepository repository;

    @Autowired
    public serviceExam(ExamRepository repository) {
        this.repository = repository;
    }

    public Exam addExam(Exam exam) {
        return repository.save(exam);
    }

    public List<Exam> findAllExams(){
        return repository.findAll();
    }

    public Exam updateExam(Exam exam){
        return repository.save(exam);
    }

    public Exam findExamById(Long id) throws Throwable {
        return repository.findExamById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

    public void deleteExam(Long id){
        repository.deleteExamById(id);
    }
}

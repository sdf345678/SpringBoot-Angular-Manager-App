package ma.odm.Manager.repository;

import ma.odm.Manager.Model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    void deleteExamById(Long id);

    Optional<Exam> findExamById(Long id);
}

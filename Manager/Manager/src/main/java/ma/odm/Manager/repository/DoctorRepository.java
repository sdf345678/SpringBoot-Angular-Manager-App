package ma.odm.Manager.repository;

import ma.odm.Manager.Model.Doctor;
import ma.odm.Manager.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    void deleteDoctorById(Long id);

    Optional<Doctor> findDoctorById(Long id);
}

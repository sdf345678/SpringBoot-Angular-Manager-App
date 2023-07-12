package ma.odm.Manager.repository;

import ma.odm.Manager.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repo extends JpaRepository<Patient, Long> {
    void deletePatientById(Long id);

    Optional<Patient> findPatientById(Long id);
}

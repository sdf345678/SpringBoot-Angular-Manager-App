package ma.odm.Manager.service;

import jakarta.transaction.Transactional;
import ma.odm.Manager.Model.Patient;
import ma.odm.Manager.exception.UserNotFoundException;
import ma.odm.Manager.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service @Transactional
public class servicePatient {
    private final PatientRepository repository;

    @Autowired
    public servicePatient(PatientRepository repository) {
        this.repository = repository;
    }

    public Patient addPatient(Patient patient) {
        return repository.save(patient);
    }

    public List<Patient> findAllPatients(){
        return repository.findAll();
    }

    public Patient updatePatient(Patient patient){
        return repository.save(patient);
    }

    public Patient findPatientById(Long id) throws Throwable {
        return repository.findPatientById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

    public void deletePatient(Long id){
        repository.deletePatientById(id);
    }
}

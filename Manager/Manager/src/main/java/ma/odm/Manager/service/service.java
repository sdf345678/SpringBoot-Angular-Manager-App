package ma.odm.Manager.service;

import ma.odm.Manager.Model.Patient;
import ma.odm.Manager.exception.UserNotFoundException;
import ma.odm.Manager.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class service {
    private final Repo Repository;

    @Autowired
    public service(Repo repository) {
        this.Repository = repository;
    }

    public Patient addPatient(Patient patient) {
        patient.setCode(UUID.randomUUID().toString());
        return Repository.save(patient);
    }

    public List<Patient> findAllPatients(){
        return Repository.findAll();
    }

    public Patient updatePatient(Patient patient){
        return Repository.save(patient);
    }

    public Patient findPatientById(Long id) throws Throwable {
        return Repository.findPatientById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

    public void deletePatient(Long id){
        Repository.deletePatientById(id);
    }
}

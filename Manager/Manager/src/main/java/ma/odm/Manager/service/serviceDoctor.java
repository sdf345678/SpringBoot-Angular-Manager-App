package ma.odm.Manager.service;

import jakarta.transaction.Transactional;
import ma.odm.Manager.Model.Doctor;
import ma.odm.Manager.exception.UserNotFoundException;
import ma.odm.Manager.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service @Transactional
public class serviceDoctor {
    private final DoctorRepository repository;

    @Autowired
    public serviceDoctor(DoctorRepository repository) {
        this.repository = repository;
    }

    public Doctor addDoctor(Doctor Doctor) {
        return repository.save(Doctor);
    }

    public List<Doctor> findAllDoctors(){
        return repository.findAll();
    }

    public Doctor updateDoctor(Doctor Doctor){
        return repository.save(Doctor);
    }

    public Doctor findDoctorById(Long id) throws Throwable {
        return repository.findDoctorById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

    public void deleteDoctor(Long id){
        repository.deleteDoctorById(id);
    }
}

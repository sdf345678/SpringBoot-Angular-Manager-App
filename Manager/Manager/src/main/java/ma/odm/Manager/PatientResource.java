package ma.odm.Manager;

import ma.odm.Manager.Model.Patient;
import ma.odm.Manager.service.service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin("*")
public class PatientResource {
    private final service patientService;

    public PatientResource(service patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatients (){
        List<Patient> Patients = patientService.findAllPatients();
        return new ResponseEntity<>(Patients, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Patient> getPatientById (@PathVariable("id") Long id) throws Throwable {
        Patient patient = patientService.findPatientById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient (@RequestBody Patient patient) throws Throwable {
        Patient patientnew = patientService.addPatient(patient) ;
        return new ResponseEntity<>(patientnew, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Patient> updatePatient (@RequestBody Patient patient) throws Throwable {
        Patient patientupdate = patientService.updatePatient(patient) ;
        return new ResponseEntity<>(patientupdate, HttpStatus.OK);
    }

    @RequestMapping(value ="/delete/{id}", method = RequestMethod.DELETE)
    public Boolean deletePatient (@PathVariable Long id)  {
        patientService.deletePatient(id);
        return true;
    }
}

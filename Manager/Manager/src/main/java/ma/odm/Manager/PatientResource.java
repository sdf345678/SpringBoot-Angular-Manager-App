package ma.odm.Manager;

import ma.odm.Manager.Model.Patient;
import ma.odm.Manager.service.servicePatient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin("*")
public class PatientResource {
    private final servicePatient patientServicePatient;

    public PatientResource(servicePatient patientServicePatient) {
        this.patientServicePatient = patientServicePatient;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatients (){
        List<Patient> Patients = patientServicePatient.findAllPatients();
        return new ResponseEntity<>(Patients, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Patient> getPatientById (@PathVariable("id") Long id) throws Throwable {
        Patient patient = patientServicePatient.findPatientById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient (@RequestBody Patient patient) throws Throwable {
        Patient patientnew = patientServicePatient.addPatient(patient) ;
        return new ResponseEntity<>(patientnew, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Patient> updatePatient (@RequestBody Patient patient) throws Throwable {
        Patient patientupdate = patientServicePatient.updatePatient(patient) ;
        return new ResponseEntity<>(patientupdate, HttpStatus.OK);
    }

    @DeleteMapping(value ="/delete/{id}")
    public void deletePatient (@PathVariable Long id)  {
        patientServicePatient.deletePatient(id);
    }
}

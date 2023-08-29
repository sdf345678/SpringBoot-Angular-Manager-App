package ma.odm.Manager;

import ma.odm.Manager.Model.Doctor;
import ma.odm.Manager.service.serviceDoctor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@CrossOrigin("*")
public class DoctorResource {
    private final serviceDoctor doctorServiceDoctor;

    public DoctorResource(serviceDoctor doctorServiceDoctor) {
        this.doctorServiceDoctor = doctorServiceDoctor;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Doctor>> getAllDoctors (){
        List<Doctor> Doctors = doctorServiceDoctor.findAllDoctors();
        return new ResponseEntity<>(Doctors, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Doctor> getDoctorById (@PathVariable("id") Long id) throws Throwable {
        Doctor doctor = doctorServiceDoctor.findDoctorById(id);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Doctor> addDoctor (@RequestBody Doctor doctor) throws Throwable {
        Doctor doctornew = doctorServiceDoctor.addDoctor(doctor) ;
        return new ResponseEntity<>(doctornew, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Doctor> updateDoctor (@RequestBody Doctor doctor) throws Throwable {
        Doctor doctorupdate = doctorServiceDoctor.updateDoctor(doctor) ;
        return new ResponseEntity<>(doctorupdate, HttpStatus.OK);
    }

    @DeleteMapping(value ="/delete/{id}")
    public void deleteDoctor (@PathVariable Long id)  {
        doctorServiceDoctor.deleteDoctor(id);
    }
}

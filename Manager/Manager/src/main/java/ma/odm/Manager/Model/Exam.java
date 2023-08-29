package ma.odm.Manager.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString @Transactional
public class Exam implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long Id;
    private Long Price;
    @Column(length = 20, unique = true)
    private String NumDossier;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date examdate;
    @Column(length = 60, unique = true)
    private String Convention;
    @ManyToOne
    private Site site;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
}

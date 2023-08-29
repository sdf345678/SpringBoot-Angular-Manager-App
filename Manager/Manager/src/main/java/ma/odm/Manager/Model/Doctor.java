package ma.odm.Manager.Model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString @Transactional
public class Doctor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long Id;
    @Column(length = 20, unique = true)
    private String CIN;
    @Column(length = 60)
    private String Lname;
    @Column(length = 60)
    private String Fname;
    @Temporal(TemporalType.DATE)
    private Date Birth;
    @Column(length = 60, unique = true)
    private String Email;
    @Column(length = 20, unique = true)
    private String Phone;
    @Column(length = 60)
    private String Type;
    @OneToMany
    private Collection<Exam> exams;


}

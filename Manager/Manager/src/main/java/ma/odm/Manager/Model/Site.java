package ma.odm.Manager.Model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString @Transactional
public class Site implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long Id;
    @Column(length = 100, unique = true)
    private String Address;
    private String name;
    @Column(length = 5, unique = true)
    private String Code;
    @ElementCollection
    @CollectionTable(name = "site_services", joinColumns = @JoinColumn(name = "site_id"))
    @Column(name = "services")
    private List<String> services = new ArrayList<>();
    @OneToMany
    private Collection<Exam> exams;

}

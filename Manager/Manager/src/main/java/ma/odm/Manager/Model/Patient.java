package ma.odm.Manager.Model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long Id;
    private String Lname;
    private String Fname;
    @Column(nullable = false, updatable = false)
    private String Code;


    public Patient() {
    }

    public Patient(Long id, String Lname, String fname, String code) {
        Id = id;
        this.Lname = Lname;
        Fname = fname;
        Code = code;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "Id=" + Id +
                ", Lname='" + Lname + '\'' +
                ", Fname='" + Fname + '\'' +
                ", Code='" + Code + '\'' +
                '}';
    }
}

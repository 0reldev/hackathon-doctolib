package com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table (name = "pillbox")
public class Pillbox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "pillbox", cascade = CascadeType.ALL)
    private List<Composition> compositions = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name ="id_patient")
    private Patient patient;

    public Pillbox() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Composition> getCompositions() {
        return compositions;
    }

    public void setCompositions(List<Composition> compositions) {
        this.compositions = compositions;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}

package com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;

    @OneToMany(mappedBy = "drug", cascade = CascadeType.ALL)
    private List<Composition> compositions = new ArrayList<>();

    public Drug() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Composition> getCompositions() {
        return compositions;
    }

    public void setCompositions(List<Composition> compositions) {
        this.compositions = compositions;
    }
}

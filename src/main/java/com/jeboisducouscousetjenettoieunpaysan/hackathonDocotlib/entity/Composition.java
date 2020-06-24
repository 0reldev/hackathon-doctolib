package com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.entity;

import javax.persistence.*;

@Entity
public class Composition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    private  String day;
    @Column(name = "time_of_the_day")
    private String timeOfTheDay;


    @ManyToOne
    @JoinColumn (name = "id_pillbox")
    private Pillbox pillbox;

    @ManyToOne
    @JoinColumn (name = "id_drug")
    private Drug drug;

    public Composition() {
    }
}

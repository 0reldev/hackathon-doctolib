package com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.entity;

import javax.persistence.*;

@Entity
@Table (name = "composition")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTimeOfTheDay() {
        return timeOfTheDay;
    }

    public void setTimeOfTheDay(String timeOfTheDay) {
        this.timeOfTheDay = timeOfTheDay;
    }

    public Pillbox getPillbox() {
        return pillbox;
    }

    public void setPillbox(Pillbox pillbox) {
        this.pillbox = pillbox;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}

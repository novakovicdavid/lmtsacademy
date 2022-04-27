package com.example.demo.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Afspraak {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boeking_generator")
    @SequenceGenerator(name = "boeking_generator", sequenceName = "boeking_seq", allocationSize = 1)
    @Id
    private Integer id;
    @Temporal(TemporalType.DATE)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Datum;
    @Temporal(TemporalType.TIME)
    @NotNull
    @DateTimeFormat(pattern = "hh-MM-ss")
    private Date startUur;
    @Temporal(TemporalType.TIME)
    @NotNull
    @DateTimeFormat(pattern = "hh-MM-ss")
    private Date eindUur;
//    moet vervangen worden door lid
    private String naam;

    public Afspraak() {
    }

    public Afspraak(Integer id, Date datum, Date startUur, Date eindUur, String naam) {
        this.id = id;
        Datum = datum;
        this.startUur = startUur;
        this.eindUur = eindUur;
        this.naam = naam;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatum() {
        return Datum;
    }

    public void setDatum(Date datum) {
        Datum = datum;
    }

    public Date getStartUur() {
        return startUur;
    }

    public void setStartUur(Date startUur) {
        this.startUur = startUur;
    }

    public Date getEindUur() {
        return eindUur;
    }

    public void setEindUur(Date eindUur) {
        this.eindUur = eindUur;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}

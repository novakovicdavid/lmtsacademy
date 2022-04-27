package com.example.demo.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Afspraak {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "afspraak_generator")
    @SequenceGenerator(name = "afspraak_generator", sequenceName = "afspraak_seq", allocationSize = 1)
    @Id
    private Integer id;
    @Temporal(TemporalType.DATE)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Datum;
    @NotNull
    private String startUur;
    @NotNull

    private String eindUur;
    //    moet vervangen worden door lid
    private String naam;

    public Afspraak() {
    }

    public Afspraak(Integer id, Date datum, String startUur, String eindUur, String naam) {
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

    public String getStartUur() {
        return startUur;
    }

    public void setStartUur(String startUur) {
        this.startUur = startUur;
    }

    public String getEindUur() {
        return eindUur;
    }

    public void setEindUur(String eindUur) {
        this.eindUur = eindUur;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}

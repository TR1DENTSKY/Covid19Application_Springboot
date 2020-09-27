package com.promineotech.covid19.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hospital")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinColumn(name = "hospital_id")
    private List<Admission> admission;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Admission> getAdmission() {
        return admission;
    }

    public void setAdmission(List<Admission> admission) {
        this.admission = admission;
    }
}

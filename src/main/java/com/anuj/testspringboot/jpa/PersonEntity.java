package com.anuj.testspringboot.jpa;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NamedQuery(name="get_all_persons", query = "select p from PersonEntity p")
public class PersonEntity {

    @Id
    @GeneratedValue
    int id;

    @Column
    String name;

    @Column
    String location;

    @Column
    LocalDate birthDate;

    //needs this default constructor on each bean that is mapped using BeanPropertyRowMapper
    public PersonEntity(){

    }

    public PersonEntity(int id, String name, String location, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public PersonEntity(String name, String location, LocalDate birthDate) {
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return "\nPerson Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}

package com.mballem.demo_spring_repo_jpa.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "info_autores")
public class InfoAutor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_info", nullable = false)
    private Long id;

    @Column(name = "cargo", length = 45, nullable = false)
    private String cargo;

    @Column(name = "bio", length = 255, nullable = true)
    private String bio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoAutor infoAutor = (InfoAutor) o;
        return Objects.equals(id, infoAutor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "InfoAutor{" +
                "id=" + id +
                '}';
    }
}

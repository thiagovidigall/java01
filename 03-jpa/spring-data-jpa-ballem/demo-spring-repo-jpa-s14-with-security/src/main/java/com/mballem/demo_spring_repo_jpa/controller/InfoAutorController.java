package com.mballem.demo_spring_repo_jpa.controller;

import com.mballem.demo_spring_repo_jpa.entity.InfoAutor;
import com.mballem.demo_spring_repo_jpa.service.InfoAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("info")
public class InfoAutorController {
    @Autowired
    private InfoAutorService service;

    @GetMapping("{id}")
    public InfoAutor getById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @GetMapping("cargo/{cargo}")
    public List<InfoAutor> getContainsCargo(@PathVariable String cargo) {
        return this.service.findAllContainsCargo(cargo);
    }

    @GetMapping("cargo/{cargo}/empresa/{empresa}")
    public List<InfoAutor> getContainsCargo(@PathVariable String cargo, @PathVariable String empresa) {
        return this.service.findAllCargoAndEmpresa(cargo, empresa);
    }

    @GetMapping("bio/{bio}")
    public InfoAutor getFromBio(@PathVariable String bio) {
        return this.service.findFromBio(bio);
    }

}

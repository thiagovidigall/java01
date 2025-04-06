package com.mballem.demo_spring_repo_jpa.controller;

import com.mballem.demo_spring_repo_jpa.entity.Endereco;
import com.mballem.demo_spring_repo_jpa.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService service;

    @PostMapping
    public Endereco salvar(@RequestBody Endereco endereco) {
        return this.service.save(endereco);
    }

    @GetMapping("uf/{uf}/cidade/{cidade}")
    public List<Endereco> getByUfAndCidade(@PathVariable String uf, @PathVariable String cidade) {
        return this.service.findByUfAndCidade(uf, cidade);
    }

    @GetMapping("uf/{uf}/logradouro/{logradouro}")
    public List<Endereco> getByUfAndLogradouro(@PathVariable String uf, @PathVariable String logradouro) {
        return this.service.findByUfAndLogradouro(uf, logradouro);
    }

    @GetMapping("uf/{uf}/cidades")
    public List<Endereco> getByUfAndCidades(@PathVariable String uf, @RequestParam(name = "nomes") List<String> cidades) {
        return this.service.findByUfAndCidades(uf, cidades);
    }

    @GetMapping("autores/nome/{nome}/sobrenome/{sobrenome}")
    public List<Endereco> getByAutoresNomeOrSobrenome(@PathVariable String nome, @PathVariable String sobrenome) {
        return this.service.findByAutorNomeOrSobrenome(nome, sobrenome);
    }

    @GetMapping("autor/nome/{nome}/sobrenome/{sobrenome}")
    public Endereco getByAutorNomeAndSobrenome(@PathVariable String nome, @PathVariable String sobrenome) {
        return this.service.findByAutorNomeAndSobrenome(nome, sobrenome);
    }

    @GetMapping("autores/total-posts")
    public List<Endereco> getByAutoresTotalDePostsPorCidades(@RequestParam long total, @RequestParam List<String> cidades) {
        return this.service.findByAutorTotalDePostsAndCidades(total, cidades);
    }

    @PutMapping("{id}/novo-endereco")
    public String updateEndereco(@PathVariable Long id, @RequestParam String bairro,
                                 @RequestParam String logradouro, @RequestParam int numero) {
        return this.service.updateEndereco(id, bairro, logradouro, numero) == 1
                ? "Endereço alterado com sucesso"
                : "Endereço não alterado";
    }

    @GetMapping("/uf/{uf}")
    public List<Endereco> getEnderecosByUf(@PathVariable String uf) {
        return this.service.findByUf(uf);
    }

    @PutMapping("{id}/novo-numero")
    public String updateNumero(@PathVariable Long id, @RequestParam int numero) {
        return this.service.updateEnderecoNumero(id, numero);
    }

    @GetMapping("{id}/endereco-completo")
    public String getEnderecoCompleto(@PathVariable Long id) {
        return this.service.getEnderecoCompleto(id);
    }

    @GetMapping("autor/{id}")
    public Endereco getEnderecoByAutorId(@PathVariable Long id) {
        return this.service.getEnderecoByAutorId(id);
    }
}

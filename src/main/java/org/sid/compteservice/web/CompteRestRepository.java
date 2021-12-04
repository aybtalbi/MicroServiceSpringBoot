package org.sid.compteservice.web;

import org.sid.compteservice.entities.Compte;
import org.sid.compteservice.repositories.CompteRepository;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompteRestRepository {

   private CompteRepository compteRepository;


    public CompteRestRepository(CompteRepository compteRepository ) {
        this.compteRepository = compteRepository;
    }

    @GetMapping(path = "/comptes")
    public List<Compte> listComptes(){
        return compteRepository.findAll();
    }

    @GetMapping(path = "/comptes/{id}")
    public Compte listComptes(@PathVariable(name = "id") Long code){
        return compteRepository.findById(code).get();
    }

    @PutMapping(path = "/comptes/{code}")
    public  Compte update(@PathVariable Long code , @RequestBody Compte compte){
        compte.setCode(code);
        return compteRepository.save(compte);
    }

    @DeleteMapping(path ="/comptes/{code}")
    public void  delete(@PathVariable Long  code){
        compteRepository.deleteById(code);
    }
}

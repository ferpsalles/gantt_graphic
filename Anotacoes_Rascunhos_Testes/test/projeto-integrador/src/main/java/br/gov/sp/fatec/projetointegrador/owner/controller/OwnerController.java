package br.gov.sp.fatec.projetointegrador.owner.controller;

import br.gov.sp.fatec.projetointegrador.owner.model.Owner;
import br.gov.sp.fatec.projetointegrador.owner.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public List<Owner> findAll() {
        return ownerService.findByName("");
    }

    @PostMapping
    public Owner save(@RequestBody Owner owner)  {
        return ownerService.save(owner);
    }

    @PutMapping("/{id}")
    public Owner update(@PathVariable("id") Long id, @RequestBody Owner owner) {
        return ownerService.update(id, owner);
    }

}

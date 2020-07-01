package br.gov.sp.fatec.projetointegrador.owner.service;

import br.gov.sp.fatec.projetointegrador.owner.model.Owner;
import br.gov.sp.fatec.projetointegrador.owner.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository repository;

    public Owner save(Owner owner){
        if(owner.getName().isEmpty()){
            throw new RuntimeException("O nome não foi informado");
        }

        if(owner.getOfficeTime() <= 0d){
            throw new RuntimeException("A carga horária não foi informada");
        }

        if(repository.countByName(owner.getName(), 0L) > 0L) {
            throw new RuntimeException("Desenvolvedor já cadastrado.");
        }
        return repository.save(owner);
    }

    public List<Owner> findByName(String name) {
        if(name.isEmpty()) {
            return repository.findAll();
        }
        return repository.findAllByNome(name);
    }

    public Owner findById(Long id) {
        Optional<Owner> optionalOwner = repository.findById(id);
        if(optionalOwner.isPresent()) {
            return optionalOwner.get();
        } else  {
            return null;
        }
    }

    public Owner update(Long id, Owner owner) {
        if(owner.getName().isEmpty()){
            throw new RuntimeException("O nome não foi informado");
        }

        if(owner.getOfficeTime() <= 0d){
            throw new RuntimeException("A carga horária não foi informada");
        }

        if(repository.countByName(owner.getName(), id) > 0L) {
            throw new RuntimeException("Desenvolvedor já cadastrado.");
        }
        Owner savedOwner = this.findById(id);
        if(owner == null) {
            throw new RuntimeException("Desenvolvedor não encontrado.");
        }
        savedOwner.setName(owner.getName());
        savedOwner.setOfficeTime(owner.getOfficeTime());
        return repository.save(savedOwner);
    }
}

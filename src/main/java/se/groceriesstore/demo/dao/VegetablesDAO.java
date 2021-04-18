package se.groceriesstore.demo.dao;

import org.springframework.stereotype.Repository;
import se.groceriesstore.demo.models.dto.VegetableDTO;
import se.groceriesstore.demo.repository.VegetableRepository;

import java.util.Optional;

@Repository
public class VegetablesDAO {

    private final VegetableRepository repositoryVegetable;

    public VegetablesDAO(VegetableRepository repositoryVegetable) {
        this.repositoryVegetable = repositoryVegetable;
    }

    public VegetableDTO addVegetable(VegetableDTO vegetableDTO) {
        return repositoryVegetable.save(vegetableDTO);
    }

    public Iterable<VegetableDTO> getAllVegetables() {
        return repositoryVegetable.findAll();
    }

    public Optional<VegetableDTO> findVegetableById(Integer id) {
        return repositoryVegetable.findById(id);

    }
    public void deleteVegetable (Integer id) {
        repositoryVegetable.deleteById(id);
    }

}

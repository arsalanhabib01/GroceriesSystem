package se.groceriesstore.demo.dao.DrinkDAO;

import org.springframework.stereotype.Repository;
import se.groceriesstore.demo.models.dto.DrinksDTO.MilkDTO;
import se.groceriesstore.demo.repository.DrinksRepository.MilkRepository;


import java.util.Optional;

@Repository
public class MilksDAO {

    private final MilkRepository repositoryMilk;

    public MilksDAO(MilkRepository repositoryMilk) {
        this.repositoryMilk = repositoryMilk;
    }

    public void addMilk(MilkDTO milkDTO) {
        repositoryMilk.save(milkDTO);
    }

    public Iterable<MilkDTO> getAllMilks() {
        return repositoryMilk.findAll();
    }

    public Optional<MilkDTO> findMilkById(Integer id) {
        return repositoryMilk.findById(id);
    }

    public void deleteMilk(Integer id) {
        repositoryMilk.deleteById(id);
    }

}

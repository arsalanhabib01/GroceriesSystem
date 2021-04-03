package se.groceriesstore.demo.dao.DrinkDAO;

import org.springframework.stereotype.Repository;
import se.groceriesstore.demo.models.dto.DrinksDTO.SodaDTO;
import se.groceriesstore.demo.repository.DrinksRepository.SodaRepository;


import java.util.Optional;

@Repository
public class SodasDAO {

    private final SodaRepository repositorySoda;

    public SodasDAO(SodaRepository repositorySoda) {
        this.repositorySoda = repositorySoda;
    }

    public void addSoda(SodaDTO sodaDTO) {
        repositorySoda.save(sodaDTO);
    }

    public Iterable<SodaDTO> getAllSodas() {
        return repositorySoda.findAll();
    }

    public Optional<SodaDTO> findSodaById(Integer id) {
        return repositorySoda.findById(id);
    }

    public void deleteSoda(Integer id) {
        repositorySoda.deleteById(id);
    }

}

package se.groceriesstore.demo.dao.DrinkDAO;

import org.springframework.stereotype.Repository;
import se.groceriesstore.demo.models.dto.DrinksDTO.JuiceDTO;
import se.groceriesstore.demo.repository.DrinksRepository.JuiceRepository;

import java.util.Optional;

@Repository
public class JuicesDAO {

    private final JuiceRepository repositoryJuice;

    public JuicesDAO(JuiceRepository repositoryJuice) {
        this.repositoryJuice = repositoryJuice;
    }

    public void addJuice(JuiceDTO juiceDTO) {
        repositoryJuice.save(juiceDTO);
    }

    public Iterable<JuiceDTO> getAllJuices() {
        return repositoryJuice.findAll();
    }

    public Optional<JuiceDTO> findJuiceById(Integer id) {
        return repositoryJuice.findById(id);
    }

    public void deleteJuice(Integer id) {
        repositoryJuice.deleteById(id);
    }
}

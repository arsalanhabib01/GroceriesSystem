package se.groceriesstore.demo.dao.DrinkDAO;

import org.springframework.stereotype.Repository;
import se.groceriesstore.demo.models.Drinks.Kaffe;
import se.groceriesstore.demo.models.dto.DrinksDTO.KaffeDTO;
import se.groceriesstore.demo.repository.DrinksRepository.KaffeRepository;

import java.util.Optional;

@Repository
public class KaffesDAO {

    private final KaffeRepository repositoryKaffe;

    public KaffesDAO(KaffeRepository repositoryKaffe) {
        this.repositoryKaffe = repositoryKaffe;
    }

    public KaffeDTO addKaffe(KaffeDTO kaffeDTO) {
        return repositoryKaffe.save(kaffeDTO);
    }

    public Iterable<KaffeDTO> getAllKaffes() {
        return repositoryKaffe.findAll();
    }

    public Optional<KaffeDTO> findKaffeById(Integer id) {
        return repositoryKaffe.findById(id);
    }

    public void deleteKaffe (Integer id) {
        repositoryKaffe.deleteById(id);
    }

}

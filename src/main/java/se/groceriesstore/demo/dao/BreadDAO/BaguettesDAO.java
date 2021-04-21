package se.groceriesstore.demo.dao.BreadDAO;

import org.springframework.stereotype.Repository;
import se.groceriesstore.demo.models.Breads.Baguette;
import se.groceriesstore.demo.models.dto.BreadsDTO.BaguetteDTO;
import se.groceriesstore.demo.repository.BreadsRepository.BaguetteRepository;


import java.util.Optional;

@Repository
public class BaguettesDAO {

    private final BaguetteRepository repositoryBaguette;

    public BaguettesDAO(BaguetteRepository repositoryBaguette) {
        this.repositoryBaguette = repositoryBaguette;
    }

    public BaguetteDTO addBaguette(BaguetteDTO baguetteDTO) {
        return repositoryBaguette.save(baguetteDTO);
    }

    public Iterable<BaguetteDTO> getAllBaguettes() {
        return repositoryBaguette.findAll();
    }

    public Optional<BaguetteDTO> findBaguetteById(Integer id) {
        return repositoryBaguette.findById(id);
    }

    public void deleteBaguette(Integer id) {
        repositoryBaguette.deleteById(id);
    }
}

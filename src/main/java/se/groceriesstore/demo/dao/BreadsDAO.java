package se.groceriesstore.demo.dao;

import org.springframework.stereotype.Repository;
import se.groceriesstore.demo.models.dto.BreadDTO;
import se.groceriesstore.demo.repository.BreadRepository;

import java.util.Optional;

@Repository
public class BreadsDAO {

    private final BreadRepository repositoryBread;

    public BreadsDAO(BreadRepository repositoryBread) {
        this.repositoryBread = repositoryBread;
    }

    public BreadDTO addBread(BreadDTO breadDTO) {
        repositoryBread.save(breadDTO);
        return breadDTO;
    }

    public Iterable<BreadDTO> getAllBreads() {
        return repositoryBread.findAll();
    }

    public Optional<BreadDTO> findBreadById(Integer id) {
        return repositoryBread.findById(id);

    }
    public void deleteBread (Integer id) {
        repositoryBread.deleteById(id);
    }

}

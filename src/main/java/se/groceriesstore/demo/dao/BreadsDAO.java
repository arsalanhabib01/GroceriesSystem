package se.groceriesstore.demo.dao;

import org.springframework.stereotype.Repository;
import se.groceriesstore.demo.models.Bread;
import se.groceriesstore.demo.models.dto.BreadDTO;
import se.groceriesstore.demo.repository.BreadRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BreadsDAO {

    private final BreadRepository repositoryBread;
    private static List<Bread> DB = new ArrayList<>();

    public BreadsDAO(BreadRepository repositoryBread) {
        this.repositoryBread = repositoryBread;
    }

    public void addBread(BreadDTO breadDTO) {
        repositoryBread.save(breadDTO);
    }

    public List<Bread> getAllBreads() {
        return DB;
    }

    /*public void addBread(Bread bread) {
        UUID id = UUID.randomUUID();
        insertBread(id, bread);
    }*/

    /*private void insertBread(Integer id, Bread bread) {
        DB.add(new Bread(id, bread.getName(), bread.getPrice()));
    }*/

    public Optional<Bread> findBreadById(Integer id) {
        return DB.stream()
                .filter(bread -> bread.getId()
                        .equals(id))
                        .findFirst();
    }

    public int deleteBread(Integer id) {
        Optional<Bread> optionalBread = findBreadById(id);
        if(optionalBread.isEmpty()) {
            return 0;
        }

        DB.remove(optionalBread.get());
        return 1;

    }
}

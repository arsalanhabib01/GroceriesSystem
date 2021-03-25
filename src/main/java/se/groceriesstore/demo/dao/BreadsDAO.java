package se.groceriesstore.demo.dao;

import org.springframework.stereotype.Repository;
import se.groceriesstore.demo.models.Bread;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class BreadsDAO {

    private static List<Bread> DB = new ArrayList<>();

    public List<Bread> getAllBreads() {
        return DB;
    }

    public void addBread(Bread bread) {
        UUID id = UUID.randomUUID();
        insertAnimal(id, bread);
    }

    private void insertAnimal(UUID id, Bread bread) {
        DB.add(new Bread(id, bread.getName(), bread.getPrice()));
    }

    public Optional<Bread> findBreadById(UUID id) {
        return DB.stream()
                .filter(bread -> bread.getId()
                        .equals(id))
                        .findFirst();
    }
}

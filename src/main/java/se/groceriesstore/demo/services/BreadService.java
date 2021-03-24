package se.groceriesstore.demo.services;
import org.springframework.stereotype.Service;
import se.groceriesstore.demo.models.Bread;


import java.util.ArrayList;
import java.util.List;

@Service
public class BreadService {

    public List<Bread> getBreads(){
        List<Bread> breads = new ArrayList<>();
        breads.add(new Bread("Ljust bröd",20));
        breads.add(new Bread("Grovt bröd",30));
        breads.add(new Bread("Knäckebröd",10));
        return breads;
    }
}

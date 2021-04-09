package se.groceriesstore.demo.services;

import org.springframework.stereotype.Service;
import se.groceriesstore.demo.dao.BreadDAO.BaguettesDAO;
import se.groceriesstore.demo.dao.BreadDAO.ToastsDAO;
import se.groceriesstore.demo.models.Bread;
import se.groceriesstore.demo.models.Breads.Baguette;
import se.groceriesstore.demo.models.Breads.Toast;
import se.groceriesstore.demo.models.dto.BreadsDTO.BaguetteDTO;
import se.groceriesstore.demo.models.dto.BreadsDTO.ToastDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class BreadService {

    private final BaguettesDAO baguettesDAO;
    private final ToastsDAO toastsDAO;

    public BreadService(BaguettesDAO baguettesDAO, ToastsDAO toastsDAO) {
        this.baguettesDAO = baguettesDAO;
        this.toastsDAO = toastsDAO;
    }

    public List<Bread> getBreads() {
        List<Bread> breads = new ArrayList<>();

        for (Baguette baguettes : getAllBaguettes())
            breads.add(baguettes);

        for (Toast toasts : getAllToasts())
            breads.add(toasts);

        return breads;
    }

    public List<Baguette> getAllBaguettes(){
        List<Baguette> baguettes = new ArrayList<>();
        for (BaguetteDTO baguetteDTO: baguettesDAO.getAllBaguettes()){
            Baguette baguette = mapToBaguette(baguetteDTO);
            baguettes.add(baguette);
        }
        return baguettes;
    }

    public List<Toast> getAllToasts(){
        List<Toast> toasts = new ArrayList<>();
        for (ToastDTO toastDTO: toastsDAO.getAllToasts()){
            Toast toast = mapToToast(toastDTO);
            toasts.add(toast);
        }
        return toasts;
    }


    public void addBaguette(Baguette baguette) {
        baguettesDAO.addBaguette(mapFromBaguette(baguette));
    }

    public void addToast(Toast toast) {
        toastsDAO.addToast(mapFromToast(toast));
    }


    public Baguette getBaguetteById(Integer id) {
        if (baguettesDAO.findBaguetteById(id).isPresent()) {
            return mapToBaguette(baguettesDAO.findBaguetteById(id).get());
        }
        return null;
    }

    public Toast getToastById(Integer id) {
        if (toastsDAO.findToastById(id).isPresent()) {
            return mapToToast(toastsDAO.findToastById(id).get());
        }
        return null;
    }


    public void deleteBaguette (Integer id ) {
        baguettesDAO.deleteBaguette(id);
    }

    public void deleteToast (Integer id ) {
        toastsDAO.deleteToast(id);
    }


    private BaguetteDTO mapFromBaguette (Baguette baguette) {
        return new BaguetteDTO(baguette.getName(), baguette.getPrice(), baguette.getImage(), baguette.getVolume());
    }

    private ToastDTO mapFromToast (Toast toast) {
        return new ToastDTO(toast.getName(), toast.getPrice(), toast.getImage(), toast.getVolume());
    }


    private Baguette mapToBaguette (BaguetteDTO baguetteDTO) {
        return new Baguette(baguetteDTO.getId(), baguetteDTO.getName(), baguetteDTO.getPrice(), baguetteDTO.getImage(), baguetteDTO.getVolume());
    }

    private Toast mapToToast (ToastDTO toastDTO) {
        return new Toast(toastDTO.getId(), toastDTO.getName(), toastDTO.getPrice(), toastDTO.getImage(), toastDTO.getVolume());
    }
}

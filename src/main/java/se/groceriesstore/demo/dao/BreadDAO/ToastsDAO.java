package se.groceriesstore.demo.dao.BreadDAO;

import org.springframework.stereotype.Repository;
import se.groceriesstore.demo.models.dto.BreadsDTO.ToastDTO;
import se.groceriesstore.demo.repository.BreadsRepository.ToastRepository;

import java.util.Optional;

@Repository
public class ToastsDAO {

    private final ToastRepository repositoryToast;

    public ToastsDAO(ToastRepository repositoryToast) {
        this.repositoryToast = repositoryToast;
    }

    public ToastDTO addToast(ToastDTO toastDTO) {
        return repositoryToast.save(toastDTO);
    }

    public Iterable<ToastDTO> getAllToasts() {
        return repositoryToast.findAll();
    }

    public Optional<ToastDTO> findToastById(Integer id) {
        return repositoryToast.findById(id);
    }

    public void deleteToast(Integer id) {
        repositoryToast.deleteById(id);
    }
}

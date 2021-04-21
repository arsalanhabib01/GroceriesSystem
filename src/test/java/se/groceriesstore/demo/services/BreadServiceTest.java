package se.groceriesstore.demo.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.groceriesstore.demo.dao.BreadDAO.BaguettesDAO;
import se.groceriesstore.demo.dao.BreadDAO.ToastsDAO;
import se.groceriesstore.demo.models.Breads.Baguette;
import se.groceriesstore.demo.models.Breads.Toast;
import se.groceriesstore.demo.models.dto.BreadsDTO.BaguetteDTO;
import se.groceriesstore.demo.models.dto.BreadsDTO.ToastDTO;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BreadServiceTest {

    public static BaguettesDAO baguettesDAO;
    public static ToastsDAO toastsDAO;

    public BreadService breadService;

    public List<BaguetteDTO> allBaguettes;
    public List<ToastDTO> allToasts;

    @BeforeAll
    public static void initAll() {
        baguettesDAO = Mockito.mock(BaguettesDAO.class);
        toastsDAO = Mockito.mock(ToastsDAO.class);
    }

    @BeforeEach
    public void init() {
        breadService = new BreadService(baguettesDAO, toastsDAO);

        allBaguettes = new ArrayList<>();
        allBaguettes.add(new BaguetteDTO(1, 7, "Levin Baguettes", "image/breads/baguettes/levinbröd.jpg", "50g"));
        allBaguettes.add(new BaguetteDTO(2,16,"Baguette", "image/breads/baguettes/baguette_hel.jpg", "250g"));

        allToasts = new ArrayList<>();
        allToasts.add(new ToastDTO(3,31,"Originalrost","image/breads/toasts/Originalrost.jpg", "750g"));
        allToasts.add(new ToastDTO(4,26,"PågenLimpan","image/breads/toasts/pågenLimpan.jpg","800g"));

    }

    @Test
    void getAllBaguettes_ShouldReturnAllBaguettes() {
        List<Baguette> expectedBaguettes = new ArrayList<>();
        expectedBaguettes.add(new Baguette(1,"Levin Baguettes",7, "image/breads/baguettes/levinbröd.jpg", "50g"));
        expectedBaguettes.add(new Baguette(2,"Baguette", 16, "image/breads/baguettes/baguette_hel.jpg", "250g"));

        Mockito.when(baguettesDAO.getAllBaguettes()).thenReturn(allBaguettes);
        List<Baguette> actualBaguettes = breadService.getAllBaguettes();

        Assertions.assertThat(actualBaguettes.size()).isEqualTo(expectedBaguettes.size());

    }

    @Test
    void getAllToasts_ShouldReturnAllToasts() {
        List<Toast> expectedToasts = new ArrayList<>();
        expectedToasts.add(new Toast(3,"Originalrost",31,"image/breads/toasts/Originalrost.jpg", "750g"));
        expectedToasts.add(new Toast(4,"PågenLimpan", 26, "image/breads/toasts/pågenLimpan.jpg","800g"));

        Mockito.when(toastsDAO.getAllToasts()).thenReturn(allToasts);
        List<Toast> actualToasts = breadService.getAllToasts();

        Assertions.assertThat(actualToasts.size()).isEqualTo(expectedToasts.size());

    }

    @Test
    void addBaguette_ShouldAddBaguetteAndReturnCorrectName() {
        BaguetteDTO baguetteDTOFromDatabase = new BaguetteDTO( "Levin Baguettes",7, "image/breads/baguettes/levinbröd.jpg", "50g");
        Baguette newBaguette = new Baguette(null, "Levin Baguettes",7, "image/breads/baguettes/levinbröd.jpg", "50g");

        Mockito.when(baguettesDAO.addBaguette(ArgumentMatchers.any(BaguetteDTO.class))).thenReturn(baguetteDTOFromDatabase);
        Baguette createdBaguette = breadService.addBaguette(newBaguette);

        Assertions.assertThat(newBaguette.getName()).isEqualTo(createdBaguette.getName());
    }


    @Test
    void addToast_ShouldAddToastAndReturnCorrectName() {
        ToastDTO toastDTOFromDatabase = new ToastDTO( "Originalrost",31, "image/breads/toasts/Originalrost.jpg", "750g");
        Toast newToast = new Toast(null, "Originalrost",31, "image/breads/toasts/Originalrost.jpg", "750g");

        Mockito.when(toastsDAO.addToast(ArgumentMatchers.any(ToastDTO.class))).thenReturn(toastDTOFromDatabase);
        Toast createdToast = breadService.addToast(newToast);

        Assertions.assertThat(newToast.getName()).isEqualTo(createdToast.getName());
    }

    @Test
    void getBaguetteById_ShouldFindBaguetteById() {
        BaguetteDTO baguetteDTOFromDatabase = new BaguetteDTO(1,7,"Levin Baguettes", "image/breads/baguettes/levinbröd.jpg", "50g");
        Baguette expectedBaguette = new Baguette(1,"Levin Baguettes",7, "image/breads/baguettes/levinbröd.jpg", "50g");

        Mockito.when(baguettesDAO.findBaguetteById(1)).thenReturn(Optional.of(baguetteDTOFromDatabase));
        Baguette actualBaguette = breadService.getBaguetteById(1);

        Assertions.assertThat(actualBaguette.getId()).isEqualTo(expectedBaguette.getId());
    }

    @Test
    void getToastById_ShouldFindToastById() {
        ToastDTO toastDTOFromDatabase = new ToastDTO(3,31,"Originalrost","image/breads/toasts/Originalrost.jpg", "750g");
        Toast expectedToast = new Toast(3,"Originalrost",31,"image/breads/toasts/Originalrost.jpg", "750g");


        Mockito.when(toastsDAO.findToastById(3)).thenReturn(Optional.of(toastDTOFromDatabase));
        Toast actualToast = breadService.getToastById(3);

        Assertions.assertThat(actualToast.getId()).isEqualTo(expectedToast.getId());
    }

    @Test
    void deleteBaguette_ShouldInvokeDeleteBaguette() {
        breadService.deleteBaguette(1);
        Mockito.verify(baguettesDAO, Mockito.times(1)).deleteBaguette(1);
    }

    @Test
    void deleteToast_ShouldInvokeDeleteToast() {
        breadService.deleteToast(3);
        Mockito.verify(toastsDAO, Mockito.times(1)).deleteToast(3);
    }

    }

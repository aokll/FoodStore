package ru.gb.FoodStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.FoodStore.Aspects.TrackUserAction;
import ru.gb.FoodStore.model.Menu;
import ru.gb.FoodStore.repository.MenuRepository;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository userRepository) {
        this.menuRepository = userRepository;
    }


    public List<Menu> findAll(){
        return menuRepository.findAll();
    }

    @TrackUserAction
    public Menu saveMenu(Menu menu){
        return menuRepository.save(menu);
    }

    public void deleteById(int id){
        menuRepository.deleteById(id);
    }
    public void updateById(int id, String firstCourse, String secondCourse, String drink, int prise){
        menuRepository.updateById(id, firstCourse, secondCourse, drink, prise);
    }
}

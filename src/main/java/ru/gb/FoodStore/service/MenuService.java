package ru.gb.FoodStore.service;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.FoodStore.Aspects.TrackUserAction;
import ru.gb.FoodStore.model.Menu;
import ru.gb.FoodStore.repository.MenuRepository;
import io.micrometer.core.instrument.Counter;

import java.util.List;

@Service

public class MenuService {
    @Autowired
    private final MenuRepository menuRepository;
//    @Autowired
//    private final Counter myCounter;

    public MenuService(MenuRepository userRepository,MeterRegistry meterRegistry) {
        this.menuRepository = userRepository;
//        this.myCounter = Counter.builder("my_custom_counter")
//                .description("Counts something very important")
//                .register(meterRegistry);
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
        //myCounter.increment();//каждый раз когда вызывается метод updateById,
        //счетчик увеличивается на 1.
    }
}

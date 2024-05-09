package ru.gb.FoodStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.FoodStore.model.Menu;
import ru.gb.FoodStore.service.MenuService;

import java.util.List;

@Controller
public class ControllerFood {
    @Autowired
    private MenuService menuService;

    @GetMapping("/users")
    public String findAll(Model model){
        List<Menu> menus = menuService.findAll();

        model.addAttribute("users", menus);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createMenuForm(Menu menu){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createMenu(Menu menu){
        menuService.saveMenu(menu);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteMenu(@PathVariable("id") int id){
        menuService.deleteById(id);
        return "redirect:/users";
    }
    @GetMapping("/user-update/{id}")
    public String updateFormMenu(Menu menu){
        return "user-update.html";
    }
    @PostMapping("/user-update")
    public String updateUser(Menu menu){
        menuService.updateById(
                menu.getId(),
                menu.getFirstCourse(),
                menu.getSecondCourse(),
                menu.getDrink(),
                menu.getPrise()
        );
        return "redirect:/users";
    }

    @GetMapping("/food-store")
    public String foodStore(){
        return "food-store";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/")
    public String food(){
        return "out";
    }
    @GetMapping("/order-table")
    public String foodUser(){
        return "order-table";
    }
    @GetMapping("/exception")
    public String except(){
        return "exception";
    }
}

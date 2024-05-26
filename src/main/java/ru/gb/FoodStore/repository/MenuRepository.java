package ru.gb.FoodStore.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gb.FoodStore.config.DBconf;
import ru.gb.FoodStore.model.Menu;

import java.util.List;

@Repository
public class MenuRepository {
    private final JdbcTemplate jdbc;
    private final DBconf dBconf;

    public MenuRepository(JdbcTemplate jdbc, DBconf dBconf) {
        this.jdbc = jdbc;
        this.dBconf = dBconf;
    }

    public List<Menu> findAll() {
        RowMapper<Menu> userRowMapper = (r, i) -> {
            Menu rowObject = new Menu();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstCourse(r.getString("firstCourse"));
            rowObject.setSecondCourse(r.getString("secondCourse"));
            rowObject.setDrink(r.getString("drink"));
            rowObject.setPrise(r.getInt("prise"));
            return rowObject;
        };

        return jdbc.query(dBconf.getFindAll(), userRowMapper);
    }

    public Menu save(Menu menu) {
        jdbc.update(dBconf.getSave(),
                menu.getFirstCourse(),
                menu.getSecondCourse(),
                menu.getDrink(),
                menu.getPrise());
        return  menu;
    }

    public void deleteById(int id){
        jdbc.update(dBconf.getDeleteById(),id);
    }

    public void updateById(int id, String firstCourse, String secondCourse, String drink, int prise){
        jdbc.update(dBconf.getUpdateById(), firstCourse, secondCourse, drink, prise, id);
    }
}
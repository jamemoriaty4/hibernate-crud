package ss10.model.dao;

import ss10.model.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> findAll();
    boolean create(Category category);
    void update(Category category);
    void deleteById(Integer id);
    Category findById(Integer id);

}

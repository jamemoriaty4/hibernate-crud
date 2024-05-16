package ss10.model.service;

import ss10.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    boolean create(Category category);
    void update(Category category);
    void deleteById(Integer id);
    Category findById(Integer id);
}

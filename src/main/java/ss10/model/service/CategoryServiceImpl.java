package ss10.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ss10.model.dao.CategoryDAO;
import ss10.model.entity.Category;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryDAO categoryDAO;
    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public boolean create(Category category) {
        return categoryDAO.create(category);
    }

    @Override
    public void update(Category category) {
        categoryDAO.update(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryDAO.deleteById(id);
    }

    @Override
    public Category findById(Integer id) {
        return categoryDAO.findById(id);
    }
}

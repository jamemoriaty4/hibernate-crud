package ss10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ss10.model.entity.Category;
import ss10.model.service.CategoryService;
import ss10.model.service.CategoryServiceImpl;

import java.util.List;

@Controller

public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/category")
    public String index(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category";
    }
    @GetMapping("/add-category")
    public String add(Model model){
        Category addCategory = new Category();
        model.addAttribute("addCategory",addCategory);
        return "add-category";
    }
    @PostMapping("/add-category")
    public String save(@ModelAttribute("addCategory") Category addcategory){
        categoryService.create(addcategory);
        return "redirect:/category";
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam Integer id){
        ModelAndView mav = new ModelAndView("/edit");
        mav.addObject("category",categoryService.findById(id));
        return mav;
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute Category category){
        categoryService.update(category);
        return "redirect:/category";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id){
        categoryService.deleteById(id);
        return "redirect:/category";
    }
}

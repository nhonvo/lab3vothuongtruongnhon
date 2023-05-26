package com.example.lab3vothuongtruongnhon.controller;

import com.example.lab3vothuongtruongnhon.entity.Category;
import com.example.lab3vothuongtruongnhon.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ModelAndView listCategories() {
        List<Category> categories = categoryService.getAllCategories();
        var modelAndView = new ModelAndView("category/list");
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("title", "Category list");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addCategoryForm() {
        var modelAndView = new ModelAndView("category/add");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("categories", categoryService.getAllCategories());
        return modelAndView;
    }

    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "category/add";
        }
        categoryService.addCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable("id") Long id, Model model) {
        Category editCategory = categoryService.getCategoryById(id);
        if (editCategory != null) {
            model.addAttribute("category", editCategory);
            return "category/edit";
        }
        return "error/404";
    }

    @PostMapping("/edit")
    public String editCategory(@Valid @ModelAttribute("category") Category updateCategory, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "category/edit";
        }
        categoryService.updateCategory(updateCategory);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}

package com.ecom.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ecom.exception.CategoryNotFoundException;
import com.ecom.model.Category;
import com.ecom.service.CategoryService;

public class CategoryServiceTest {
	
	CategoryService service;
	
	@BeforeEach
    public void init() {
        service = new CategoryService();
    }

    @Test
    public void testAddCategory() {
        Category c = new Category(101, "Electronics");
        assertDoesNotThrow(() -> service.addCategory(c));
    }

    @Test
    public void testGetByIdSuccess() throws CategoryNotFoundException {
    	Category category = service.getById(1);  
        assertNotNull(category);
        assertEquals(1, category.getId());
    }
    
    @Test
    public void testViewAllCategories() {
        List<Category> list = service.viewAllCategories();
        assertNotNull(list);
    }

}

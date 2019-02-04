package com.niit.goshop.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.niit.goshop.models.Category;

@Repository("categoryDAO")
public interface CategoryDao {
		boolean addCategory(Category Category);
		Category getCategory(int id);
		boolean updateCategory(Category c);
	    boolean deleteCategory(int id);
	    List<Category> listCategories();
		}



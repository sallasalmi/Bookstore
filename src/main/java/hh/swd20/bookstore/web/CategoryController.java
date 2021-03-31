package hh.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@Controller 
public class CategoryController {
	
	@Autowired
	private CategoryRepository crepository;
	
	@GetMapping("/categorylist") 
	public String categoryList(Model model) { 
		model.addAttribute("categorys", crepository.findAll());
		return "categorylist";
	}
	
	@RequestMapping(value = "/newcategory")
	public String addCategory(Model model){
		model.addAttribute("category", new Category());
		return "newcategory";
	}
	
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String save(Category category){
		crepository.save(category);
		return "redirect:categorylist";
	}

}

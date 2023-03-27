package com.alok.Controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.alok.bindings.Product;

@Controller
public class ProductController {
	//Method To Display the Form 
	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("product", new Product());
		return "index";
		
	}
	
	//method to handle the Form Submission
	@PostMapping("/product")
	public String handleSubmitBtn(@Valid Product p,BindingResult result,Model model) {
		System.out.println(p);
		if(result.hasErrors()) {
			return "index";
		}else {
			model.addAttribute("msg", "product Saved");
		}
		return "index";
		
		
	}

}

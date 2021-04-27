package com.persistent.tourism.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.persistent.tourism.entities.MyUserDetails;
import com.persistent.tourism.entities.Pack;
import com.persistent.tourism.repos.BookingRepository;
import com.persistent.tourism.services.PackageService;


@Controller
public class PackageController {
	@Autowired
	private PackageService packageService;
	
	@Autowired
	private BookingRepository bookingRepo;
	
	@GetMapping(path = "admin/home")
	public String home(Model model, Authentication authentication) {
		model.addAttribute("name", "Hi " + ((MyUserDetails)(authentication.getPrincipal())).getFirstName());
		return "adminHome";
	}
	@GetMapping("admin/package")
	public String viewHomePage(Model model,Authentication authentication) {
	model.addAttribute("p1", packageService.getAllPackages());
	model.addAttribute("name", "Hi " + ((MyUserDetails)(authentication.getPrincipal())).getFirstName());
	return "adminDashboard";
}
	
	@Transactional
	@GetMapping(path="/admin/cancel")
	public String cancelBoking(Model model,@RequestParam("bid") int cid) {
		System.out.println(cid);
		bookingRepo.deleteByBid(cid);
		return "redirect:/admin/details";
		
	}
	
	@GetMapping(path="/admin/details")
	public String details(Model model, Authentication authentication) {
		model.addAttribute("bookings",bookingRepo.findAll());
		model.addAttribute("name",   ((MyUserDetails)(authentication.getPrincipal())).getFirstName());
		return "adminBooking";
		
	}

	@GetMapping("/newPackageForm")
	public String newPackageForm(Model model) {
		Pack pack=new Pack();
		model.addAttribute("pack", pack);
		return "adminNewPackage";
	}
	@PostMapping("/savePackage")
	public String savePackage(@ModelAttribute("pack") Pack pack) {
		packageService.savePack(pack);
		return "redirect:/admin/package";
		
	}
	
	@GetMapping("/showFormUpdate/{id}")
	public String showFormUpdate(@PathVariable(value="id")long id,Model model) {
		Pack pack=packageService.getPackageById(id);
		model.addAttribute("pack", pack);
		return "adminUpdatePackage";
	}
	@GetMapping("/deletePackage/{id}")
	public String deletePackage(@PathVariable (value="id") long id) {
		this.packageService.deletePackageById(id);
		return "redirect:/admin/package";
	}
}

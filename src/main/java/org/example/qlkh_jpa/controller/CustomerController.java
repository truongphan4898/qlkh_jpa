package org.example.qlkh_jpa.controller;

import org.example.qlkh_jpa.model.Customer;
import org.example.qlkh_jpa.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
   private ICustomerService customerService;
//    @GetMapping("")
//    public String index (Model model){
//        List<Customer> customerList=customerService.findAll();
//        model.addAttribute("customer",customerList);
//        return "/index";
//    }
    @GetMapping("")
    public String index (@RequestParam(defaultValue = "",required = false) String search,@PageableDefault(page = 0,size =2 ,sort = "name")  Pageable pageable, Model model){
        Page<Customer> customerPage=customerService.findCustomerByNameContaining(search,pageable);
        model.addAttribute("customerPage",customerPage);
        return "/index";
    }
//    @GetMapping("")
//    public String listCustomersSearch(@RequestParam(defaultValue = "",required = false) String search, Pageable pageable,Model model){
//        Page<Customer> customers = customerService.findCustomerByNameContaining(search,pageable);
//        model.addAttribute("customerPage",customers);
//        return "/index";
//    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }
}

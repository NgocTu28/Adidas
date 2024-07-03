package com.example.ecommerce_adidas_tuvungoc.Controller;


import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Customer_Create;
import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Customer_Update;
import com.example.ecommerce_adidas_tuvungoc.Dto.Response.Customer_Reponse;
import com.example.ecommerce_adidas_tuvungoc.Entity.Customer;
import com.example.ecommerce_adidas_tuvungoc.Service.Customer_Service;
import com.example.ecommerce_adidas_tuvungoc.Service.Role_Service;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/customer")
public class Customer_Controller {
    private final Customer_Service customerService;
    private final Role_Service role_Service;

    @GetMapping("")
    public String getAll(@RequestParam(name = "error", required = false, defaultValue = "") String error,
                         @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                         @RequestParam(name = "size", required = false, defaultValue = "5") int size,
                         Model model) {
        if (error.equalsIgnoreCase("true"))
            model.addAttribute("error", "Bạn không đủ quyền thực hiện hành động này");
        Pageable pageable = PageRequest.of(page, size);
        Page<Customer_Reponse> pageResult = customerService.getAllCustomers(pageable);
        model.addAttribute("list", pageResult.getContent());
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPage", pageResult.getTotalPages());
        return "/customer/list";
    }

    @GetMapping("/add")
    public String getViewAdd(Model model) {
        model.addAttribute("roles", role_Service.findByStatusList(1));
        model.addAttribute("add", new Customer_Create());
        return "/customer/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("add") @Valid Customer_Create create,
                      BindingResult result,
                      Model model) {
        if (!create.getPassword().equals(create.getPasswordComfirm()))
            result.rejectValue("passwordComfirm", "passwordComfirm", "Password comfirm not matched");
        if (customerService.existByEmail(create.getEmail()))
            result.rejectValue("email", "email", "Email is exist");
        if (customerService.existByPhone(create.getPhone()))
            result.rejectValue("phone", "phone", "Phone is exist");
        if (result.hasErrors()) {
            model.addAttribute("roles", role_Service.findByStatusList(1));
            return "/customer/add";
        }
        customerService.save(create);
        return "redirect:/customer/";
    }

    @GetMapping("/update/{id}")
    public String getViewUpdate(Model model, @PathVariable("id") Integer id) {
        Optional<Customer> response = customerService.findByIdCustomer(id);
        Customer_Update update = new Customer_Update();
        update.setId(response.get().getId());
        update.setName(response.get().getName());
        update.setStatus(response.get().getStatus());
        update.setPhone(response.get().getPhone());
        update.setEmail(response.get().getEmail());
        model.addAttribute("roles", role_Service.findByStatusList(1));
        model.addAttribute("response", response);
        model.addAttribute("update", update);
        return "/customer/update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("update") @Valid Customer_Update update,
                         BindingResult result,
                         @ModelAttribute("response") Customer_Reponse response,
                         Model model) {
        if (customerService.existByEmail(update.getEmail()))
            result.rejectValue("email", "email", "Email is exist");
        if (customerService.existByPhone(update.getPhone()))
            result.rejectValue("phone", "phone", "Phone is exist");
        if (result.hasErrors()) {
            model.addAttribute("roles", role_Service.findByStatusList(1));
            return "/customer/update";
        }
        customerService.update(update);
        return "redirect:/customer/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("detail", customerService.findByIdCustomer(id));
        return "/customer/detail";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        customerService.deleteById(id);
        return "redirect:/customer/";
    }

    // for client

    @GetMapping("/profile")
    public String profile(@SessionAttribute("o") Customer o, Model model) {
        Customer_Reponse response = customerService.findById(o.getId());
        model.addAttribute("o", response);
        return "/customer/profile";
    }

    @GetMapping("/modify")
    public String getViewModifyForClient(@SessionAttribute("o") Customer o, Model model) {
        Customer_Reponse response = customerService.findById(o.getId());
        Customer_Update update = Customer_Update.builder()
                .status(response.getStatus())
                .phone(response.getPhone())
                .email(response.getEmail())
                .address(response.getAddress())
                .id(response.getId())
                .name(response.getName())
                .build();
        model.addAttribute("modify", update);
        return "/customer/modify";
    }

    @PostMapping("/modify")
    public String modifyForClient(@ModelAttribute("modify") @Valid Customer_Update update, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/customer/modify";
        }
        Customer_Reponse response = customerService.update(update);
        return "redirect:/customer/profile";
    }

    @GetMapping("register")
    public String getViewRegister(Model model) {
        Customer_Create create = new Customer_Create();
        create.setStatus(1);
        model.addAttribute("register", create);
        return "/customer/register";
    }

    @PostMapping("register")
    public String register(@ModelAttribute("register") @Valid Customer_Create create,
                           BindingResult result, Model model) {
        if (!create.getPassword().equals(create.getPasswordComfirm()))
            result.rejectValue("passwordComfirm", "passwordComfirm", "Password comfirm not matched");
        if (customerService.existByEmail(create.getEmail()))
            result.rejectValue("email", "email", "Email is exist");
        if (customerService.existByPhone(create.getPhone()))
            result.rejectValue("phone", "phone", "Phone is exist");
        if (result.hasErrors()) {
            return "/customer/register";
        }
        create.setStatus(1);
        Customer_Reponse response = customerService.save(create);
        model.addAttribute("mess", "Đăng ký thành công, hãy đăng nhập.");
        return "/login";
    }
}

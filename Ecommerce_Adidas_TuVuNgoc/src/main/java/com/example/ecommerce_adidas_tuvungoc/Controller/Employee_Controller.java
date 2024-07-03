package com.example.ecommerce_adidas_tuvungoc.Controller;

import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Employee_Create;
import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Employee_Update;
import com.example.ecommerce_adidas_tuvungoc.Dto.Response.Employee_Reponse;
import com.example.ecommerce_adidas_tuvungoc.Service.Employee_Service;
import com.example.ecommerce_adidas_tuvungoc.Service.Role_Service;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@RequestMapping("/employee")
public class Employee_Controller {
    private final Employee_Service employee_service;
    private final Role_Service role_service;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("")
    public String getAll(@RequestParam(name = "error", required = false, defaultValue = "") String error,
                         @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                         @RequestParam(name = "size", required = false, defaultValue = "5") int size,
                         Model model) {
        if (error.equalsIgnoreCase("true"))
            model.addAttribute("error", "Bạn không đủ quyền thực hiện hành động này");
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee_Reponse> pageResult = employee_service.getAll(pageable);
        model.addAttribute("list", pageResult.getContent());
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPage", pageResult.getTotalPages());
        return "/employee/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("add")
    public String getViewAdd(Model model) {
        model.addAttribute("add", new Employee_Create());
        model.addAttribute("roles", role_service.findByStatusList(1));
        return "/employee/add";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public String add(@ModelAttribute("add") @Valid Employee_Create create,
                      BindingResult result,
                      Model model) {
        if (role_service.existByName(create.getUsername()))
            result.rejectValue("username", "username", "Username is exist");
        if (!create.getPassword().trim().equals(create.getPasswordComfirm().trim()))
            result.rejectValue("passwordComfirm", "passwordComfirm", "Password comfirm not matches");
        if (employee_service.existByEmail(create.getEmail()))
            result.rejectValue("email", "email", "Email is exist");
        if (result.hasErrors()) {
            model.addAttribute("roles", role_service.findByStatusList(1));
            return "/employee/add";
        }
        employee_service.add(create);
        return "redirect:/employee/";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/update/{id}")
    public String getViewUpdate(@PathVariable("id") Integer id,
                                Model model) {
        Employee_Reponse response = employee_service.findById(id);
        Employee_Update update = new Employee_Update();
        update.setId(response.getId());
        update.setName(response.getName());
        update.setEmail(response.getEmail());
        update.setStatus(response.getStatus());
        update.setIdRole(role_service.findByName(response.getRole()).getId());
        model.addAttribute("response", response);
        model.addAttribute("update", update);
        model.addAttribute("roles", role_service.findByStatusList(1));
        return "/employee/update";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("update/{id}")
    public String update(@ModelAttribute("update") @Valid Employee_Update update,
                         BindingResult result,
                         @ModelAttribute("response") Employee_Reponse response,
                         @PathVariable("id") Long id,
                         Model model) {
        if (employee_service.existByEmail(update.getEmail()))
            if (result.hasErrors()) {
                model.addAttribute("roles", role_service.findByStatusList(1));
                return "/employee/update";
            }
            employee_service.update(update);
            return "redirect:/employee/";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employee_service.delete(id);
        return "redirect:/employee/";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("detail", employee_service.findById(id));
        return "/employee/detail";
    }
}

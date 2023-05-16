package com.example.furama.controller;

import com.example.furama.dto.CustomerDto;
import com.example.furama.model.customer.Customer;
import com.example.furama.service.customer.ICustomerService;
import com.example.furama.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String searchCustomer(@PageableDefault(page = 0, size = 5) Pageable pageable,
                                 @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                                 @RequestParam(value = "emailSearch", defaultValue = "") String emailSearch,
                                 @RequestParam(value = "idSearch", defaultValue = "") String id,
                                 Model model) {
        model.addAttribute("customerList", customerService.searchCustomer(nameSearch, emailSearch, id, pageable));
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("emailSearch", emailSearch);
        model.addAttribute("idSearch", id);
        return "customer/list";
    }

    @GetMapping("create")
    public String showFromCreate(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        String str = "";
        return "customer/create";
    }

    @PostMapping("/save")
    public String saveCus(@ModelAttribute CustomerDto customerDto, BindingResult bindingResult,
                          RedirectAttributes redirectAttributes, Model model) {
        new CustomerDto().validate(customerDto, bindingResult);

        boolean isDuplicateIdCard = false;
        for (Customer customer : customerService.findAll()) {
            if (customerDto.getCustomerIdCard().equals(customer.getCustomerIdCard())) {
                isDuplicateIdCard = true;
                break;
            }
        }
        if (bindingResult.hasFieldErrors() || isDuplicateIdCard) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            model.addAttribute("customerDto", customerDto);

            if (isDuplicateIdCard) {
                model.addAttribute("duplicateIdCard", "Số CMND/CCCD đã tồn tại, vui lòng kiểm tra lại.");
            }
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới khách hàng thành công!");

        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {
        Customer customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);

        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerTypeList", customerTypeService.findAll());

        return "customer/update";
    }

    @PostMapping("/update")
    public String updateCus(@ModelAttribute CustomerDto customerDto, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes, Model model) {
        new CustomerDto().validate(customerDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypeList", customerService.findAll());

            return "customer/update";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa khách hàng thành công!");

        return "redirect:/customer";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam(value = "idDelete") Integer id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa khách hàng  [" +
                customerService.findById(id).getCustomerName() + "]  thành công.");

        return "redirect:/customer";
    }
}

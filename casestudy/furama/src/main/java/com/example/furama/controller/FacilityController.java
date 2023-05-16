package com.example.furama.controller;

import com.example.furama.dto.CustomerDto;
import com.example.furama.dto.FacilityDto;
import com.example.furama.model.customer.Customer;
import com.example.furama.model.facility.Facility;
import com.example.furama.service.customer.ICustomerService;
import com.example.furama.service.customer.ICustomerTypeService;
import com.example.furama.service.facility.IFacilityService;
import com.example.furama.service.facility.IFacilityTypeService;
import com.example.furama.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("")
    public String searchFacility(@PageableDefault(page = 0, size = 5) Pageable pageable,
                                 @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                                 @RequestParam(value = "idSearch", defaultValue = "0") int id,
                                 Model model) {
        if (id == 0) {
            boolean deleteStatus=false;
            model.addAttribute("facilityList", facilityService.findByFacilityNameContainingAndDeleteStatus(nameSearch,deleteStatus,pageable));
        } else {

            model.addAttribute("facilityList", facilityService.searchFacility(nameSearch,id, pageable));
        }
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("idSearch", id);
        return "facility/list";
    }

    @GetMapping("create")
    public String showFromCreate(Model model) {
        model.addAttribute("facilityDto", new FacilityDto());
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "facility/create";
    }
//
    @PostMapping("/save")
    public String saveCus(@ModelAttribute @Validated FacilityDto facilityDto, BindingResult bindingResult,
                          RedirectAttributes redirectAttributes, Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);

        boolean isDuplicateName = false;
        for (Facility facility : facilityService.findAll(Pageable.unpaged())) {
            if (facility.getFacilityName().equals(facilityDto.getFacilityName())) {
                isDuplicateName = true;
                break;
            }
        }
        if (bindingResult.hasFieldErrors() || isDuplicateName) {
            model.addAttribute("facilityTypeList", facilityTypeService.findAll());
            model.addAttribute("facilityDto", facilityDto);

            if (isDuplicateName) {
                model.addAttribute("isDuplicateName","Tên đã tồn tại, vui lòng kiểm tra lại.");
            }
            return "facility/create";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công!");

        return "redirect:/facility";
    }

    @GetMapping("/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {
        Facility facility = facilityService.findById(id);
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facility, facilityDto);
        model.addAttribute("facilityDto", facilityDto);
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "facility/update";
    }

    @PostMapping("/update")
    public String updateCus(@ModelAttribute @Validated FacilityDto facilityDto, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes, Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("facilityDto", facilityDto);
            model.addAttribute("facilityTypeList", facilityTypeService.findAll());
            model.addAttribute("rentTypeList", rentTypeService.findAll());
            return "facility/update";
        }

        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa  thành công!");

        return "redirect:/facility";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam(value = "idDelete") Integer id, RedirectAttributes redirectAttributes) {
        facilityService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa khách hàng  [" +
                facilityService.findById(id).getFacilityName() + "]  thành công.");

        return "redirect:/facility";
    }
}

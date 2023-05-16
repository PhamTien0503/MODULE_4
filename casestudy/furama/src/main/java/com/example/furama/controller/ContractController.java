package com.example.furama.controller;

import com.example.furama.model.contract.Contract;
import com.example.furama.model.contract.ContractDetail;
import com.example.furama.service.contract.IAttachFacilityService;
import com.example.furama.service.contract.IContractDetailService;
import com.example.furama.service.contract.IContractService;
import com.example.furama.service.customer.ICustomerService;
import com.example.furama.service.employee.IEmployeeService;
import com.example.furama.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @Autowired
    private IContractDetailService iContractDetailService;

    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping("")
    public String showList(@PageableDefault(page = 0,size = 5) Pageable pageable, Model model){
        model.addAttribute("contractList", iContractService.findAllDto(pageable));
        model.addAttribute("attachFacilityList", iAttachFacilityService.findAll());
        model.addAttribute("contractDetailList", iContractDetailService.findAll());
        model.addAttribute("facilityList", iFacilityService.findAll());
        model.addAttribute("employeeList", iEmployeeService.findAll());
        model.addAttribute("customerList", iCustomerService.findAll());
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractDetail", new ContractDetail());
        return "contract/list";
    }
    @PostMapping("add")
    public String addContract(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes,
                              @RequestParam List<Integer>quantityList,
                              @RequestParam List<Integer>idAttachFacilityList){
        iContractService.save(contract);
        if(quantityList!=null){
            for (int i = 0; i < quantityList.size(); i++) {

                ContractDetail contractDetail=new ContractDetail(quantityList.get(i),iAttachFacilityService.findById(idAttachFacilityList.get(i)),contract);
                iContractDetailService.save(contractDetail);
            }
        }
        String message="Add Success!!!!";
        redirectAttributes.addFlashAttribute("message",message);
        return "redirect:/contract";
    }
    @PostMapping("/addContractDetail")
    public String saveDetail(@ModelAttribute ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        ContractDetail contractDetail1=contractDetail;
        iContractDetailService.save(contractDetail1);
        redirectAttributes.addFlashAttribute("message", "Thêm mới hợp đồng chi tiết thành công!");

        return "redirect:/contract";
    }
}

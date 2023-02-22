package com.furama.controller;

import com.furama.dto.ContractDto;
import com.furama.model.contract.Contract;
import com.furama.service.IContractService;
import com.furama.service.ICustomerService;
import com.furama.service.IEmployeeService;
import com.furama.service.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IFacilityService facilityService;

    @GetMapping("")
    public String getListContract(Model model,
                                  @PageableDefault(size = 3, page = 0, sort = "id",
                                          direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Contract> contractPage = contractService.findAll(pageable);
        model.addAttribute("contractPage",contractPage);
        model.addAttribute("listEmployee",employeeService.listEmployee());
        model.addAttribute("listCustomer",customerService.customerList());
        model.addAttribute("listFacility",facilityService.getListFacility());
        model.addAttribute("contractDto", new ContractDto());
        return "/view/contract/listContract";
    }

    @PostMapping("/save")
    public String addNewContract(@Validated @ModelAttribute ContractDto contractDto, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("contractDto" , contractDto);
            model.addAttribute("listEmployee",employeeService.listEmployee());
            model.addAttribute("listCustomer",customerService.customerList());
            model.addAttribute("listFacility",facilityService.getListFacility());
            model.addAttribute("hasErr" ,"true");
            return "/view/contract/listContract";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contractService.saveContract(contract);
        redirectAttributes.addFlashAttribute("mess", "Thêm hợp đồng thành công");
        return "redirect:/contract";
    }

}

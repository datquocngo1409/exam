package com.codegym.exam.controller;

import com.codegym.exam.model.Group;
import com.codegym.exam.model.Staff;
import com.codegym.exam.service.GroupService;
import com.codegym.exam.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private GroupService groupService;

    @ModelAttribute("groups")
    public Iterable<Group> groups(){
        return groupService.findAll();
    }

    @GetMapping("/staff")
    public ModelAndView showList(@PageableDefault(5) Pageable pageable, @RequestParam("s")Optional<String> s) {
        String search = s.toString().substring(9, s.toString().length()-1);
        if (search.equals("empt")) search ="";
        Page<Staff> staff;
        if (!s.isPresent()){
            staff = staffService.findAll(pageable);
        }else {
            staff = staffService.findAllByName(search, pageable);
        }
        ModelAndView modelAndView = new ModelAndView("staff/list");
        modelAndView.addObject("staff", staff);
        modelAndView.addObject("search", search);
        return modelAndView;
    }

    @GetMapping("/create-staff")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("staff/create");
        modelAndView.addObject("staff", new Staff());
        return modelAndView;
    }

    @PostMapping("/create-staff")
    public ModelAndView createStaff(@Validated @ModelAttribute("staff") Staff staff, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("staff/create");
        if (!bindingResult.hasFieldErrors()) {
            staffService.save(staff);
            modelAndView.addObject("staff", staff);
            modelAndView.addObject("mess", "Created!");
        }else {
            modelAndView.addObject("staff" , new Staff());
            modelAndView.addAllObjects(bindingResult.getModel());
        }
        return modelAndView;
    }

    @GetMapping("/edit-staff/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("staff/edit");
        modelAndView.addObject("staff", staffService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit-staff/{id}")
    public ModelAndView editStaff(@Validated @ModelAttribute("staff") Staff staff, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("staff/edit");
        if (!bindingResult.hasFieldErrors()) {
            staffService.save(staff);
            modelAndView.addObject("staff", staff);
            modelAndView.addObject("mess", "Updated!");
        }else {
            modelAndView.addObject("staff" , new Staff());
            modelAndView.addAllObjects(bindingResult.getModel());
        }
        return modelAndView;
    }

    @GetMapping("/delete-staff/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("staff/delete");
        modelAndView.addObject("staff", staffService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete-staff")
    public String deleteStaff(@ModelAttribute("staff") Staff staff) {
        staffService.remove(staff.getId());
        return "redirect:staff";
    }


}

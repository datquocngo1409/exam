package com.codegym.exam.service.impl;

import com.codegym.exam.model.Staff;
import com.codegym.exam.repository.StaffRepository;
import com.codegym.exam.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Page<Staff> findAll(Pageable pageable) {
        return staffRepository.findAll(pageable);
    }

    @Override
    public Staff findById(Long id) {
        return staffRepository.findById(id).get();
    }

    @Override
    public void save(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void remove(Long id) {
        staffRepository.deleteById(id);
    }

    @Override
    public Page<Staff> findAllByName(String search, Pageable pageable) {
        return staffRepository.findAllByNameContains(search, pageable);
    }
}

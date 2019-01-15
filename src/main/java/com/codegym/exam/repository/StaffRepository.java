package com.codegym.exam.repository;

import com.codegym.exam.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StaffRepository extends PagingAndSortingRepository<Staff, Long> {
    Page<Staff> findAllByNameContains(String name, Pageable pageable);
}

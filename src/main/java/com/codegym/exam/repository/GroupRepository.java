package com.codegym.exam.repository;

import com.codegym.exam.model.Group;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GroupRepository extends PagingAndSortingRepository<Group, Long> {
}

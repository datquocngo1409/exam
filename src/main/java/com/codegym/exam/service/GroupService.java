package com.codegym.exam.service;

import com.codegym.exam.model.Group;

public interface GroupService {
    Iterable<Group> findAll();

    Group findById(Long id);

    void save(Group group);

    void remove(Long id);
}

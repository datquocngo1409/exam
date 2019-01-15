package com.codegym.exam.service.impl;

import com.codegym.exam.model.Group;
import com.codegym.exam.repository.GroupRepository;
import com.codegym.exam.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;

public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Iterable<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group findById(Long id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public void save(Group group) {
        groupRepository.save(group);
    }

    @Override
    public void remove(Long id) {
        groupRepository.deleteById(id);
    }
}

package com.slobodianiuk.departmentservice.service;

import java.util.List;

public interface BaseCrudService<M> {
    void create(M model);

    List<M> getAll();

    void edit(M model);

    void deleteById(Integer id);

    M getById(Integer id);
}

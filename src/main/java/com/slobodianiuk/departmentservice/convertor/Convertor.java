package com.slobodianiuk.departmentservice.convertor;

public interface Convertor<T, U> {
    T convertToModel(U dto);

    U convertFromModel(T model);
}
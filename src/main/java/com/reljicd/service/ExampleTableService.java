package com.reljicd.service;

import com.reljicd.dto.ExampleTableDTO;

import java.util.Collection;

public interface ExampleTableService {

    Collection<ExampleTableDTO> findByTextField1(String textField1);

}

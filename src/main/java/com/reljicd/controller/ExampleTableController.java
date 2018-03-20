package com.reljicd.controller;

import com.reljicd.dto.ExampleTableDTO;
import com.reljicd.service.ExampleTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExampleTableController {

    static final String TEXT_FIELD_1_ENDPOINT = "/api/text_field_1/";

    private ExampleTableService ExampleTableService;

    @Autowired
    public ExampleTableController(ExampleTableService ExampleTableService) {
        this.ExampleTableService = ExampleTableService;
    }

    @GetMapping(value = TEXT_FIELD_1_ENDPOINT + "{textField1}")
    public ResponseEntity<Iterable<ExampleTableDTO>> returnExampleTablesForTextField1(@PathVariable String textField1) {
        Collection<ExampleTableDTO> ExampleTableDTOs = this.ExampleTableService.findByTextField1(textField1);
        return new ResponseEntity<>(ExampleTableDTOs, HttpStatus.OK);
    }

}

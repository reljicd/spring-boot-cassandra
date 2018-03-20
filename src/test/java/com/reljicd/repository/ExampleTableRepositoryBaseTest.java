package com.reljicd.repository;

import com.reljicd.entity.ExampleTable;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Ignore
public class ExampleTableRepositoryBaseTest {

    private static final String TEXT_FIELD_1 = "text_field_1";

    @Autowired
    ExampleTableRepository ExampleTableRepository;

    private ExampleTable ExampleTable;

    @Before
    public void setUp() {
        ExampleTable = new ExampleTable(TEXT_FIELD_1, "text_field_2", 4604231, 4624009);
        ExampleTableRepository.save(ExampleTable);
    }

    @After
    public void tearDown() {
        ExampleTableRepository.delete(ExampleTable);
    }

    @Test
    public void testExampleTableShouldBeInDatabase() {
        List<ExampleTable> ExampleTablesFromRepository = (List<ExampleTable>) ExampleTableRepository.findAll();
        assert ExampleTablesFromRepository.contains(ExampleTable);
    }

    @Test
    public void testShouldFindExampleTablesByTagSearch() {
        List<ExampleTable> ExampleTablesFromRepository = ExampleTableRepository.findByTextField1(TEXT_FIELD_1);
        assert ExampleTablesFromRepository.contains(ExampleTable);
    }
}



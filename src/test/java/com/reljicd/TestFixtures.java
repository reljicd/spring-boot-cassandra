package com.reljicd;

import com.reljicd.dto.ExampleTableDTO;

public class TestFixtures {

    public static final String EXAMPLE_TEXT_FIELD = "text_field_1";

    public static final ExampleTableDTO EXAMPLE_TABLE_DTO_1 = new ExampleTableDTO(
            EXAMPLE_TEXT_FIELD,
            "text_field_2_1",
            4604231,
            4624009);

    public static final ExampleTableDTO EXAMPLE_TABLE_DTO_2 = new ExampleTableDTO(
            EXAMPLE_TEXT_FIELD,
            "text_field_2_2",
            4604232,
            4624010);

}

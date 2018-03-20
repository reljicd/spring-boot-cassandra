package com.reljicd.controller;

import com.reljicd.TestFixtures;
import com.reljicd.annotation.CassandraEmbeddedConfiguration;
import com.reljicd.dto.ExampleTableDTO;
import com.reljicd.entity.ExampleTable;
import com.reljicd.repository.ExampleTableRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CassandraEmbeddedConfiguration
public class ExampleTableControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    ExampleTableRepository ExampleTableRepository;

    @After
    public void tearDown() {
        ExampleTableRepository.deleteAll();
    }

    @Test
    public void shouldGetAndFindTwoExampleTables() {
        // Save first two ExampleTables in repository
        ExampleTableRepository.save(ExampleTable.instanceOf(TestFixtures.EXAMPLE_TABLE_DTO_1));
        ExampleTableRepository.save(ExampleTable.instanceOf(TestFixtures.EXAMPLE_TABLE_DTO_2));

        HttpHeaders headers = new HttpHeaders();

        ResponseEntity<Collection<ExampleTableDTO>> responseEntity =
                restTemplate.exchange(
                        ExampleTableController.TEXT_FIELD_1_ENDPOINT + TestFixtures.EXAMPLE_TEXT_FIELD,
                        HttpMethod.GET,
                        new HttpEntity<>(headers),
                        new ParameterizedTypeReference<Collection<ExampleTableDTO>>() {
                        });

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Collection<ExampleTableDTO> ExampleTablesDTOsReturnedFromGET = responseEntity.getBody();

        assertThat(ExampleTablesDTOsReturnedFromGET.size()).isEqualTo(2);
        assertThat(TestFixtures.EXAMPLE_TABLE_DTO_1).isIn(ExampleTablesDTOsReturnedFromGET);
        assertThat(TestFixtures.EXAMPLE_TABLE_DTO_2).isIn(ExampleTablesDTOsReturnedFromGET);
    }

}



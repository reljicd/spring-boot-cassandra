package com.reljicd.repository;

import com.reljicd.annotation.CassandraEmbeddedConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@CassandraEmbeddedConfiguration
public class ExampleTableRepositoryTest extends ExampleTableRepositoryBaseTest {
}

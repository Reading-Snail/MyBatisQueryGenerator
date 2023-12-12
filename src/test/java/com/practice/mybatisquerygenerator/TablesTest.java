package com.practice.mybatisquerygenerator;

import com.practice.mybatisquerygenerator.entity.Tables;
import com.practice.mybatisquerygenerator.repository.TablesRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyBatisQueryGeneratorApplication.class)
@WebAppConfiguration
@Transactional
class TablesTest {

    @Autowired
    TablesRepository tableListRepository;
    @Test
    void test(){
        //Given
        Tables table = new Tables();
        System.out.println("table.id: " + table.getId());
        table.setName("hi");

        //When
        tableListRepository.save(table);

        //Then
        assertEquals(table, tableListRepository.findOne("hi"));
    }

}

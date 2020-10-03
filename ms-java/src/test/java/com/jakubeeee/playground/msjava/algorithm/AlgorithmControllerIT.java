package com.jakubeeee.playground.msjava.algorithm;

import com.jakubeeee.playground.msjava.MSJavaApplicationEntryPoint;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = MSJavaApplicationEntryPoint.class)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
@AutoConfigureMockMvc
@ActiveProfiles("integration-test")
class AlgorithmControllerIT {

    @Autowired
    private MockMvc mvc;

    @ParameterizedTest
    @CsvSource({
            "/algorithm/invokeloop?iterations=10,10",
            "/algorithm/invokeloop?iterations=100,100",
            "/algorithm/invokeloop?iterations=1000,1000",
            "/algorithm/invokeloop?iterations=10000,10000"
    })
    void invokeLoopTest(String url, String response) throws Exception {
        mvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(content().string(response));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "/algorithm/quicksort?ints=1,10,2,9,3,8,4,7,5,6|[1,2,3,4,5,6,7,8,9,10]",
            "/algorithm/quicksort?ints=-1,-10,-2,-9,-3,-8,-4,-7,-5,-6|[-10,-9,-8,-7,-6,-5,-4,-3,-2,-1]",
            "/algorithm/quicksort?ints=1,10,2,9,3,8,4,7,5,6,-1,-10,-2,-9,-3,-8,-4,-7,-5,-6|[-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8,9,10]",
    }, delimiter = '|')
    void quickSortTest(String url, String response) throws Exception {
        mvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(content().string(response));
    }

}

package com.example.errorpagesecurityfilter

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ErrorPageSecurityFilterApplicationTests {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun anonymous() {
        mockMvc.get("/login")
            .andExpect {
                status { isOk() }
            }
    }
}

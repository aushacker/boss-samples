package com.github.aushacker.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.io.IOException;

import jakarta.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BonjourServletTest extends AbstractHttpServletTest {

    private BonjourServlet servlet;

    @BeforeEach
    public void setUp() throws IOException {
        super.setUp();
        servlet = new BonjourServlet();
    }

    @Test
    public void testDoGet() throws IOException {
        servlet.doGet(request, response);

        verify(response).setStatus(HttpServletResponse.SC_OK);
        verify(response).setContentType("text/plain");
        assertEquals("Bonjour Monde!\n", getContent(), "content");
    }
}

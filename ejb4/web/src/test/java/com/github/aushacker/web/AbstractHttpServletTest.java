package com.github.aushacker.web;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Common configuration for mocked HttpServlet testing.
 *
 * @since 1.0
 */
public abstract class AbstractHttpServletTest {

    /**
     * Breaking encapsulation for convenience.
     */
    protected HttpServletRequest request;

    /**
     * Breaking encapsulation for convenience.
     */
    protected HttpServletResponse response;

    /**
     * Underlying Http response text.
     */
    private StringWriter writer;

    /**
     * Subclass should call as part of its @BeforeEach processing.
     *
     * @throws IOException
     */
    protected void setUp() throws IOException {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        writer = new StringWriter();

        when(response.getWriter()).thenReturn(new PrintWriter(writer));
    }

    protected String getContent() {
        return writer.toString();
    }

}

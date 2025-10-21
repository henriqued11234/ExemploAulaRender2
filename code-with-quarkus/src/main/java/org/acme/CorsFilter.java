package org.acme.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) throws IOException {

        responseContext.getHeaders().add(
                "Access-Control-Allow-Origin", "https://abcd-ndjr.onrender.com"
            //"Access-Control-Allow-Origin", "https://abcd-ndjr.onrender"
        );
        responseContext.getHeaders().add(
                "Access-Control-Allow-Credentials", "true"
        );
        responseContext.getHeaders().add(
                "Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization, x-requested-with"
        );
        responseContext.getHeaders().add(
                "Access-Control-Allow-Methods",
                //"GET, POST, PUT, DELETE, OPTIONS, HEAD"
            //"GET, DELETE, OPTIONS, HEAD"
            "GET, DELETE,POST, OPTIONS, HEAD"
        );
        responseContext.getHeaders().add(
                "Access-Control-Max-Age", "86400"
        );

        // Handle OPTIONS method
        if ("OPTIONS".equals(requestContext.getMethod())) {
            responseContext.setStatus(200);
        }
    }
}

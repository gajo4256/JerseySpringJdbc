package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Component
@Path("myresource")
public class MyResource {

    private static final String query = "SELECT COUNT(*) FROM OFFERS";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Offer getOffer() {
        final Integer result = jdbcTemplate.queryForObject(query, Integer.class);
        return Offer.createOffer(result);
    }

    private static class Offer {
        private Integer size;

        public static Offer createOffer(final Integer size) {
            final Offer offer = new Offer();
            offer.setSize(size);
            return offer;
        }

        // jackson needs this for serialization to JSON
        public Integer getSize() {
            return size;
        }

        // jackson needs this for deserialization
        public void setSize(Integer size) {
            this.size = size;
        }
    }
}

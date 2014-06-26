/*
 * Jersey style resource class
 */

package com.ligo.dwhello.resources;

import com.ligo.dwhello.core.Saying;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

//import com.ligo.dwhello.core.Template;
//import io.dropwizard.jersey.caching.CacheControl;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import javax.validation.Valid;
//import javax.ws.rs.*;
//import java.util.concurrent.TimeUnit;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class DwHelloResource {

//    private static final Logger LOGGER = LoggerFactory.getLogger(DwHelloResource.class);

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;
//    private final Template template;

    public DwHelloResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }


//    public DwHelloResource(Template template) {
//        this.template = template;
//        this.counter = new AtomicLong();
//    }

    @GET
    @Timed
//    @Timed(name = "get-requests")
//    @CacheControl(maxAge = 1, maxAgeUnit = TimeUnit.DAYS)
    public Saying sayHello(@QueryParam("name") Optional<String> name) {

        final String value = String.format(template, name.or(defaultName));

        return new Saying(counter.incrementAndGet(), value);
//        return new Saying(counter.incrementAndGet(), template.render(name));

    }

//    @POST
//    public void receiveHello(@Valid Saying saying) {
//        LOGGER.info("Received a saying: {}", saying);
//    }

}

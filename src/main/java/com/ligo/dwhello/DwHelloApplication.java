/* Dropwizard style 'application' class
 *
 * Main project class which is a sub-class of the application-specific configuration class.
 */

package com.ligo.dwhello;

import com.ligo.dwhello.resources.*;
import com.ligo.dwhello.health.TemplateHealthCheck;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.wordnik.swagger.jaxrs.config.*;
import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;
import com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider;
import com.wordnik.swagger.jaxrs.listing.ResourceListingProvider;
import com.wordnik.swagger.config.*;
import com.wordnik.swagger.reader.*;
import com.wordnik.swagger.jaxrs.reader.DefaultJaxrsApiReader;


public class DwHelloApplication extends Application<DwHelloConfiguration> {

    public static void main(String[] args) throws Exception {
        new DwHelloApplication().run(args);
    }

    @Override   
    public String getName() {
        return "hello-world-swagger";
    }

    /* Configure aspects of the application needed to run such as bundles, configuration source providers, etc. */

    @Override
    public void initialize(Bootstrap<DwHelloConfiguration> bootstrap) {
        // Do nothing for now
    }

    @Override
    public void run(DwHelloConfiguration configuration, Environment environment) throws ClassNotFoundException {

        final DwHelloResource resource = new DwHelloResource(configuration.getTemplate(), configuration.getDefaultName());
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());

        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);

        /* Set up resources and providers needed to support Swagger */

        environment.jersey().register(new ApiListingResourceJSON());
        environment.jersey().register(new ResourceListingProvider());
        environment.jersey().register(new ApiDeclarationProvider());
        ScannerFactory.setScanner(new DefaultJaxrsScanner());
        ClassReaders.setReader(new DefaultJaxrsApiReader());

        /* Handle some Swagger config settings */
//TODO Remove API version hardcoding
//TODO Remove host hardcoding


        SwaggerConfig config = ConfigFactory.config();
        config.setApiVersion("1.0.1");
        config.setBasePath("http://localhost:8000");
    }

}

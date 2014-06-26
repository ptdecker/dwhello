/* Dropwizard style 'application' class
 *
 * Main project class which is a sub-class of the application-specific configuration class.
 */

package com.ligo.dwhello;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.ligo.dwhello.resources.DwHelloResource;
import com.ligo.dwhello.health.TemplateHealthCheck;

//import com.ligo.dwhello.auth.ExampleAuthenticator;
//import com.ligo.dwhello.cli.RenderCommand;
//import com.ligo.dwhello.core.Person;
//import com.ligo.dwhello.core.Template;
//import com.ligo.dwhello.db.PersonDAO;
//import com.ligo.dwhello.resources.*;
//import io.dropwizard.assets.AssetsBundle;
//import io.dropwizard.auth.basic.BasicAuthProvider;
//import io.dropwizard.db.DataSourceFactory;
//import io.dropwizard.hibernate.HibernateBundle;
//import io.dropwizard.migrations.MigrationsBundle;
//import io.dropwizard.views.ViewBundle;

public class DwHelloApplication extends Application<DwHelloConfiguration> {
    
    public static void main(String[] args) throws Exception {
        new DwHelloApplication().run(args);
    }

//    private final HibernateBundle<DwHelloConfiguration> hibernateBundle = new HibernateBundle<DwHelloConfiguration>(Person.class) {
//        @Override
//        public DataSourceFactory getDataSourceFactory(DwHelloConfiguration configuration) {
//            return configuration.getDataSourceFactory();
//        }
//    }

    @Override   
    public String getName() {
        return "hello-world";
    }

    /* Configure aspects of the application needed to run such as bundles, configuration source providers, etc. */

    @Override
    public void initialize(Bootstrap<DwHelloConfiguration> bootstrap) {
//        bootstrap.addCommand(new RenderCommand());
//        bootstrap.addBundle(new AssetsBundle());
//        bootstrap.addBundle(new MigrationsBundle<DwHelloConfiguration>() {
//            @Override
//            public DataSourceFactory getDataSourceFactory(DwHelloConfiguration configuration) {
//                return configuration.getDataSourceFactory();
//           }
//        });
//        bootstrap.addBundle(hibernateBundle);
//        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(DwHelloConfiguration configuration, Environment environment) throws ClassNotFoundException {

        final DwHelloResource resource = new DwHelloResource(configuration.getTemplate(), configuration.getDefaultName());
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
//        final PersonDAO dao = new PersonDAO(hibernateBundle.getSessionFactory());
//        final Template template = configuration.buildTemplate();

        environment.healthChecks().register("template", healthCheck);
//        environment.healthChecks().register("template", new TemplateHealthCheck(template));
        environment.jersey().register(resource);
//        environment.jersey().register(new BasicAuthProvider<>(new ExampleAuthenticator(), "SUPER SECRET STUFF"));
//        environment.jersey().register(new DwHelloResource(template));
//        environment.jersey().register(new ViewResource());
//        environment.jersey().register(new ProtectedResource());
//        environment.jersey().register(new PeopleResource(dao));
//        environment.jersey().register(new PersonResource(dao));

    }
}

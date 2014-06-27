/* Dropwizard style 'configuration' class
 *
 * Specifis environment-specific parameters which are stored in a YAML configuration file, deserialized into an
 * instance of this class, and validated.
 */

package com.ligo.dwhello;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

//import com.yammer.dropwizard.config.Configuration;  <- this seems to be old, before 'com.yammer.dropwizard.config' became 'io.dropwizard'
//import com.ligo.dwhello.core.Template;
//import io.dropwizard.db.DataSourceFactory;
//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;

public class DwHelloConfiguration extends Configuration {

    @NotEmpty
    private String template;

    @NotEmpty
//    @JsonProperty  <-- perhaps this line is needed?
    private String defaultName = "Stranger-Swagger";

//    @Valid
//    @NotNull
//    private DataSourceFactory database = new DataSourceFactory();

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

//    public Template buildTemplate() {
//        return new Template(template, defaultName);
//    }

//    @JsonProperty("database")
//    public DataSourceFactory getDataSourceFactory() {
//        return database;
//    }

//    @JsonProperty("database")
//    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
//        this.database = dataSourceFactory;
//    }

}

/* Health Check 
 */

package com.ligo.dwhello.health;

import com.codahale.metrics.health.HealthCheck;
//import com.ligo.dwhello.core.Template;
//import com.google.common.base.Optional;

public class TemplateHealthCheck extends HealthCheck {

    private final String template;
//    private final Template template;

//    public TemplateHealthCheck(Template template) {
    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
//        template.render(Optional.of("woo"));
//        template.render(Optional.<String>absent());
        final String saying = String.format(template, "TEST");
        if(!saying.contains("TEST")) {
            return Result.unhealthy("template does not include a name");
        }
        return Result.healthy();
    }
}

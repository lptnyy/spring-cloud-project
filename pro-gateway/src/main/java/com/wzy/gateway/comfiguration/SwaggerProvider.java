package com.wzy.gateway.comfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
public class SwaggerProvider implements SwaggerResourcesProvider {

  public static final String API_URI = "v2/api-docs";
  @Value(value = "${pro.swagger2.other-services}")
  String otherSerivce;

  @Override
  public List<SwaggerResource> get() {
    List<SwaggerResource> resources = new ArrayList<>();
    String[] otherServiceArray = otherSerivce.split(",");

    // 获取所有配置service
    Arrays.asList(otherServiceArray).forEach(service -> {
       String[] services = service.split(":");
       resources.add(swaggerResource(services[1],"/"+services[0].toLowerCase()+"/"+API_URI));
    });
    return resources;
  }

  private SwaggerResource swaggerResource(String name, String location) {
    SwaggerResource swaggerResource = new SwaggerResource();
    swaggerResource.setName(name);
    swaggerResource.setLocation(location);
    swaggerResource.setSwaggerVersion("1.0");
    return swaggerResource;
  }
}

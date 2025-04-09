package com.conectados.conectados.configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI conectadosOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Conectados API")
                        .version("v.0.0.1")
                        .description("documentação da API Conectados")
                        .license(new License().name("").url(""))
                        .contact(new Contact().name("Rodrigo Santos").url("https://rudr1gu.vercel.app")
                                .email("rodrigo.santos.ii@hotmail.com")))
                .externalDocs(new ExternalDocumentation().description("Github")
                        .url("https://github.com/rudr1gu/API-Conectados-JAVA"));
    }

    @Bean
    OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {
        return openApi -> openApi.getPaths().values().forEach(pathItem -> pathItem.readOperationsMap().values()
                .forEach(operation -> {

                    ApiResponses apiResponses = operation.getResponses();

                    apiResponses.addApiResponse("200", createApiResponse("Sucesso"));
                    apiResponses.addApiResponse("201", createApiResponse("Criado com sucesso"));
                    apiResponses.addApiResponse("204", createApiResponse("Sem conteúdo"));
                    apiResponses.addApiResponse("400", createApiResponse("Requisição inválida"));
                    apiResponses.addApiResponse("401", createApiResponse("Não autorizado"));
                    apiResponses.addApiResponse("403", createApiResponse("Proibido"));
                    apiResponses.addApiResponse("404", createApiResponse("Não encontrado"));
                    apiResponses.addApiResponse("500", createApiResponse("Erro interno do servidor"));
                    apiResponses.addApiResponse("503", createApiResponse("Serviço indisponível"));
                    apiResponses.addApiResponse("504", createApiResponse("Tempo limite de solicitação excedido"));
                    apiResponses.addApiResponse("409", createApiResponse("Conflito"));
                    apiResponses.addApiResponse("422", createApiResponse("Entidade não processável"));
                    apiResponses.addApiResponse("429", createApiResponse("Muitas requisições"));
                    apiResponses.addApiResponse("418", createApiResponse("Eu sou um bule de café"));
                    apiResponses.addApiResponse("511", createApiResponse("Autenticação de rede necessária"));
                }));
    }

    private ApiResponse createApiResponse(String message) {
        return new ApiResponse().description(message);
    }

}

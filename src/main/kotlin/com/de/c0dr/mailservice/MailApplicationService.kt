package com.de.c0dr.mailservice;

import org.springframework.stereotype.Component
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import org.thymeleaf.templatemode.TemplateMode
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver

@Component
class MailApplicationService {


    fun getTemplateEngine(): TemplateEngine {
        val templateResolver = ClassLoaderTemplateResolver()
        templateResolver.prefix = "/templates/"
        templateResolver.suffix = ".html"
        templateResolver.templateMode = TemplateMode.HTML
        templateResolver.characterEncoding = "UTF-8"

        val templateEngine = TemplateEngine()
        templateEngine.setTemplateResolver(templateResolver)
        return templateEngine
    }


    fun generateTemplate(templateName: String, contextData: Map<String, String>): String {
        val templateEngine = getTemplateEngine()
        val context = Context()
        contextData.entries.stream().forEach {
            context.setVariable(it.key, it.value);
        }

        return templateEngine.process(templateName, context)
    }
}

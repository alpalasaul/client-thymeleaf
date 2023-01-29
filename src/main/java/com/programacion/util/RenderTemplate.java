package com.programacion.util;

import com.programacion.config.ThymeleafTemplateEngine;
import spark.ModelAndView;

import java.util.Map;

public class RenderTemplate {
    public static String render(Map<String, Object> model, String tempPath) {
        return new ThymeleafTemplateEngine().render(new ModelAndView(model, tempPath));
    }
}

package com.programacion.controller;

import com.programacion.config.ThymeleafTemplateEngine;
import com.programacion.model.Album;
import com.programacion.service.AlbumService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import spark.ModelAndView;
import spark.Redirect;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

@ApplicationScoped
public class AlbumController {

    @Inject
    private AlbumService albumService;

    public void init() {

        staticFiles.location("/templates");

        get("/albums", (req, res) -> {

            Map<String, Object> model = new HashMap<>();
            model.put("singers", albumService.getAll()); // arrays de singers

            return new ThymeleafTemplateEngine().render(
                    new ModelAndView(model, "albums")
            );
        });

        get("/album/nuevo", (req, res) -> {

            Map<String, Object> model = new HashMap<>();
            model.put("album", new Album());

            return new ThymeleafTemplateEngine().render(
                    new ModelAndView(model, "agregar_album")
            );
        });

        get("/album/editar/:id", (req, res) -> {

            Album album = albumService.findById(req.params(":id"));

            Map<String, Object> model = new HashMap<>();
            model.put("album", album);

            return new ThymeleafTemplateEngine().render(
                    new ModelAndView(model, "editar_album")
            );
        });

        post("/album/editar/:id", (req, res) -> {
            String body = req.body();
            albumService.update(Integer.parseInt(req.params(":id")), new Album());
            res.redirect("/albums");
            return null;
        });

        delete("/album/eliminar/:id", (req, res) -> {
            albumService.delete(Integer.parseInt(req.params(":id")));
            res.redirect("/albums");
            return null;
        });

    }

}

package com.programacion.controller;

import com.programacion.model.Singer;
import com.programacion.service.SingerService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.HashMap;
import java.util.Map;

import static com.programacion.util.RenderTemplate.render;
import static spark.Spark.*;

@ApplicationScoped
public class SingerController {

    @Inject
    private SingerService singerService;

    public void init() {

        path("/client", () -> {
            get("/singers", (req, res) -> {

                Map<String, Object> model = new HashMap<>();
//                model.put("singers", singerService.getAll()); // arrays de singers

                return render(model, "singers");
            });

            get("/singer/nuevo", (req, res) -> {

                Map<String, Object> model = new HashMap<>();
                model.put("singer", new Singer());

                return render(model, "agregar_singer");
            });

            get("/singer/editar/:id", (req, res) -> {

//                Singer singer = singerService.findById(req.params(":id"));

                Map<String, Object> model = new HashMap<>();
//                model.put("singer", singer);

                return render(model, "editar_album");
            });

            post("/singer/editar/:id", (req, res) -> {
                singerService.update(Integer.parseInt(req.params(":id")), new Singer());
                res.redirect("/singers");
                return null;
            });

            delete("/singer/eliminar/:id", (req, res) -> {
                singerService.delete(Integer.parseInt(req.params(":id")));
                res.redirect("/singers");
                return null;
            });
        });

    }
}

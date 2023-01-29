package com.programacion.controller;

import com.programacion.config.ThymeleafTemplateEngine;
import com.programacion.model.Author;
import com.programacion.model.Book;
import com.programacion.service.BookService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import static com.programacion.util.RenderTemplate.render;
import static spark.Spark.*;

@ApplicationScoped
public class BookController {

    @Inject
    private BookService bookService;

    public void init() {

        path("/api", () -> {

            get("/books", (req, res) -> {

                Map<String, Object> model = new HashMap<>();
                model.put("books", bookService.getAll()); // arrays de books

                return render(model, "books");
//                return new ThymeleafTemplateEngine().render(
//                        new ModelAndView(model, "books")
//                );
            });

            get("/book/nuevo", (req, res) -> {

                Map<String, Object> model = new HashMap<>();
                model.put("book", new Book());

                return render(model, "agregarBook");
//                return new ModelAndView(model, "agregar_album");
            });

            get("/book/editar/:id", (req, res) -> {

                Book book = bookService.findById(req.params(":id"));

                Map<String, Object> model = new HashMap<>();
//                model.put("album", new Book(1, "ac", "sd", 2.2));
                model.put("book", book);
                model.put("title", "Holaaa");
//                model.put("book1", new Book(1, "ac", "sd", 2.2));

//                return render(model, "agregarBook");
                return new ThymeleafTemplateEngine().render(new ModelAndView(model, "editar_book"));
            });

            post("/book/editar/:id", (req, res) -> {
                String body = req.body();
                bookService.update(Integer.parseInt(req.params(":id")), new Book());
                res.redirect("/books");
                return null;

            }, new ThymeleafTemplateEngine());

            post("/book", (req, res) -> {
                String body = req.body();
                bookService.update(Integer.parseInt(req.params(":id")), new Book());
                res.redirect("/books");
                return null;

            }, new ThymeleafTemplateEngine());

            delete("/book/eliminar/:id", (req, res) -> {
                bookService.delete(Integer.parseInt(req.params(":id")));
                res.redirect("/books");
                return null;

            }, new ThymeleafTemplateEngine());
        });

    }
}
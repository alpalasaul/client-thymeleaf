package com.programacion;

import com.programacion.controller.BookController;
import com.programacion.controller.SingerController;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import static spark.Spark.port;
import static spark.Spark.staticFiles;

public class Main {

    public static void main(String[] args) {

        staticFiles.location("/templates");
        port(8089);

        var weld = new Weld();
        WeldContainer weldContainer = weld.initialize();

        var albumController = weldContainer.select(BookController.class).get();
        albumController.init();

        var singerController = weldContainer.select(SingerController.class).get();
        singerController.init();
    }

}

package com.programacion;

import com.programacion.controller.AlbumController;
import com.programacion.controller.SingerController;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import static spark.Spark.port;

public class Main {

    public static void main(String[] args) {

        Weld weld = new Weld();
        WeldContainer weldContainer = weld.initialize();

        port(8088);

        SingerController singerController = weldContainer.select(SingerController.class).get();
        singerController.init();

        AlbumController albumController = weldContainer.select(AlbumController.class).get();
        albumController.init();

    }

}

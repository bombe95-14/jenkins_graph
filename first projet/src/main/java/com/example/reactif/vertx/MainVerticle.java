package com.example.reactif.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
     vertx.createHttpServer().requestHandler(req -> {
      req.response()
        .putHeader("content-type", "text/plain")
        .end("Hello from Vert.x!");
    }).listen(8081).onComplete(http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("HTTP server started on port 8888");
      } else {
        startPromise.fail(http.cause());
      }
    }); 
/* 
       final Router router = Router.router(vertx);

    router.get("/hello/") 
        .handler(req -> req.response()
            .putHeader("content-type", "text/html") 
            .end("<html><body><h1>Hello World</h1></body></html>"));

    router.get("/byebye/") 
        .handler(req -> req.response()
            .putHeader("content-type", "text/html") 
            .end("<html><body><h1>Bye Bye World</h1></body></html>"));

            vertx.createHttpServer() 
         //   .requestHandler(router::accept) 
            .listen(8080);        */ 

  }
}

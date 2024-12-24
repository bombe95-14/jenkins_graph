package com.example.reactif.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {

   /*   vertx.createHttpServer().requestHandler(req -> {
   
      if ( req.path().startsWith("toto") ) {
          req.response().end("welcome vertx");        
      }

      //req.response()
      //  .putHeader("content-type", "text/plain")
      //  .end("Hello from Vert.x!");
    }).listen(8081).onComplete(http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("HTTP server started on port 8888");
      } else {
        startPromise.fail(http.cause());
      }
    });  */
 
    vertx.deployVerticle(new HelloVerticle());
       final Router router = Router.router(vertx);

    router.get("/eleve/list") 
        .handler( this::getAllStudent );

    router.get("/matiere/:list") 
        .handler( this::getAllCourseUnit );



            vertx.createHttpServer() 
            .requestHandler(router) 
            .listen(8080);         

  }

  void getAllStudent( RoutingContext routingContext ){

    vertx.eventBus().request("hello.vertx.addr", "", reply->{
      routingContext.request().response()
     // .putHeader("content-type", "text/html") 
      .end( (String) reply.result().body() );
    }); 

  }

  void getAllCourseUnit( RoutingContext routingContext ){

    System.out.println("jkoiogiepoh erjhopieroph");
    String name = routingContext.pathParam("variable");
    routingContext.request().response()
      .putHeader("content-type", "text/html") 
      .end("<html><body><h1>Bye Bye World "+ name +" </h1></body></html>");

  }
}

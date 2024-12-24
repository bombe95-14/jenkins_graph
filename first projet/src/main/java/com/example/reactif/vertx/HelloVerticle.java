package com.example.reactif.vertx;

import io.vertx.core.AbstractVerticle;

public class HelloVerticle extends AbstractVerticle {
    
    @Override
    public void start(){

        vertx.eventBus().consumer("hello.vertx.addr", msg->{
            msg.reply("good morning");
        });

        vertx.eventBus().consumer("hello.named.addr", msg->{
                msg.body();
        });
    }


}

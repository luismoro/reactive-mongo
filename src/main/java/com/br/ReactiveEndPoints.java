package com.br;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.web.reactive.config.EnableWebReactive;


@SpringBootApplication
@EnableWebReactive
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class ReactiveEndPoints {
	private static final Logger log = LoggerFactory.getLogger(ReactiveEndPoints.class);

//	@Bean
//	public HttpServer getHttpServer(){
//		ApplicationContext context = new AnnotationConfigApplicationContext(DelegatingWebReactiveConfiguration.class);
//		HttpHandler handler = DispatcherHandler.toHttpHandler(context);
//		ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
//		HttpServer server = HttpServer.create("localhost", 8080);
//		server.newHandler(adapter);
//		return server;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ReactiveEndPoints.class, args);
	}
}

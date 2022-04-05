package br.com.ADev;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


public class Server {

	public static void main(String[] args) throws IOException{
		String url = "http://localhost:8080/dev";
		ResourceConfig rc = new ResourceConfig().packages("br.com.ADev.controller"); 
		URI uri = URI.create(url);
		HttpServer server =  GrizzlyHttpServerFactory.createHttpServer(uri, rc);
		System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", url));
        System.in.read();
        server.stop();
	}

}

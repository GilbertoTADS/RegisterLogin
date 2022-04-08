package br.com.ADev;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


public class Server {
	private static String url = "http://localhost:8080/api/v1/";
	private static String resources = "br.com.ADev.controller";
	private static HttpServer server;
	
	public static void main(String[] args) throws IOException{
		server =  createServer();
		System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", url));
        System.in.read();
        server.stop();
	}
	
	private static URI configURL() { 
		return URI.create(url);	
	}
	
	private static ResourceConfig configResource() {
		ResourceConfig rc = new ResourceConfig().packages(resources);
		 return rc;
	}
	
	private static HttpServer createServer() {
		return GrizzlyHttpServerFactory.createHttpServer(configURL(), configResource());
	}
	

}

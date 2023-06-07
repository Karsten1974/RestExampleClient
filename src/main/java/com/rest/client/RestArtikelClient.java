package com.rest.client;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class RestArtikelClient {

    public static void main(String[] args) {
        System.out.println("RestArtikelClient start");

        example1WebTargetResponse();
        example2RESTEasy();

        System.out.println("RestArtikelClient beendet");
    }

    public static void example1WebTargetResponse() {
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target("http://localhost:8080/api/artikel/1");
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        System.out.println("value:"+value);
        response.close(); // You should close connections!
    }

    // RESTEasy with RESTful Web Services annotations
    public static void example2RESTEasy() {
        ResteasyClient client = (ResteasyClient)ClientBuilder.newClient();
        ResteasyWebTarget target = client.target("http://localhost:8080/");
        //ResteasyClient client = (ResteasyClient)ClientBuilder.newBuilder().register(ResteasyJackson2Provider.class).build();
        //ArtikelServiceInterface artikelService = client.target("http://localhost:8080/").register(ResteasyJackson2Provider.class).proxy(ArtikelServiceInterface.class); // .request().get();
        ArtikelServiceInterface artikelService = target.proxy(ArtikelServiceInterface.class);
        
        ArtikelDto art  = artikelService.receiveArtikel("1");
        System.out.println("Artikelnr:"+art.getArtikelnr());
        System.out.println("Bezeichnung:"+art.getBezeichnung());
    }
}

package com.rest.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public interface ArtikelServiceInterface {
    @GET
    @Path("/api/artikel/{artikelnr}")
    public ArtikelDto receiveArtikel(@PathParam(value = "artikelnr") String artikelnr);
}

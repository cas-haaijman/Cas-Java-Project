package com.example.yak;

import com.example.yak.data.Farm;
import com.example.yak.data.LabYak;
import com.example.yak.data.Stock;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/stock")
public class StockResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{intVal}")
    public Stock getStock(@PathParam("intVal") Integer daysElapsed) {
        Stock stock = Farm.getStockFromElapsedDays(daysElapsed);
        return stock;
    }
}
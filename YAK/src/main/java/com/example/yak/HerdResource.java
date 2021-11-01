package com.example.yak;

import com.example.yak.data.Farm;
import com.example.yak.data.Herd;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/herd")
public class HerdResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{intVal}")
    public Herd getStock(@PathParam("intVal") Integer daysElapsed) {
        return Farm.getHerdFromElapsedDays(daysElapsed);
    }
}
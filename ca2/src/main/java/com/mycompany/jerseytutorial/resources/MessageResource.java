/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.resources;

import com.mycompany.jerseytutorial.model.Message;
import com.mycompany.jerseytutorial.services.MessageService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author MTova-Izquierdo
 */
@Path("/messages")
public class MessageResource {
    
    MessageService messageService = new MessageService();
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }    
    
    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_XML)  
    public Message getMessage(@PathParam("messageId") int id) {
        return messageService.getMessage(id);
    }
}

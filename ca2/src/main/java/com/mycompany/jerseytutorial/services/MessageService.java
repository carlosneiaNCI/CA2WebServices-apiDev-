/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.services;

import com.mycompany.jerseytutorial.model.Message;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MTova-Izquierdo
 */
public class MessageService {
    
    public static List<Message> list = new ArrayList<>();
    
    public List<Message> getAllMessages() {
        Message m1 = new Message(1L, "Hello there", "Jack");
        Message m2 = new Message(2L, "Bye bye", "Dan");

        list.add(m1);
        list.add(m2);
        return list;
       
    }
    
    public Message getMessage(int id) {
        return list.get(id-1);
    }
    
    
}

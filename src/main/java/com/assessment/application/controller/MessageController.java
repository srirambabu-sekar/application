package com.assessment.application.controller;

import com.assessment.application.bean.Message;
import com.assessment.application.bean.UserDetails;
import com.assessment.application.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author srirambabu.sekar on 11-12-2020.
 */
@RestController
@RequestMapping(value = "/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    /**
     * Expects Two Params Object
     * Makes Service Call for Validating User Details
     */
    @RequestMapping(value = "/login/{userName}/{password}", method = RequestMethod.GET)
    public boolean login(@PathVariable("userName") String userName, @PathVariable("password") String password) throws Exception {

        UserDetails userDetails = new UserDetails();
        userDetails.setUserName(userName);
        userDetails.setPassword(password);

        return messageService.userDetails(userDetails);
    }


    /*
     * Making Service Call for Fetching Message Details
     */
    @RequestMapping(value = "/fetch", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> messages() throws Exception {
        return messageService.messages();
    }
}

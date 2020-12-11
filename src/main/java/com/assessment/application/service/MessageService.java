package com.assessment.application.service;

import com.assessment.application.bean.Message;
import com.assessment.application.bean.UserDetails;
import com.assessment.application.dao.MessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author srirambabu.sekar on 11-12-2020.
 */
@Service
public class MessageService {

    @Autowired
    MessageDAO messageDAO;

    /**
     * Validates User and Returns Boolean
     */
    public boolean userDetails(UserDetails userDetails) throws Exception {
        List<UserDetails> userDetailsList = messageDAO.login(); // Call for fetching All User Details
        for (UserDetails user:userDetailsList) {
            if (user.getUserName().equals(userDetails.getUserName()) && user.getPassword().equals(userDetails.getPassword())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Service for Fetching Messages
     */
    public List<Message> messages() throws Exception {
        return MessageDAO.messageList;
    }
}

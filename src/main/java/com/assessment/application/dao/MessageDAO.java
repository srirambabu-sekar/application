package com.assessment.application.dao;

import com.assessment.application.bean.Message;
import com.assessment.application.bean.UserDetails;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author srirambabu.sekar on 11-12-2020.
 */
@Component
public class MessageDAO {

    public static List<Message> messageList = new ArrayList<Message>(); // Global Variable


    /**
     * Reads User Details from CSV file
     */
    public List<UserDetails> login() throws Exception {
        List<UserDetails> userDetailsList = new ArrayList<UserDetails>();
        CSVReader csvReader = new CSVReader(new FileReader("dataFolder\\login.csv")); // File Path to read User Details
        String[] nextline;
        while ((nextline=csvReader.readNext())!=null) {
            UserDetails userDetails = new UserDetails();
            if (nextline.length>=2) {
                userDetails.setUserName(nextline[0]);
                userDetails.setPassword(nextline[1]);
                userDetailsList.add(userDetails);
            }
        }
        return userDetailsList;
    }

    /**
     * Method Gets Executed on Application Startup
     * Messages Data will be added to a Global Variable
     * Reads Data from CSV file
     */
    @PostConstruct
    public void messagesCSV() throws Exception {
        CSVReader csvReader = new CSVReader(new FileReader("dataFolder\\sample.csv")); // File Path to read Messages
        String[] nextline;
        while ((nextline=csvReader.readNext())!=null) {
            Message messageObj = new Message();
            if (nextline.length>=2) {
                messageObj.setMessageId(nextline[0]);
                messageObj.setMessageContent(nextline[1]);
                messageList.add(messageObj);
            }
        }
        messageList.remove(0);
    }
}

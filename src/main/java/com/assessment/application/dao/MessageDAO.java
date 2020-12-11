package com.assessment.application.dao;

import com.assessment.application.bean.UnstructuredMessage;
import com.assessment.application.bean.StructuredMessage;
import com.assessment.application.bean.UserDetails;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author srirambabu.sekar on 11-12-2020.
 */
@Component
public class MessageDAO {

    public static List<StructuredMessage> structuredMessageList = new ArrayList<StructuredMessage>(); // Global Variable

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
        List<UnstructuredMessage> unstructuredMessages = new ArrayList<UnstructuredMessage>();
        CSVReader csvReader = new CSVReader(new FileReader("dataFolder\\sample.csv")); // File Path to read Messages
        String[] nextline;
        while ((nextline=csvReader.readNext())!=null) {
            UnstructuredMessage messageObj = new UnstructuredMessage();
            if (nextline.length>=2) {
                messageObj.setMessageId(nextline[0]);
                messageObj.setMessageContent(nextline[1]);
                unstructuredMessages.add(messageObj);
            }
        }
        unstructuredMessages.remove(0);

        for (UnstructuredMessage me:
                unstructuredMessages) {
            List<String> messagesList = new ArrayList<String>(Arrays.asList(me.getMessageContent().split("\\r?\\n", -1)));
            messagesList.removeAll(Arrays.asList("", null));

            StructuredMessage messages = new StructuredMessage(messagesList);
            messages.setId(me.getMessageId());

            structuredMessageList.add(messages);
        }
    }
}

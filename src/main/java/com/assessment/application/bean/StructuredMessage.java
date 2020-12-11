package com.assessment.application.bean;

import java.util.List;

/**
 * @author srirambabu.sekar on 11-12-2020.
 */
public class StructuredMessage {
    private String id;
    private String messageId;
    private String date;
    private String from;
    private String to;
    private String subject;
    private String mimeVersion;
    private String contentType;
    private String contentTransferEncoding;
    private String xFrom;
    private String xTo;
    private String xCC;
    private String xBcc;
    private String xFolder;
    private String xOrigin;
    private String xFileName;
    private String context;

    public StructuredMessage(List<String> messages) {

        messageId = messages.get(0).split(":", 2).length>1? messages.get(0).split(":", 2)[1]:messages.get(0).split(":", 2)[0];
        date = messages.get(1).split(":", 2).length>1?messages.get(1).split(":", 2)[1]:messages.get(1).split(":", 2)[0];
        from = messages.get(2).split(":", 2).length>1?messages.get(2).split(":", 2)[1]:messages.get(2).split(":", 2)[0];
        to = messages.get(3).split(":", 2).length>1?messages.get(3).split(":", 2)[1]:messages.get(3).split(":", 2)[0];
        subject = messages.get(4).split(":", 2).length>1?messages.get(4).split(":", 2)[1]:messages.get(4).split(":", 2)[0];
        mimeVersion = messages.get(5).split(":", 2).length>1?messages.get(5).split(":", 2)[1]:messages.get(5).split(":", 2)[0];
        contentType = messages.get(6).split(":", 2).length>1?messages.get(6).split(":", 2)[1]:messages.get(6).split(":", 2)[0];
        contentTransferEncoding = messages.get(7).split(":", 2).length>1?messages.get(7).split(":", 2)[1]:messages.get(7).split(":", 2)[0];
        xFrom = messages.get(8).split(":", 2).length>1?messages.get(8).split(":", 2)[1]:messages.get(8).split(":", 2)[0];
        xTo = messages.get(9).split(":", 2).length>1?messages.get(9).split(":", 2)[1]:messages.get(9).split(":", 2)[0];
        xCC = messages.get(10).split(":", 2).length>1?messages.get(10).split(":", 2)[1]:messages.get(10).split(":", 2)[0];
        xBcc = messages.get(11).split(":", 2).length>1?messages.get(11).split(":", 2)[1]:messages.get(11).split(":", 2)[0];
        xFolder = messages.get(12).split(":", 2).length>1?messages.get(12).split(":", 2)[1]:messages.get(12).split(":", 2)[0];
        xOrigin = messages.get(13).split(":", 2).length>1?messages.get(13).split(":", 2)[1]:messages.get(13).split(":", 2)[0];
        xFileName = messages.get(14).split(":", 2).length>1?messages.get(14).split(":", 2)[1]:messages.get(14).split(":", 2)[0];
        String st = "";
        for (int i=15;i<messages.size();i++) {
            st = st.concat(messages.get(i));
        }
        context = st;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMimeVersion() {
        return mimeVersion;
    }

    public void setMimeVersion(String mimeVersion) {
        this.mimeVersion = mimeVersion;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentTransferEncoding() {
        return contentTransferEncoding;
    }

    public void setContentTransferEncoding(String contentTransferEncoding) {
        this.contentTransferEncoding = contentTransferEncoding;
    }

    public String getxFrom() {
        return xFrom;
    }

    public void setxFrom(String xFrom) {
        this.xFrom = xFrom;
    }

    public String getxTo() {
        return xTo;
    }

    public void setxTo(String xTo) {
        this.xTo = xTo;
    }

    public String getxCC() {
        return xCC;
    }

    public void setxCC(String xCC) {
        this.xCC = xCC;
    }

    public String getxBcc() {
        return xBcc;
    }

    public void setxBcc(String xBcc) {
        this.xBcc = xBcc;
    }

    public String getxFolder() {
        return xFolder;
    }

    public void setxFolder(String xFolder) {
        this.xFolder = xFolder;
    }

    public String getxOrigin() {
        return xOrigin;
    }

    public void setxOrigin(String xOrigin) {
        this.xOrigin = xOrigin;
    }

    public String getxFileName() {
        return xFileName;
    }

    public void setxFileName(String xFileName) {
        this.xFileName = xFileName;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}

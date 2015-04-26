package pl.edu.agh.iosr.realestatebroker.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by grzegorz on 2015-04-26.
 */
public class Message implements Serializable {

    private Integer id;
    private Integer conversationId;
    private EstateOffer estateOffer;
    private User sender;
    private User recipient;
    private String topic;
    private String content;
    private Date sendTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConversationId() {
        return conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    public EstateOffer getEstateOffer() {
        return estateOffer;
    }

    public void setEstateOffer(EstateOffer estateOffer) {
        this.estateOffer = estateOffer;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}

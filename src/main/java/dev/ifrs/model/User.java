package dev.ifrs.model;

import java.util.ArrayList;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.ManyToMany;
import java.util.List;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class User extends PanacheEntity
{
    private String name;
    @ManyToMany
    @JsonBackReference
    private List<Channel> channels;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Message> messages;
    
    public User() {
        this.channels = new ArrayList<Channel>();
        this.messages = new ArrayList<Message>();
    }
    
    public void addChannel(final Channel ch) {
        this.channels.add(ch);
    }
    
    public void addMessage(final Message ms) {
        this.messages.add(ms);
    }
    
    public String getName() {
        return this.name;
    }
    
    public List<Channel> getChannels() {
        return this.channels;
    }
    
    public List<Message> getMessages() {
        return this.messages;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setChannels(final List<Channel> channels) {
        this.channels = channels;
    }
    
    public void setMessages(final List<Message> messages) {
        this.messages = messages;
    }
}

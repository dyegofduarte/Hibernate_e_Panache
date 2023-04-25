package dev.ifrs.model;

import java.util.ArrayList;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.ManyToMany;
import java.util.List;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Channel extends PanacheEntity
{
    private String hash;
    @ManyToMany(mappedBy = "channels")
    @JsonManagedReference
    private List<User> users;
    @OneToMany
    @JoinColumn(name = "channel_id")
    private List<Message> messages;
    
    public Channel() {
        this.users = new ArrayList<User>();
        this.messages = new ArrayList<Message>();
    }
    
    public void addUser(final User user) {
        this.users.add(user);
    }
    
    public void addMessage(final Message ms) {
        this.messages.add(ms);
    }
    
    public String getHash() {
        return this.hash;
    }
    
    public List<User> getUsers() {
        return this.users;
    }
    
    public List<Message> getMessages() {
        return this.messages;
    }
    
    public void setHash(final String hash) {
        this.hash = hash;
    }
    
    public void setUsers(final List<User> users) {
        this.users = users;
    }
    
    public void setMessages(final List<Message> messages) {
        this.messages = messages;
    }
}
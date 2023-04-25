package dev.ifrs.model;

import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Message extends PanacheEntity
{
    private String text;
    
    public String getText() {
        return this.text;
    }
    
    public void setText(final String text) {
        this.text = text;
    }
}
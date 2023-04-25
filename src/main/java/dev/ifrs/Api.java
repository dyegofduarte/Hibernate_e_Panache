package dev.ifrs;

import javax.transaction.Transactional;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import dev.ifrs.model.Message;
import dev.ifrs.model.Channel;
import dev.ifrs.model.User;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;

@Path("/user")
public class Api
{
    @Path("/create")
    @POST
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/json" })
    @Transactional
    public User createUser(@FormParam("name") final String name) {
        final Channel ch = new Channel();
        ch.setHash("QUALQUER HASH");
        ch.persist();
        final User user = new User();
        user.setName(name);
        user.addChannel(ch);
        user.persist();
        final Message ms = new Message();
        ms.setText("TEXTO DA MENSAGEM");
        ch.addMessage(ms);
        ch.persist();
        ms.persist();
        return user;
    }
}
package perfectcell.api.users;

/**
 * Created by gnut3ll4 on 22/01/16.
 */

import perfectcell.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.ArrayList;

@Path("users")
public class UserResources {

    @GET
    @Path("/list")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<User> getUsers() {
        User user = new User();
        user.setName("john doe");
        user.setDescription("potato");
        ArrayList<String> needs = new ArrayList<>();
        needs.add("i need you");
        user.setNeeds(needs);

        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        return users;
    }

    @GET
    @Path("/verify")
    @Produces(MediaType.TEXT_PLAIN)
    public Response verifyRESTService(InputStream incomingData) {
        String result = "CrunchifyRESTService Successfully started..";

        // return HTTP response 200 in case of success
        return Response.status(200).entity(result).build();
    }
}
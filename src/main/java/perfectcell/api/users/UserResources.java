package perfectcell.api.users;

import perfectcell.model.User;
import perfectcell.repositories.DbPersistance;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("users")
public class UserResources {

    private DbPersistance dbPersistance = DbPersistance.getInstance();

    @GET
    @Path("/list")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<User> listUsers() {
        return dbPersistance.userRepository.List();
    }

    @GET
    @Path("/getuser/{key}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<User> getUser(@PathParam("key")String key) {
        ArrayList<User> user = new ArrayList<>();
        user.add(dbPersistance.userRepository.Get(key));
        return user;
    }

    @GET
    @Path("/deleteuser/{key}")

    public boolean deleteUser(@PathParam("key")String key) {
        return dbPersistance.userRepository.Delete(key);
    }

    @POST
    @Path("/adduser")
    public Response AddUser(User user) {
        String output = user.toString();
        dbPersistance.userRepository.Add(user);
        return Response.status(200).entity(output).build();
    }
}
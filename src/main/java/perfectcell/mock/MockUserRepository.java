package perfectcell.mock;

import perfectcell.model.User;
import perfectcell.repositories.ICrudRepository;

import java.util.ArrayList;

/**
 * Created by jjgha on 2016-02-13.
 */
public class MockUserRepository implements ICrudRepository<User> {
    ArrayList<User> usersList;
    ArrayList<String> needsList;


    public MockUserRepository() {
        needsList = new ArrayList<>();
        usersList = new ArrayList<User>();

        needsList.add("Besoin d'aide pour faire mes devoirs en INF111");
        needsList.add("Besoin de bénévoles pour l'AMC");
        needsList.add("All you need is love! :D");

        initialize();
    }

    private void initialize() {
        User user1 = new User();
        user1.setDescription(
                "Bacon ipsum dolor amet andouille corned beef beef ribs leberkas fatback." +
                        " Spare ribs salami turducken, turkey kielbasa t-bone chuck andouille." +
                        "Tongue kevin corned beef turducken pork loin cow drumstick doner jerky tail andouille pig." +
                        " Tenderloin biltong filet mignon beef ribs. Meatball kevin chuck boudin," +
                        " swine porchetta flank sirloin hamburger frankfurter sausage.");
        user1.setName("John Doe");
        user1.setNeeds(needsList);

        User user2 = new User();
        user2.setDescription(
                "Bacon ipsum dolor amet andouille corned beef beef ribs leberkas fatback." +
                        " Spare ribs salami turducken, turkey kielbasa t-bone chuck andouille." +
                        "Tongue kevin corned beef turducken pork loin cow drumstick doner jerky tail andouille pig." +
                        " Tenderloin biltong filet mignon beef ribs. Meatball kevin chuck boudin," +
                        " swine porchetta flank sirloin hamburger frankfurter sausage.");
        user2.setName("John Doe");
        user2.setNeeds(needsList);

        User user3 = new User();
        user3.setDescription(
                "Bacon ipsum dolor amet andouille corned beef beef ribs leberkas fatback." +
                        " Spare ribs salami turducken, turkey kielbasa t-bone chuck andouille." +
                        "Tongue kevin corned beef turducken pork loin cow drumstick doner jerky tail andouille pig." +
                        " Tenderloin biltong filet mignon beef ribs. Meatball kevin chuck boudin," +
                        " swine porchetta flank sirloin hamburger frankfurter sausage.");
        user3.setName("John Doe");
        user3.setNeeds(needsList);

        User user4 = new User();
        user4.setDescription(
                "Bacon ipsum dolor amet andouille corned beef beef ribs leberkas fatback." +
                        " Spare ribs salami turducken, turkey kielbasa t-bone chuck andouille." +
                        "Tongue kevin corned beef turducken pork loin cow drumstick doner jerky tail andouille pig." +
                        " Tenderloin biltong filet mignon beef ribs. Meatball kevin chuck boudin," +
                        " swine porchetta flank sirloin hamburger frankfurter sausage.");
        user4.setName("John Doe");
        user4.setNeeds(needsList);

        usersList.add(new User() {
        });
    }


    @Override
    public User Add(User model) {
        usersList.add(model);
        return model;
    }

    @Override
    public User Edit(User model) {
        for (int i = 0; i < usersList.size(); ++i) {
            if (usersList.get(i).getName().equals(model.getName())) {
                usersList.remove(i);
                usersList.add(model);
                return model;
            }
        }
        return null;
    }

    @Override
    public boolean Delete(User model) {
        for (int i = 0; i < usersList.size(); ++i) {
            if (usersList.get(i).getName().equals(model.getName())) {
                usersList.remove(i);
                usersList.add(model);
                return true;
            }
        }
        return false;
    }

    @Override
    public User Get(String name) {
        for (User user:usersList) {
            if (user.getName().equals(name)){
             return user;
            }
        }
        return null;
    }

    @Override
    public ArrayList<User> List() {
        return usersList;
    }
}

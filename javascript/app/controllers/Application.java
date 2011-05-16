package controllers;

import models.User;
import play.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

   public static void users() {
      List<User> users = new ArrayList<User>();
      users.add(new User("Odersky"));
      users.add(new User("Boner"));
      users.add(new User("Gosling"));
      users.add(new User("Strachan"));
      users.add(new User("Nutter"));
      users.add(new User("Bini"));
      users.add(new User("Ford"));
      renderJSON(users);
   }

}

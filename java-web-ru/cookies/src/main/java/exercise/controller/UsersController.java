package exercise.controller;

import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");

        var token = Security.generateToken();
        ctx.cookie("token", token);
        var page = new User(firstName, lastName, email, password, token);
        UserRepository.save(page);
        var id = page.getId();
        ctx.redirect(NamedRoutes.userPath(id));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var token = ctx.cookie("token");
        var user = UserRepository
                .find(id)

                .orElseThrow(() -> new NotFoundResponse("User not found!"));
        if (token != null && token.equals(user.getToken())) {
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        } else {
            ctx.render(NamedRoutes.buildUserPath());
        }
    }
    // END
}

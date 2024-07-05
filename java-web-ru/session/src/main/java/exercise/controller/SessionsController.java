package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;

import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        var name = ctx.sessionAttribute("currentUser");
        var page = new MainPage(name);
        ctx.render("index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new LoginPage(null, null);
        ctx.render("build.jte", model("page", page));
    }

    public static void login(Context ctx) {
        try {
            var login = ctx.formParamAsClass("name", String.class)
                    .check(UsersRepository::existsByName, "Wrong username or password")
                    .get();

            var password = ctx.formParam("password");
            var encPassword = Security.encrypt(password);
            var userLogin = UsersRepository.findByName(login);

            if (userLogin.getName() != null && userLogin.getPassword().equals(encPassword)) {
                ctx.sessionAttribute("currentUser", login);
                ctx.redirect("/");
            } else {
                throw new NotFoundResponse("Wrong username or password");
            }
        } catch (NotFoundResponse e) {
            var login = ctx.formParam("name");
            var page = new LoginPage(login, e.getMessage());
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void logout(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }
    // END
}

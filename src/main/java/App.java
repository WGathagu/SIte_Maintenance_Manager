import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.io.IOException;
import java.util.*;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) throws IOException {

        //home page
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //create engineer page
        get("/engineers/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("uniqueId", request.session().attribute("uniqueId"));
            return new ModelAndView(model, "engineerform.hbs");
        }, new HandlebarsTemplateEngine());

        //submit a new engineer - redirect to success page
        post("/engineers/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Date newDate = new Date();
            String name = request.queryParams("engineerName");
            String email = request.queryParams("engineerEmail");
            String sitename = request.queryParams("siteName");
            Engineer newEngineer = new Engineer(name, email, sitename, newDate);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //create site page
        get("/sites/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("uniqueId", request.session().attribute("uniqueId"));
            return new ModelAndView(model, "siteform.hbs");
        }, new HandlebarsTemplateEngine());

        //new site page
        get("/sites/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Engineer> sitelessEnginner = new ArrayList<>();
            for (Engineer engineer : Engineer.all()) {
                if (engineer.getSiteName().equals("")) {
                    sitelessEnginner.add(engineer);
                }
            }
            model.put("sitelessEnginner", sitelessEnginner);
            return new ModelAndView(model, "siteform.hbs");
        }, new HandlebarsTemplateEngine());

        //create a new site page - redirect to success page
        post("/sites/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Engineer> sitelessEnginner = new ArrayList<>();
            for (Engineer engineer : Engineer.all()) {
                if (engineer.getSites().equals("")) {
                    sitelessEnginner.add(engineer);
                }
            }

            String name = request.queryParams("siteName");
            int uniqueId = Integer.parseInt(request.queryParams("uniqueId"));
            Site newSquad = new Site(name, uniqueId );
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        post("/success", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String uniqueId = request.queryParams("uniqueId");
            request.session().attribute("uniqueId", uniqueId);
            model.put("uniqueId", uniqueId);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //display engineers list
        get("/engineers", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("engineer", Engineer.all());
            model.put("uniqueId", request.session().attribute("uniqueId"));
            return new ModelAndView(model, "engineerlist.hbs");
        }, new HandlebarsTemplateEngine());

        //display sites list
        get("/sites", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("site", Site.all());
            model.put("uniqueId", request.session().attribute("uniqueId"));
            return new ModelAndView(model, "sitelist.hbs");
        }, new HandlebarsTemplateEngine());

    }
}

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.SparkBase.setPort;

import com.google.gson.Gson;
import spark.Request;

public class SparkMainRest {
    public static void main(String[] args) {

        setPort(8081);

        final RemindService remindService = new RemindServiceMapImpl();

        post("/reminder/create", (request, response) -> {
            response.type("application/json");

            Remind remind = new Gson().fromJson(request.body(), Remind.class);
            remindService.addRemind(remind);

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
        });

        get("/reminder/get-all", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(remindService.getRemindList())));
        });

        get("/reminder/get-by-id/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(remindService.getRemind(request.params(":id")))));
        });

        put("/reminder/edit/:id", (request, response) -> {
            response.type("application/json");

            Remind toEdit = new Gson().fromJson(request.body(), Remind.class);
            Remind editedRemind = null;
            try {
                editedRemind = remindService.editRemind(toEdit);
            } catch (RemindException e) {
                e.printStackTrace();
            }

            if (editedRemind != null) {
                return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(editedRemind)));
            } else {
                return new Gson().toJson(new StandardResponse(StatusResponse.ERROR, new Gson().toJson("Remind not found or error in edit")));
            }
        });

        delete("/reminder/:id", (request, response) -> {
            response.type("application/json");

            remindService.deleteRemind(request.params(":id"));
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "remind deleted"));
        });

        options("/reminder/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, (remindService.isRemindExist(request.params(":id"))) ? "Remind exists" : "Remind does not exists"));
        });
    }
}
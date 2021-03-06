package si.fri.rso.projekt.apartment.api.v1.resources;

import com.kumuluz.ee.common.runtime.EeRuntime;

import javax.enterprise.context.ApplicationScoped;
import javax.print.DocFlavor;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Path("info")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class InfoResource {
    private Logger log = Logger.getLogger(DemoResource.class.getName());
    @GET
    public Response getInfo() {
        log.info("Getting project INFO");
        JSONObject json = new JSONObject();

        JSONArray clani = new JSONArray();
        clani.put("np4826");
        clani.put("kk7072");

        JSONArray mikrostoritve = new JSONArray();
        mikrostoritve.put("http://35.195.205.42:8082/v1/user/");
        mikrostoritve.put("http://35.205.101.132:8081/v1/apartment");

        JSONArray github = new JSONArray();
        github.put("https://github.com/np4826/projekt-apartment");

        JSONArray travis = new JSONArray();
        travis.put("https://travis-ci.org/np4826/projekt-apartment");

        JSONArray dockerhub = new JSONArray();
        dockerhub.put("https://hub.docker.com/r/kknp/rso-user/");
        dockerhub.put("https://hub.docker.com/r/kknp/rso-apartment/");

        json.put("clani", clani);
        json.put("opis_projekta", "Nas projekt implementira aplikacijo za oddajo nepremicnin.");
        json.put("mikrostoritve", mikrostoritve);
        json.put("github", github);
        json.put("travis", travis);
        json.put("dockerhub", dockerhub);

        return Response.ok(json.toString()).build();
    }
}


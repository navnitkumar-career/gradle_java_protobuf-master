package app.controller;


import app.proto.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class ViewController {
    @RequestMapping(value = "/withprotobuf", method = RequestMethod.GET, produces = "application/x-protobuf")
    public  @ResponseBody Person.result getProtoExample(@RequestParam(name="message", required=false, defaultValue="default") String message) {

        Person.result result = Person.result.newBuilder().setStatus(true).setMessage(message).build();

        return result;
    }

    @RequestMapping(value = "/withjson", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Person.result getjsonExample(@RequestParam(name="message", required=false, defaultValue="default") String message) {

        Person.result result = Person.result.newBuilder().setStatus(true).setMessage(message).build();

        return result;
    }
}

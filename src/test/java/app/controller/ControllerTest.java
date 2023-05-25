package app.controller;

import app.SpringApp;
import app.proto.Person;
import com.googlecode.protobuf.format.JsonFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringApp.class)
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkProtobuf_response() throws Exception{
        MvcResult result = this.mockMvc.perform(get("/withprotobuf")).andExpect(status().is(200)).andReturn();
       // System.out.print("This is bad "+result.getResponse().getContentAsString().getBytes());
        JsonFormat jsonFormat = new JsonFormat();
         Person.result  result1 = Person.result.parseFrom(result.getResponse().getContentAsString().getBytes());
      System.out.println( jsonFormat.printToString(result1));


    }


}

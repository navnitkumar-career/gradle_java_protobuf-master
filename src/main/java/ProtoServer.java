import app.proto.Person;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.protobuf.InvalidProtocolBufferException;

public class ProtoServer {

  public static void main(String args[]) throws InvalidProtocolBufferException {

      Person.person person = Person.person.newBuilder().setAge(32).setName("pravanjan").build();


      System.out.println(person.toString());


  }

   public Person.result addperson(Person.person person){

          Person.result result = Person.result.newBuilder().setStatus(true).setMessage("This is success fully integrated").build();

       return result;

      }





}
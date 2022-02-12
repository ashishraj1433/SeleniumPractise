import Student.Pojo.StudentPojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.time.Clock;

import static io.restassured.RestAssured.*;

@DisplayName("Display name of people")
@Test

public class ApiTestPractise {

       public void getAllData() throws JsonProcessingException {
                              String response = given()
                              .when()
                              .get("https://gorest.co.in/public/v2/users/2049")
                              .prettyPrint();
           //.then();

             ObjectMapper om = new ObjectMapper();
             StudentPojo studentPojo = om.readValue(response, StudentPojo.class);
           // Assert.assertEquals(studentPojo.getGender(),"female");
             SoftAssert softAssert = new SoftAssert();
             softAssert.assertEquals(studentPojo.getGender(),"female");

            System.out.println(studentPojo.getGender());
            System.out.println(studentPojo.getEmail());
           System.out.println(studentPojo.getName());
           System.out.println(studentPojo.getId());


/*
              public class Root{
                     public int id;
                     public String name;
                     public String email;
                     public String gender;
                     public String status;
              }
*/




       }
}

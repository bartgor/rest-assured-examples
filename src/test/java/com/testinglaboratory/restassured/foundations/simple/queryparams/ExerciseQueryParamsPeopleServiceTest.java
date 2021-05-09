package com.testinglaboratory.restassured.foundations.simple.queryparams;

//TODO exercise query parameters

import java.util.List;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.Test;
import scala.collection.Map;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Create tests for:
 * /get_all_people_sliced
 * /get_all_people_paged
 * /get_all_people_by
 * endpoints
 */
@Slf4j
public class ExerciseQueryParamsPeopleServiceTest {

    @Test
    public void shouldGetAllPeopleSliced() {
        Response response =
                given().queryParam("from_number", 0)
                        .queryParam("up_to_number", 5)
                        .when()
                        .get("/get_all_people_sliced")
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.SC_OK).extract().response();
        List<Map<String, String>> people = response.body().jsonPath().getList(".");
        log.info(String.valueOf(people));
        assertThat(people).as("People should be sliced from 0 to 5 ")
                .hasSizeBetween(0, 5)
                .hasSize(6);
    }

    @Test
    public void shouldGetPagedPeople() {
        Response response =
                given().queryParam("page_size", 20)
                        .when()
                        .get("/get_all_people_paged")
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.SC_OK).extract().response();
        List<Map<String, String>> people = response.body().jsonPath().getList(".");
        log.info(String.valueOf(people));
        assertThat(people).as("People should be paged by 20 people")
                .hasSize(20);
    }


    @Test
    public void shouldGetPeopleBy() {
        Response response =
                given().queryParam("first_name", "Monika")
                        .when()
                        .get("/get_people_by")
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.SC_OK).extract().response();
        List<Map<String, String>> people = response.body().jsonPath().getList(".");
        log.info(String.valueOf(people));
        people.forEach(stringStringMap -> assertThat(stringStringMap.get("first_name")).isEqualTo("Monika"));
    }
}

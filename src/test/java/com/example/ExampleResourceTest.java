package com.example;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

@QuarkusTest
class ExampleResourceTest {

	@Test
	void testMetricsForUnauthorizedRequest() {
		var pathParam = "foo";

		given()
				.when().get("/hello/{message}", pathParam)
				.then()
				.statusCode(403);

		given()
				.when().get("/q/metrics")
				.then()
				.statusCode(200)
				.body(
						allOf(
								not(containsString("/hello/" + pathParam)),
								containsString("/hello/{message}")
						)

				);
	}

}

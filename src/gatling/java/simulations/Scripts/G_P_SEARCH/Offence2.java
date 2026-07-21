
import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class Offence2 extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("https://opal-frontend.test.apps.hmcts.net")
      .inferHtmlResources()
      .acceptHeader("application/json, text/plain, */*")
      .acceptEncodingHeader("gzip, deflate, br")
      .acceptLanguageHeader("en-US,en;q=0.9")
      .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/150.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_0 = new HashMap<>();
    headers_0.put("Sec-Fetch-Dest", "empty");
    headers_0.put("Sec-Fetch-Mode", "cors");
    headers_0.put("Sec-Fetch-Site", "same-origin");
    headers_0.put("cache-control", "no-cache");
    headers_0.put("expires", "0");
    headers_0.put("pragma", "no-cache");
    headers_0.put("request-id", "|33d0a2908f1643b18e6e68c2bd94f42b.c6c734f579074fb3");
    headers_0.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_0.put("sec-ch-ua-mobile", "?0");
    headers_0.put("sec-ch-ua-platform", "Windows");
    headers_0.put("traceparent", "00-33d0a2908f1643b18e6e68c2bd94f42b-c6c734f579074fb3-01");
    headers_0.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_1 = new HashMap<>();
    headers_1.put("Sec-Fetch-Dest", "empty");
    headers_1.put("Sec-Fetch-Mode", "cors");
    headers_1.put("Sec-Fetch-Site", "same-origin");
    headers_1.put("request-id", "|33d0a2908f1643b18e6e68c2bd94f42b.72096c4afe6040d6");
    headers_1.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_1.put("sec-ch-ua-mobile", "?0");
    headers_1.put("sec-ch-ua-platform", "Windows");
    headers_1.put("traceparent", "00-33d0a2908f1643b18e6e68c2bd94f42b-72096c4afe6040d6-01");
    headers_1.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_2 = new HashMap<>();
    headers_2.put("Sec-Fetch-Dest", "empty");
    headers_2.put("Sec-Fetch-Mode", "cors");
    headers_2.put("Sec-Fetch-Site", "same-origin");
    headers_2.put("request-id", "|33d0a2908f1643b18e6e68c2bd94f42b.0215d0972d3247aa");
    headers_2.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_2.put("sec-ch-ua-mobile", "?0");
    headers_2.put("sec-ch-ua-platform", "Windows");
    headers_2.put("traceparent", "00-33d0a2908f1643b18e6e68c2bd94f42b-0215d0972d3247aa-01");
    headers_2.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_3 = new HashMap<>();
    headers_3.put("Sec-Fetch-Dest", "empty");
    headers_3.put("Sec-Fetch-Mode", "cors");
    headers_3.put("Sec-Fetch-Site", "same-origin");
    headers_3.put("cache-control", "no-cache");
    headers_3.put("expires", "0");
    headers_3.put("pragma", "no-cache");
    headers_3.put("request-id", "|33d0a2908f1643b18e6e68c2bd94f42b.17971735e5c14208");
    headers_3.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_3.put("sec-ch-ua-mobile", "?0");
    headers_3.put("sec-ch-ua-platform", "Windows");
    headers_3.put("traceparent", "00-33d0a2908f1643b18e6e68c2bd94f42b-17971735e5c14208-01");
    headers_3.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_4 = new HashMap<>();
    headers_4.put("Sec-Fetch-Dest", "empty");
    headers_4.put("Sec-Fetch-Mode", "cors");
    headers_4.put("Sec-Fetch-Site", "same-origin");
    headers_4.put("request-id", "|33d0a2908f1643b18e6e68c2bd94f42b.092fdf48fc134070");
    headers_4.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_4.put("sec-ch-ua-mobile", "?0");
    headers_4.put("sec-ch-ua-platform", "Windows");
    headers_4.put("traceparent", "00-33d0a2908f1643b18e6e68c2bd94f42b-092fdf48fc134070-01");
    headers_4.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_5 = new HashMap<>();
    headers_5.put("Sec-Fetch-Dest", "empty");
    headers_5.put("Sec-Fetch-Mode", "cors");
    headers_5.put("Sec-Fetch-Site", "same-origin");
    headers_5.put("request-id", "|33d0a2908f1643b18e6e68c2bd94f42b.8e2b5b9f3c784340");
    headers_5.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_5.put("sec-ch-ua-mobile", "?0");
    headers_5.put("sec-ch-ua-platform", "Windows");
    headers_5.put("traceparent", "00-33d0a2908f1643b18e6e68c2bd94f42b-8e2b5b9f3c784340-01");
    headers_5.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_6 = new HashMap<>();
    headers_6.put("Sec-Fetch-Dest", "empty");
    headers_6.put("Sec-Fetch-Mode", "cors");
    headers_6.put("Sec-Fetch-Site", "same-origin");
    headers_6.put("request-id", "|33d0a2908f1643b18e6e68c2bd94f42b.8d03c4e1d4124877");
    headers_6.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_6.put("sec-ch-ua-mobile", "?0");
    headers_6.put("sec-ch-ua-platform", "Windows");
    headers_6.put("traceparent", "00-33d0a2908f1643b18e6e68c2bd94f42b-8d03c4e1d4124877-01");
    headers_6.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_7 = new HashMap<>();
    headers_7.put("Sec-Fetch-Dest", "empty");
    headers_7.put("Sec-Fetch-Mode", "cors");
    headers_7.put("Sec-Fetch-Site", "same-origin");
    headers_7.put("request-id", "|33d0a2908f1643b18e6e68c2bd94f42b.f740f37f516a426b");
    headers_7.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_7.put("sec-ch-ua-mobile", "?0");
    headers_7.put("sec-ch-ua-platform", "Windows");
    headers_7.put("traceparent", "00-33d0a2908f1643b18e6e68c2bd94f42b-f740f37f516a426b-01");
    headers_7.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_8 = new HashMap<>();
    headers_8.put("Cache-Control", "max-age=0");
    headers_8.put("Origin", "https://opal-frontend.test.apps.hmcts.net");
    headers_8.put("Sec-Fetch-Dest", "empty");
    headers_8.put("Sec-Fetch-Mode", "cors");
    headers_8.put("Sec-Fetch-Site", "same-origin");
    headers_8.put("business-unit-id", "38");
    headers_8.put("content-digest", "sha-512=:lhSQklvv2dOO526wI3git0Lj5aD4T4vXFGqeVrU5gQ9Otmn1ebcpMYKcgKfKwKHPy8VpxKei34V6PajCkoleVA==:");
    headers_8.put("content-type", "application/json");
    headers_8.put("if-match", "1");
    headers_8.put("request-id", "|570680a1057c4c8382b4b11271cb26c3.821989aa9bd84796");
    headers_8.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_8.put("sec-ch-ua-mobile", "?0");
    headers_8.put("sec-ch-ua-platform", "Windows");
    headers_8.put("traceparent", "00-570680a1057c4c8382b4b11271cb26c3-821989aa9bd84796-01");
    headers_8.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_9 = new HashMap<>();
    headers_9.put("Sec-Fetch-Dest", "empty");
    headers_9.put("Sec-Fetch-Mode", "cors");
    headers_9.put("Sec-Fetch-Site", "same-origin");
    headers_9.put("cache-control", "no-cache");
    headers_9.put("expires", "0");
    headers_9.put("pragma", "no-cache");
    headers_9.put("request-id", "|570680a1057c4c8382b4b11271cb26c3.d1d4550ba7dc479b");
    headers_9.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_9.put("sec-ch-ua-mobile", "?0");
    headers_9.put("sec-ch-ua-platform", "Windows");
    headers_9.put("traceparent", "00-570680a1057c4c8382b4b11271cb26c3-d1d4550ba7dc479b-01");
    headers_9.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_10 = new HashMap<>();
    headers_10.put("Sec-Fetch-Dest", "empty");
    headers_10.put("Sec-Fetch-Mode", "cors");
    headers_10.put("Sec-Fetch-Site", "same-origin");
    headers_10.put("request-id", "|570680a1057c4c8382b4b11271cb26c3.0ae5054bc43048f1");
    headers_10.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_10.put("sec-ch-ua-mobile", "?0");
    headers_10.put("sec-ch-ua-platform", "Windows");
    headers_10.put("traceparent", "00-570680a1057c4c8382b4b11271cb26c3-0ae5054bc43048f1-01");
    headers_10.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_11 = new HashMap<>();
    headers_11.put("Sec-Fetch-Dest", "empty");
    headers_11.put("Sec-Fetch-Mode", "cors");
    headers_11.put("Sec-Fetch-Site", "same-origin");
    headers_11.put("request-id", "|570680a1057c4c8382b4b11271cb26c3.fb7a88962e4d4e7c");
    headers_11.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_11.put("sec-ch-ua-mobile", "?0");
    headers_11.put("sec-ch-ua-platform", "Windows");
    headers_11.put("traceparent", "00-570680a1057c4c8382b4b11271cb26c3-fb7a88962e4d4e7c-01");
    headers_11.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_12 = new HashMap<>();
    headers_12.put("Sec-Fetch-Dest", "empty");
    headers_12.put("Sec-Fetch-Mode", "cors");
    headers_12.put("Sec-Fetch-Site", "same-origin");
    headers_12.put("request-id", "|570680a1057c4c8382b4b11271cb26c3.b3b4f564ac5940a1");
    headers_12.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_12.put("sec-ch-ua-mobile", "?0");
    headers_12.put("sec-ch-ua-platform", "Windows");
    headers_12.put("traceparent", "00-570680a1057c4c8382b4b11271cb26c3-b3b4f564ac5940a1-01");
    headers_12.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_13 = new HashMap<>();
    headers_13.put("Sec-Fetch-Dest", "empty");
    headers_13.put("Sec-Fetch-Mode", "cors");
    headers_13.put("Sec-Fetch-Site", "same-origin");
    headers_13.put("request-id", "|77431ef3e7ee469c835c651fed883f44.329c5374198b4ff2");
    headers_13.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_13.put("sec-ch-ua-mobile", "?0");
    headers_13.put("sec-ch-ua-platform", "Windows");
    headers_13.put("traceparent", "00-77431ef3e7ee469c835c651fed883f44-329c5374198b4ff2-01");
    headers_13.put("want-content-digest", "sha-512");


    ScenarioBuilder scn = scenario("Offence2")
      .exec(
        http("request_0")
          .get("/sso/authenticated")
          .headers(headers_0)
          .resources(
            http("request_1")
              .get("/api/user-state")
              .headers(headers_1),
            http("request_2")
              .get("/api/user-state")
              .headers(headers_2),
            http("request_3")
              .get("/sso/authenticated")
              .headers(headers_3),
            http("request_4")
              .get("/api/user-state")
              .headers(headers_4),
            http("request_5")
              .get("/api/user-state")
              .headers(headers_5),
            http("request_6")
              .get("/api/user-state")
              .headers(headers_6),
            http("request_7")
              .get("/opal-fines-service/defendant-accounts/60000000001754/header-summary")
              .headers(headers_7)
          )
      )
      .pause(21)
      .exec(
        http("request_8")
          .put("/opal-fines-service/defendant-accounts/60000000001754/defendant-account-parties/60000000001784")
          .headers(headers_8)
          .body(RawFileBody("offence2/0008_request.json"))
          .resources(
            http("request_9")
              .get("/sso/authenticated")
              .headers(headers_9),
            http("request_10")
              .get("/api/user-state")
              .headers(headers_10),
            http("request_11")
              .get("/api/user-state")
              .headers(headers_11),
            http("request_12")
              .get("/opal-fines-service/defendant-accounts/60000000001754/header-summary")
              .headers(headers_12),
            http("request_13")
              .get("/opal-fines-service/defendant-accounts/60000000001754/defendant-account-parties/60000000001784")
              .headers(headers_13)
          )
      );

	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}

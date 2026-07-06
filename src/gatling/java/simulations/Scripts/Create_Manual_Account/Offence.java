
// import java.time.Duration;
// import java.util.*;

// import io.gatling.javaapi.core.*;
// import io.gatling.javaapi.http.*;
// import io.gatling.javaapi.jdbc.*;

// import static io.gatling.javaapi.core.CoreDsl.*;
// import static io.gatling.javaapi.http.HttpDsl.*;
// import static io.gatling.javaapi.jdbc.JdbcDsl.*;

// public class Offence extends Simulation {

//   {
//     HttpProtocolBuilder httpProtocol = http
//       .baseUrl("https://opal-frontend.test.apps.hmcts.net")
//       .inferHtmlResources()
//       .acceptHeader("application/json, text/plain, */*")
//       .acceptEncodingHeader("gzip, deflate, br")
//       .acceptLanguageHeader("en-US,en;q=0.9")
//       .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/149.0.0.0 Safari/537.36");
    
//     Map<CharSequence, String> headers_0 = new HashMap<>();
//     headers_0.put("Sec-Fetch-Dest", "empty");
//     headers_0.put("Sec-Fetch-Mode", "cors");
//     headers_0.put("Sec-Fetch-Site", "same-origin");
//     headers_0.put("request-id", "|70bae2bde66e4ed7b5a9c5ef062395da.7729e64ef2884f81");
//     headers_0.put("sec-ch-ua", "Google Chrome\";v=\"149\", \"Chromium\";v=\"149\", \"Not)A;Brand\";v=\"24");
//     headers_0.put("sec-ch-ua-mobile", "?0");
//     headers_0.put("sec-ch-ua-platform", "Windows");
//     headers_0.put("traceparent", "00-70bae2bde66e4ed7b5a9c5ef062395da-7729e64ef2884f81-01");
//     headers_0.put("want-content-digest", "sha-512");
    
//     Map<CharSequence, String> headers_1 = new HashMap<>();
//     headers_1.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
//     headers_1.put("If-None-Match", "W/\"a148-0yN83Tkw3Zc7vqpyN+6HVejazsU\"");
//     headers_1.put("Sec-Fetch-Dest", "document");
//     headers_1.put("Sec-Fetch-Mode", "navigate");
//     headers_1.put("Sec-Fetch-Site", "same-origin");
//     headers_1.put("Sec-Fetch-User", "?1");
//     headers_1.put("Upgrade-Insecure-Requests", "1");
//     headers_1.put("sec-ch-ua", "Google Chrome\";v=\"149\", \"Chromium\";v=\"149\", \"Not)A;Brand\";v=\"24");
//     headers_1.put("sec-ch-ua-mobile", "?0");
//     headers_1.put("sec-ch-ua-platform", "Windows");
    
//     Map<CharSequence, String> headers_2 = new HashMap<>();
//     headers_2.put("If-None-Match", "W/\"53-4xPR/TRSrQDfdDZlAi0g3PCpa+4\"");
//     headers_2.put("Sec-Fetch-Dest", "empty");
//     headers_2.put("Sec-Fetch-Mode", "cors");
//     headers_2.put("Sec-Fetch-Site", "same-origin");
//     headers_2.put("Want-Content-Digest", "sha-512");
//     headers_2.put("sec-ch-ua", "Google Chrome\";v=\"149\", \"Chromium\";v=\"149\", \"Not)A;Brand\";v=\"24");
//     headers_2.put("sec-ch-ua-mobile", "?0");
//     headers_2.put("sec-ch-ua-platform", "Windows");
    
//     Map<CharSequence, String> headers_3 = new HashMap<>();
//     headers_3.put("Sec-Fetch-Dest", "empty");
//     headers_3.put("Sec-Fetch-Mode", "cors");
//     headers_3.put("Sec-Fetch-Site", "same-origin");
//     headers_3.put("Want-Content-Digest", "sha-512");
//     headers_3.put("sec-ch-ua", "Google Chrome\";v=\"149\", \"Chromium\";v=\"149\", \"Not)A;Brand\";v=\"24");
//     headers_3.put("sec-ch-ua-mobile", "?0");
//     headers_3.put("sec-ch-ua-platform", "Windows");
    
//     Map<CharSequence, String> headers_4 = new HashMap<>();
//     headers_4.put("Sec-Fetch-Dest", "empty");
//     headers_4.put("Sec-Fetch-Mode", "cors");
//     headers_4.put("Sec-Fetch-Site", "same-origin");
//     headers_4.put("cache-control", "no-cache");
//     headers_4.put("expires", "0");
//     headers_4.put("pragma", "no-cache");
//     headers_4.put("request-id", "|f414fa9d88764795b07bf239659fce95.fc3bb075cf6e45af");
//     headers_4.put("sec-ch-ua", "Google Chrome\";v=\"149\", \"Chromium\";v=\"149\", \"Not)A;Brand\";v=\"24");
//     headers_4.put("sec-ch-ua-mobile", "?0");
//     headers_4.put("sec-ch-ua-platform", "Windows");
//     headers_4.put("traceparent", "00-f414fa9d88764795b07bf239659fce95-fc3bb075cf6e45af-01");
//     headers_4.put("want-content-digest", "sha-512");
    
//     Map<CharSequence, String> headers_5 = new HashMap<>();
//     headers_5.put("Sec-Fetch-Dest", "empty");
//     headers_5.put("Sec-Fetch-Mode", "cors");
//     headers_5.put("Sec-Fetch-Site", "same-origin");
//     headers_5.put("request-id", "|f414fa9d88764795b07bf239659fce95.e89d318e100e4b6b");
//     headers_5.put("sec-ch-ua", "Google Chrome\";v=\"149\", \"Chromium\";v=\"149\", \"Not)A;Brand\";v=\"24");
//     headers_5.put("sec-ch-ua-mobile", "?0");
//     headers_5.put("sec-ch-ua-platform", "Windows");
//     headers_5.put("traceparent", "00-f414fa9d88764795b07bf239659fce95-e89d318e100e4b6b-01");
//     headers_5.put("want-content-digest", "sha-512");
    
//     Map<CharSequence, String> headers_6 = new HashMap<>();
//     headers_6.put("Sec-Fetch-Dest", "empty");
//     headers_6.put("Sec-Fetch-Mode", "cors");
//     headers_6.put("Sec-Fetch-Site", "same-origin");
//     headers_6.put("request-id", "|f414fa9d88764795b07bf239659fce95.7c032a3c0d804a50");
//     headers_6.put("sec-ch-ua", "Google Chrome\";v=\"149\", \"Chromium\";v=\"149\", \"Not)A;Brand\";v=\"24");
//     headers_6.put("sec-ch-ua-mobile", "?0");
//     headers_6.put("sec-ch-ua-platform", "Windows");
//     headers_6.put("traceparent", "00-f414fa9d88764795b07bf239659fce95-7c032a3c0d804a50-01");
//     headers_6.put("want-content-digest", "sha-512");
    
//     Map<CharSequence, String> headers_7 = new HashMap<>();
//     headers_7.put("Sec-Fetch-Dest", "empty");
//     headers_7.put("Sec-Fetch-Mode", "cors");
//     headers_7.put("Sec-Fetch-Site", "same-origin");
//     headers_7.put("cache-control", "no-cache");
//     headers_7.put("expires", "0");
//     headers_7.put("pragma", "no-cache");
//     headers_7.put("request-id", "|f414fa9d88764795b07bf239659fce95.175537a54f8941f3");
//     headers_7.put("sec-ch-ua", "Google Chrome\";v=\"149\", \"Chromium\";v=\"149\", \"Not)A;Brand\";v=\"24");
//     headers_7.put("sec-ch-ua-mobile", "?0");
//     headers_7.put("sec-ch-ua-platform", "Windows");
//     headers_7.put("traceparent", "00-f414fa9d88764795b07bf239659fce95-175537a54f8941f3-01");
//     headers_7.put("want-content-digest", "sha-512");
    
//     Map<CharSequence, String> headers_8 = new HashMap<>();
//     headers_8.put("Sec-Fetch-Dest", "empty");
//     headers_8.put("Sec-Fetch-Mode", "cors");
//     headers_8.put("Sec-Fetch-Site", "same-origin");
//     headers_8.put("request-id", "|f414fa9d88764795b07bf239659fce95.1f01e9a5f7ec4c27");
//     headers_8.put("sec-ch-ua", "Google Chrome\";v=\"149\", \"Chromium\";v=\"149\", \"Not)A;Brand\";v=\"24");
//     headers_8.put("sec-ch-ua-mobile", "?0");
//     headers_8.put("sec-ch-ua-platform", "Windows");
//     headers_8.put("traceparent", "00-f414fa9d88764795b07bf239659fce95-1f01e9a5f7ec4c27-01");
//     headers_8.put("want-content-digest", "sha-512");
    
//     Map<CharSequence, String> headers_9 = new HashMap<>();
//     headers_9.put("Sec-Fetch-Dest", "empty");
//     headers_9.put("Sec-Fetch-Mode", "cors");
//     headers_9.put("Sec-Fetch-Site", "same-origin");
//     headers_9.put("cache-control", "no-cache");
//     headers_9.put("expires", "0");
//     headers_9.put("pragma", "no-cache");
//     headers_9.put("request-id", "|f414fa9d88764795b07bf239659fce95.c570f018b046439d");
//     headers_9.put("sec-ch-ua", "Google Chrome\";v=\"149\", \"Chromium\";v=\"149\", \"Not)A;Brand\";v=\"24");
//     headers_9.put("sec-ch-ua-mobile", "?0");
//     headers_9.put("sec-ch-ua-platform", "Windows");
//     headers_9.put("traceparent", "00-f414fa9d88764795b07bf239659fce95-c570f018b046439d-01");
//     headers_9.put("want-content-digest", "sha-512");
    
//     Map<CharSequence, String> headers_10 = new HashMap<>();
//     headers_10.put("Sec-Fetch-Dest", "empty");
//     headers_10.put("Sec-Fetch-Mode", "cors");
//     headers_10.put("Sec-Fetch-Site", "same-origin");
//     headers_10.put("request-id", "|f414fa9d88764795b07bf239659fce95.9caf2a9024004dea");
//     headers_10.put("sec-ch-ua", "Google Chrome\";v=\"149\", \"Chromium\";v=\"149\", \"Not)A;Brand\";v=\"24");
//     headers_10.put("sec-ch-ua-mobile", "?0");
//     headers_10.put("sec-ch-ua-platform", "Windows");
//     headers_10.put("traceparent", "00-f414fa9d88764795b07bf239659fce95-9caf2a9024004dea-01");
//     headers_10.put("want-content-digest", "sha-512");
    
//     Map<CharSequence, String> headers_11 = new HashMap<>();
//     headers_11.put("Sec-Fetch-Dest", "empty");
//     headers_11.put("Sec-Fetch-Mode", "cors");
//     headers_11.put("Sec-Fetch-Site", "same-origin");
//     headers_11.put("request-id", "|647b6476066e4e88b20b0b72d141e2eb.a1279aa934f641d1");
//     headers_11.put("sec-ch-ua", "Google Chrome\";v=\"149\", \"Chromium\";v=\"149\", \"Not)A;Brand\";v=\"24");
//     headers_11.put("sec-ch-ua-mobile", "?0");
//     headers_11.put("sec-ch-ua-platform", "Windows");
//     headers_11.put("traceparent", "00-647b6476066e4e88b20b0b72d141e2eb-a1279aa934f641d1-01");
//     headers_11.put("want-content-digest", "sha-512");
    
//     Map<CharSequence, String> headers_12 = new HashMap<>();
//     headers_12.put("Origin", "https://opal-frontend.test.apps.hmcts.net");
//     headers_12.put("Sec-Fetch-Dest", "empty");
//     headers_12.put("Sec-Fetch-Mode", "cors");
//     headers_12.put("Sec-Fetch-Site", "same-origin");
//     headers_12.put("content-digest", "sha-512=:JIEJhiQJu3JIzV9+nI3kYmAWmELJsVhKjlvGyA3P3YMsbeBRuWQ4a7tcQXqUySQc0CLWSnXRB+rtRnT9+ER4Yg==:");
//     headers_12.put("content-type", "application/json");
//     headers_12.put("request-id", "|647b6476066e4e88b20b0b72d141e2eb.179ea7e701244159");
//     headers_12.put("sec-ch-ua", "Google Chrome\";v=\"149\", \"Chromium\";v=\"149\", \"Not)A;Brand\";v=\"24");
//     headers_12.put("sec-ch-ua-mobile", "?0");
//     headers_12.put("sec-ch-ua-platform", "Windows");
//     headers_12.put("traceparent", "00-647b6476066e4e88b20b0b72d141e2eb-179ea7e701244159-01");
//     headers_12.put("want-content-digest", "sha-512");
    
//     Map<CharSequence, String> headers_13 = new HashMap<>();
//     headers_13.put("Sec-Fetch-Dest", "empty");
//     headers_13.put("Sec-Fetch-Mode", "cors");
//     headers_13.put("Sec-Fetch-Site", "same-origin");
//     headers_13.put("request-id", "|c2d7cc65f72e4d18a37411b5ac9abb89.5495edd754894b7b");
//     headers_13.put("sec-ch-ua", "Google Chrome\";v=\"149\", \"Chromium\";v=\"149\", \"Not)A;Brand\";v=\"24");
//     headers_13.put("sec-ch-ua-mobile", "?0");
//     headers_13.put("sec-ch-ua-platform", "Windows");
//     headers_13.put("traceparent", "00-c2d7cc65f72e4d18a37411b5ac9abb89-5495edd754894b7b-01");
//     headers_13.put("want-content-digest", "sha-512");


//     ScenarioBuilder scn = scenario("Offence")
//       .exec(
//         http("request_0")
//           .get("/api/user-state")
//           .headers(headers_0)
//       )
//       .pause(4)
//       .exec(
//         http("request_1")
//           .get("/fines/manual-account-creation/offence-details/search-offences")
//           .headers(headers_1)
//           .resources(
//             http("request_2")
//               .get("/session/expiry")
//               .headers(headers_2),
//             http("request_3")
//               .get("/api/user-state")
//               .headers(headers_3),
//             http("request_4")
//               .get("/sso/authenticated")
//               .headers(headers_4),
//             http("request_5")
//               .get("/api/user-state")
//               .headers(headers_5),
//             http("request_6")
//               .get("/api/user-state")
//               .headers(headers_6),
//             http("request_7")
//               .get("/sso/authenticated")
//               .headers(headers_7),
//             http("request_8")
//               .get("/api/user-state")
//               .headers(headers_8),
//             http("request_9")
//               .get("/sso/authenticated")
//               .headers(headers_9),
//             http("request_10")
//               .get("/api/user-state")
//               .headers(headers_10)
//           )
//       )
//       .pause(31)
//       .exec(
//         http("request_11")
//           .get("/api/user-state")
//           .headers(headers_11)
//           .resources(
//             http("request_12")
//               .post("/opal-fines-service/offences/search")
//               .headers(headers_12)
//               .body(RawFileBody("offence/0012_request.json"))
//           )
//       )
//       .pause(8)
//       .exec(
//         http("request_13")
//           .get("/api/user-state")
//           .headers(headers_13)
//       );

// 	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
//   }
// }

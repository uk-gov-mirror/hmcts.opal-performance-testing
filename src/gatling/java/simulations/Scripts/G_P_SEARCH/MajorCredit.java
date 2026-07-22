
import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class MajorCredit extends Simulation {

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
    headers_0.put("request-id", "|6b4e32a4d3e14518a6e18df1d5ceb596.9688e95810194b92");
    headers_0.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_0.put("sec-ch-ua-mobile", "?0");
    headers_0.put("sec-ch-ua-platform", "Windows");
    headers_0.put("traceparent", "00-6b4e32a4d3e14518a6e18df1d5ceb596-9688e95810194b92-01");
    headers_0.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_1 = new HashMap<>();
    headers_1.put("Sec-Fetch-Dest", "empty");
    headers_1.put("Sec-Fetch-Mode", "cors");
    headers_1.put("Sec-Fetch-Site", "same-origin");
    headers_1.put("cache-control", "no-cache");
    headers_1.put("expires", "0");
    headers_1.put("pragma", "no-cache");
    headers_1.put("request-id", "|5c6febbae2d04cfc80d8c9f357d87c81.aad49cbb54124134");
    headers_1.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_1.put("sec-ch-ua-mobile", "?0");
    headers_1.put("sec-ch-ua-platform", "Windows");
    headers_1.put("traceparent", "00-5c6febbae2d04cfc80d8c9f357d87c81-aad49cbb54124134-01");
    headers_1.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_2 = new HashMap<>();
    headers_2.put("Sec-Fetch-Dest", "empty");
    headers_2.put("Sec-Fetch-Mode", "cors");
    headers_2.put("Sec-Fetch-Site", "same-origin");
    headers_2.put("cache-control", "no-cache");
    headers_2.put("expires", "0");
    headers_2.put("pragma", "no-cache");
    headers_2.put("request-id", "|a8d79e8a8c154250b887143d47f353a5.3a413846424248a8");
    headers_2.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_2.put("sec-ch-ua-mobile", "?0");
    headers_2.put("sec-ch-ua-platform", "Windows");
    headers_2.put("traceparent", "00-a8d79e8a8c154250b887143d47f353a5-3a413846424248a8-01");
    headers_2.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_3 = new HashMap<>();
    headers_3.put("Sec-Fetch-Dest", "empty");
    headers_3.put("Sec-Fetch-Mode", "cors");
    headers_3.put("Sec-Fetch-Site", "same-origin");
    headers_3.put("cache-control", "no-cache");
    headers_3.put("expires", "0");
    headers_3.put("pragma", "no-cache");
    headers_3.put("request-id", "|1163fdf5b55948488d7b9f35e23f95aa.59d4e58f572a4500");
    headers_3.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_3.put("sec-ch-ua-mobile", "?0");
    headers_3.put("sec-ch-ua-platform", "Windows");
    headers_3.put("traceparent", "00-1163fdf5b55948488d7b9f35e23f95aa-59d4e58f572a4500-01");
    headers_3.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_4 = new HashMap<>();
    headers_4.put("Sec-Fetch-Dest", "empty");
    headers_4.put("Sec-Fetch-Mode", "cors");
    headers_4.put("Sec-Fetch-Site", "same-origin");
    headers_4.put("request-id", "|1163fdf5b55948488d7b9f35e23f95aa.1b4ea37fb83b4f25");
    headers_4.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_4.put("sec-ch-ua-mobile", "?0");
    headers_4.put("sec-ch-ua-platform", "Windows");
    headers_4.put("traceparent", "00-1163fdf5b55948488d7b9f35e23f95aa-1b4ea37fb83b4f25-01");
    headers_4.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_5 = new HashMap<>();
    headers_5.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
    headers_5.put("Sec-Fetch-Dest", "document");
    headers_5.put("Sec-Fetch-Mode", "navigate");
    headers_5.put("Sec-Fetch-Site", "same-origin");
    headers_5.put("Sec-Fetch-User", "?1");
    headers_5.put("Upgrade-Insecure-Requests", "1");
    headers_5.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_5.put("sec-ch-ua-mobile", "?0");
    headers_5.put("sec-ch-ua-platform", "Windows");
    
    Map<CharSequence, String> headers_6 = new HashMap<>();
    headers_6.put("Sec-Fetch-Dest", "empty");
    headers_6.put("Sec-Fetch-Mode", "cors");
    headers_6.put("Sec-Fetch-Site", "same-origin");
    headers_6.put("Want-Content-Digest", "sha-512");
    headers_6.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_6.put("sec-ch-ua-mobile", "?0");
    headers_6.put("sec-ch-ua-platform", "Windows");
    
    Map<CharSequence, String> headers_7 = new HashMap<>();
    headers_7.put("Sec-Fetch-Dest", "empty");
    headers_7.put("Sec-Fetch-Mode", "cors");
    headers_7.put("Sec-Fetch-Site", "same-origin");
    headers_7.put("cache-control", "no-cache");
    headers_7.put("expires", "0");
    headers_7.put("pragma", "no-cache");
    headers_7.put("request-id", "|eb8ec4ae30e5477fb7d1f23862d41a40.76de64b40b934945");
    headers_7.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_7.put("sec-ch-ua-mobile", "?0");
    headers_7.put("sec-ch-ua-platform", "Windows");
    headers_7.put("traceparent", "00-eb8ec4ae30e5477fb7d1f23862d41a40-76de64b40b934945-01");
    headers_7.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_8 = new HashMap<>();
    headers_8.put("Sec-Fetch-Dest", "empty");
    headers_8.put("Sec-Fetch-Mode", "cors");
    headers_8.put("Sec-Fetch-Site", "same-origin");
    headers_8.put("cache-control", "no-cache");
    headers_8.put("expires", "0");
    headers_8.put("pragma", "no-cache");
    headers_8.put("request-id", "|eb8ec4ae30e5477fb7d1f23862d41a40.5134a3ce80264920");
    headers_8.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_8.put("sec-ch-ua-mobile", "?0");
    headers_8.put("sec-ch-ua-platform", "Windows");
    headers_8.put("traceparent", "00-eb8ec4ae30e5477fb7d1f23862d41a40-5134a3ce80264920-01");
    headers_8.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_9 = new HashMap<>();
    headers_9.put("Sec-Fetch-Dest", "empty");
    headers_9.put("Sec-Fetch-Mode", "cors");
    headers_9.put("Sec-Fetch-Site", "same-origin");
    headers_9.put("request-id", "|eb8ec4ae30e5477fb7d1f23862d41a40.25df9344742f4f60");
    headers_9.put("sec-ch-ua", "Not;A=Brand\";v=\"8\", \"Chromium\";v=\"150\", \"Google Chrome\";v=\"150");
    headers_9.put("sec-ch-ua-mobile", "?0");
    headers_9.put("sec-ch-ua-platform", "Windows");
    headers_9.put("traceparent", "00-eb8ec4ae30e5477fb7d1f23862d41a40-25df9344742f4f60-01");
    headers_9.put("want-content-digest", "sha-512");


    ScenarioBuilder scn = scenario("MajorCredit")
      .exec(
        http("request_0")
          .get("/sso/authenticated")
          .headers(headers_0)
      )
      .pause(7)
      .exec(
        http("request_1")
          .get("/sso/authenticated")
          .headers(headers_1)
      )
      .pause(2)
      .exec(
        http("request_2")
          .get("/sso/authenticated")
          .headers(headers_2)
      )
      .pause(3)
      .exec(
        http("request_3")
          .get("/sso/authenticated")
          .headers(headers_3)
          .resources(
            http("request_4")
              .get("/opal-fines-service/major-creditors?businessUnit=9")
              .headers(headers_4)
          )
      )
      .pause(9)
      .exec(
        http("request_5")
          .get("/fines/account/major-creditor/11300000000146/details")
          .headers(headers_5)
          .resources(
            http("request_6")
              .get("/api/user-state")
              .headers(headers_6),
            http("request_7")
              .get("/sso/authenticated")
              .headers(headers_7),
            http("request_8")
              .get("/sso/authenticated")
              .headers(headers_8),
            http("request_9")
              .get("/opal-fines-service/major-creditor-accounts/11300000000146/header-summary")
              .headers(headers_9)
              .check(status().is(403))
          )
      );

	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}


import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class RemovePG extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("https://opal-frontend.test.apps.hmcts.net")
      .inferHtmlResources()
      .acceptHeader("application/json, text/plain, */*")
      .acceptEncodingHeader("gzip, deflate, br")
      .acceptLanguageHeader("en-US,en;q=0.9")
      .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/153.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_0 = new HashMap<>();
    headers_0.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
    headers_0.put("If-None-Match", "W/\"9e54-4GXUrxUNhMbbVuMwcxdib5f4T/o\"");
    headers_0.put("Sec-Fetch-Dest", "document");
    headers_0.put("Sec-Fetch-Mode", "navigate");
    headers_0.put("Sec-Fetch-Site", "same-origin");
    headers_0.put("Sec-Fetch-User", "?1");
    headers_0.put("Upgrade-Insecure-Requests", "1");
    headers_0.put("sec-ch-ua", "Google Chrome\";v=\"153\", \"Not_A Brand\";v=\"8\", \"Chromium\";v=\"153");
    headers_0.put("sec-ch-ua-mobile", "?0");
    headers_0.put("sec-ch-ua-platform", "Windows");
    
    Map<CharSequence, String> headers_1 = new HashMap<>();
    headers_1.put("If-None-Match", "W/\"53-0qPZwmsF0yLCsF4QuYAfGiyAK78\"");
    headers_1.put("Sec-Fetch-Dest", "empty");
    headers_1.put("Sec-Fetch-Mode", "cors");
    headers_1.put("Sec-Fetch-Site", "same-origin");
    headers_1.put("Want-Content-Digest", "sha-512");
    headers_1.put("sec-ch-ua", "Google Chrome\";v=\"153\", \"Not_A Brand\";v=\"8\", \"Chromium\";v=\"153");
    headers_1.put("sec-ch-ua-mobile", "?0");
    headers_1.put("sec-ch-ua-platform", "Windows");
    
    Map<CharSequence, String> headers_2 = new HashMap<>();
    headers_2.put("Sec-Fetch-Dest", "empty");
    headers_2.put("Sec-Fetch-Mode", "cors");
    headers_2.put("Sec-Fetch-Site", "same-origin");
    headers_2.put("Want-Content-Digest", "sha-512");
    headers_2.put("sec-ch-ua", "Google Chrome\";v=\"153\", \"Not_A Brand\";v=\"8\", \"Chromium\";v=\"153");
    headers_2.put("sec-ch-ua-mobile", "?0");
    headers_2.put("sec-ch-ua-platform", "Windows");
    
    Map<CharSequence, String> headers_3 = new HashMap<>();
    headers_3.put("Sec-Fetch-Dest", "empty");
    headers_3.put("Sec-Fetch-Mode", "cors");
    headers_3.put("Sec-Fetch-Site", "same-origin");
    headers_3.put("cache-control", "no-cache");
    headers_3.put("expires", "0");
    headers_3.put("pragma", "no-cache");
    headers_3.put("request-id", "|dfcd23463a1d4f2ab1820610fd1d1839.3a5fd4cb29884add");
    headers_3.put("sec-ch-ua", "Google Chrome\";v=\"153\", \"Not_A Brand\";v=\"8\", \"Chromium\";v=\"153");
    headers_3.put("sec-ch-ua-mobile", "?0");
    headers_3.put("sec-ch-ua-platform", "Windows");
    headers_3.put("traceparent", "00-dfcd23463a1d4f2ab1820610fd1d1839-3a5fd4cb29884add-01");
    headers_3.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_4 = new HashMap<>();
    headers_4.put("Sec-Fetch-Dest", "empty");
    headers_4.put("Sec-Fetch-Mode", "cors");
    headers_4.put("Sec-Fetch-Site", "same-origin");
    headers_4.put("cache-control", "no-cache");
    headers_4.put("expires", "0");
    headers_4.put("pragma", "no-cache");
    headers_4.put("request-id", "|dfcd23463a1d4f2ab1820610fd1d1839.9a59faa0955b4c31");
    headers_4.put("sec-ch-ua", "Google Chrome\";v=\"153\", \"Not_A Brand\";v=\"8\", \"Chromium\";v=\"153");
    headers_4.put("sec-ch-ua-mobile", "?0");
    headers_4.put("sec-ch-ua-platform", "Windows");
    headers_4.put("traceparent", "00-dfcd23463a1d4f2ab1820610fd1d1839-9a59faa0955b4c31-01");
    headers_4.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_5 = new HashMap<>();
    headers_5.put("Sec-Fetch-Dest", "empty");
    headers_5.put("Sec-Fetch-Mode", "cors");
    headers_5.put("Sec-Fetch-Site", "same-origin");
    headers_5.put("request-id", "|dfcd23463a1d4f2ab1820610fd1d1839.ab3b6cfbe7c74c61");
    headers_5.put("sec-ch-ua", "Google Chrome\";v=\"153\", \"Not_A Brand\";v=\"8\", \"Chromium\";v=\"153");
    headers_5.put("sec-ch-ua-mobile", "?0");
    headers_5.put("sec-ch-ua-platform", "Windows");
    headers_5.put("traceparent", "00-dfcd23463a1d4f2ab1820610fd1d1839-ab3b6cfbe7c74c61-01");
    headers_5.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_6 = new HashMap<>();
    headers_6.put("Sec-Fetch-Dest", "empty");
    headers_6.put("Sec-Fetch-Mode", "cors");
    headers_6.put("Sec-Fetch-Site", "same-origin");
    headers_6.put("request-id", "|e3970b8be467488792182edd72aa643a.c0ef406c114b4377");
    headers_6.put("sec-ch-ua", "Google Chrome\";v=\"153\", \"Not_A Brand\";v=\"8\", \"Chromium\";v=\"153");
    headers_6.put("sec-ch-ua-mobile", "?0");
    headers_6.put("sec-ch-ua-platform", "Windows");
    headers_6.put("traceparent", "00-e3970b8be467488792182edd72aa643a-c0ef406c114b4377-01");
    headers_6.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_7 = new HashMap<>();
    headers_7.put("Sec-Fetch-Dest", "empty");
    headers_7.put("Sec-Fetch-Mode", "cors");
    headers_7.put("Sec-Fetch-Site", "same-origin");
    headers_7.put("request-id", "|c83345760d1348abad8b694a5f7fa51c.04d49a4c7c4441f3");
    headers_7.put("sec-ch-ua", "Google Chrome\";v=\"153\", \"Not_A Brand\";v=\"8\", \"Chromium\";v=\"153");
    headers_7.put("sec-ch-ua-mobile", "?0");
    headers_7.put("sec-ch-ua-platform", "Windows");
    headers_7.put("traceparent", "00-c83345760d1348abad8b694a5f7fa51c-04d49a4c7c4441f3-01");
    headers_7.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_8 = new HashMap<>();
    headers_8.put("Sec-Fetch-Dest", "empty");
    headers_8.put("Sec-Fetch-Mode", "cors");
    headers_8.put("Sec-Fetch-Site", "same-origin");
    headers_8.put("cache-control", "no-cache");
    headers_8.put("expires", "0");
    headers_8.put("pragma", "no-cache");
    headers_8.put("request-id", "|c83345760d1348abad8b694a5f7fa51c.c012fe9730f149b1");
    headers_8.put("sec-ch-ua", "Google Chrome\";v=\"153\", \"Not_A Brand\";v=\"8\", \"Chromium\";v=\"153");
    headers_8.put("sec-ch-ua-mobile", "?0");
    headers_8.put("sec-ch-ua-platform", "Windows");
    headers_8.put("traceparent", "00-c83345760d1348abad8b694a5f7fa51c-c012fe9730f149b1-01");
    headers_8.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_9 = new HashMap<>();
    headers_9.put("Sec-Fetch-Dest", "empty");
    headers_9.put("Sec-Fetch-Mode", "cors");
    headers_9.put("Sec-Fetch-Site", "same-origin");
    headers_9.put("cache-control", "no-cache");
    headers_9.put("expires", "0");
    headers_9.put("pragma", "no-cache");
    headers_9.put("request-id", "|c83345760d1348abad8b694a5f7fa51c.126fee2b28b6428d");
    headers_9.put("sec-ch-ua", "Google Chrome\";v=\"153\", \"Not_A Brand\";v=\"8\", \"Chromium\";v=\"153");
    headers_9.put("sec-ch-ua-mobile", "?0");
    headers_9.put("sec-ch-ua-platform", "Windows");
    headers_9.put("traceparent", "00-c83345760d1348abad8b694a5f7fa51c-126fee2b28b6428d-01");
    headers_9.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_10 = new HashMap<>();
    headers_10.put("Cache-Control", "max-age=0");
    headers_10.put("Origin", "https://opal-frontend.test.apps.hmcts.net");
    headers_10.put("Sec-Fetch-Dest", "empty");
    headers_10.put("Sec-Fetch-Mode", "cors");
    headers_10.put("Sec-Fetch-Site", "same-origin");
    headers_10.put("business-unit-id", "65");
    headers_10.put("content-digest", "sha-512=:FolwUKK48++tFx18teXUVDAyWWkiENlGfZYJVuE43XGfIO5u8zSaDJJWBHJBDVWC7duikFtCIDnQLHekOo6zFw==:");
    headers_10.put("content-type", "application/json");
    headers_10.put("if-match", "5");
    headers_10.put("request-id", "|828108771efd4fcabc2f7dcbb12a0a83.c8ff5ab49c494608");
    headers_10.put("sec-ch-ua", "Google Chrome\";v=\"153\", \"Not_A Brand\";v=\"8\", \"Chromium\";v=\"153");
    headers_10.put("sec-ch-ua-mobile", "?0");
    headers_10.put("sec-ch-ua-platform", "Windows");
    headers_10.put("traceparent", "00-828108771efd4fcabc2f7dcbb12a0a83-c8ff5ab49c494608-01");
    headers_10.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_11 = new HashMap<>();
    headers_11.put("Sec-Fetch-Dest", "empty");
    headers_11.put("Sec-Fetch-Mode", "cors");
    headers_11.put("Sec-Fetch-Site", "same-origin");
    headers_11.put("cache-control", "no-cache");
    headers_11.put("expires", "0");
    headers_11.put("pragma", "no-cache");
    headers_11.put("request-id", "|828108771efd4fcabc2f7dcbb12a0a83.7fda903230be46bf");
    headers_11.put("sec-ch-ua", "Google Chrome\";v=\"153\", \"Not_A Brand\";v=\"8\", \"Chromium\";v=\"153");
    headers_11.put("sec-ch-ua-mobile", "?0");
    headers_11.put("sec-ch-ua-platform", "Windows");
    headers_11.put("traceparent", "00-828108771efd4fcabc2f7dcbb12a0a83-7fda903230be46bf-01");
    headers_11.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_12 = new HashMap<>();
    headers_12.put("Sec-Fetch-Dest", "empty");
    headers_12.put("Sec-Fetch-Mode", "cors");
    headers_12.put("Sec-Fetch-Site", "same-origin");
    headers_12.put("request-id", "|828108771efd4fcabc2f7dcbb12a0a83.39c04dc0ded14a32");
    headers_12.put("sec-ch-ua", "Google Chrome\";v=\"153\", \"Not_A Brand\";v=\"8\", \"Chromium\";v=\"153");
    headers_12.put("sec-ch-ua-mobile", "?0");
    headers_12.put("sec-ch-ua-platform", "Windows");
    headers_12.put("traceparent", "00-828108771efd4fcabc2f7dcbb12a0a83-39c04dc0ded14a32-01");
    headers_12.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_13 = new HashMap<>();
    headers_13.put("Sec-Fetch-Dest", "empty");
    headers_13.put("Sec-Fetch-Mode", "cors");
    headers_13.put("Sec-Fetch-Site", "same-origin");
    headers_13.put("request-id", "|beafd8074af34c2a83f175fab8742ca7.dc338bd1e34d4d97");
    headers_13.put("sec-ch-ua", "Google Chrome\";v=\"153\", \"Not_A Brand\";v=\"8\", \"Chromium\";v=\"153");
    headers_13.put("sec-ch-ua-mobile", "?0");
    headers_13.put("sec-ch-ua-platform", "Windows");
    headers_13.put("traceparent", "00-beafd8074af34c2a83f175fab8742ca7-dc338bd1e34d4d97-01");
    headers_13.put("want-content-digest", "sha-512");


    ScenarioBuilder scn = scenario("RemovePG")
      .exec(
        http("request_0")
          .get("/fines/account/minor-creditor/60000000000034/details")
          .headers(headers_0)
          .resources(
            http("request_1")
              .get("/session/expiry")
              .headers(headers_1),
            http("request_2")
              .get("/api/user-state")
              .headers(headers_2),
            http("request_3")
              .get("/sso/authenticated")
              .headers(headers_3),
            http("request_4")
              .get("/sso/authenticated")
              .headers(headers_4),
            http("request_5")
              .get("/opal-fines-service/minor-creditor-accounts/60000000000034/header-summary")
              .headers(headers_5),
            http("request_6")
              .get("/opal-fines-service/minor-creditor-accounts/60000000000034/at-a-glance")
              .headers(headers_6)
          )
      )
      .pause(3)
      .exec(
        http("request_7")
          .get("/opal-fines-service/minor-creditor-accounts/60000000000034")
          .headers(headers_7)
      )
      .pause(3)
      .exec(
        http("request_8")
          .get("/sso/authenticated")
          .headers(headers_8)
          .resources(
            http("request_9")
              .get("/sso/authenticated")
              .headers(headers_9)
          )
      )
      .pause(13)
      .exec(
        http("request_10")
          .patch("/opal-fines-service/minor-creditor-accounts/60000000000034")
          .headers(headers_10)
          .body(RawFileBody("removepg/0010_request.json"))
          .resources(
            http("request_11")
              .get("/sso/authenticated")
              .headers(headers_11),
            http("request_12")
              .get("/opal-fines-service/minor-creditor-accounts/60000000000034/header-summary")
              .headers(headers_12),
            http("request_13")
              .get("/opal-fines-service/minor-creditor-accounts/60000000000034")
              .headers(headers_13)
          )
      );

	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}

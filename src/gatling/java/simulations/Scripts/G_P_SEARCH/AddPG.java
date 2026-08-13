
import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class AddPG extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("https://opal-frontend.test.apps.hmcts.net")
      .inferHtmlResources()
      .acceptHeader("application/json, text/plain, */*")
      .acceptEncodingHeader("gzip, deflate, br")
      .acceptLanguageHeader("en-US,en;q=0.9")
      .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/151.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_0 = new HashMap<>();
    headers_0.put("Sec-Fetch-Dest", "empty");
    headers_0.put("Sec-Fetch-Mode", "cors");
    headers_0.put("Sec-Fetch-Site", "same-origin");
    headers_0.put("request-id", "|9c45908d33144013b0fe2462d84aff3a.ce7775fa6bbf4b95");
    headers_0.put("sec-ch-ua", "Not=A?Brand\";v=\"99\", \"Google Chrome\";v=\"151\", \"Chromium\";v=\"151");
    headers_0.put("sec-ch-ua-mobile", "?0");
    headers_0.put("sec-ch-ua-platform", "Windows");
    headers_0.put("traceparent", "00-9c45908d33144013b0fe2462d84aff3a-ce7775fa6bbf4b95-01");
    headers_0.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_1 = new HashMap<>();
    headers_1.put("Sec-Fetch-Dest", "empty");
    headers_1.put("Sec-Fetch-Mode", "cors");
    headers_1.put("Sec-Fetch-Site", "same-origin");
    headers_1.put("cache-control", "no-cache");
    headers_1.put("expires", "0");
    headers_1.put("pragma", "no-cache");
    headers_1.put("request-id", "|9c45908d33144013b0fe2462d84aff3a.28accc3dddb24803");
    headers_1.put("sec-ch-ua", "Not=A?Brand\";v=\"99\", \"Google Chrome\";v=\"151\", \"Chromium\";v=\"151");
    headers_1.put("sec-ch-ua-mobile", "?0");
    headers_1.put("sec-ch-ua-platform", "Windows");
    headers_1.put("traceparent", "00-9c45908d33144013b0fe2462d84aff3a-28accc3dddb24803-01");
    headers_1.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_2 = new HashMap<>();
    headers_2.put("Sec-Fetch-Dest", "empty");
    headers_2.put("Sec-Fetch-Mode", "cors");
    headers_2.put("Sec-Fetch-Site", "same-origin");
    headers_2.put("request-id", "|9c45908d33144013b0fe2462d84aff3a.7dbd5ea4ee444650");
    headers_2.put("sec-ch-ua", "Not=A?Brand\";v=\"99\", \"Google Chrome\";v=\"151\", \"Chromium\";v=\"151");
    headers_2.put("sec-ch-ua-mobile", "?0");
    headers_2.put("sec-ch-ua-platform", "Windows");
    headers_2.put("traceparent", "00-9c45908d33144013b0fe2462d84aff3a-7dbd5ea4ee444650-01");
    headers_2.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_3 = new HashMap<>();
    headers_3.put("Sec-Fetch-Dest", "empty");
    headers_3.put("Sec-Fetch-Mode", "cors");
    headers_3.put("Sec-Fetch-Site", "same-origin");
    headers_3.put("cache-control", "no-cache");
    headers_3.put("expires", "0");
    headers_3.put("pragma", "no-cache");
    headers_3.put("request-id", "|9c45908d33144013b0fe2462d84aff3a.75edc3591b454441");
    headers_3.put("sec-ch-ua", "Not=A?Brand\";v=\"99\", \"Google Chrome\";v=\"151\", \"Chromium\";v=\"151");
    headers_3.put("sec-ch-ua-mobile", "?0");
    headers_3.put("sec-ch-ua-platform", "Windows");
    headers_3.put("traceparent", "00-9c45908d33144013b0fe2462d84aff3a-75edc3591b454441-01");
    headers_3.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_4 = new HashMap<>();
    headers_4.put("Sec-Fetch-Dest", "empty");
    headers_4.put("Sec-Fetch-Mode", "cors");
    headers_4.put("Sec-Fetch-Site", "same-origin");
    headers_4.put("request-id", "|9c45908d33144013b0fe2462d84aff3a.2877bc15cdad405a");
    headers_4.put("sec-ch-ua", "Not=A?Brand\";v=\"99\", \"Google Chrome\";v=\"151\", \"Chromium\";v=\"151");
    headers_4.put("sec-ch-ua-mobile", "?0");
    headers_4.put("sec-ch-ua-platform", "Windows");
    headers_4.put("traceparent", "00-9c45908d33144013b0fe2462d84aff3a-2877bc15cdad405a-01");
    headers_4.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_5 = new HashMap<>();
    headers_5.put("Accept", "*/*");
    headers_5.put("Accept-Encoding", "gzip, deflate, br");
    headers_5.put("Accept-Language", "en-GB");
    headers_5.put("Cache-Control", "no-cache");
    headers_5.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36 Edge/18.26200");
    headers_5.put("client-request-id", "23f485ba-2b25-40d1-a48f-0ae60207e8bd");
    headers_5.put("return-client-request-id", "true");
    headers_5.put("tb-aad-device-family", "3");
    headers_5.put("tb-aad-env-id", "10.0.26100.8875");
    headers_5.put("x-ms-RefreshTokenCredential", "NA");
    
    Map<CharSequence, String> headers_6 = new HashMap<>();
    headers_6.put("Cache-Control", "max-age=0");
    headers_6.put("Origin", "https://opal-frontend.test.apps.hmcts.net");
    headers_6.put("Sec-Fetch-Dest", "empty");
    headers_6.put("Sec-Fetch-Mode", "cors");
    headers_6.put("Sec-Fetch-Site", "same-origin");
    headers_6.put("business-unit-id", "61");
    headers_6.put("content-digest", "sha-512=:cYID6zk7wpZPt+Fc/pOCdHxQsuUTLAGP6epHDRvC3q9DJ/igGL9VG6f3EyxMmOyT8hZFyriEoTicr+I5b0sOvw==:");
    headers_6.put("content-type", "application/json");
    headers_6.put("if-match", "2");
    headers_6.put("request-id", "|294a40b435b741168b8e0a0e12c773d8.648d383a912e4f2a");
    headers_6.put("sec-ch-ua", "Not=A?Brand\";v=\"99\", \"Google Chrome\";v=\"151\", \"Chromium\";v=\"151");
    headers_6.put("sec-ch-ua-mobile", "?0");
    headers_6.put("sec-ch-ua-platform", "Windows");
    headers_6.put("traceparent", "00-294a40b435b741168b8e0a0e12c773d8-648d383a912e4f2a-01");
    headers_6.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_7 = new HashMap<>();
    headers_7.put("Sec-Fetch-Dest", "empty");
    headers_7.put("Sec-Fetch-Mode", "cors");
    headers_7.put("Sec-Fetch-Site", "same-origin");
    headers_7.put("cache-control", "no-cache");
    headers_7.put("expires", "0");
    headers_7.put("pragma", "no-cache");
    headers_7.put("request-id", "|294a40b435b741168b8e0a0e12c773d8.447f62d8fe64444f");
    headers_7.put("sec-ch-ua", "Not=A?Brand\";v=\"99\", \"Google Chrome\";v=\"151\", \"Chromium\";v=\"151");
    headers_7.put("sec-ch-ua-mobile", "?0");
    headers_7.put("sec-ch-ua-platform", "Windows");
    headers_7.put("traceparent", "00-294a40b435b741168b8e0a0e12c773d8-447f62d8fe64444f-01");
    headers_7.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_8 = new HashMap<>();
    headers_8.put("Sec-Fetch-Dest", "empty");
    headers_8.put("Sec-Fetch-Mode", "cors");
    headers_8.put("Sec-Fetch-Site", "same-origin");
    headers_8.put("request-id", "|294a40b435b741168b8e0a0e12c773d8.a2521c59e9494e1b");
    headers_8.put("sec-ch-ua", "Not=A?Brand\";v=\"99\", \"Google Chrome\";v=\"151\", \"Chromium\";v=\"151");
    headers_8.put("sec-ch-ua-mobile", "?0");
    headers_8.put("sec-ch-ua-platform", "Windows");
    headers_8.put("traceparent", "00-294a40b435b741168b8e0a0e12c773d8-a2521c59e9494e1b-01");
    headers_8.put("want-content-digest", "sha-512");
    
    Map<CharSequence, String> headers_9 = new HashMap<>();
    headers_9.put("Sec-Fetch-Dest", "empty");
    headers_9.put("Sec-Fetch-Mode", "cors");
    headers_9.put("Sec-Fetch-Site", "same-origin");
    headers_9.put("request-id", "|051c1d7c7213451e864a21375768aa21.44464194eec04f5e");
    headers_9.put("sec-ch-ua", "Not=A?Brand\";v=\"99\", \"Google Chrome\";v=\"151\", \"Chromium\";v=\"151");
    headers_9.put("sec-ch-ua-mobile", "?0");
    headers_9.put("sec-ch-ua-platform", "Windows");
    headers_9.put("traceparent", "00-051c1d7c7213451e864a21375768aa21-44464194eec04f5e-01");
    headers_9.put("want-content-digest", "sha-512");
    
    String uri1 = "https://login.microsoftonline.com/common/oauth2/token";

    ScenarioBuilder scn = scenario("AddPG")
      .exec(
        http("request_0")
          .get("/opal-fines-service/defendant-accounts/60000000001429/defendant-account-parties/60000000001432")
          .headers(headers_0)
      )
      .pause(1)
      .exec(
        http("request_1")
          .get("/sso/authenticated")
          .headers(headers_1)
          .resources(
            http("request_2")
              .get("/api/user-state")
              .headers(headers_2),
            http("request_3")
              .get("/sso/authenticated")
              .headers(headers_3),
            http("request_4")
              .get("/opal-fines-service/defendant-accounts/60000000001429/header-summary")
              .headers(headers_4)
          )
      )
      .pause(2)
      .exec(
        http("request_5")
          .post(uri1)
          .headers(headers_5)
          .formParam("grant_type", "urn:ietf:params:oauth:grant-type:jwt-bearer")
          .formParam("request", "eyJrZGZfdmVyIjoyLCJjdHgiOiJjNUNTRXRlRmNzeUZTbkV6WEQ3bGJvZmpTc2tCa2hPNiIsImFsZyI6IkhTMjU2In0.eyJ3aW5fdmVyIjoiMTAuMC4yNjEwMC44ODc1Iiwic2NvcGUiOiJvcGVuaWQgYXphIiwicmVzb3VyY2UiOiIyNmE0YWU2NC01ODYyLTQyN2YtYTliMC0wNDRlNjI1NzJhNGYiLCJyZWZyZXNoX3Rva2VuIjoiMS5BUTBBak1iLXVTM0pIa2FhbHowRG9QR0xnb2M3cWpodG9CZElzblY2TVdtSTJUc0FBR0FOQUEuQlFBQkF3RUFBQUFEQU96X0JRRDBfMFYyYjFOMGMwRnlkR2xtWVdOMGN3SUFBQUFBQUROV3BaTGdaX01SZmZLMjhrRGRQenAzRlZRaUtVRjV4ZHl1UWtybm5LeFlZMkkwcU5VVHNnZUtheDhiZy03c09fS3NXVnpycHIyTVFFNHMwVDREV1VqNmd5aDVpdHg5SFN0Q0hzYm8wUmVPd3BiM2hNTzZKQi15OFRVTmU3YllkbTNOV1FTSFpSQzJjR1ZqM0F2M1R2LXVTRjRDSzM5M3NXZWR4b2xGMDhUZmVtSFA1U01uUm1BUldfelQtcDFOVHB1dmlIY3NZVW1FbVZGcHI2NnNCVTV6NXpVVkphZG5BM1NaeTBJUHFMR181WTMwMFVzU0pTcnVrNGlXSGhiT3loQzhkd1BKSlh4ZWdGSTNPd3RaRjl3SVZ5enhEVHBzaVE5cUxpc0lOSndZR1BSdUVpMTUzbGdrb3V5M1BpVmxkemVyLUQ0dmRaMlRBN1haN2RnMXNLODBtU3hnWVgtRjRqNVZWNHRTX0pGWW1MTkRndWRoemE2bGtvM3RjRHAwYUkwc2trNEVfTTFiaW5Hb2RKUW82ZTRuYzlvbGU2eTlGRm1nMGQ1WXIyR1dwMXk4ZGNVT2FKUGNSTGQ0VkViY016ckN2UDhnOEotMTFJVk11bWZ2cS05MlBLUzF6QlRCUUQwcGFaRHB0M0RVYTlzMTVnYkNOMlI1bnE2b20yNW5XUUFJU1k3YVNfWXR4S09OVWhMajd4N3EyRTdwUWZYRlV1VGdobTFmU0NYbHk2RXF0d1dkbG4xdkxYeTVudmJnUHQ4T0ZOcE53S3lfZGtYTE5NdjJZTTJfMVNVNnNxYTVMZDZXNHdoUUNzVzZXMm1icTdjcGNlY0xSbXdtNVk0bGRiQ09JOEUwQ2hfUGhjalJKeTAxYTJPSExtYkdLeDVpUE1kUmV0OW5sdFR0cFNoalUwdGdBVGstcHlIdDhoXzBYdXRBUDItUGl3LXZ5TlVTMHN4RnFGYjhyZHBFUDhVUWlNTDdHeDhUdUN1dG1vTUpPTnBSMFlnQlZKQTFMN2YwVmxsOW9lQUNqeUJEWmZBQ0pGN2ZpbXYwbnpLRXBtbGxjWjVMbUZ0WlFRSXZzelhudVRMWVl0UEVxMEJObVRCcmp1U3I3bm9vaXEwMGlrbHpYWk94ZjBXUHFmZ2t1MmpUNmptT2NEYnYtRUZ4Vlk2aW9UZE1sSnl0LXJ3MEtQaEdIRjZ0VnBpXzdWVVFwNUtNWmUtTDNoOTQ3bkV3dU1OckVqWFpXTDFKeUxiaDdPUXBpbEVwOVRoaEV2SUV6Rzc1a2ZVWFJFX21MZGVTSTZ5QWdlLTN1YVFSeHhrVThzOTJGYVJaX0JsdElsM2tXZ1RBNVpnaGk3ckVidThwYjNCQjJwWGtWa0xNTVRqRmNjeDRkV1VNRzc4ekNaYVRER2ppZ3EyY2JEYVpjdW9OUTZIblB6NnAwMkxFRk8yT3hKM0dybkl1Qzc0MlFVSGRJd2ZXVF9NdnNua1d5Ylg2ZU5vSUF6ZWdRMlVWN3RRUXB2dkNjSi1VeVRJTldULVM0RzZYbUttTTA5QkFWMzhWWnplNk40dFdoRm9VNzJKNTRONHhycjd2OTlEd2JSVlFxVGgxWkNQOHFmZms5QTlnNnQ2QVBXSWtkQ2xMblBpdk5FeFVSczY5TGZqYWI2bGpWcGJwZU92Ukdlb0ZyU2FRSjYxRXhqTnUxbmgwLURyN2Y1N2daUGVpSE1PTGxMTUNVelRvS0pMM3lXYW1uLXNaZ1BfalhrNTZQeHZNa2F5MHdIaThxZTNHb3FoRC1VSTZ3R3k1eHJlMy1nRnlFR2NaREhDMS1zMEluaEFnTDk0SVBLdFF0OEpPSy1wZkFWOEwxdDg0QXc2NDJzeWdYa3llX0JoVVVjSGZxdEdQUTUyUGhvdjF3VE9teURfem9Ddm5HNk9GUzhmdUNYSVllQUk1NV9hazhOUnEwVkM5bzNKS2t4bUI4YUFUWEVxYkVIdkdCSnpSS0hqeUtfOTRCVFZiTVNxaWtOTnNBRFlVamw3aHZ0RXMxVjF0dnZOSFRfZno0NXhjRXciLCJyZWRpcmVjdF91cmkiOiJtcy1hcHB4LXdlYjpcL1wvTWljcm9zb2Z0LkFBRC5Ccm9rZXJQbHVnaW5cL2ZjMGYzYWY0LTY4MzUtNDE3NC1iODA2LWY3ZGIzMTFmZDJmMyIsImlzcyI6ImFhZDpicm9rZXJwbHVnaW4iLCJpYXQiOjE3ODY2MDk3MjEsImdyYW50X3R5cGUiOiJyZWZyZXNoX3Rva2VuIiwiY2xpZW50X2lkIjoiZmMwZjNhZjQtNjgzNS00MTc0LWI4MDYtZjdkYjMxMWZkMmYzIiwiYXVkIjoibG9naW4ubWljcm9zb2Z0b25saW5lLmNvbSJ9.glGTiwKqfnmgS_2z_kozYRaP5RhMZLzJuE6WC5Jdcsk")
          .formParam("client_info", "1")
          .formParam("windows_api_version", "2.0.1")
      )
      .pause(11)
      .exec(
        http("request_6")
          .post("/opal-fines-service/defendant-accounts/60000000001429/defendant-account-parties")
          .headers(headers_6)
          .body(RawFileBody("addpg/0006_request.json"))
          .resources(
            http("request_7")
              .get("/sso/authenticated")
              .headers(headers_7),
            http("request_8")
              .get("/opal-fines-service/defendant-accounts/60000000001429/header-summary")
              .headers(headers_8),
            http("request_9")
              .get("/opal-fines-service/defendant-accounts/60000000001429/defendant-account-parties/60000000002457")
              .headers(headers_9)
          )
      );

	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}

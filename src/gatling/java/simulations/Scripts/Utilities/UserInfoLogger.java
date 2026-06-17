package simulations.Scripts.Utilities;

import io.gatling.javaapi.core.ChainBuilder;
import static io.gatling.javaapi.core.CoreDsl.exec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserInfoLogger {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(UserInfoLogger.class);

    private static boolean isGateway(int code) {
        return code == 502 || code == 504;
    }

    public static ChainBuilder logDetailedErrorMessage(String requestName) {

        return exec(session -> {

            Integer statusCode =
                    session.contains("httpStatus")
                            ? session.getInt("httpStatus")
                            : null;

            String responseBody =
                    session.contains("responseBody")
                            ? session.getString("responseBody")
                            : "N/A";           

            String errorStatus =
                    session.contains("errorStatus")
                            ? session.getString("errorStatus")
                            : "N/A";

            String detail =
                    session.contains("getDetail")
                            ? session.getString("getDetail")
                            : "N/A";

            String userName =
                    session.contains("Username")
                            ? session.getString("Username")
                            : "N/A";

            boolean gatewayError =
                    statusCode != null && isGateway(statusCode);

            // -------------------------
            // SUCCESS
            // -------------------------
            if (!session.isFailed() && !gatewayError) {

                LOGGER.info(
                        "Request '{}' succeeded. User: {}. Status: {}",
                        requestName,
                        userName,
                        statusCode
                );

                return session;
            }

            // -------------------------
            // GATEWAY ERROR
            // -------------------------
            if (gatewayError) {

                LOGGER.error("""
                        Request '{}' FAILED (Gateway Error)

                        Status Code: {}
                        User: {}

                        Response Body:
                        {}
                        """,
                        requestName,
                        statusCode,
                        userName,
                        responseBody
                );

                return session;
            }

            // -------------------------
            // FUNCTIONAL FAILURE 
            // -------------------------
            LOGGER.error("""
                    Request '{}' FAILED

                    Status Code: {}
                    Error Type: {}
                    Error Title: {}
                    Error Status: {}

                    User: {}
                    Detail: {}

                    Response Body:
                    {}
                    """,
                    requestName,
                    statusCode,
                    errorStatus,
                    userName,
                    detail,
                    responseBody
            );

            return session;
        });
    }
}
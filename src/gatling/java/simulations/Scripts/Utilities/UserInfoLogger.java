package simulations.Scripts.Utilities;

import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.exec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserInfoLogger {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(UserInfoLogger.class);

    private static boolean isGateway(Integer code) {
        return code != null && (code == 502 || code == 504);
    }

        public static ChainBuilder logSessionStatus(String stepName) {
        return exec(session -> {

                LOGGER.info(
                "STEP: {} | session.isFailed()={}",
                stepName,
                session.isFailed()
                );

                return session;
        });
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

            String errorType =
                    session.contains("errorType")
                            ? session.getString("errorType")
                            : "N/A";

            String errorTitle =
                    session.contains("errorTitle")
                            ? session.getString("errorTitle")
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


            boolean gatewayError = isGateway(statusCode);


            // ------------------------------------------------
            // Determine THIS REQUEST result
            // ------------------------------------------------
            boolean requestSucceeded =
                    statusCode != null &&
                    statusCode >= 200 &&
                    statusCode < 300 &&
                    !gatewayError;


            // ------------------------------------------------
            // Diagnostic information
            // ------------------------------------------------
                if (AppConfig.LoggingConfig.ENABLE_DIAGNOSTIC_LOGGING) {
                LOGGER.info(
                        """
                        Request '{}'
                        Session Failed: {}
                        Request Successful: {}
                        Gateway Error: {}
                        Status Code: {}
                        """,
                        requestName,
                        session.isFailed(),
                        requestSucceeded,
                        gatewayError,
                        statusCode
                );
                }


            // ------------------------------------------------
            // SUCCESS
            // ------------------------------------------------
            if (requestSucceeded) {

                LOGGER.info(
                        """
                        Request '{}' SUCCEEDED

                        Status Code: {}
                        User: {}
                        """,
                        requestName,
                        statusCode,
                        userName
                );

                return session;
            }


            // ------------------------------------------------
            // GATEWAY ERROR
            // ------------------------------------------------
            if (gatewayError) {

                LOGGER.error(
                        """
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


            // ------------------------------------------------
            // FUNCTIONAL FAILURE
            // ------------------------------------------------
            LOGGER.error(
                    """
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
                    errorType,
                    errorTitle,
                    errorStatus,
                    userName,
                    detail,
                    responseBody
            );


            return session;
        });
    }
}
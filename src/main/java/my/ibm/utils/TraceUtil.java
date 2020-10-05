package my.ibm.utils;


import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author kingdee lwt 2020/10/4
 */
public class TraceUtil {

    public static String getTraceId(HttpServletRequest request) {
        String traceId = request.getServletContext().getInitParameter("traceId");
        if (StringUtils.isEmpty(traceId)) {
            traceId = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        }
        return traceId;
    }
}

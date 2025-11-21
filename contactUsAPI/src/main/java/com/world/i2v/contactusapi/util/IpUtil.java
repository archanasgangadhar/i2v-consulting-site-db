package com.world.i2v.contactusapi.util;



import jakarta.servlet.http.HttpServletRequest;

public class IpUtil {

    public static String getClientIp(HttpServletRequest request) {

        // Check if reverse proxy or load balancer added the X-Forwarded-For header
        String forwardedFor = request.getHeader("X-Forwarded-For");

        if (forwardedFor != null && !forwardedFor.isEmpty()) {
            // X-Forwarded-For can contain multiple IPs: client, proxy1, proxy2...
            // We return the first one (client)
            return forwardedFor.split(",")[0].trim();
        }

        // Fall back to remote address
        return request.getRemoteAddr();
    }
}

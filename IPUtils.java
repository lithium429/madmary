
public class IPUtils{


public static long ip2Long(String ipStr) {
        String[] ip = ipStr.split("\\.");
        return (Long.valueOf(ip[0]) << 24) + (Long.valueOf(ip[1]) << 16)
                + (Long.valueOf(ip[2]) << 8) + Long.valueOf(ip[3]);
    }


    public static String long2Ip(long ipLong) {
        StringBuilder ip = new StringBuilder();
        ip.append(ipLong >>> 24).append(".");
        ip.append((ipLong >>> 16) & 0xFF).append(".");
        ip.append((ipLong >>> 8) & 0xFF).append(".");
        ip.append(ipLong & 0xFF);
        return ip.toString();
    }


    }
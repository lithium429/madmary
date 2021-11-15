public class Test {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间:  "+now);
        
        //时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("formate: "+ now.format(formatter));
        
        //当天的零点
        System.out.println("当天的零点:  "+LocalDateTime.of(now.toLocalDate(), LocalTime.MIN));
        
        //当天的最后时间
        System.out.println("当天的最后时间:  "+LocalDateTime.of(now.toLocalDate(), LocalTime.MAX));
        
        //最近的五分钟点位
        Integer minute = now.getMinute();
        minute = minute/5*5;
        System.out.println("最近的五分钟点位:  "+LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), now.getHour(), minute, 0));
        
        //Date转为LocalDateTime
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("Date转为LocalDateTime: "+instant.atZone(zoneId).toLocalDateTime());
    }

}
package learning.effective;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Page 17 of package name for book
 * 避免创建不必要的对象
 * @author Chenstyle
 * @date 2016/10/25 0025
 * @time 15:28
 */
public class Person {
    private final Date birthDate;

    // Other fields, methods, and constructor omitted
    // DON'T DO THIS!
    public boolean isBabyBron() {
        // Unnecessary allocation of expensive object
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();
        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;

    }
}

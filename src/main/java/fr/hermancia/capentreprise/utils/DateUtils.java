package fr.hermancia.capentreprise.utils;

import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
@Service
public class DateUtils {

    public String getDateFormat(LocalDate localDate, String format) {
        if (localDate == null) return "";
        return getDateFormat(localDate.atTime(0, 0), format);
    }

    public String getDateFormat(LocalDateTime localDate, String format) {
        if (localDate == null) return "";
        Date date = Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
        return new SimpleDateFormat(format).format(date);
    }

}

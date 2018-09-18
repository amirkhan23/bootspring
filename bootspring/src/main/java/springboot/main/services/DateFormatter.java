package springboot.main.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateFormatter {

	public Date dateFormate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		try {
			Date date1 = sdf.parse(date);
			return date1;
		} catch (ParseException e) {

			e.printStackTrace();
			return null;
		}

	}

}

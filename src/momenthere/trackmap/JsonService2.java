package momenthere.trackmap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Specialize differet types generate different objects
public class JsonService2 {
	public JsonService2() {

	}

	public TrackmapNode getTrackmapNode() {
		Date date;
		String dateString = "03/04/2013";
		TrackmapNode tmn =  null;
		SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = dateFormater.parse(dateString);
			tmn = new TrackmapNode("a", date, "9182", 23);
			System.out.println(tmn);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tmn;
	}

}

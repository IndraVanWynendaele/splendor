package domein;

import java.util.Locale;
import java.util.ResourceBundle;

public class TaalHelper {

	private static Locale taal;
	private static ResourceBundle rb;
	
	public TaalHelper(String taal) {
		this.taal=new Locale(taal);
    	rb = ResourceBundle.getBundle("languages.Messages",this.taal);
	}
	
	public static String getText(String key) {
		return rb.getString(key);
	}
}

package uca.esi.heave;

import java.util.Calendar;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebay.sdk.call.GeteBayOfficialTimeCall;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController 
{
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 * @throws SdkException 
	 * @throws ApiException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception 
	{	
		return "home";
	}
	
}

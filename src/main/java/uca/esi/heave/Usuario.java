package uca.esi.heave;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiException;
import com.ebay.sdk.ApiLogging;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.FetchTokenCall;
import com.ebay.sdk.call.GetOrdersCall;
import com.ebay.sdk.call.GetSessionIDCall;
import com.ebay.sdk.call.GeteBayOfficialTimeCall;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.OrderType;

@Controller
@RequestMapping("/Usuario")
public class Usuario 
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void home(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws ApiException, SdkException, Exception 
	{	
		//Creo el contexto y lo meto en una variable de sesión
		ApiContext contexto = Ebay.getApiContext();
		request.getSession().setAttribute("contexto", contexto);
		
		//De la API de eBay
		String runame = "David_Jim_nez_C-DavidJim-7797-4-vihnh";
		
		//Se crea un objeto de la clase GetSessionIDCall para pedir un ID para la sesión
		GetSessionIDCall api = new GetSessionIDCall(contexto);
		api.setRuName(runame);
		
		//Se crea una cadena con el runame y el entorno elegido
		String ruParams=("params="+runame +"-Production");
		
		//Se pide el ID y se mete en una cadena de texto
		 String sessionID = api.getSessionID();
		//Se codifica en el juego de caracteres deseado
		 String encodedSesssionIDString =URLEncoder.encode(sessionID,"UTF-8");			 
		 //Se inserta  el ID sin codificar en una variable de sesión
		 request.getSession().setAttribute("sessionID", sessionID);		
		 //Se redirige al login de eBay
		 response.sendRedirect(response.encodeRedirectURL("https://signin.ebay.com/ws/eBayISAPI.dll?SignIn" + 
				 										"&RuName=" + runame + 
				 										"&SessID=" + encodedSesssionIDString + 
				 										"&ruparams=" + ruParams )); 
		
		//return "Accept";
	}
	
	@RequestMapping(value = "/aceptar", method = RequestMethod.GET)
	public String aceptar(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws ApiException, SdkException, Exception 
	{	
		String alias =request.getParameter("username");
		//String ruparams = request.getParameter("params");
		
		ApiContext contexto = (ApiContext) request.getSession().getAttribute("contexto"); 
		
		String sessionID = (String) request.getSession().getAttribute("sessionID");
		
		FetchTokenCall api = new FetchTokenCall(contexto);
		api.setSessionID(sessionID);

		
		String eBayToken = api.fetchToken();
		Date tokenExp = api.getHardExpirationTime().getTime();
		
		contexto.getApiCredential().seteBayToken(eBayToken);
		ApiLogging apiLogging = new ApiLogging();
        contexto.setApiLogging(apiLogging); 
		request.getSession().setAttribute("alias", alias);
		request.getSession().setAttribute("contexto", contexto);
		request.getSession().setAttribute("tokenExp", tokenExp);
		
		//Prueba con las órdenes
		
		DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[]{DetailLevelCodeType.RETURN_ALL};
		Calendar to = new GregorianCalendar();    
	    Calendar from = (GregorianCalendar) to.clone();
	    from.add(Calendar.DAY_OF_YEAR, -7);
	    
	    GetOrdersCall getOrders = new GetOrdersCall(contexto);
        getOrders.setDetailLevel(detailLevels);
        getOrders.setCreateTimeFrom(from);
        getOrders.setCreateTimeTo(to);
	     
        OrderType[] orders = getOrders.getOrders();
        
        double totalGanado = 0;
        for(OrderType orden : orders)
        {
        	totalGanado += orden.getAmountPaid().getValue();
        }
        
        model.addAttribute("nOrdenes", orders.length);
        model.addAttribute("totalGanado", totalGanado);
		
		return "Accept";
		
	}
}

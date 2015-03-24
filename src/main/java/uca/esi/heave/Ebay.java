package uca.esi.heave;

import java.io.IOException;

import com.ebay.sdk.ApiAccount;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;

public class Ebay 
{
	public static ApiContext getApiContext()
	        throws IOException
	    {
	        ApiContext apiContext = new ApiContext();
	        ApiCredential cred = new ApiCredential();
	        ApiAccount ac = cred.getApiAccount();
	        ac.setApplication("DavidJim-7797-43b7-9e34-c7fc706dc65b");
	        ac.setDeveloper("7dc70a97-28aa-4802-b04d-311f6c1802f3");
	        ac.setCertificate("7c57d4f4-99cb-4f6a-8351-ef167a331035");
	        //cred.seteBayToken("AgAAAA**AQAAAA**aAAAAA**eL1LVA**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6AFloGhAZWEoASdj6x9nY+seQ**jyQCAA**AAMAAA**bWNTKkk6+dS9J3nbzOlFzvvbJCVR7n2nYCDOH2tFjKLGjgah7M9yOtNKIoLLzPNHymoUHr4Wp7TF6fWnHCVqL5IDPwpPtvcGRAEu0q7NtrRdZ2IPps05RmhFhdGz1kYYN1ESf9d20U020b0h1MyPf3f6BZkLVapZ0CFp9dhPzwYrVg7zkwbF2YLVn/nhZ4lAZXy3A4vty0DjUur+PZnrUtfvbnKBiec4FblluNk2i0h79wDh76Z4huuKajnIforS4pIGVTWBKBoi7lW1Xvd+HSBxGQ06rI9JNx3YiY8JzqimnWA7g9HOb6AgyDkeYO2fTAWV75PFbR4uQ3YJEhbN++WxNE9eYihKOr/i2yasQKx5J5HXuZniVA3G+oyxJ+JZrxBOnaKbyfQKqsbiSGhzpKANA8URay9tG68D84QqfP7rMPbmGcZeToV5Q8Sv2/Yjk2hoyQWJCHRblfJNLOjua2zGr3CaHBberagHIRzhZjrfyKcYD2A0hsaQg/saNK7ccStJHOGkkEK6D0qMI2FwGWlchr2tNbso45pcbgNQqtnyu2UVSzFdf8OOrEm1pzqZD8nNQqBXQf62cji3HZb9sZG1RLbbCXd0V3lXYQuXjHEjdZX1O7jJkJMkO+s7x+oTkmh212ncLdmNBTfuUOdCwXFVmj/4bNf/XtQ182v7IwfzP/XiWbL6sa3FgbELCkBmXsf+yBEtUwTCZEY0A1aUnN4mfgYN7gCy7nHSMGKtZdiRFsmVLLJ3Q5ByiH8iOSML");
	        apiContext.setApiCredential(cred);
	        apiContext.setApiServerUrl("https://api.ebay.com/wsapi");
	        apiContext.setSite(SiteCodeType.SPAIN); 
	        return apiContext;
	    }
}

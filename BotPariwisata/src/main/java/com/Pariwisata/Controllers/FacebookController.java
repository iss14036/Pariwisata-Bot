package com.Pariwisata.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.Pariwisata.Constant;
import com.Pariwisata.ConstantMessage;
import com.Pariwisata.models.facebook.Facebook;
import com.Pariwisata.models.facebook.FacebookAttachment;
import com.Pariwisata.models.facebook.FacebookButton;
import com.Pariwisata.models.facebook.FacebookDefaultAction;
import com.Pariwisata.models.facebook.FacebookElement;
import com.Pariwisata.models.facebook.FacebookMessageButton;
import com.Pariwisata.models.facebook.FacebookMessageSend;
import com.Pariwisata.models.facebook.FacebookPayload;
import com.Pariwisata.models.facebook.FacebookRecipient;
import com.Pariwisata.models.facebook.FacebookSend;
import com.Pariwisata.models.facebook.FacebookSendButton;
import com.Pariwisata.models.pariwisata.Pariwisata;

@RestController
public class FacebookController {
	private static final String FACEBOOK_TOKEN = "https://graph.facebook.com/v2.6/me/messages?access_token=EAACLcLPDwfsBAInYlLnohvkfKQk8Sojhp78fKzj7kZAz4NrIQuLNRlMhRPPwPqmZAUKL8uSd49UM1gbJ7mzWjCXe9t9SIP9IGdbKoKa014ICUdbiiaIYpy06kfjZAlRZCEUqbdj34nwp7SoqjD1aiOZCYGvaTMXW4mabmbaBfywprrhPCz4HE";
	@Autowired
	MessageController messageController;
	ObjectMapper mapper = new ObjectMapper();
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	GoogleAPIController gController;
	
	@RequestMapping("/facebook")
	public String getIndex(HttpServletRequest request){	
		String challange = request.getParameter("hub.challenge");
		
		return challange;
	}	
	
	@RequestMapping(value="/facebook", method = RequestMethod.POST)
	public void receiveMessage(@RequestBody Facebook facebook){
		String id = facebook.getEntry().get(0).getMessaging().get(0).getSender().getId();
		String kata = null;
		try{
			kata = facebook.getEntry().get(0).getMessaging().get(0).getMessage().getText().toLowerCase();
		}
		catch(NullPointerException ie){
			kata = facebook.getEntry().get(0).getMessaging().get(0).getPostback().getPayload().toLowerCase();
		}
		finally{
			messageController.processMessage(id, kata, "facebook");
		}
	}
	
	public void sendBackText(String id,String teks){
		FacebookRecipient facebookRecipient = new FacebookRecipient(id);
		FacebookMessageSend fMessageSend = new FacebookMessageSend(teks);
		FacebookSend facebookSend= new FacebookSend(facebookRecipient, fMessageSend);
		HttpEntity<FacebookSend> entity1 = new HttpEntity<>(facebookSend);
		try {
			System.out.println(mapper.writeValueAsString(facebookSend));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}			
		ResponseEntity<String> result = restTemplate.postForEntity(FACEBOOK_TOKEN, entity1, String.class);
        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());
    }
	
	public void sendTemplateButton(String id){
		List<FacebookButton> buttons = new ArrayList<>();
		FacebookButton button1 = new FacebookButton("postback", Constant.PARIWISATA, null, "pariwisata");
		FacebookButton button2 = new FacebookButton("postback", Constant.RUMAH_MAKAN, null, "rumah makan");
		buttons.add(button1);
		buttons.add(button2);
		FacebookPayload payload = new FacebookPayload("button", ConstantMessage.MENU_MESSAGE, buttons);
		FacebookAttachment attachment = new FacebookAttachment("template", payload);
		FacebookMessageButton message = new FacebookMessageButton(attachment);
		FacebookRecipient recipient = new FacebookRecipient(id);
		FacebookSendButton facebookSend = new FacebookSendButton(recipient, message);
		
		HttpEntity<FacebookSendButton> entity1 = new HttpEntity<>(facebookSend);
		try {
			System.out.println(mapper.writeValueAsString(facebookSend));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}			
		ResponseEntity<String> result = restTemplate.postForEntity(FACEBOOK_TOKEN, entity1, String.class);
        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());
	}
	
	public void sendListRequest(String id,Pariwisata pariwisata,String kota){
		List<FacebookElement> elements = new ArrayList<>();
		pariwisata.getResults().stream().forEach(result->{
			if(elements.size()==4) return;
			String photo=null;
			try{
				String nama_request =result.getPhotos().get(0).getPhoto_reference();
				//photo = pariwisata.getResults().get(i).getIcon();
				photo = gController.sendPhoto(nama_request);
			}
			catch(NullPointerException ie){
				photo = result.getIcon();
			}
			finally{
				List<FacebookButton> buttons = new ArrayList<>();
				FacebookButton button1 = new FacebookButton("web_url", "Lihat", Constant.URL_SEARCH+result.getName()+" "+kota, null);
				buttons.add(button1);
				FacebookDefaultAction default_action = new FacebookDefaultAction("web_url", Constant.URL_SEARCH+result.getName()+" "+kota, null, null, null);
				FacebookElement element = new FacebookElement(result.getName(), photo, result.getFormatted_address(), default_action, buttons);
				elements.add(element);
			}
		});
		FacebookPayload payload = new FacebookPayload("generic", elements);
		FacebookAttachment attachment = new FacebookAttachment("template", payload);
		FacebookMessageButton message = new FacebookMessageButton(attachment);
		FacebookRecipient recipient = new FacebookRecipient(id);
		FacebookSendButton facebookSend = new FacebookSendButton(recipient, message);
		
		HttpEntity<FacebookSendButton> entity1 = new HttpEntity<>(facebookSend);
		try {
			System.out.println(mapper.writeValueAsString(facebookSend));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}			
		if(!pariwisata.getResults().isEmpty()){
			ResponseEntity<String> result = restTemplate.postForEntity(FACEBOOK_TOKEN, entity1, String.class);
			System.out.println(result.getStatusCode());	
	        System.out.println(result.getBody());
	        messageController.setFitur(Constant.NONE);
		}
		else{
			sendBackText(id,ConstantMessage.ERROR_MESSAGE); //Send Respond Error
		}
	}
}
	
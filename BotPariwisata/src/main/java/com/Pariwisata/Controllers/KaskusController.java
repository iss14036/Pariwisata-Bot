package com.Pariwisata.Controllers;


import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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
import com.Pariwisata.models.kaskus.Kaskus;
import com.Pariwisata.models.kaskus.KaskusBody;
import com.Pariwisata.models.kaskus.KaskusButton;
import com.Pariwisata.models.kaskus.KaskusInteractive;
import com.Pariwisata.models.kaskus.KaskusList;
import com.Pariwisata.models.kaskus.KaskusSend;
import com.Pariwisata.models.kaskus.KaskusSendInteractive;
import com.Pariwisata.models.kaskus.KaskusSendList;
import com.Pariwisata.models.pariwisata.Pariwisata;


@RestController
public class KaskusController {
	private static final String KASKUS_TOKEN = "https://Pariwisata:12345678@api.obrol.id/api/v1/bot/send-mass";
	private static final String ACCESS_PAGE = "Basic VGVzdEJvdDoxMjM0NTY3OA==";
	private static final String DOMAIN_KASKUS = "@kaskus-s.obrol.id";
	
	@Autowired
	private MessageController mController;
	ObjectMapper mapper = new ObjectMapper();
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	GoogleAPIController gController;
	
	@RequestMapping("/kaskus")
	public String getResponse(HttpServletRequest request){
		return null;			
	}
	
	@RequestMapping(value="/kaskus", method = RequestMethod.POST)
	public void receiveMessage(@RequestBody Kaskus kaskus){
		try {
			System.out.println(mapper.writeValueAsString(kaskus));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}	
		String id = kaskus.getFromPlain()+DOMAIN_KASKUS;
		String teks = kaskus.getBody().toLowerCase();
		mController.processMessage(id, teks, "kaskus");
		//sendMessage(id,"tess");
	}
	
	public void sendMessage(String id,String teks){
		List<KaskusSendList> kSendLists = new ArrayList<>();
		KaskusSendList kSendList = new KaskusSendList(id, teks);
		kSendLists.add(kSendList);
		KaskusSend kaskusSend = new KaskusSend(115185, kSendLists);
		
		HttpHeaders headers = setHeader();
		HttpEntity<KaskusSend> entity1 = new HttpEntity<>(kaskusSend,headers);
		
		try {
			System.out.println(mapper.writeValueAsString(kaskusSend));
		} catch (JsonProcessingException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		ResponseEntity<String> result = restTemplate.postForEntity(KASKUS_TOKEN, entity1, String.class);
        System.out.println(result.getStatusCode());	
        System.out.println(result.getBody());
	}
	
	public void sendInteractiveText(String id){
		KaskusButton button1 = new KaskusButton(Constant.PARIWISATA, Constant.PARIWISATA, "recipient");
		KaskusButton button2 = new KaskusButton(Constant.RUMAH_MAKAN, Constant.RUMAH_MAKAN, "recipient");
		
		List<KaskusButton> buttons = new ArrayList<>();
		buttons.add(button1);
		buttons.add(button2);
		
		List<KaskusInteractive> kInteractives = new ArrayList<>();
		KaskusInteractive kInteractive = new KaskusInteractive(buttons, null, null, null);
		kInteractives.add(kInteractive);
		KaskusBody kBody = new KaskusBody(kInteractives);
		List<KaskusList> kSendLists = new ArrayList<>();
		KaskusList kSendList = new KaskusList(id, kBody);
		kSendLists.add(kSendList);
		KaskusSendInteractive kSendInteractive = new KaskusSendInteractive(115185, kSendLists, "A cool Bot", "Insert your response");
		
		HttpHeaders headers = setHeader();
		HttpEntity<KaskusSendInteractive> entity1 = new HttpEntity<>(kSendInteractive,headers);
		
		try {
			System.out.println(mapper.writeValueAsString(kSendInteractive));
		} catch (JsonProcessingException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		ResponseEntity<String> result = restTemplate.postForEntity(KASKUS_TOKEN, entity1, String.class);
        System.out.println(result.getStatusCode());	
        System.out.println(result.getBody());
    }

	public void sendListRequest(String id,Pariwisata pariwisata,String city){
		List<KaskusList> kSendLists = new ArrayList<>();
		List<KaskusInteractive> kInteractives = new ArrayList<>();
		RestTemplate restTemplate = new RestTemplate();
		pariwisata.getResults().stream().forEach(result->{
			if(kInteractives.size()==5) return;
			String photo=null;
			try{
				String nama_request = result.getPhotos().get(0).getPhoto_reference();
				//photo = pariwisata.getResults().get(i).getIcon();
				photo = gController.sendPhoto(nama_request);
			}
			catch(NullPointerException ie){
				photo = result.getIcon();
			}
			finally{
				List<KaskusButton> buttons = new ArrayList<>();
				KaskusButton button1 = new KaskusButton(Constant.URL_SEARCH+result.getName()+" "+city, "Lihat", "recipient");
				buttons.add(button1);
				KaskusInteractive kInteractive = new KaskusInteractive(buttons, photo, result.getName(), result.getFormatted_address());
				kInteractives.add(kInteractive);
			}
		});
		KaskusBody kBody = new KaskusBody(kInteractives);
		KaskusList kSendList = new KaskusList(id, kBody);
		kSendLists.add(kSendList);
		KaskusSendInteractive kSendInteractive = new KaskusSendInteractive(115185, kSendLists, "A cool Bot", "Insert your response");
		
		HttpHeaders headers = setHeader();
		HttpEntity<KaskusSendInteractive> entity1 = new HttpEntity<>(kSendInteractive,headers);
		try {
			System.out.println(mapper.writeValueAsString(kSendInteractive));
		} catch (JsonProcessingException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!pariwisata.getResults().isEmpty()){
			ResponseEntity<String> result = restTemplate.postForEntity(KASKUS_TOKEN, entity1, String.class);
			System.out.println(result.getStatusCode());	
	        System.out.println(result.getBody());
	        mController.setFitur(Constant.NONE);
		}
		else{
			sendMessage(id,ConstantMessage.ERROR_MESSAGE);
		}
	}
	
	public void sendDashboard(String id){
		List<KaskusList> kSendLists = new ArrayList<>();
		List<KaskusInteractive> kInteractives = new ArrayList<>();
		List<KaskusButton> buttons = new ArrayList<>();
		KaskusButton button1 = new KaskusButton(Constant.PARIWISATA, Constant.PARIWISATA, "recipient");
		KaskusButton button2 = new KaskusButton(Constant.RUMAH_MAKAN, Constant.RUMAH_MAKAN, "recipient");
		buttons.add(button1);
		buttons.add(button2);
		KaskusInteractive kInteractive = new KaskusInteractive(buttons,ConstantMessage.IMAGE_DASHBOARD, "Dashboard",ConstantMessage.TEXT_DASHBOARD);
		kInteractives.add(kInteractive);
		KaskusBody kBody = new KaskusBody(kInteractives);
		KaskusList kSendList = new KaskusList(id, kBody);
		kSendLists.add(kSendList);
		KaskusSendInteractive kSendInteractive = new KaskusSendInteractive(115185, kSendLists, "A cool Bot", "Insert your response");
		
		HttpHeaders headers = setHeader();
		
		HttpEntity<KaskusSendInteractive> entity1 = new HttpEntity<>(kSendInteractive,headers);
		
		try {
			System.out.println(mapper.writeValueAsString(kSendInteractive));
		} catch (JsonProcessingException e) {	
			e.printStackTrace();
		}
		
		ResponseEntity<String> result = restTemplate.postForEntity(KASKUS_TOKEN, entity1, String.class);
		System.out.println(result.getStatusCode());	
        System.out.println(result.getBody());
	}
	
	public HttpHeaders setHeader(){
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION,ACCESS_PAGE);
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
		return headers;
	}
	
}
	
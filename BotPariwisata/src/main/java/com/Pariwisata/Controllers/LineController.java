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
import com.Pariwisata.models.line.Line;
import com.Pariwisata.models.line.LineAction;
import com.Pariwisata.models.line.LineBody;
import com.Pariwisata.models.line.LineColumn;
import com.Pariwisata.models.line.LineReply;
import com.Pariwisata.models.line.LineReplyMessage;
import com.Pariwisata.models.line.LineReplyTemplate;
import com.Pariwisata.models.line.LineSendTemplate;
import com.Pariwisata.models.line.LineSingleBody;
import com.Pariwisata.models.line.LineSingleTemplate;
import com.Pariwisata.models.line.LineTemplate;
import com.Pariwisata.models.pariwisata.Pariwisata;

@RestController
public class LineController {
	private static final String LINE_TOKEN = "https://api.line.me/v2/bot/message/push";
	private static final String ACCESS_TOKEN = "Bearer FjsDbqZaYTv4Wah5oJ3wnOKk2DpXl3yeNWueMbVWP1EaAa3new+Z9kxc6sbNZB63qKAcwz64bnJeDD4jbwRgdbRc1V28RHFMhFf+sDGM/7Pb8kf6xi9BtAp8s+D4ebboRKie/wgmNNmNQWQUSNl5hQdB04t89/1O/w1cDnyilFU=";
	private static final int TITLE_LIMIT = 40;
	private static final int LOCATION_LIMIT = 60;
	
	@Autowired
	RestTemplate restTemplate;
	ObjectMapper mapper = new ObjectMapper();
	@Autowired
	MessageController messageController;
	@Autowired
	GoogleAPIController gController;
	
	@RequestMapping("/line")
	public String getResponse(HttpServletRequest request){
		return null;			
	}
	
	@RequestMapping(value="/line", method = RequestMethod.POST)
	public void receiveMessage(@RequestBody Line line){
		String id = line.getEvents().get(0).getSource().getUserId();
		try{
			String kata = line.getEvents().get(0).getMessage().getText();
			kata.toLowerCase();
			try {
				System.out.println(mapper.writeValueAsString(line));
			} catch (JsonProcessingException e) {	
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			messageController.processMessage(id,kata, "line");
		}catch(NullPointerException ie){
			String kata = line.getEvents().get(0).getPostback().getData();
			messageController.processMessage(id,kata, "line");
		}
	}
	
	public void sendLineText(String id,String teks){
		List<LineReplyMessage> lRMessages = new ArrayList<>();
		LineReplyMessage lRMessage = new LineReplyMessage("text", teks);
		lRMessages.add(lRMessage);	
		LineReply lineReply = new LineReply(id, lRMessages);
		HttpHeaders headers = setHeader();
		HttpEntity<LineReply> entity1 = new HttpEntity<>(lineReply,headers);
		try {
			System.out.println(mapper.writeValueAsString(lineReply));
		} catch (JsonProcessingException e) {	
			e.printStackTrace();
		}			
		ResponseEntity<String> result = restTemplate.postForEntity(LINE_TOKEN, entity1, String.class);
        System.out.println(result.getStatusCode());	
        System.out.println(result.getBody());
	}
	
	public void sendOptionButton(String id){
		List<LineAction> actions = new ArrayList<>();
		LineAction action1 = new LineAction("postback", Constant.PARIWISATA, Constant.PARIWISATA, null);
		LineAction action2 = new LineAction("postback", Constant.RUMAH_MAKAN, Constant.RUMAH_MAKAN, null);
		actions.add(action1);
		actions.add(action2);
		LineSingleTemplate lSTemplate = new LineSingleTemplate("buttons", null, "Menu", ConstantMessage.MENU_MESSAGE, actions);
		List<LineSingleBody> bodys = new ArrayList<>();
		LineSingleBody lSBody = new LineSingleBody("template", "this is a button template", lSTemplate);
		bodys.add(lSBody);
		LineSendTemplate lSend = new LineSendTemplate(id, bodys);
		
		HttpHeaders headers = setHeader();
		HttpEntity<LineSendTemplate> entity1 = new HttpEntity<>(lSend,headers);
		
		try {
			System.out.println(mapper.writeValueAsString(lSend));
		} catch (JsonProcessingException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		ResponseEntity<String> result = restTemplate.postForEntity(LINE_TOKEN, entity1, String.class);
        System.out.println(result.getStatusCode());	
        System.out.println(result.getBody());
		
	}
	
	public void sendListRequest(String id,Pariwisata pariwisata,String kota){
		List<LineColumn> columns = new ArrayList<>();
		RestTemplate restTemplate = new RestTemplate();
		pariwisata.getResults().stream().forEach(result->{
			if(columns.size()==5) return;
			kota.replaceAll(" ", "+");
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
				String location = result.getFormatted_address();
				String place = result.getName().replaceAll(" ", "+");
				String title = result.getName();
				location = (location.length()>60) ? cutSentence(location,LOCATION_LIMIT) : location;
				title = (title.length()>40) ? cutSentence(title,TITLE_LIMIT) : title;
				List<LineAction> actions = new ArrayList<>();
				LineAction action1 = new LineAction("uri", "Lihat", null,Constant.URL_SEARCH+place+"+"+kota);
				actions.add(action1);
				LineColumn column = new LineColumn(photo, title, location, actions);
				columns.add(column);
			}
		});
		LineTemplate template = new LineTemplate("carousel", columns);
		List<LineBody> bodys = new ArrayList<>();
		LineBody body = new LineBody("template", "this is a carousel", template);
		bodys.add(body);
		LineReplyTemplate lReply = new LineReplyTemplate(id, bodys);
		if(!pariwisata.getResults().isEmpty()){
			HttpHeaders headers = setHeader();
			HttpEntity<LineReplyTemplate> entity1 = new HttpEntity<>(lReply,headers);
			ResponseEntity<String> result = restTemplate.postForEntity(LINE_TOKEN, entity1, String.class);
			System.out.println(result.getStatusCode());	
	        System.out.println(result.getBody());
	        messageController.setFitur(Constant.NONE);
		}
		else{
			sendLineText(id,ConstantMessage.ERROR_MESSAGE);
		}
	}
	public String cutSentence(String sentence,int limit){
		String new_sentence = sentence.substring(0, limit-1);
		return new_sentence;
	}
	
	public HttpHeaders setHeader(){
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION,ACCESS_TOKEN);
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
		return headers;
	}
	
}

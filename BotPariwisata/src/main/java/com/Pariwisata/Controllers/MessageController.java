package com.Pariwisata.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Pariwisata.ConstantMessage;
import com.Pariwisata.models.db.Event;
import com.Pariwisata.models.db.EventRepository;
import com.Pariwisata.models.db.State;
import com.Pariwisata.models.db.StateRepository;

@Service
public class MessageController {
	@Autowired
	private KaskusController kController;
	@Autowired
	private LineController lController;
	@Autowired
	private FacebookController fController;
	@Autowired
	GoogleAPIController gController;
	@Autowired
	EventRepository eRepository;
	@Autowired
	StateRepository sRepository;
	
	private String fitur = "none";
	
	public String getFitur() {
		return fitur;
	}

	public void setFitur(String fitur) {
		this.fitur = fitur;
	}

	public void processMessage(String id,String text, String platform){
		if(text.equalsIgnoreCase("/subscribe")){
			if(platform.equalsIgnoreCase("kaskus")) {
				kController.sendMessage(id, ConstantMessage.SUBSCRIBE);
				kController.sendDashboard(id);
			}
			Event event = eRepository.findOne(1);
			State state = new State(id, event, platform);
			sRepository.save(state);
		}
		else if(text.equalsIgnoreCase("pariwisata")){
			fitur = "pariwisata";
			if(platform.equalsIgnoreCase("kaskus")) {
				kController.sendMessage(id,ConstantMessage.INPUT_PARIWISATA);
			}
			else if(platform.equalsIgnoreCase("line")) {
				lController.sendLineText(id,ConstantMessage.INPUT_PARIWISATA);
			}
			else if(platform.equalsIgnoreCase("facebook")) {
				fController.sendBackText(id,ConstantMessage.INPUT_PARIWISATA);
			}
			Event event = eRepository.findOne(2);
			State state = new State(id, event, platform);
			sRepository.save(state);
		}
		else if(text.equalsIgnoreCase("rumah makan")){
			fitur = "rumah makan";
			if(platform.equalsIgnoreCase("kaskus")) {
				kController.sendMessage(id,ConstantMessage.INPUT_RUMAH_MAKAN);
			}
			else if(platform.equalsIgnoreCase("line")) {
				lController.sendLineText(id,ConstantMessage.INPUT_RUMAH_MAKAN);
			}
			else if(platform.equalsIgnoreCase("facebook")) {
				fController.sendBackText(id,ConstantMessage.INPUT_RUMAH_MAKAN);	
			}
			Event event = eRepository.findOne(3);
			State state = new State(id, event, platform);
			sRepository.save(state);
		}
		else if(!fitur.equalsIgnoreCase("none")){
			if(fitur.equalsIgnoreCase("pariwisata")){
				if(platform.equalsIgnoreCase("kaskus")) {
					kController.sendListRequest(id,gController.sendListPariwisata(text),text);
				}
				else if(platform.equalsIgnoreCase("line")) {
					lController.sendListRequest(id,gController.sendListPariwisata(text),text);
				}
				else if(platform.equalsIgnoreCase("facebook")) {
					fController.sendListRequest(id,gController.sendListPariwisata(text),text);
				}
			}
			else if(fitur.equalsIgnoreCase("rumah makan")){
				if(platform.equalsIgnoreCase("kaskus")) {
					kController.sendListRequest(id,gController.sendListRumahMakan(text),text);
				}
				else if(platform.equalsIgnoreCase("line")) {
					lController.sendListRequest(id,gController.sendListRumahMakan(text),text);
				}
				else if(platform.equalsIgnoreCase("facebook")) {
					fController.sendListRequest(id,gController.sendListRumahMakan(text),text);
				}
			}
		}
		else{
			if(platform.equalsIgnoreCase("kaskus")) {
				kController.sendMessage(id,ConstantMessage.TEXT_DASHBOARD);
				kController.sendInteractiveText(id);
			}
			else if(platform.equalsIgnoreCase("line")){
				lController.sendLineText(id,ConstantMessage.WELCOME);
				lController.sendOptionButton(id);
			}
			else if(platform.equalsIgnoreCase("facebook")){
				fController.sendBackText(id,ConstantMessage.WELCOME);
				fController.sendTemplateButton(id);
			}
			Event event = eRepository.findOne(1);
			State state = new State(id, event, platform);
			sRepository.save(state);
		}

	}
	
}

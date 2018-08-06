package com.Pariwisata.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Pariwisata.models.pariwisata.Pariwisata;

@Service
public class GoogleAPIController {
	@Autowired
	RestTemplate restTemplate;
	
	private static final String KEY = "AIzaSyCoGXiujh2PMB9hgZkrwdFHxi9m4KHCkS0";
	
	public Pariwisata sendListPariwisata(String kota){
		Pariwisata pariwisata = restTemplate.getForObject("https://maps.googleapis.com/maps/api/place/textsearch/json?query=daftar+tempat+pariwisata+di+"+kota+"&key="+KEY, Pariwisata.class);
		return pariwisata;
	}
	
	public Pariwisata sendListRumahMakan(String kota){
		Pariwisata pariwisata = restTemplate.getForObject("https://maps.googleapis.com/maps/api/place/textsearch/json?query=daftar+tempat+rumah+makan+di+"+kota+"&key="+KEY, Pariwisata.class);
		return pariwisata;
	}
	
	public String sendPhoto(String kota){
		String photo = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference="+kota+"&key="+KEY;
		return photo;
	}
	
}

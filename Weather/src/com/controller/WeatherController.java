package com.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class WeatherController {

@RequestMapping("/")
public String home() {
	return "Home";
}
@ResponseBody
@RequestMapping("/weather")
public String weather(@RequestParam String weather) throws JSONException {
	
	JSONObject object = new JSONObject(weather);
	
	return object.get("latitude")+"";
}


}

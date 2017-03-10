package com.tactfactory.dofus;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tactfactory.dofus.entities.BonusPrimaire;
import com.tactfactory.dofus.entities.Condition;
import com.tactfactory.dofus.entities.Effet;
import com.tactfactory.dofus.entities.Stat;
import com.tactfactory.dofus.entities.Weapon;

public class Application {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();

		/*
		 * Weapon weapon = new Weapon(); ArrayList<BonusPrimaire> bonus = new
		 * ArrayList<BonusPrimaire>(); BonusPrimaire b1 = new BonusPrimaire();
		 * b1.setName("a taper y a deux p");
		 * b1.setPicture("http://bourrin.com");
		 *
		 * BonusPrimaire b2 = new BonusPrimaire(); b2.setName("tapper p");
		 * b2.setPicture("http://bourrin-life.com");
		 *
		 * bonus.add(b1); bonus.add(b2);
		 *
		 * weapon.setBonus(bonus); weapon.setConditions(new
		 * ArrayList<Condition>());
		 * weapon.setDescription("arme qui fait mal tres fort une fois");
		 *
		 * ArrayList<Effet> effects = new ArrayList<Effet>();
		 *
		 * Effet e1 = new Effet(); e1.setName("a taper y a deux p");
		 * e1.setPicture("http://bourrin.com");
		 * e1.setDescription("tape 2* plus fort");
		 *
		 * Effet e2 = new Effet(); e2.setName("tapper p");
		 * e2.setPicture("http://bourrin-life.com");
		 * e2.setDescription("tape 4* plus fort");
		 *
		 * Effet e3 = new Effet(); e3.setName("ko mode");
		 * e3.setPicture("https://boucher-de-kentergburi.com");
		 * e1.setDescription("des petites tranchettes");
		 *
		 * effects.add(e1); effects.add(e2); effects.add(e3);
		 *
		 * weapon.setEffets(effects);
		 *
		 * weapon.setLevel(1000); weapon.setName("gourdinator");
		 * weapon.setPicture("https://google.com");
		 *
		 * ArrayList<Stat> stats = new ArrayList<Stat>();
		 *
		 * Stat s1 = new Stat(); s1.setName("force");
		 * s1.setPicture("http://come-to-the-dark-side.png");
		 * s1.setStatName("force"); s1.setValue("10 / 2 * 3 +6 -7 * 10");
		 *
		 * Stat s2 = new Stat(); s2.setName("dexterite");
		 * s2.setPicture("http://yolo-dodge.png"); s2.setStatName("dexterite");
		 * s2.setValue("10");
		 *
		 * stats.add(s1); stats.add(s2);
		 *
		 * weapon.setStats(stats); weapon.setType("gourdin");
		 *
		 * String test = ""; try { test = mapper.writeValueAsString(weapon); }
		 * catch (JsonProcessingException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } System.out.println(test);
		 *
		 * /* test = test.replace(",", ",\n"); test = test.replace("{", "{\n");
		 * test = test.replace("[", "[\n");
		 *
		 * System.out.print(test);
		 */

		/*
		 * File file = new File(".\\jsonFiles\\");
		 *
		 * if (!file.exists()) { boolean result = false;
		 *
		 * result = file.mkdirs(); }
		 *
		 * File file1 = new File(".\\jsonFiles\\arme1.json");
		 *
		 * PrintWriter out = null; try { out = new PrintWriter(new
		 * BufferedWriter( new FileWriter(file1, false)));
		 * mapper.writeValue(out, weapon); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } finally{
		 * out.close(); }
		 *
		 * Weapon weep = new Weapon(); try { weep = mapper.readValue(file1,
		 * Weapon.class); } catch (JsonParseException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch
		 * (JsonMappingException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 *
		 * System.out.println(weep);
		 */

		String baseUrl = "http://www.dofus.com";
		String armesUrlBase = "/fr/mmorpg/encyclopedie/armes";

		String result = GetHttpStringItem(baseUrl+armesUrlBase);
		result = result.substring(result.indexOf("<tbody>"),
				result.indexOf("</tbody>"));
		result = result.replace("<tbody>", "");
		result = result.replace("<tr class=\"ak-bg-odd\" >", "");
		result = result.replace("<tr class=\"ak-bg-even\" >", "");

		while(result.contains("<a href") && result.contains("<img src=")){
			String tmp = "";
			tmp = result.substring(result.indexOf("<a href=\""), result.indexOf("\">",result.indexOf("<a href=\"")));
			tmp = tmp.replace("<a href=\"", "");
			String detail = GetHttpStringItem(baseUrl+tmp);
		}

		System.out.println(result);
	}

	public static String GetHttpStringItem(String goTo) {
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(goTo);
		HttpResponse response;
		try {
			response = client.execute(httpGet);

			ResponseHandler<String> handler = new BasicResponseHandler();
			return handler.handleResponse(response);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

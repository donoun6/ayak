package com.ayak.phms.pill;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;

public class MedicineData {
	
	public static void main(String[] args) throws IOException {
		int[] arr_num = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100};
		int[] location_num = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100};
		int count = 0;
		String[] company = new String[arr_num[0]];
		String[] drugName = new String[arr_num[1]];
		String[] drugEffect = new String[arr_num[2]];
		String[] useDrug = new String[arr_num[3]];
		String[] beforeWarn = new String[arr_num[4]];
		String[] afterWarn = new String[arr_num[5]];
		String[] interaction = new String[arr_num[6]];
		String[] sideEffect = new String[arr_num[7]];
		String[] storage_Method = new String[arr_num[8]];
		String[] drugImage = new String[arr_num[9]];
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=8WoPefBD%2BySzxWU8TAgL3ujsJSYmuElrcobBfOkEknwIL7FUHBtWk0oFZJ0yJ3oYbQ4E2gKwrx0aGNZ4BmLvnw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("entpName","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*업체명*/
        urlBuilder.append("&" + URLEncoder.encode("itemName","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*제품명*/
        urlBuilder.append("&" + URLEncoder.encode("itemSeq","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*품목기준코드*/
        urlBuilder.append("&" + URLEncoder.encode("efcyQesitm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*이 약의 효능은 무엇입니까?*/
        urlBuilder.append("&" + URLEncoder.encode("useMethodQesitm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*이 약은 어떻게 사용합니까?*/
        urlBuilder.append("&" + URLEncoder.encode("atpnWarnQesitm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*이 약을 사용하기 전에 반드시 알아야 할 내용은 무엇입니까?*/
        urlBuilder.append("&" + URLEncoder.encode("atpnQesitm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*이 약의 사용상 주의사항은 무엇입니까?*/
        urlBuilder.append("&" + URLEncoder.encode("intrcQesitm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*이 약을 사용하는 동안 주의해야 할 약 또는 음식은 무엇입니까?*/
        urlBuilder.append("&" + URLEncoder.encode("seQesitm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*이 약은 어떤 이상반응이 나타날 수 있습니까?*/
        urlBuilder.append("&" + URLEncoder.encode("depositMethodQesitm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*이 약은 어떻게 보관해야 합니까?*/
        urlBuilder.append("&" + URLEncoder.encode("openDe","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*공개일자*/
        urlBuilder.append("&" + URLEncoder.encode("updateDe","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*수정일자*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*응답데이터 형식(xml/json) Default:xml*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        String M_data = sb.toString();
        M_data = M_data.replaceAll("</", "");
        String[] M_data_Array = M_data.split("<");
        
        
        
        rd.close();
        conn.disconnect();
        for(int i = 0; i < M_data_Array.length; i++) {
        	if(M_data_Array[i] != null) {
        		M_data_Array[i] = M_data_Array[i].replaceAll(">", ":");
        	}
        }
        for(int i = 0; i < M_data_Array.length; i++) {
        	M_data_Array[i] = M_data_Array[i].replaceAll(">", ":");
        	M_data_Array[i] = M_data_Array[i].replaceAll("&lt;p", "");
        	M_data_Array[i] = M_data_Array[i].replaceAll("&lt;/p", "");
        	M_data_Array[i] = M_data_Array[i].replaceAll("&lt;", "");
        	M_data_Array[i] = M_data_Array[i].replaceAll("&lt;/", "");
        	M_data_Array[i] = M_data_Array[i].replaceAll("&gt;", "");
        	M_data_Array[i] = M_data_Array[i].replaceAll("sup", "");
        	M_data_Array[i] = M_data_Array[i].replaceAll("sub", "");
        	M_data_Array[i] = M_data_Array[i].replaceAll("/정", "정");
        	M_data_Array[i] = M_data_Array[i].replaceAll("/포", "포");
        	M_data_Array[i] = M_data_Array[i].replaceAll("/병", "병");
        		if(M_data_Array[i].contains("entpName") == true) {
            		M_data_Array[i] = M_data_Array[i].replaceAll("entpName:", "");
            		M_data_Array[i] = M_data_Array[i].replaceAll("entpName/:", "");
            		company[arr_num[count]-location_num[count]] = M_data_Array[i];
            		location_num[count]--;
            		count++;
        		}else if(M_data_Array[i].contains("itemName") == true) {
        			M_data_Array[i] = M_data_Array[i].replaceAll("itemName:", "");
        			M_data_Array[i] = M_data_Array[i].replaceAll("itemName/:", "");
        			
        			drugName[arr_num[count]-location_num[count]] = M_data_Array[i];
            		location_num[count]--;
            		count++;
        		}else if(M_data_Array[i].contains("efcyQesitm") == true) {
        			M_data_Array[i] = M_data_Array[i].replaceAll("efcyQesitm:", "");
        			M_data_Array[i] = M_data_Array[i].replaceAll("efcyQesitm/:", "");
        			drugEffect[arr_num[count]-location_num[count]] = M_data_Array[i];
            		location_num[count]--;
            		count++;
        		}else if(M_data_Array[i].contains("useMethodQesitm") == true) {
        			M_data_Array[i] = M_data_Array[i].replaceAll("useMethodQesitm:", "");
        			M_data_Array[i] = M_data_Array[i].replaceAll("useMethodQesitm/:", "");
        			useDrug[arr_num[count]-location_num[count]] = M_data_Array[i];
            		location_num[count]--;
            		count++;
        		}else if(M_data_Array[i].contains("atpnWarnQesitm") == true) {
        			M_data_Array[i] = M_data_Array[i].replaceAll("atpnWarnQesitm:", "");
        			M_data_Array[i] = M_data_Array[i].replaceAll("atpnWarnQesitm/:", "");
        			beforeWarn[arr_num[count]-location_num[count]] = M_data_Array[i];
            		location_num[count]--;
            		count++;
        		}else if(M_data_Array[i].contains("atpnQesitm") == true) {
        			M_data_Array[i] = M_data_Array[i].replaceAll("atpnQesitm:", "");
        			M_data_Array[i] = M_data_Array[i].replaceAll("atpnQesitm/:", "");
        			afterWarn[arr_num[count]-location_num[count]] = M_data_Array[i];
            		location_num[count]--;
            		count++;
        		}else if(M_data_Array[i].contains("intrcQesitm") == true) {
        			M_data_Array[i] = M_data_Array[i].replaceAll("intrcQesitm:", "");
        			M_data_Array[i] = M_data_Array[i].replaceAll("intrcQesitm/:", "");
        			interaction[arr_num[count]-location_num[count]] = M_data_Array[i];
            		location_num[count]--;
            		count++;
        		}else if(M_data_Array[i].contains("seQesitm") == true) {
        			M_data_Array[i] = M_data_Array[i].replaceAll("seQesitm:", "");
        			M_data_Array[i] = M_data_Array[i].replaceAll("seQesitm/:", "");
        			sideEffect[arr_num[count]-location_num[count]] = M_data_Array[i];
            		location_num[count]--;
            		count++;
        		}else if(M_data_Array[i].contains("depositMethodQesitm") == true) {
        			M_data_Array[i] = M_data_Array[i].replaceAll("depositMethodQesitm:", "");
        			M_data_Array[i] = M_data_Array[i].replaceAll("depositMethodQesitm/:", "");
        			storage_Method[arr_num[count]-location_num[count]] = M_data_Array[i];
            		location_num[count]--;
            		count++;
        		}else if(i == M_data_Array.length-1) {
        			M_data_Array[i] = M_data_Array[i].replaceAll("items:", "");
        			M_data_Array[i] = M_data_Array[i].replaceAll("body:", "");
        			M_data_Array[i] = M_data_Array[i].replaceAll("response:", "");
        			M_data_Array[i] = M_data_Array[i].replaceAll("itemImage:", "");
        			M_data_Array[i] = M_data_Array[i].replaceAll("itemImage/:", "");
        			M_data_Array[i] = M_data_Array[i].replaceAll("item:", "");
        			drugImage[arr_num[count]-location_num[count]] = M_data_Array[i];
            		location_num[count]--;
            		count = 0;
        		}else if(M_data_Array[i].contains("itemImage") == true) {
        			M_data_Array[i] = M_data_Array[i].replaceAll("itemImage:", "");
        			M_data_Array[i] = M_data_Array[i].replaceAll("itemImage/:", "");
        			M_data_Array[i] = M_data_Array[i].replaceAll("item:", "");
        			M_data_Array[i] = M_data_Array[i].replaceAll("/PBP/CMN/ITEMIMAGEDOWNLOAD/", "/pbp/cmn/itemImageDownload/");
        			drugImage[arr_num[count]-location_num[count]] = M_data_Array[i];
        			location_num[count]--;
            		count = 0;
            		
        		}
        }
        
        Medicine medi = new Medicine();
        MedicineDao medi_dao = new MedicineDao();
        for(int i = 0; i < arr_num[0]; i++) {
        	medi.setM_Company(company[i]);
        	medi.setM_DrugName(drugName[i]);
        	medi.setM_DrugEffect(drugEffect[i]);
        	medi.setM_UseDrug(useDrug[i]);
        	medi.setM_BeforeWarn(beforeWarn[i]);
        	medi.setM_AfterWarn(afterWarn[i]);
        	medi.setM_Interaction(interaction[i]);
        	medi.setM_SideEffect(sideEffect[i]);
        	medi.setM_StorageMethod(storage_Method[i]);
        	medi.setM_DrugImage(drugImage[i]);
        	medi_dao.add_Pill(medi);
        }
    }
}

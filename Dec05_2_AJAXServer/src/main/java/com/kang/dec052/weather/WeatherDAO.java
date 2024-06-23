package com.kang.dec052.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class WeatherDAO {
	//	기상청 xml 다운(파싱) 받아서 -> String 한 덩어리로 뭉쳐서 그대로 리턴
	//	https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1150060300
	
	public String getKorWeather(HttpServletRequest req) {
		try {
			String url="https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1150060300";
			URL u = new URL(url);
			
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				
			// 나오는 하나하나를 한 덩어리로 뭉치기
			StringBuffer sb = new StringBuffer();
			
			String line = null;
			while((line = br.readLine()) !=null) {
				sb.append(line.replace("\r\n", ""));
				//받아온 데이터들 엔터 없애고 한 덩어리로 뭉치는 작업
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

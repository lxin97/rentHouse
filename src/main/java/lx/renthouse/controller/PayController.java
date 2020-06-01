package lx.renthouse.controller;

import lx.renthouse.utils.HttpRequest;
import lx.renthouse.utils.SecurityUtils;
import lx.renthouse.vo.API.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/nihaopay")
public class PayController {
	private static final Logger logger = LoggerFactory.getLogger(PayController.class);
	
	private static final String token = "e68e6e5f84a43a8c9a6226dc93a88b9c22e7955884411b887484da7adadc52a3";


	@RequestMapping(value = "/APISecurePay", method = RequestMethod.POST)
	public  void APISecurePay(APISecurePayReqVO payReq,
                              HttpServletResponse resp) {
		try {
		/*	if (errors.hasErrors()) {
				resp.getWriter().print(errors.getAllErrors());
			}*/
			System.out.println(payReq.getUrl());
			System.out.println(payReq.getToken());
			logger.info("Do API SecurePay: " + payReq.getInput());
			String result = HttpRequest.sendAuthPost(payReq.getUrl(), payReq.getInput(), "Bearer " + payReq.getToken());
			logger.info("get response from php_API: " + result);
			resp.setCharacterEncoding("UTF-8");
			resp.setHeader("Content-type", "text/html");// jquery post must return json type
			resp.getWriter().print(result);
			//return result;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
	}


	@RequestMapping(value = "/APIRefund", method = RequestMethod.POST)
	public void APIRefund(@RequestBody APIRefundReqVO payReq,
                          BindingResult errors, HttpServletResponse resp) {
		try {
			if (errors.hasErrors()) {
				resp.getWriter().print(errors.getAllErrors());
			}
			logger.info("Do API Refund: " + payReq);
			String url = payReq.getUrl().replace("{transaction_id}", payReq.getTransaction_id());
			String result = HttpRequest.sendAuthPost(url, payReq.getInput(), "Bearer " + payReq.getToken());
			logger.info("get response from php_API: " + result);
			resp.setCharacterEncoding("UTF-8");
			resp.setHeader("Content-type", "application/json");// jquery post must return json type
			resp.getWriter().print(result);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
	}


	@RequestMapping(value = "/callback")
	public ModelAndView callback(HttpServletRequest request) {
		try {
			logger.info("callback request:");
			logger.info(getClientInfo(request));

			Map<String, String[]> params = request.getParameterMap();
			if (params.size() < 1) {
				return new ModelAndView("callback", "result", "Response status:" + HttpServletResponse.SC_NO_CONTENT);
			}
			StringBuilder str = new StringBuilder();
			str.append("Form Data:");
			for (String key : params.keySet()) {
				String[] values = params.get(key);
				for (int i = 0; i < values.length; i++) {
					String value = values[i];
					str.append("<br/>" + key + "=" + value);
				}
			}
			Set<String> keySet = params.keySet();
			List<String> keyList = new ArrayList<String>(keySet);
			Collections.sort(keyList);
			StringBuffer mdStr = new StringBuffer();
			for (String key : keyList) {
				String value = params.get(key)[0];
				if (!key.equals("verify_sign") && params.get(key) != null && value != null && !value.equals("null")) {
					mdStr.append(key + "=" + value + "&");
				}
			}
			logger.info("sign prams string:" + mdStr.toString());
			mdStr.append(SecurityUtils.MD5(token).toLowerCase());
			logger.info("prams and token sign string:" + mdStr.toString());
			String verify_sign = params.get("verify_sign")[0];
			String sign = SecurityUtils.MD5(mdStr.toString()).toLowerCase();
			logger.info("sign string:" + sign);
			logger.info("verify_sign string:" + verify_sign);
			if (sign.equals(verify_sign)) {
				str.append("<br/>sign_vlidated -> true");
			} else {
				str.append("<br/>sign_vlidated -> false");
			}
			logger.info("Callback " + str.toString());
			return new ModelAndView("callback", "result", str.toString());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return new ModelAndView("callback", "result", e.getMessage());
		}
	}



	public static String getClientInfo(HttpServletRequest request) {
		StringBuilder str = new StringBuilder();
		str.append("\r\n ----------New Request---------------");
		str.append("\r\n RequestURL:" + request.getRequestURL());
		str.append("\r\n Request Header");
		str.append("\r\n Origin:" + request.getHeader("Origin"));
		str.append("\r\n Referer:" + request.getHeader("Referer"));
		str.append("\r\n Accept:" + request.getHeader("Accept"));
		str.append("\r\n Host:" + request.getHeader("Host"));
		str.append("\r\n User-Agent:" + request.getHeader("User-Agent"));
		str.append("\r\n Locale:" + request.getLocale());
		str.append("\r\n Protocol:" + request.getProtocol());
		str.append("\r\n Scheme:" + request.getScheme());
		str.append("\r\n Connection:" + request.getHeader("Connection"));
		str.append("\r\n Character Encoding:" + request.getCharacterEncoding());
		str.append("\r\n Content Type:" + request.getContentType());
		str.append("\r\n Content Length:" + request.getContentLength());
		str.append("\r\n Http Method:" + request.getMethod());
		str.append("\r\n Remote Addr: " + request.getRemoteAddr());
		str.append("\r\n Remote Host: " + request.getRemoteHost());
		str.append("\r\n Remote Port: " + request.getRemotePort());
		str.append("\r\n Remote User: " + request.getRemoteUser());
		str.append("\r\n Query String: " + request.getQueryString());
		str.append("\r\n Form Data:");
		Map<String, String[]> params = request.getParameterMap();
		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				String value = values[i];
				str.append("\r\n " + key + " -> " + value);
			}
		}
		str.append("\r\n ----------End Request---------------");
		return str.toString();
	}
}

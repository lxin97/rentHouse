package lx.renthouse.controller;

import lx.renthouse.Pojo.Topaid;
import lx.renthouse.service.TopaidService;
import lx.renthouse.vo.API.APISecurePayReqVO;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class CreatePayController {

    @Autowired
    private PayController apiSecurePay;
    @Autowired
    private TopaidService topaidService;

    //点击报障后跳转到添加报障信息页面
    @GetMapping("/selectPay")
    public ModelAndView selectPay(Integer id){
        System.out.println("id=========="+id);
        ModelAndView view = new ModelAndView();
        String topaidid=""+id;
        view.addObject("toPaidId", topaidid);
        view.addObject("mainPage", "selectPay.jsp");
        view.setViewName("zuke/main");
        return view;
    }

    @RequestMapping("/create")
    public void creatPay(@RequestParam("vendor") String vendor,@RequestParam("toPaidId") Integer toPaidId, HttpServletResponse resp, HttpSession httpSession){
        //id= (Integer) httpSession.getAttribute("topaidId");
        System.out.println("id222========"+toPaidId+"ventor==="+vendor);
        Topaid topaid = topaidService.findbyid(toPaidId);
        System.out.println("houseId=="+topaid.getHouse_id()+"price==="+topaid.getPrice());
        APISecurePayReqVO payReqVO=new APISecurePayReqVO();
        String orderId = "TEST_" + DateFormatUtils.format(new Date(), "yyyyMMddHHmmss") + "_" + RandomStringUtils.random(5, true, true).toUpperCase();
        System.out.println("id=============>"+toPaidId);
        payReqVO.setCurrency("USD");
        payReqVO.setReference(orderId);
        payReqVO.setIpn_url("https://apitest.nihaopay.com/v1.2");
        payReqVO.setUrl("https://apitest.nihaopay.com/v1.2/transactions/securepay");
        payReqVO.setCallback_url("http://5yjfqd.natappfree.cc/text2/paid/gotopay.action?topaidId="+toPaidId);
        payReqVO.setDescription("test");
        int price= (int) (topaid.getPrice()*100);
        payReqVO.setRmb_amount(""+price);
        payReqVO.setVendor(vendor);
        payReqVO.setToken("e68e6e5f84a43a8c9a6226dc93a88b9c22e7955884411b887484da7adadc52a3");

        apiSecurePay.APISecurePay(payReqVO,resp);

    }
}

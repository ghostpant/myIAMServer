package my.iam.controller;


import my.iam.service.WxAppletService;
import my.iam.utils.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WxAppletController {



    private final WxAppletService wxAppletService;

    @Autowired
    public WxAppletController(WxAppletService wxAppletService) {
        this.wxAppletService = wxAppletService;
    }

    @PostMapping(value = "/wx/get/AccessToken")
    public ApiResult getWxAppletQRcode(){

        return wxAppletService.getQRcode();
    }
}

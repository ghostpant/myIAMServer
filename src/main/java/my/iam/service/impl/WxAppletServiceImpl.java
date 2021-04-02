package my.iam.service.impl;

import my.iam.builder.ApiResultBuilder;
import my.iam.httpRequest.WxApiHttp;
import my.iam.info.params.WxQRcodeParams;
import my.iam.service.WxAppletService;
import my.iam.utils.ApiResult;
import my.iam.utils.RedisUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class WxAppletServiceImpl implements WxAppletService {


    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=${APPID}&secret=${APPSECRET}";
    private static final String QR_CODE_URL = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=${ACCESS_TOKEN}";
    private static final String APP_ID = "wx82c909ba37e8aec4";
    private static final String APP_SECERT = "ce1141179eb430110dfec32b9d925a2a";
    private final RedisUtil redisUtil;

    public WxAppletServiceImpl(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Override
    public ApiResult getQRcode() {
        String accessToken = getAccessTokenUrl();
        WxQRcodeParams params = WxQRcodeParams.builder().scene("01234567890123456789").build();
        String qrurl = QR_CODE_URL.replace("${ACCESS_TOKEN}", accessToken);
        String codeBuffer = WxApiHttp.doPostWxAppletQRcode(qrurl, params);
        return ApiResultBuilder.success("11", "success", codeBuffer).build();
    }


    private String getAccessTokenUrl() {
        String accessToken = null;
        accessToken = (String) redisUtil.get("WX_APPLET_ACCESS_TOKEN");
        if (!StringUtils.isEmpty(accessToken)) {
            return accessToken;
        }
        String url = ACCESS_TOKEN_URL.replace("${APPID}", APP_ID).replace("${APPSECRET}", APP_SECERT);
        accessToken = WxApiHttp.doGetWxAppletAccessToken(url);
        redisUtil.set("WX_APPLET_ACCESS_TOKEN", accessToken, 7200);
        return accessToken;
    }
}

package com.sech.framework.core.commons.https;

import com.sech.framework.core.utils.StringHelper;
import org.springframework.web.client.RestTemplate;

/**
 * 通过请求URL获取不同类别的RestTemplate
 *
 * @author sech.io
 */
public class HttpUtil {

    public static final String HTTPS = "https";

    public static RestTemplate restTemplate(String reqUrl) {
        if (StringHelper.isBlank(reqUrl)) return new RestTemplate();

        return reqUrl.startsWith(HTTPS) ? new RestTemplate(new HttpsClientRequestFactory())
                : new RestTemplate();
    }
}

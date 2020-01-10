package service;

import com.ipaynow.security.sign.ecdsa.SignUtil;
import org.junit.Test;

public class TestVerify {

    @Test
    public void verify() throws Exception {
        String joinMessagePubkey = "04b64025214c2673b914050c93ac8a603d8b377ffb91971da0484fbbfc59673172c96f72aba0abf01c96cdf0fca0de8e175485947d38bec0ef84f63de8bae1fe85";
        String message = "{\"data\":{\"mn\":\"上海小荧星教育培训有限公司\",\"type\":5,\"iotmu\":290,\"uioipn\":\"mch2018092615379249998636626\"},\"sign\":\"861ae985e094f50bb6c586b41d9b913ac1bf706a2dfeff29011784eb6002746334851cd9290cafc4efa66efbaabfead83897660512c8e526db39b5ba4f4d1b6101\"}";
        boolean verify = SignUtil.verify(joinMessagePubkey, message);
        System.out.println("verify:" + verify);
    }
}

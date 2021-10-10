import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.junit.Test;

public class MyTest {
    @Test
    public void test() {
        String appId = "wx3912bc23bde5849f";
        String secret = "f9d04bd4a21553bf55acd58b23855621";
        String jsCode = "013dCK100zK5AM1nzc200oqKQM0dCK16";
        String s = HttpUtil.get("https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + secret + "&js_code=" + jsCode + "&grant_type=authorization_code");
        System.out.println(s);
        JSONObject jsonObject = JSONUtil.parseObj(s);
        System.out.println(jsonObject.getStr("openid"));

    }

}

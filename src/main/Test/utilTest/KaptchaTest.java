package utilTest;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ssm.blog.util.StringUtil;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Administrator on 2017/3/8 0008.
 */
@Controller
@RequestMapping("/captcha")
public class KaptchaTest {
    @Resource
    private Producer captchaProducer;

    @RequestMapping(value = "/getCaptchaImage",method = RequestMethod.GET)
    public ModelAndView getCaptchaImage(Model model, HttpServletResponse response, HttpServletRequest request,
                                        @RequestParam(value = "timestamp",required = false)String timestamp) throws IOException {

        if(StringUtil.isEmpty(timestamp)){
            //无时间戳
            model.addAttribute("timestamp",System.currentTimeMillis());
        }else{
            //有时间戳
            model.addAttribute("timestamp",timestamp);
        }
        response.setDateHeader("Expires",0);
        response.setHeader("Cache-Control","no-store,no-cache,must-revalidate");
        //兼容IE5
        response.addHeader("Cache-Control","post-check=0,pre-check=0");
        //兼容http1.0
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = captchaProducer.createText();

        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY,capText);
        BufferedImage bufferedImage = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bufferedImage,"jpg",out);
        try {
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.close();
        }

        return null;

    }

}

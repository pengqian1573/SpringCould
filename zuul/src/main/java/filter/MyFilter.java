package filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MyFilter extends ZuulFilter {

    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     pre：路由之前
     routing：路由之时
     post： 路由之后
     error：发送错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤器顺序越小越先执行
    @Override
    public int filterOrder() {
        return 1;
    }

    //这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx =RequestContext.getCurrentContext();
        HttpServletRequest request =ctx.getRequest();
        String token =request.getHeader("token");
        if (StringUtils.isBlank(token)){

           token=request.getParameter("token");
        }

        if(StringUtils.isBlank(token)){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        System.out.println("token : " + token);


        return null;
    }
}

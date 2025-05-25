package umc.spring.validation.resolver;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.validation.annotation.ValidPage;

@Component
@RequiredArgsConstructor
public class ValidPageResolver implements HandlerMethodArgumentResolver{

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        System.out.println("supportParameter 호출됨");
        return parameter.hasParameterAnnotation(ValidPage.class)
                && parameter.getParameterType().equals(Integer.class)
                || parameter.getParameterType().equals(int.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {
        System.out.println("validPageResolver 호출됨");

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        String pageStr = request.getParameter("page");
        if (pageStr == null) {
            throw new GeneralException(ErrorStatus.PAGE_MISSING);
        }

        int page = Integer.parseInt(pageStr);

        if (page < 1) {
            throw new GeneralException(ErrorStatus.INVALID_PAGE_RANGE);
        }

        return page - 1;
    }
}

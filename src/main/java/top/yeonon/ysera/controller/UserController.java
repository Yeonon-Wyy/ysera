package top.yeonon.ysera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.yeonon.ysera.common.exception.YseraException;
import top.yeonon.ysera.common.resp.ResponseCode;
import top.yeonon.ysera.common.resp.ServiceResponse;
import top.yeonon.ysera.common.util.CommonUtils;
import top.yeonon.ysera.entity.User;
import top.yeonon.ysera.repository.UserRepository;
import top.yeonon.ysera.service.IUserService;
import top.yeonon.ysera.vo.req.UserLoginReqVo;
import top.yeonon.ysera.vo.req.UserQueryReqVo;
import top.yeonon.ysera.vo.req.UserRegistrationReqVo;
import top.yeonon.ysera.vo.resp.UserLoginRespVo;
import top.yeonon.ysera.vo.resp.UserQueryRespVo;
import top.yeonon.ysera.vo.resp.UserRegistrationRespVo;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 * @author: yeonon
 * @date: 2019/12/23
 */
@RestController
@RequestMapping("/users")
public class UserController {

    public static final String CURRENT_USER = "CURRENT_USER";

    @Autowired
    private IUserService userService;

    @PostMapping
    public UserRegistrationRespVo register(@Valid @RequestBody UserRegistrationReqVo reqVo, BindingResult bindingResult) throws YseraException {
        if (bindingResult.hasErrors()) {
            throw new YseraException(ResponseCode.REQUEST_PARAM_ERROR.getCode(),
                    CommonUtils.generateErrorString(ResponseCode.REQUEST_PARAM_ERROR.getDescription(),bindingResult));
        }

        return userService.userRegistration(reqVo);
    }

    @PostMapping("/login")
    public UserLoginRespVo login(@Valid @RequestBody UserLoginReqVo reqVo, BindingResult bindingResult, HttpServletRequest servletRequest) throws YseraException {
        if (bindingResult.hasErrors()) {
            throw new YseraException(ResponseCode.REQUEST_PARAM_ERROR.getCode(),
                    CommonUtils.generateErrorString(ResponseCode.REQUEST_PARAM_ERROR.getDescription(),bindingResult));
        }

        if (servletRequest.getSession().getAttribute(CURRENT_USER) != null) {
            throw new YseraException(ResponseCode.USER_ALREADY_LOGIN.getCode(),
                    ResponseCode.USER_ALREADY_LOGIN.getDescription());
        }
        UserLoginRespVo respVo = userService.userLogin(reqVo);
        servletRequest.getSession().setAttribute(CURRENT_USER, respVo);
        return respVo;
    }

    @DeleteMapping("/logout")
    public ServiceResponse logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return new ServiceResponse(ResponseCode.SUCCESS.getCode(),
                ResponseCode.SUCCESS.getDescription(), null);
    }

    @GetMapping("/{id}")
    public UserQueryRespVo queryUser(@PathVariable("id")
                                         @NotNull(message = "id can't null")
                                         @PositiveOrZero(message = "id must greater or equals zero") Long id) throws YseraException {
        UserQueryReqVo reqVo = new UserQueryReqVo(id);
        return userService.userQuery(reqVo);
    }
}

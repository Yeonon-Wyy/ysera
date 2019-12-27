package top.yeonon.ysera.service;

import top.yeonon.ysera.common.exception.YseraException;
import top.yeonon.ysera.entity.User;
import top.yeonon.ysera.vo.req.UserLoginReqVo;
import top.yeonon.ysera.vo.req.UserQueryReqVo;
import top.yeonon.ysera.vo.req.UserRegistrationReqVo;
import top.yeonon.ysera.vo.resp.UserLoginRespVo;
import top.yeonon.ysera.vo.resp.UserQueryRespVo;
import top.yeonon.ysera.vo.resp.UserRegistrationRespVo;

/**
 * @author: yeonon
 * @date: 2019/12/23
 */
public interface IUserService {

    UserRegistrationRespVo userRegistration(UserRegistrationReqVo reqVo)
            throws YseraException;

    UserLoginRespVo userLogin(UserLoginReqVo reqVo)
            throws YseraException;

    UserQueryRespVo userQuery(UserQueryReqVo reqVo)
            throws YseraException;
}

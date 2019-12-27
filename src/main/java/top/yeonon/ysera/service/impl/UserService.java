package top.yeonon.ysera.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.yeonon.ysera.common.exception.YseraException;
import top.yeonon.ysera.common.resp.ResponseCode;
import top.yeonon.ysera.entity.User;
import top.yeonon.ysera.repository.UserRepository;
import top.yeonon.ysera.service.IUserService;
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
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserRegistrationRespVo userRegistration(UserRegistrationReqVo reqVo) throws YseraException {
        if (userRepository.existsByPhoneNumber(reqVo.getPhoneNumber())) {
            throw new YseraException(ResponseCode.PHONE_NUMBER_DUPLICATE.getCode(),
                    ResponseCode.PHONE_NUMBER_DUPLICATE.getDescription());
        }

        User user = new User(
                reqVo.getPhoneNumber(),
                DigestUtils.md5Hex(reqVo.getPassword()),
                reqVo.getNickName(),
                reqVo.getGender()
        );
        user = userRepository.saveAndFlush(user);
        return new UserRegistrationRespVo(user.getId());
    }

    @Override
    public UserLoginRespVo userLogin(UserLoginReqVo reqVo) throws YseraException {
        User user = userRepository.findByPhoneNumberAndPassword(reqVo.getPhoneNumber(), DigestUtils.md5Hex(reqVo.getPassword()));
        if (user == null) {
            throw new YseraException(ResponseCode.PHONE_NUMBER_OR_PASSWORD_ERROR.getCode(),
                    ResponseCode.PHONE_NUMBER_OR_PASSWORD_ERROR.getDescription());
        }

        return new UserLoginRespVo(
                user.getId(),
                user.getPhoneNumber(),
                user.getNickname(),
                user.getGender(),
                user.getCreateTime(),
                user.getUpdateTime()
        );

    }

    @Override
    public UserQueryRespVo userQuery(UserQueryReqVo reqVo) throws YseraException {
        User user = userRepository.findById(reqVo.getId()).orElse(null);
        if (user == null) {
            throw new YseraException(ResponseCode.USER_ID_ERROR.getCode(),
                    ResponseCode.USER_ID_ERROR.getDescription());
        }

        return new UserQueryRespVo(
                user.getPhoneNumber(),
                user.getNickname(),
                user.getGender(),
                user.getCreateTime(),
                user.getUpdateTime()
        );
    }
}

package org.onecmdb.facade;

import org.onecmdb.dto.RestResult;
import org.onecmdb.dto.SignInDTO;
import org.onecmdb.dto.SignUpDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 账号
 *
 * @author tom
 */
public interface AccountRestService {
    /**
     * 注册
     */
    RestResult signUp(SignUpDTO signUp);

    /**
     * 登录
     */
    RestResult signIn(SignInDTO signIn, HttpServletRequest request, HttpServletResponse response);

    /**
     * 退出
     */
    RestResult signOut();

}

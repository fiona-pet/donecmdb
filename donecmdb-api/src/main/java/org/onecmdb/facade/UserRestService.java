package org.onecmdb.facade;

import org.onecmdb.converter.Converter;
import org.onecmdb.dto.UserDTO;
import org.onecmdb.entity.User;

/**
 * 用户信息 接口
 * <p>
 * Created by tom on 2017-03-07 13:25:01.
 */
 public interface UserRestService extends CURDRestService<UserDTO>,Converter<UserDTO, User> {

 }

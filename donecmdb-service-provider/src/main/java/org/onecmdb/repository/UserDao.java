/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.onecmdb.repository;

import org.onecmdb.entity.User;

public interface UserDao extends DaoBase<User> {
  User findByLoginName(String loginName);
}

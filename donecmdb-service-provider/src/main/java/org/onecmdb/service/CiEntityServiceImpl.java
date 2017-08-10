package org.onecmdb.service;

import lombok.Getter;
import org.onecmdb.dto.ConfigurationItem;
import org.onecmdb.dto.ICi;
import org.onecmdb.dto.IPath;
import org.onecmdb.entity.CiEntity;
import org.onecmdb.repository.CiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * 用户信息
 * Created by tom on 2017-03-07 13:25:01.
 */


@Service
@Getter
public class CiEntityServiceImpl extends CURDServiceBase<CiEntity> implements CiEntityService {

    @Autowired
    private CiDao dao;

    @Override
    public CiEntity findCi(IPath<String> path) {
        return findCiByAlias(path);
    }

    @Override
    public CiEntity findCiByAlias(@NotNull IPath<String> path) {
        String name = path.getLeaf();

        CiEntity ciEntity = dao.findByAlias(name);

        return ciEntity;
    }
}

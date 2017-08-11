package org.onecmdb.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import io.swagger.annotations.ApiOperation;
import lombok.Setter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.onecmdb.dto.ListFilter;
import org.onecmdb.dto.RestResult;
import org.onecmdb.dto.SignInDTO;
import org.onecmdb.dto.SignUpDTO;
import org.onecmdb.entity.User;
import org.onecmdb.security.PermissionEnum;
import org.onecmdb.security.credentials.PasswordHelper;
import org.onecmdb.service.ModelService;
import org.onecmdb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * User: baiqw
 * Date: 14-12-9
 * Time: 下午3:45
 */
@Service(protocol = "rest")
@Path("cmdb/instance")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Setter
public class CmdbfInstanceRestServiceImpl implements CmdbInstanceRestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmdbfInstanceRestServiceImpl.class);

    @Autowired
    private ModelService modelService;

    @POST
    @Path("/list/{alias}")
    @ApiOperation("列表")
    @Override
    public RestResult<List> list(String alias, ListFilter listFilter) {
        return RestResult.OK(modelService.list(alias, listFilter));
    }
}

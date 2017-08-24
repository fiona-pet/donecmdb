package org.onecmdb.facade;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.onecmdb.dto.ListFilter;
import org.onecmdb.dto.PageSearch;
import org.onecmdb.dto.RestResult;
import org.springframework.data.domain.Page;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by X on 2017/4/17.
 */
public interface DBRestService<T> {
    @POST
    @Path("/{version}/{name}/list")
    @ApiOperation("列表")
    RestResult<List<T>> list(ListFilter listFilter);

    @POST
    @Path("/{version}/{name}/page")
    @ApiOperation("分页")
    RestResult<Page<T>> page(PageSearch pageSearch);

    @GET
    @Path("/{version}/{name}/{id}")
    @ApiOperation("详细信息")
    RestResult<T> detail(@ApiParam("id") @PathParam("id") Long id);

    @POST
    @Path("/{version}/{name}")
    @ApiOperation("添加/修改")
    RestResult<T> create(T entity);

    @DELETE
    @Path("/{version}/{name}/{id}")
    @ApiOperation("删除")
    RestResult<String> delete(@ApiParam("id") @PathParam("id") Long id);

    @POST
    @Path("/{version}/{name}/{method}")
    @ApiOperation("其他接口")
    RestResult<T> method(T entity);
}

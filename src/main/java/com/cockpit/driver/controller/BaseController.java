package com.cockpit.driver.controller;

import com.cockpit.driver.mapper.BaseRepository;
import com.cockpit.driver.utils.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@CrossOrigin
public class BaseController<B extends BaseRepository, E> {
  @Autowired
  protected HttpServletRequest request;
  @Autowired
  protected B baseBiz;

  /**
   * 添加一条记录
   *
   * @param entity
   * @return
   */
  @RequestMapping(value = "", method = RequestMethod.POST)
  @ResponseBody
  public ResultData<Object> add(@RequestBody E entity) {
    Object object = baseBiz.save(entity);
    return ResultData.success(object);
  }

  /**
   * 根据id或作业编号查询一条记录
   *
   * @param id
   * @return
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public ResultData<E> get(@PathVariable String id) {
    return ResultData.success((E) baseBiz.findById(id));
  }

  /**
   * 根据id或作业编号更新一条记录
   *
   * @param id
   * @param entity
   * @return
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  @ResponseBody
  public ResultData<E> update(@PathVariable String id,
      @RequestBody E entity) {
    baseBiz.saveAndFlush(entity);
    return ResultData.success(entity);
  }

  /**
   * 根据id删除
   *
   * @param id
   * @return
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  @ResponseBody
  public ResultData<E> remove(@PathVariable String id) {
    baseBiz.deleteById(id);
    return ResultData.success();
  }
}


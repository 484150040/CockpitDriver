package com.cockpit.driver.controller;

import com.cockpit.driver.entity.xf.WeBeditPlayer;
import com.cockpit.driver.mapper.WeBeditPlayerMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 信息发布
 */
@RestController
@CrossOrigin
@RequestMapping("/webeditplayer")
public class WeBeditPlayerController extends BaseController<WeBeditPlayerMapper, WeBeditPlayer> {
}

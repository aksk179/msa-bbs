package com.ksj.bbs.controller;

import com.ksj.bbs.service.BbsService;
import com.ksj.bbs.vo.BbsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class BbsRestController {

    @Autowired
    BbsService bbsService;

    @RequestMapping(value = "/manager/update_bbs_master.do", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> updateBbsMaster(@RequestBody BbsVO bbsVO) {
        Map<String, String> result = new HashMap<>();
        try {
            bbsService.updateBbsMasterOne(bbsVO);
            result.put("code", "Y");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", "N");
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/manager/create_bbs_master.do", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> createBbsMaster(@RequestBody BbsVO bbsVO) {
        Map<String, String> result = new HashMap<>();
        try {
            bbsService.createBbsMaster(bbsVO);
            result.put("code", "Y");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", "N");
        }
        return ResponseEntity.ok(result);
    }
}

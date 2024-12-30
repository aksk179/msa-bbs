package com.ksj.bbs.controller;

import com.ksj.bbs.service.BbsMasterService;
import com.ksj.bbs.vo.BbsMasterVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class BbsMasterRestController {

    @Autowired
    BbsMasterService bbsMasterService;

    @RequestMapping(value = "/manager/update_bbs_master.do", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> updateBbsMaster(@RequestBody BbsMasterVO bbsVO) {
        Map<String, String> result = new HashMap<>();
        try {
            bbsMasterService.updateBbsMasterOne(bbsVO);
            result.put("code", "Y");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", "N");
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/manager/create_bbs_master.do", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> createBbsMaster(@RequestBody BbsMasterVO bbsVO) {
        Map<String, String> result = new HashMap<>();
        try {
            bbsMasterService.createBbsMaster(bbsVO);
            result.put("code", "Y");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", "N");
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/manager/delete_bbs_master.do", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> deleteBbsMaster(@RequestBody BbsMasterVO bbsVO) {
        Map<String, String> result = new HashMap<>();
        try {
            bbsMasterService.deleteBbsMaster(bbsVO);
            result.put("code", "Y");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", "N");
        }
        return ResponseEntity.ok(result);
    }
}

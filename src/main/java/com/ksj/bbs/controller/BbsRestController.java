package com.ksj.bbs.controller;

import com.ksj.bbs.service.BbsMainService;
import com.ksj.bbs.vo.BbsCommentVO;
import com.ksj.bbs.vo.MemberVO;
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
    BbsMainService bbsMainService;

    @RequestMapping(value = "/bbs/createCmt.do", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> createCmt(@RequestBody BbsCommentVO bbsCommentVO) {
        Map<String, Object> result = new HashMap<>();
        try {
            MemberVO memberVO = new MemberVO();
            memberVO.setId("TTTT2");
            memberVO.setName("황희찬");

            bbsCommentVO.setBbsCmtWriter(memberVO.getName());
            bbsMainService.createCmt(bbsCommentVO);
            BbsCommentVO newBbsCmtVO = bbsMainService.selectCmt(bbsCommentVO);
            result.put("newBbsCmtVO", newBbsCmtVO);
            result.put("code", "Y");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", "N");
        }
        return ResponseEntity.ok(result);
    }


}

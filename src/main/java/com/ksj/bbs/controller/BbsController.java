package com.ksj.bbs.controller;

import com.ksj.bbs.service.BbsService;
import com.ksj.bbs.vo.BbsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
public class BbsController {

    @Autowired
    BbsService bbsService;

    @RequestMapping(value = "/manager/bbs_master_list.page")
    public String selectBbsMasterListPage(Model model) {
        List<BbsVO> bbsMasterList = bbsService.selectBbsMasterListPage(new BbsVO());
        model.addAttribute("bbsMasterList", bbsMasterList);
        System.out.println("bbsMasterList : " + bbsMasterList.toString());
        return "/manager/bbs_master_list";
    }

}

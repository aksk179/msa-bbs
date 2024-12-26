package com.ksj.bbs.controller;

import com.ksj.bbs.service.BbsService;
import com.ksj.bbs.vo.BbsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    BbsService bbsService;

    @RequestMapping(value = "/{dirPath}/{pageName}.page/{bbsId}")
    public String dynamicPage(@PathVariable("dirPath") String dirPath, @PathVariable("pageName") String pageName, @PathVariable("bbsId") String bbsId, Model model) {
        checkModel(pageName, bbsId, model);
        return "/" + dirPath + "/" + pageName;
    }

    @RequestMapping(value = "/{dirPath}/{pageName}.page")
    public String dynamicPage(@PathVariable("dirPath") String dirPath, @PathVariable("pageName") String pageName, Model model) {
        checkModel(pageName, "", model);
        return "/" + dirPath + "/" + pageName;
    }

    @RequestMapping(value = "/{pageName}.page")
    public String dynamicPage(@PathVariable("pageName") String pageName) {
        // "manager/" 폴더 아래의 페이지로 동적 전환
        return "/" + pageName;
    }

    private void checkModel(String pageName, String bbsId, Model model) {
        if (pageName.equals("bbs_master_list")) {
            List<BbsVO> bbsMasterList = bbsService.selectBbsMasterListPage(new BbsVO());
            model.addAttribute("bbsMasterList", bbsMasterList);
        } else if (pageName.equals("create_bbs_master")) {
            //수정
            if (!bbsId.isEmpty()) {
                BbsVO bbsVO = new BbsVO();
                bbsVO.setBbsId(bbsId);
                BbsVO resultVO = bbsService.selectBbsInfo(bbsVO);
                model.addAttribute("bbsVO", resultVO);
                model.addAttribute("title", "수정");
                model.addAttribute("btnName", "저장");
            }
            //등록
            else {
                model.addAttribute("bbsVO", new BbsVO());
                model.addAttribute("title", "등록");
                model.addAttribute("btnName", "등록");
            }
        }
    }
}

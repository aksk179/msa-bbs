package com.ksj.bbs.service;

import com.ksj.bbs.vo.BbsAttachVO;
import com.ksj.bbs.vo.BbsCommentVO;
import com.ksj.bbs.vo.BbsMainVO;
import com.ksj.bbs.vo.BbsMasterVO;

import java.util.List;

public interface BbsMainService {

    public List<BbsMainVO> selectBbsList(BbsMainVO bbsMainVO);

    public BbsMainVO selectBbsInfo(BbsMainVO bbsMainVO);

    public List<BbsAttachVO> selectBbsAttachList(BbsAttachVO bbsAttachVO);

    public List<BbsCommentVO> selectBbsCmtList(BbsCommentVO bbsCommentVO);
}

package com.ksj.bbs.service;

import com.ksj.bbs.mapper.BbsMainMapper;
import com.ksj.bbs.mapper.BbsMasterMapper;
import com.ksj.bbs.vo.BbsAttachVO;
import com.ksj.bbs.vo.BbsCommentVO;
import com.ksj.bbs.vo.BbsMainVO;
import com.ksj.bbs.vo.BbsMasterVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BbsMainServiceImpl implements BbsMainService {

    @Autowired
    BbsMainMapper bbsMainMapper;

    @Override
    public List<BbsMainVO> selectBbsList(BbsMainVO bbsMainVO) {
        return bbsMainMapper.selectBbsList(bbsMainVO);
    }

    @Override
    public BbsMainVO selectBbsInfo(BbsMainVO bbsMainVO) {
        return bbsMainMapper.selectBbsInfo(bbsMainVO);
    }

    @Override
    public List<BbsAttachVO> selectBbsAttachList(BbsAttachVO bbsAttachVO) {
        return bbsMainMapper.selectBbsAttachList(bbsAttachVO);
    }

    @Override
    public List<BbsCommentVO> selectBbsCmtList(BbsCommentVO bbsCommentVO) {
        return bbsMainMapper.selectBbsCmtList(bbsCommentVO);
    }

    @Override
    public void createCmt(BbsCommentVO bbsCommentVO) {
        BbsCommentVO resultCmtVO = bbsMainMapper.selectCmtMaxSeq(bbsCommentVO);
        int seq = resultCmtVO.getBbsCmtSeq();

        bbsCommentVO.setBbsCmtSeq(seq+1);
        bbsMainMapper.createCmt(bbsCommentVO);
    }

    @Override
    public BbsCommentVO selectCmt(BbsCommentVO bbsCommentVO) {
        return bbsMainMapper.selectCmt(bbsCommentVO);
    }

    @Override
    public List<BbsCommentVO> selectBbsReplyList(BbsCommentVO bbsReplyVO) {
        return bbsMainMapper.selectBbsReplyList(bbsReplyVO);
    }
}

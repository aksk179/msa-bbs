package com.ksj.bbs.mapper;

import com.ksj.bbs.vo.BbsAttachVO;
import com.ksj.bbs.vo.BbsCommentVO;
import com.ksj.bbs.vo.BbsMainVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BbsMainMapper {

    public List<BbsMainVO> selectBbsList(BbsMainVO bbsMainVO);

    public BbsMainVO selectBbsInfo(BbsMainVO bbsMainVO);

    public List<BbsAttachVO> selectBbsAttachList(BbsAttachVO bbsAttachVO);

    public List<BbsCommentVO> selectBbsCmtList(BbsCommentVO bbsCommentVO);

    public void createCmt(BbsCommentVO bbsCommentVO);

    public BbsCommentVO selectCmtMaxSeq(BbsCommentVO bbsCommentVO);

    public BbsCommentVO selectCmt(BbsCommentVO bbsCommentVO);

    public void createBbs(BbsMainVO bbsMainVO);

    public BbsMainVO selectMaxBbsNo(BbsMainVO bbsMainVO);
}

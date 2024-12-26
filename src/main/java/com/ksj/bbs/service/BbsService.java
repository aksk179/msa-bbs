package com.ksj.bbs.service;

import com.ksj.bbs.vo.BbsVO;

import java.util.List;

public interface BbsService {

    public List<BbsVO> selectBbsMasterListPage(BbsVO bbsVO);

    public BbsVO selectBbsInfo(BbsVO bbsVO);

    public void updateBbsMasterOne(BbsVO bbsVO);

    public void createBbsMaster(BbsVO bbsVO);
}

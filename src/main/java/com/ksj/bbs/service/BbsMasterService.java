package com.ksj.bbs.service;

import com.ksj.bbs.vo.BbsMainVO;
import com.ksj.bbs.vo.BbsMasterVO;

import java.util.List;

public interface BbsMasterService {

    public List<BbsMasterVO> selectBbsMasterListPage(BbsMasterVO bbsMasterVO);

    public BbsMasterVO selectBbsMasterInfo(BbsMasterVO bbsMasterVO);

    public void updateBbsMasterOne(BbsMasterVO bbsMasterVO);

    public void createBbsMaster(BbsMasterVO bbsMasterVO);

    public void deleteBbsMaster(BbsMasterVO bbsMasterVO);
}

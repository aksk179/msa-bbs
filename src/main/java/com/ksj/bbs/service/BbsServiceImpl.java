package com.ksj.bbs.service;

import com.ksj.bbs.mapper.BbsMapper;
import com.ksj.bbs.vo.BbsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BbsServiceImpl implements BbsService {

    @Autowired
    BbsMapper bbsMapper;

    @Override
    public List<BbsVO> selectBbsMasterListPage(BbsVO bbsVO) {
        return bbsMapper.selectBbsMasterListPage(bbsVO);
    }

    @Override
    public BbsVO selectBbsInfo(BbsVO bbsVO) {
        return bbsMapper.selectBbsInfo(bbsVO);
    }

    @Override
    public void updateBbsMasterOne(BbsVO bbsVO) {
        bbsMapper.updateBbsMasterOne(bbsVO);
    }

    @Override
    public void createBbsMaster(BbsVO bbsVO) {
        BbsVO newBbsVO = bbsMapper.selectBbsMaxKey();
        String id = newBbsVO.getBbsId();
        int num = Integer.parseInt(id.substring(3));
        log.info("num : " + num);
        id = String.format("BBS%03d", ++num);
        bbsVO.setBbsId(id);

        bbsMapper.createBbsMaster(bbsVO);
    }

    @Override
    public void deleteBbsMaster(BbsVO bbsVO) {
        bbsMapper.deleteBbsMaster(bbsVO);
    }
}

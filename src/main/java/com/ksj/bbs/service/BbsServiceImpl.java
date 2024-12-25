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
}

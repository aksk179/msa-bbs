package com.ksj.bbs.mapper;

import com.ksj.bbs.vo.BbsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BbsMapper {

    public List<BbsVO> selectBbsMasterListPage(BbsVO bbsVO);

    public BbsVO selectBbsInfo(BbsVO bbsVO);

    public void updateBbsMasterOne(BbsVO bbsVO);

    public void createBbsMaster(BbsVO bbsVO);

    public BbsVO selectBbsMaxKey();
}

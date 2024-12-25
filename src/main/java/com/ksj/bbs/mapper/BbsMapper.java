package com.ksj.bbs.mapper;

import com.ksj.bbs.vo.BbsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BbsMapper {

    public List<BbsVO> selectBbsMasterListPage(BbsVO bbsVO);

}

package com.ksj.bbs.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data

public class BbsVO {
    private String bbsId;
    private String bbsName;
    private String bbsReplyYn;
    private String bbsFileYn;
    private int bbsFileSize;
    private int bbsNewHour;
    private String bbsWriterViewYn;

    public String getBbsId() {
        return bbsId;
    }

    public void setBbsId(String bbsId) {
        this.bbsId = bbsId;
    }

    public String getBbsName() {
        return bbsName;
    }

    public void setBbsName(String bbsName) {
        this.bbsName = bbsName;
    }

    public String getBbsReplyYn() {
        return bbsReplyYn;
    }

    public void setBbsReplyYn(String bbsReplyYn) {
        this.bbsReplyYn = bbsReplyYn;
    }

    public String getBbsFileYn() {
        return bbsFileYn;
    }

    public void setBbsFileYn(String bbsFileYn) {
        this.bbsFileYn = bbsFileYn;
    }

    public int getBbsFileSize() {
        return bbsFileSize;
    }

    public void setBbsFileSize(int bbsFileSize) {
        this.bbsFileSize = bbsFileSize;
    }

    public int getBbsNewHour() {
        return bbsNewHour;
    }

    public void setBbsNewHour(int bbsNewHour) {
        this.bbsNewHour = bbsNewHour;
    }

    public String getBbsWriterViewYn() {
        return bbsWriterViewYn;
    }

    public void setBbsWriterViewYn(String bbsWriterViewYn) {
        this.bbsWriterViewYn = bbsWriterViewYn;
    }
}

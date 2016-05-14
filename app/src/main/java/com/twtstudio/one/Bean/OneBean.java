package com.twtstudio.one.Bean;

/**
 * Created by jcy on 2016/5/9.
 */
public class OneBean {

    /**
     * result : SUCCESS
     * hpEntity : {"strLastUpdateDate":"2016-05-06 16:01:35","strDayDiffer":"1","strHpId":"1342","strHpTitle":"VOL.1311","strThumbnailUrl":"http://image.wufazhuce.com/Fq7HeWVtVIiUpqVoa1oqlsVLyXqi","strOriginalImgUrl":"http://image.wufazhuce.com/Fq7HeWVtVIiUpqVoa1oqlsVLyXqi","strAuthor":"等待黑夜&花芍子 作品","strContent":"我们总喜欢回忆往事，但不一定真想去重复。 by 陈染","strMarketTime":"2016-05-09","sWebLk":"http://m.wufazhuce.com/one/1342","strPn":"","wImgUrl":""}
     */

    private String result;
    /**
     * strLastUpdateDate : 2016-05-06 16:01:35
     * strDayDiffer : 1
     * strHpId : 1342
     * strHpTitle : VOL.1311
     * strThumbnailUrl : http://image.wufazhuce.com/Fq7HeWVtVIiUpqVoa1oqlsVLyXqi
     * strOriginalImgUrl : http://image.wufazhuce.com/Fq7HeWVtVIiUpqVoa1oqlsVLyXqi
     * strAuthor : 等待黑夜&花芍子 作品
     * strContent : 我们总喜欢回忆往事，但不一定真想去重复。 by 陈染
     * strMarketTime : 2016-05-09
     * sWebLk : http://m.wufazhuce.com/one/1342
     * strPn :
     * wImgUrl :
     */

    private HpEntityBean hpEntity;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public HpEntityBean getHpEntity() {
        return hpEntity;
    }

    public void setHpEntity(HpEntityBean hpEntity) {
        this.hpEntity = hpEntity;
    }

    public static class HpEntityBean {
        private String strLastUpdateDate;
        private String strDayDiffer;
        private String strHpId;
        private String strHpTitle;
        private String strThumbnailUrl;
        private String strOriginalImgUrl;
        private String strAuthor;
        private String strContent;
        private String strMarketTime;
        private String sWebLk;
        private String strPn;
        private String wImgUrl;

        public String getStrLastUpdateDate() {
            return strLastUpdateDate;
        }

        public void setStrLastUpdateDate(String strLastUpdateDate) {
            this.strLastUpdateDate = strLastUpdateDate;
        }

        public String getStrDayDiffer() {
            return strDayDiffer;
        }

        public void setStrDayDiffer(String strDayDiffer) {
            this.strDayDiffer = strDayDiffer;
        }

        public String getStrHpId() {
            return strHpId;
        }

        public void setStrHpId(String strHpId) {
            this.strHpId = strHpId;
        }

        public String getStrHpTitle() {
            return strHpTitle;
        }

        public void setStrHpTitle(String strHpTitle) {
            this.strHpTitle = strHpTitle;
        }

        public String getStrThumbnailUrl() {
            return strThumbnailUrl;
        }

        public void setStrThumbnailUrl(String strThumbnailUrl) {
            this.strThumbnailUrl = strThumbnailUrl;
        }

        public String getStrOriginalImgUrl() {
            return strOriginalImgUrl;
        }

        public void setStrOriginalImgUrl(String strOriginalImgUrl) {
            this.strOriginalImgUrl = strOriginalImgUrl;
        }

        public String getStrAuthor() {
            return strAuthor;
        }

        public void setStrAuthor(String strAuthor) {
            this.strAuthor = strAuthor;
        }

        public String getStrContent() {
            return strContent;
        }

        public void setStrContent(String strContent) {
            this.strContent = strContent;
        }

        public String getStrMarketTime() {
            return strMarketTime;
        }

        public void setStrMarketTime(String strMarketTime) {
            this.strMarketTime = strMarketTime;
        }

        public String getSWebLk() {
            return sWebLk;
        }

        public void setSWebLk(String sWebLk) {
            this.sWebLk = sWebLk;
        }

        public String getStrPn() {
            return strPn;
        }

        public void setStrPn(String strPn) {
            this.strPn = strPn;
        }

        public String getWImgUrl() {
            return wImgUrl;
        }

        public void setWImgUrl(String wImgUrl) {
            this.wImgUrl = wImgUrl;
        }
    }
}

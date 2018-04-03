package com.example.administrator.minedemo.okhttp;

import java.util.List;

public class CommonBeans {

    /**
     * resultData : {"nowDate":"2018-03-30","activitylist":[{"adClickCount":15,"adId":"130","adName":"APP首页弹出广告","adTitle":"APP首页弹出广告20180314","adimg":"http://218.29.121.74:8081/app/im/advert/a8a35ce7-9e96-47cb-8734-0bf1e0899c10.jpg","adurl":"http://www.youtoo365.com/ccbwechat/weChat/coupon?gid=2319&channelId=0","enddate":"2018-04-25","remark":"","startdate":"2018-03-14"}]}
     * detail : 成功
     * message : 成功
     * isSuccess : true
     */

    private ResultDataBean resultData;
    private String message;
    private boolean isSuccess;

    public ResultDataBean getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataBean resultData) {
        this.resultData = resultData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public static class ResultDataBean {
        /**
         * nowDate : 2018-03-30
         * activitylist : [{"adClickCount":15,"adId":"130","adName":"APP首页弹出广告","adTitle":"APP首页弹出广告20180314","adimg":"http://218.29.121.74:8081/app/im/advert/a8a35ce7-9e96-47cb-8734-0bf1e0899c10.jpg","adurl":"http://www.youtoo365.com/ccbwechat/weChat/coupon?gid=2319&channelId=0","enddate":"2018-04-25","remark":"","startdate":"2018-03-14"}]
         */

        private String nowDate;
        private List<ActivitylistBean> activitylist;

        public String getNowDate() {
            return nowDate;
        }

        public void setNowDate(String nowDate) {
            this.nowDate = nowDate;
        }

        public List<ActivitylistBean> getActivitylist() {
            return activitylist;
        }

        public void setActivitylist(List<ActivitylistBean> activitylist) {
            this.activitylist = activitylist;
        }

        public static class ActivitylistBean {
            /**
             * adClickCount : 15
             * adId : 130
             * adName : APP首页弹出广告
             * adTitle : APP首页弹出广告20180314
             * adimg : http://218.29.121.74:8081/app/im/advert/a8a35ce7-9e96-47cb-8734-0bf1e0899c10.jpg
             * adurl : http://www.youtoo365.com/ccbwechat/weChat/coupon?gid=2319&channelId=0
             * enddate : 2018-04-25
             * remark :
             * startdate : 2018-03-14
             */

            private int adClickCount;
            private String adId;
            private String adName;
            private String adTitle;
            private String adimg;
            private String adurl;
            private String enddate;
            private String remark;
            private String startdate;

            public int getAdClickCount() {
                return adClickCount;
            }

            public void setAdClickCount(int adClickCount) {
                this.adClickCount = adClickCount;
            }

            public String getAdId() {
                return adId;
            }

            public void setAdId(String adId) {
                this.adId = adId;
            }

            public String getAdName() {
                return adName;
            }

            public void setAdName(String adName) {
                this.adName = adName;
            }

            public String getAdTitle() {
                return adTitle;
            }

            public void setAdTitle(String adTitle) {
                this.adTitle = adTitle;
            }

            public String getAdimg() {
                return adimg;
            }

            public void setAdimg(String adimg) {
                this.adimg = adimg;
            }

            public String getAdurl() {
                return adurl;
            }

            public void setAdurl(String adurl) {
                this.adurl = adurl;
            }

            public String getEnddate() {
                return enddate;
            }

            public void setEnddate(String enddate) {
                this.enddate = enddate;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getStartdate() {
                return startdate;
            }

            public void setStartdate(String startdate) {
                this.startdate = startdate;
            }
        }
    }
}
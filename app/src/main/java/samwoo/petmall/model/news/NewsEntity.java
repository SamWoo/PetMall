package samwoo.petmall.model.news;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */

public class NewsEntity {

    /**
     * size : 10
     * list : [{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/f/f1/f176c8b2699c147dc1103d52d5c818c5.jpg","has_content":true,"docurl":"http://war.163.com/17/0728/13/CQEFKD3K000181KT.html","id":21572,"time":"2017-07-28 13:38:27","title":"日防卫相稻田朋美宣布辞职 安倍就任命责任致歉","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/25090696b2244fc783d478879574edf320170728133422.jpeg","has_content":true,"docurl":"http://war.163.com/17/0728/13/CQEFENSD000181KT.html","id":21573,"time":"2017-07-28 13:35:21","title":"以色列警方与巴勒斯坦人起冲突 致上百人受伤","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/0/05/05d37eb721535e6de48e9aab9b222e1b.jpg","has_content":true,"docurl":"http://war.163.com/17/0728/13/CQEDHCR0000181KT.html","id":21570,"time":"2017-07-28 13:01:51","title":"＂海空卫士＂王伟之子军校毕业 已成一名海军军官","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/8e3e9b6cf8474d74b0388f792390981020170728125823.jpeg","has_content":true,"docurl":"http://war.163.com/17/0728/12/CQEDB1J7000181KT.html","id":21571,"time":"2017-07-28 12:58:23","title":"央行将发行建军90周年纪念币 最高面额800元","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/b/b6/b62f3cfc79316863a755734744c28338.jpg","has_content":true,"docurl":"http://war.163.com/17/0728/12/CQECFGSO000181KT.html","id":21569,"time":"2017-07-28 12:43:21","title":"欲给局势降温？印度重申与中国的＂发展伙伴关系＂","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/3305f00d2d6d4cc3acfe85f8101715a320170728114914.jpeg","has_content":true,"docurl":"http://war.163.com/17/0728/11/CQE9CP6O000181KT.html","id":21544,"time":"2017-07-28 11:49:26","title":"法专家解析为何沙特总与伊朗对抗:不仅仅因为宗教","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/3383751a90d44298aed0e02ba101d08720170728114707.jpeg","has_content":true,"docurl":"http://war.163.com/17/0728/11/CQE99PDE000181KT.html","id":21537,"time":"2017-07-28 11:47:48","title":"韩媒:仁川化妆品突破＂萨德＂障碍 对华出口猛增78%","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/9532c61238eb41bf94c937fc448ae23f20170728114614.jpeg","has_content":true,"docurl":"http://war.163.com/17/0728/11/CQE97IVQ000181KT.html","id":21540,"time":"2017-07-28 11:46:35","title":"印媒：印度与蒙古强化关系 向中国释放信号","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/f/fe/fe6d13fbcba809c982448c0b86b21a8d.jpg","has_content":true,"docurl":"http://war.163.com/17/0728/11/CQE8RV78000181KT.html","id":21538,"time":"2017-07-28 11:40:15","title":"俄媒：美国在争夺对泰菲影响力上已输给中国","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/ecb96f0be03f44bb974cfbc47a6707f020170728113451.jpeg","has_content":true,"docurl":"http://war.163.com/17/0728/11/CQE8J0N5000181KT.html","id":21539,"time":"2017-07-28 11:35:21","title":"伊朗启用新航天中心并发射一枚小型运载火箭","channelname":"war"}]
     */

    private int size;
    private List<ListBean> list;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * imgurl : http://cms-bucket.nosdn.127.net/catchpic/f/f1/f176c8b2699c147dc1103d52d5c818c5.jpg
         * has_content : true
         * docurl : http://war.163.com/17/0728/13/CQEFKD3K000181KT.html
         * id : 21572
         * time : 2017-07-28 13:38:27
         * title : 日防卫相稻田朋美宣布辞职 安倍就任命责任致歉
         * channelname : war
         */

        private String imgurl;
        private boolean has_content;
        private String docurl;
        private int id;
        private String time;
        private String title;
        private String channelname;

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public boolean isHas_content() {
            return has_content;
        }

        public void setHas_content(boolean has_content) {
            this.has_content = has_content;
        }

        public String getDocurl() {
            return docurl;
        }

        public void setDocurl(String docurl) {
            this.docurl = docurl;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getChannelname() {
            return channelname;
        }

        public void setChannelname(String channelname) {
            this.channelname = channelname;
        }
    }
}

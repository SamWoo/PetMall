package samwoo.petmall.model.news;

import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */

public class GeekEntity {
    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean{
   /** "_id": "597982e0421aa90ca3bb6b82",
   *         "createdAt": "2017-07-27T14:06:24.790Z",
            "desc": "\u7c7b\u4f3c Instagram Story \u7684\u63d2\u4ef6\uff0c\u5c55\u793a\u7167\u7247\u96c6\u5408\u3002",
            "publishedAt": "2017-07-27T14:16:33.773Z",
            "source": "chrome",
            "type": "Android",
            "url": "https://github.com/shts/StoriesProgressView",
            "used": true,
            "who": "\u4ee3\u7801\u5bb6"
    */
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}

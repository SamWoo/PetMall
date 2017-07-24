package samwoo.petmall.model.news;

/**
 * Created by Administrator on 2017/7/24.
 */

public class NewsChildModel {
    private String title;
    private boolean isZhiding;
    private boolean isJingxuan;
    private String author;
    private long stars;
    private int resourceId;

    public NewsChildModel(String title, boolean isZhiding, boolean isJingxuan, String author, long stars, int resourceId) {
        this.title = title;
        this.isZhiding = isZhiding;
        this.isJingxuan = isJingxuan;
        this.author = author;
        this.stars = stars;
        this.resourceId = resourceId;
    }

    public NewsChildModel(String title, String author, long stars, int resourceId) {
        this.title = title;
        this.author = author;
        this.stars = stars;
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isZhiding() {
        return isZhiding;
    }

    public void setZhiding(boolean zhiding) {
        isZhiding = zhiding;
    }

    public boolean isJingxuan() {
        return isJingxuan;
    }

    public void setJingxuan(boolean jingxuan) {
        isJingxuan = jingxuan;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getStars() {
        return stars;
    }

    public void setStars(long stars) {
        this.stars = stars;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}

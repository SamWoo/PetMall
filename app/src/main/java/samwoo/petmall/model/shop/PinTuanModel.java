package samwoo.petmall.model.shop;

/**
 * Created by Administrator on 2017/7/24.
 */

public class PinTuanModel {
    private int imageId;
    private String descript;
    private double mutch_one;
    private double mutch_two;

    public PinTuanModel(int imageId, String descript, double mutch_one, double mutch_two) {
        this.imageId = imageId;
        this.descript = descript;
        this.mutch_one = mutch_one;
        this.mutch_two = mutch_two;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public double getMutch_one() {
        return mutch_one;
    }

    public void setMutch_one(double mutch_one) {
        this.mutch_one = mutch_one;
    }

    public double getMutch_two() {
        return mutch_two;
    }

    public void setMutch_two(double mutch_two) {
        this.mutch_two = mutch_two;
    }
}

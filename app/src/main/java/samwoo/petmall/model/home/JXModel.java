package samwoo.petmall.model.home;

import samwoo.petmall.R;

/**
 * Created by Administrator on 2017/7/21.
 */

public class JXModel {
    private int headerImg;
    private String userName;
    private String userAir;
    private int userImg;
    private String petName;
    private String petType;
    private int mainImg;
    private String descript;

    public int getHeaderImg() {
        return headerImg;
    }

    public void setHeaderImg(int headerImg) {
        this.headerImg = headerImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAir() {
        return userAir;
    }

    public void setUserAir(String userAir) {
        this.userAir = userAir;
    }

    public int getUserImg() {
        return userImg;
    }

    public void setUserImg(int userImg) {
        this.userImg = userImg;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public int getMainImg() {
        return mainImg;
    }

    public void setMainImg(int mainImg) {
        this.mainImg = mainImg;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public JXModel() {
        this.headerImg = R.drawable.jx_header;
        this.userName = "豌豆麻麻";
        this.userAir = "四川 资阳";
        this.userImg = R.drawable.jx_user_pet;
        this.petName = "豌豆";
        this.petType = "小小柯基犬";
        this.mainImg = R.drawable.jx_main;
    }

    public JXModel(int headerImg, String userName, String userAir, int userImg,
                   String petName, String petType, int mainImg) {
        this.headerImg = headerImg;
        this.userName = userName;
        this.userAir = userAir;
        this.userImg = userImg;
        this.petName = petName;
        this.petType = petType;
        this.mainImg = mainImg;
    }

}

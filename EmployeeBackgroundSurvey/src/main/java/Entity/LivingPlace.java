package Entity;

public class LivingPlace {
    public String cityName;
    public String province;

    public LivingPlace() {
    }

    public LivingPlace(String cityName, String province) {
        this.cityName = cityName;
        this.province = province;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}

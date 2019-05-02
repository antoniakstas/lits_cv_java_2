package dto;

public class Address {
private int id;
    private int user_id;
    private String country;
    private String city;
    private String newpost;

    public Address(int id, int user_id, String country, String city, String newpost) {
        this.id = id;
        this.user_id = user_id;
        this.country = country;
        this.city = city;
        this.newpost = newpost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNewpost() {
        return newpost;
    }

    public void setNewpost(String newpost) {
        this.newpost = newpost;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", newpost='" + newpost + '\'' +
                '}';
    }
}

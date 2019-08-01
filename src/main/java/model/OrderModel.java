package model;

public class OrderModel {
    private int id;
    private String status;
    private int user_m_id;
    private int user_c_id;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "OrderModel{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", user_m_id=" + user_m_id +
                ", user_c_id=" + user_c_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUser_m_id() {
        return user_m_id;
    }

    public void setUser_m_id(int user_m_id) {
        this.user_m_id = user_m_id;
    }

    public int getUser_c_id() {
        return user_c_id;
    }

    public void setUser_c_id(int user_c_id) {
        this.user_c_id = user_c_id;
    }


    public OrderModel() {
    }

    public OrderModel(int id, String status, int user_m_id, int user_c_id, String url) {
        this.id = id;
        this.status = status;
        this.user_m_id = user_m_id;
        this.user_c_id = user_c_id;
        this.url = url;
    }
}

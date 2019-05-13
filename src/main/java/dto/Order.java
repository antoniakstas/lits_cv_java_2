package dto;

public class Order {
   private int id;
   private String status;
   private int user_m_id;
   private int user_c_id;

    public Order(int id, String status, int user_m_id, int user_c_id) {
        this.id = id;
        this.status = status;
        this.user_m_id = user_m_id;
        this.user_c_id = user_c_id;
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", user_m_id=" + user_m_id +
                ", user_c_id=" + user_c_id +
                '}';
    }
}

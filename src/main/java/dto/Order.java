package dto;

import javax.persistence.*;

@Table
@Entity(name = "orders")
public class Order {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
   private int id;
   private String status;
    @Column(name="user_m_id")
   private int userMId;
    @Column(name="user_c_id")
   private int userCId;

    public Order(){

    }

    public Order(int id, String status, int userMId, int userCId) {
        this.id = id;
        this.status = status;
        this.userMId = userMId;
        this.userCId = userCId;
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

    public int getUserMId() {
        return userMId;
    }

    public void setUserMId(int userMId) {
        this.userMId = userMId;
    }

    public int getUserCId() {
        return userCId;
    }

    public void setUserCId(int userCId) {
        this.userCId = userCId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", userMId=" + userMId +
                ", userCId=" + userCId +
                '}';
    }
}

package Models;

import java.util.Date;

public class BaseModel {
    private int id;
    private Date createdAt;
    private Date lastUpdatedAt;

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}

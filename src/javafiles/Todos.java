package javafiles;

import com.google.gson.annotations.SerializedName;

public class Todos {
    @SerializedName("userid")
    private int userid;
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("completed")
    private Boolean completed;

    public int getUserid() {return userid;}

    public void setUserid(int userid) {this.userid = userid;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public Boolean getCompleted() { return completed; }

    public void setCompleted(Boolean completed) { this.completed = completed; }
}

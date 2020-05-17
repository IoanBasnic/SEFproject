package sef.proj.model;

public class Task {

    private String User;
    private String Title;
    private String Content;
    private  String Time;

    public Task(){

    }

    public Task(String User, String Title, String Content, String Time) {
        this.Title = Title;
        this.Content = Content;
        this.Time = Time;
        this.User = User;
    }
    public String getUser() {
        return User;
    }

    public void setUser(String User) {

        this.User = User;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task sch = (Task) o;

        if (!Title.equals(sch.Title)) return false;
        if (!Time.equals(sch.Time)) return false;

        return Content.equals(sch.Content);
    }

    public String toString() {

        return  Title + " " + Content + "  " + Time;
    }
}

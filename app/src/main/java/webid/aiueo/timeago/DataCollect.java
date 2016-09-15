package webid.aiueo.timeago;


public class DataCollect {
    private String title, desc, year;

    public DataCollect() {
    }

    public DataCollect(String title, String desc, String year) {
        this.title = title;
        this.desc = desc;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getDate() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDesc() {
        return desc;
    }

    public void setGenre(String genre) {
        this.desc = genre;
    }
}

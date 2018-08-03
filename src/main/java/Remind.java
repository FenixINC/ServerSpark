/**
 * Created by Taras Koloshmatin on 02.08.2018
 */
public class Remind {

    private int id;
    private String title;
    private String remindDate;
    private String description;
    private String typeRemind;

    public Remind(int id, String title, String remindDate, String description, String typeRemind) {
        this.id = id;
        this.title = title;
        this.remindDate = remindDate;
        this.description = description;
        this.typeRemind = typeRemind;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRemindDate(String remindDate) {
        this.remindDate = remindDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTypeRemind(String typeRemind) {
        this.typeRemind = typeRemind;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getRemindDate() {
        return remindDate;
    }

    public String getDescription() {
        return description;
    }

    public String getTypeRemind() {
        return typeRemind;
    }

    @Override
    public String toString() {
        return "Remind{" +
                "id=" + id +
                ", title=" + title +
                ", remindDate=" + remindDate +
                ", description" + description +
                ", typeRemind=" + typeRemind +
                '}';
    }
}

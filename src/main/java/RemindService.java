import java.util.Collection;

public interface RemindService {
    public void addRemind(Remind user);

    public Collection<Remind> getRemindList();

    public Remind getRemind(String id);

    public Remind editRemind(Remind remind) throws RemindException;

    public void deleteRemind(String id);

    public boolean isRemindExist(String id);
}
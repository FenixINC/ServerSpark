import java.util.Collection;
import java.util.HashMap;

public class RemindServiceMapImpl implements RemindService {
    private HashMap<Integer, Remind> remindMap;

    public RemindServiceMapImpl() {
        remindMap = new HashMap<>();
    }

    @Override
    public void addRemind(Remind remind) {
        remindMap.put(remind.getId(), remind);
    }

    @Override
    public Collection<Remind> getRemindList() {
        return remindMap.values();
    }

    @Override
    public Remind getRemind(String id) {
        return remindMap.get(id);
    }

    @Override
    public Remind editRemind(Remind forEdit) throws RemindException {
        try {
            if (forEdit.getId() < 0)
                throw new RemindException("ID cannot be blank");

            Remind toEdit = remindMap.get(forEdit.getId());

            if (toEdit == null)
                throw new RemindException("Remind not found");

            if (forEdit.getTitle() != null) {
                toEdit.setTitle(forEdit.getTitle());
            }
            if (forEdit.getRemindDate() != null) {
                toEdit.setRemindDate(forEdit.getRemindDate());
            }
            if (forEdit.getDescription() != null) {
                toEdit.setDescription(forEdit.getDescription());
            }
            if (forEdit.getTypeRemind() != null) {
                toEdit.setTypeRemind(forEdit.getTypeRemind());
            }
            if (forEdit.getId() != 0) {
                toEdit.setId(forEdit.getId());
            }

            return toEdit;
        } catch (Exception ex) {
            throw new RemindException(ex.getMessage());
        }
    }

    @Override
    public void deleteRemind(String id) {
        remindMap.remove(id);
    }

    @Override
    public boolean isRemindExist(String id) {
        return remindMap.containsKey(id);
    }

}
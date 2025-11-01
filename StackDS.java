package HospitalPatientStack;
import java.util.ArrayList;

public class StackDS {
    private ArrayList<Record> stack = new ArrayList<>();

    public void push(Record r) {
        stack.add(r);
    }

    public Record pop() {
        if (stack.isEmpty()) return null;
        return stack.remove(stack.size() - 1);
    }

    public Record peek() {
        if (stack.isEmpty()) return null;
        return stack.get(stack.size() - 1);
    }

    public void updateTop(Record newRecord) {
        if (!stack.isEmpty()) {
            stack.set(stack.size() - 1, newRecord);
        }
    }

    public String displayString() {
        if (stack.isEmpty()) return "Stack is empty!";
        StringBuilder sb = new StringBuilder();
        for (int i = stack.size() - 1; i >= 0; i--) {
            sb.append(stack.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}

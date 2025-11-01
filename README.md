Hospital Patient Management System
(Stack Based GUI Project)


1. Chosen Inventory System
The chosen inventory system is a Hospital Patient Management System. This system stores patient information using the Stack data structure. It allows adding, viewing, updating, and deleting patient records efficiently.
2. Implemented Data Structure
The data structure used in this project is a Stack implemented using Java’s ArrayList. Stack follows Last In, First Out (LIFO) principle. Each record represents a patient and is stored in the stack for easy access and removal.

3. Code Implementation

Below is the implementation of the Stack and Record classes used in the project:


class Record {
    String name;
    int age;
    String disease;

    Record(String name, int age, String disease) {
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public String toString() {
        return name + " | " + age + " | " + disease;
    }
}

class StackDS {
    private ArrayList<Record> stack = new ArrayList<>();

    public void push(Record record) {
        stack.add(record);
    }

    public Record pop() {
        if (stack.isEmpty()) return null;
        return stack.remove(stack.size() - 1);
    }

    public void display() {
        for (Record r : stack)
            System.out.println(r);
    }


    public void update(String name, Record newRecord) {
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i).name.equals(name)) {
                stack.set(i, newRecord);
                break;
            }
        }
    }


    public void delete(String name) {
        stack.removeIf(r -> r.name.equals(name));
    }
}


4. CRUD Operations Explanation

• **Push()** – Adds a new patient record to the top of the stack.
• **Pop()** – Removes the most recent patient record (LIFO).
• **Update()** – Finds a patient by name and updates their details.
• **Delete()** – Deletes a specific patient record by name.
• **Display()** – Shows all patient records currently in the stack.

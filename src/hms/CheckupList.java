package hms;

class CNode {

    CheckUp cu;
    CNode next, prev;

    public CNode(CheckUp cu) {
        this.cu = cu;
        next = null;
        prev = null;
    }

}

public class CheckupList {

    CNode head, tail;

    public CheckupList() {
        head = null;
        tail = null;
    }
    
    public void addRecommendation(int index, String rec) {
        CNode temp = head;
        int i = 0;
        while (temp != null) {
            if (index == i) {
                temp.cu.setRecommendation(rec);
                break;
            }
            i++;
            temp = temp.prev;
        }
    }
    
    public Patient getPatient(int index) {
        CNode temp = head;
        int i = 0;
        while (temp != null) {
            if (index == i) {
                break;
            }
            i++;
            temp = temp.prev;
        }
        return temp.cu.getPatient();
         
    }
    public int size() {
        CNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.prev;
        }
        return count;
    }
    

    public void enQueue(CheckUp cu) {
        CNode node = new CNode(cu);

        if (head == null || tail == null) {
            head = node;
            tail = node;
        } else if (head.cu.getPriority() < cu.getPriority()) {
            head.next = node;
            node.prev = head;
            head = node;
        } else if (tail.cu.getPriority() >= cu.getPriority()) {
            tail.prev = node;
            node.next = tail;
            tail = node;
        } else {
            CNode temp = tail;
            while (temp != null) {
                if (temp.cu.getPriority() >= cu.getPriority()) {
                    break;
                }

                temp = temp.next;
            }
            node.next = temp;
            node.prev = temp.prev;
            node.prev.next = node;
            temp.prev = node;

        }

    }

    public CheckUp deQueue() {
        if (head == null) {
            return null;
        }
        CNode checkup = head;
        head.next = head;
        return checkup.cu;

    }

    public void print() {
        System.out.println("Priority    " + "Recommendation");
        CNode temp = head;
        while (temp != null) {
            
            System.out.println(temp.cu.getPriority() + "                " + temp.cu.getRecommendation());
            
            temp = temp.prev;
        }
    }

}

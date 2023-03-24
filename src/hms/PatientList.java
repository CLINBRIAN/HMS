
package hms;
class PNode{
    Patient patient;
    PNode next, prev;

    public PNode(Patient patient) {
        this.patient = patient;
        next = null;
        prev = null;
    }
    
}

public class PatientList {
    PNode head; 
    PNode tail;

    public PatientList() {
        head = null;
        tail = null;
    }
    public void insertNode(Patient patient){
        PNode node = new PNode(patient);
        
        if(head == null || tail == null){
            head = node;
            tail = node;
        }
        else{
          head.next = node;
          node.prev = head;
          head = node;
        }
    }
    public Patient searchById(String Id){
        PNode temp = head;
        while(temp != null){
           if(temp.patient.getId().equals(Id)){
              return temp.patient;
           }
         
           temp = temp.prev;
        }
        return null;    
    }
    
    public int size() {
        PNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.prev;
        }
        return count;
    }
    
    public Patient searchByContact(String contact){
        PNode temp = head;
        while(temp != null){
           if(temp.patient.getContact().equals(contact)){
              return temp.patient;
           }
         
           temp = temp.prev;
        }
        return null;    
    }
    public void printData(){
        PNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            System.out.println(count+":  "+temp.patient.toString());
            temp = temp.prev;
        }
    }
    
    
}

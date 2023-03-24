
package hms;

public class Patient {
   private String Id, name, contact;

    public Patient() {
        Id = "";
        this.name= "";
        this.contact = "";
    }

    public Patient(String Id, String name, String contact) {
        this.Id = Id;
        this.name = name;
        this.contact = contact;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Patient{" + "Id=" + Id + ", name=" + name + ", contact=" + contact + '}';
    }
    
   
    
}

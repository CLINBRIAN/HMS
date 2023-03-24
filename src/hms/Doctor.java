
package hms;

public class Doctor {
       private String Id, name, contact, speciality;
       private int fees;

    public Doctor() {
    }

    public Doctor(String Id, String name, String contact, String speciality, int fees) {
        this.Id = Id;
        this.name = name;
        this.contact = contact;
        this.speciality = speciality;
        this.fees = fees;
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "Doctor{" + "Id=" + Id + ", name=" + name + ", contact=" + contact + ", speciality=" + speciality + ", fees=" + fees + '}';
    }
       
    
}

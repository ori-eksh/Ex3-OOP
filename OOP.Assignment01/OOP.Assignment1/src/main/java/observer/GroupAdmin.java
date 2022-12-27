package observer;

import java.util.ArrayList;

public class GroupAdmin implements Sender {
    UndoableStringBuilder usb;

    ArrayList<Member> observers;

    // Constructors section
    public GroupAdmin() {
        this.usb = new UndoableStringBuilder();
        this.observers = new ArrayList<Member>();
    }

    public GroupAdmin(UndoableStringBuilder usb, ArrayList<Member> observers) {
        this.usb = usb;
        this.observers = observers;
    }
    public GroupAdmin(UndoableStringBuilder usb) {
        this.usb = usb;
        this.observers = new ArrayList<Member>();
    }

    // For each member that registered in groupAdmin - Update it's local Usb.
    public void sendUpdates()
    {

        for (Member observer : this.getObservers())
        {
            observer.update(this.usb);
        }
    }

    // Add a concrete member to a GroupAdmin.
    public void register(Member member)
    {
        if(this.observers.contains(member)==false)
        {
            member.update(this.usb);
            this.observers.add(member);
        }
    }

    // Remove a concreteMember from a groupAdmin list.
    public void unregister(Member member)
    {
        member.update(null);
        this.observers.remove(member);
    }

   public void insert(int offset, String obj)
    {
        this.usb.insert(offset,obj);
    }

   public void append(String obj)
    {
        this.usb.append(obj);
    }

    public  void delete(int start, int end)
    {
        this.usb.delete(start,end);
    }

    public void undo()
    {
        this.usb.undo();
    }


    //Get and set section.
    public UndoableStringBuilder getUsb()
    {
        return usb;
    }

    private void setUsb(UndoableStringBuilder usb)
    {
        this.usb = usb;
    }

    public ArrayList<Member> getObservers()
    {
        return observers;
    }

    private void setObservers(ArrayList<Member> observers)
    {
        this.observers = observers;
    }

}
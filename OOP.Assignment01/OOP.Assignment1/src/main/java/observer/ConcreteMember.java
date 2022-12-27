package observer;

import java.util.ArrayList;

public class ConcreteMember implements Member {
    UndoableStringBuilder localUsbs;

    public ConcreteMember()
    {
        this.localUsbs = new UndoableStringBuilder();
    }


    public ConcreteMember(UndoableStringBuilder usb_copy)
    {
        this.localUsbs = usb_copy;
    }

    public UndoableStringBuilder getLocalUsbs()
    {
        return this.localUsbs;
    }

    public void update(UndoableStringBuilder update)
    {
        this.localUsbs=update;
    }
}

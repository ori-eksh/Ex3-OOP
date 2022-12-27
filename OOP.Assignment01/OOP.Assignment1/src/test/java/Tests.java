import observer.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import static org.junit.jupiter.api.Assertions.fail;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility

    @Test
    void register()
    {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("We love java");
        GroupAdmin admin = new GroupAdmin(usb);
        ConcreteMember member = new ConcreteMember(admin.getUsb());

        // Check what happens if a member that already in the group is added (again)
        admin.register(member);

        admin.getObservers().contains(member);//if it was added to the list

        admin.register(member);
        int count=0;
        for (Member cm : admin.getObservers())
        {
            if (cm.equals(member))count++;
        }
        if (count>1) fail(); //If the list contains "member" more than once - it's a fail


        logger.info(()->JvmUtilities.objectFootprint(usb));

        logger.info(()->JvmUtilities.objectTotalSize(usb));

        logger.info(() -> JvmUtilities.jvmInfo());

    }

    @Test
    void unregister() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("We love java");
        GroupAdmin admin = new GroupAdmin(usb);
        ConcreteMember member1 = new ConcreteMember(admin.getUsb());
        ConcreteMember member2 = new ConcreteMember(admin.getUsb());

        // Check if a removed member's localUsb is a pointer to the admin.
        admin.register(member1);
        admin.register(member2);

        admin.unregister(member1);

        for (Member member : admin.getObservers()) {
            if (member.equals(member1)) { // The specific member that we removed
                fail();

            }
        }
        logger.info(()->JvmUtilities.objectFootprint(member1));
        logger.info(()->JvmUtilities.objectFootprint(member1,member2));

        logger.info(()->JvmUtilities.objectTotalSize(member1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }
    // Set a member's UndoableStringBuilder and check if they're equals.
    @Test
    void update() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("We love java");
        GroupAdmin admin = new GroupAdmin(usb);
        ConcreteMember member = new ConcreteMember(admin.getUsb());
        admin.register(member);
        member.update(admin.getUsb());
        if(member.getLocalUsbs() != admin.getUsb()) fail();


        logger.info(()->JvmUtilities.objectFootprint(usb));
        logger.info(()->JvmUtilities.objectTotalSize(usb));
        logger.info(() -> JvmUtilities.jvmInfo());


    }
}

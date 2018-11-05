package me.cubxity.jna;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class OverlayStateChangedNotification extends Structure {
//    typedef struct
//    {
//        bool open;                  //!< true if the overlay is opening, false if it is closing
//        NVGSDK_OverlayState state;  //!< State the overlay is closing from or opening to
//    } NVGSDK_OverlayStateChangedNotification;

    private static final List<String> FIELD_ORDER = Arrays.asList(
            "open",
            "state"
    );

    public boolean open;

    public int state;

    @Override
    public List<String> getFieldOrder() {
        return FIELD_ORDER;
    }
}

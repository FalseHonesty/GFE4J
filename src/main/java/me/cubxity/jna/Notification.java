package me.cubxity.jna;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class Notification extends Structure {
//    typedef struct
//    {
//        void* context;
//        union
//        {
//            NVGSDK_PermissionsChangedNotification permissionsChanged;
//            NVGSDK_OverlayStateChangedNotification overlayStateChanged;
//        };
//    } NVGSDK_Notification;

    private static final List<String> FIELD_ORDER = Arrays.asList(
            "context",
            "permissionsChanged",
            "overlayStateChanged"
    );

    public Pointer context;

    public PermissionsChangedNotification permissionsChanged;

    public OverlayStateChangedNotification overlayStateChanged;

    @Override
    public List<String> getFieldOrder() {
        return FIELD_ORDER;
    }
}

package me.cubxity.jna;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class PermissionsChangedNotification extends Structure {
//    typedef struct
//    {
//        NVGSDK_ScopePermission* scopePermissionTable;
//        size_t scopePermissionTableSize;
//    } NVGSDK_PermissionsChangedNotification;

    private static final List<String> FIELD_ORDER = Arrays.asList(
            "scopePermissionTable",
            "scopePermissionTableSize"
    );

    public ScopePermission scopePermissionTable;

    public SizeT scopePermissionTableSize;

    @Override
    public List<String> getFieldOrder() {
        return FIELD_ORDER;
    }
}

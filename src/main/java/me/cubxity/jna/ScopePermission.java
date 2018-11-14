package me.cubxity.jna;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class ScopePermission extends Structure {
//    typedef struct
//    {
//        NVGSDK_Scope scope;
//        NVGSDK_Permission permission;
//    } NVGSDK_ScopePermission;

    private static final List<String> FIELD_ORDER = Arrays.asList(
            "scope",
            "permission"
    );

    public int scope;

    public int permission;

    @Override
    public List<String> getFieldOrder() {
        return FIELD_ORDER;
    }

    public static class ByReference extends ScopePermission implements Structure.ByReference {

    }
}

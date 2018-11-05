package me.cubxity.jna;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class RequestPermissionsParams extends Structure {
//    typedef struct
//    {
//        NVGSDK_Scope* scopeTable;
//        size_t scopeTableSize;
//    } NVGSDK_RequestPermissionsParams;

    private static List<String> FIELD_ORDER = Arrays.asList(
            "scopeTable",
            "scopeTableSize"
    );

    public int scopeTable;

    public SizeT scopeTableSize;

    @Override
    public List<String> getFieldOrder() {
        return FIELD_ORDER;
    }
}

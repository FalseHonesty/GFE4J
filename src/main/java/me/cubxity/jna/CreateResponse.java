package me.cubxity.jna;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class CreateResponse extends Structure {
//    typedef struct
//    {
//        uint16_t versionMajor;                          //!< Will be populated with SDK major version
//        uint16_t versionMinor;                          //!< Will be populated with SDK minor version
//        char gfeVersionStr[NVGSDK_MAX_LENGTH];          //!< Must be provided to call. Will be populated by GFE version string
//        NVGSDK_ScopePermission* scopePermissionTable;   //!< Must be provided to call. Will be filled with scope/permission pairs
//        size_t scopePermissionTableSize;                //!< Must be provided to call.
//    } NVGSDK_CreateResponse;

    private static final List<String> FIELD_ORDER = Arrays.asList(
            "versionMajor",
            "versionMinor",
            "gfeVersionStr",
            "scopePermissionTable",
            "scopePermissionTableSize"
    );

    public int versionMajor;

    public int versionMinor;

    public String gfeVersionStr;

    public Pointer scopePermissionTable;

    public SizeT scopePermissionTableSize;

    @Override
    public List<String> getFieldOrder() {
        return FIELD_ORDER;
    }
}

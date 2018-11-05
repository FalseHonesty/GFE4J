package me.cubxity.jna;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class CreateInputParams extends Structure {
    //    typedef struct
//    {
//        char const* appName;        //!< Provide the name of the application. Will be used in cases when NVIDIA cannot detect game.
//        NVGSDK_Scope* scopeTable;   //!< List of scopes used by the application
//        size_t scopeTableSize;      //!< Number of entries in the scope table
//        bool pollForCallbacks;      /*!< \brief Set to true to poll for asynchronous callbacks on an app thread.
//         *   If false, callbacks will occur on a GfeSDK controlled thread, no polling necessary */
//        NVGSDK_NotificationCallback notificationCallback;   //!< Called on unsolicited notifications
//        void* notificationCallbackContext;                  //!< Passed along unchanged with each notification
//
//        uint32_t targetPid;         //!< Advanced usage
//        char const* targetPath;     //!< Advanced usage
//    } NVGSDK_CreateInputParams;

    private static final List<String> FIELD_ORDER = Arrays.asList(
            "appName",
            "scopeTable",
            "scopeTableSize",
            "pollForCallbacks",
            "notificationCallback",
            "notificationCallbackContext",
            "targetPid",
            "targetPath"
    );

    public String appName;

    public Pointer scopeTable;

    public SizeT scopeTableSize;

    public boolean pollForCallbacks;

    public NotificationCallback notificationCallback;

    public Pointer notificationCallbackContext;

    public UInt32T targetPid;

    public String targetPath;

    @Override
    public List<String> getFieldOrder() {
        return FIELD_ORDER;
    }
}

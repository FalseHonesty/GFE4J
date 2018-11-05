package me.cubxity.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public interface GfeSDK extends Library {
    int NVGSDK_SCOPE_HIGHLIGHTS = 0;            //!< Scope required to access highlights information, open group summary, etc
    int NVGSDK_SCOPE_HIGHLIGHTS_VIDEO = 1;      //!< Scope required to save video highlights
    int NVGSDK_SCOPE_HIGHLIGHTS_SCREENSHOT = 2; //!< Scope required to save screenshot highlights
    int NVGSDK_SCOPE_OPS = 3;                   //!< Scope required to optimize the game

    int NVGSDK_PERMISSION_GRANTED = 0;  //!< Requested permission has been granted to the app by the user
    int NVGSDK_PERMISSION_MUST_ASK = 1; //!< Requested permission must be granted by the user.
    int NVGSDK_PERMISSION_DENIED = 2;   //!< Requested permission has been denied to the app, feature won't function
    int NVGSDK_PERMISSION_UNKNOWN = 3;  //!< Scope does not match list of known scopes. Version mismatch?

    int NVGSDK_OVERLAY_STATE_MAIN = 0;               //!< Normal overlay menu
    int NVGSDK_OVERLAY_STATE_PERMISSION = 1;         //!< Menu that appears to ask user for permissions
    int NVGSDK_OVERLAY_STATE_HIGHLIGHTS_SUMMARY = 2; //!< Menu that appears to show the user the highlights group summary

    GfeSDK INSTANCE = Native.load("GfeSDK", GfeSDK.class);

    //NVGSDK_EXPORT NVGSDK_RetCode NVGSDKApi NVGSDK_Create(NVGSDK_HANDLE** handle, NVGSDK_CreateInputParams const* inParams, NVGSDK_CreateResponse* outParams);
    int NVGSDK_Create(Pointer handle, CreateInputParams inParams, CreateResponse outParams);

    //NVGSDK_EXPORT void NVGSDKApi NVGSDK_RequestPermissionsAsync(NVGSDK_HANDLE* handle, NVGSDK_RequestPermissionsParams const* params, NVGSDK_EmptyCallback callback, void* context);
    int NVGSDK_RequestPermissionsAsync(Pointer handle, RequestPermissionsParams params, EmptyCallback callback, Pointer context);
}

package me.cubxity.tests;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import me.cubxity.jna.*;

public class GFE4JTest {


    public static void main(String... args) {
        GfeSDK sdk = GfeSDK.INSTANCE;

        Pointer handle = new Memory(Native.POINTER_SIZE);

        int[] scopes = {GfeSDK.NVGSDK_SCOPE_HIGHLIGHTS, GfeSDK.NVGSDK_SCOPE_HIGHLIGHTS_VIDEO, GfeSDK.NVGSDK_SCOPE_HIGHLIGHTS_SCREENSHOT};
        Pointer nScopes = new Memory(scopes.length * 4);    // int is 4 bytes
        nScopes.write(0, scopes, 0, scopes.length);

//        @SuppressWarnings("MismatchedReadAndWriteOfArray")
//        ScopePermission[] scopePermissions = new ScopePermission[scopes.length];
//        Pointer nScopePermissions = new Memory(scopePermissions.length * Native.POINTER_SIZE);
//        for (int i = 0; i < scopePermissions.length; i++) {
//            Pointer p = new Memory(Native.POINTER_SIZE);
//            scopePermissions[i] = new ScopePermission(p);
//        }
//        nScopePermissions.write(0, Arrays.copyOf(Arrays.stream(scopePermissions).map(Structure::getPointer).toArray(), scopePermissions.length, Pointer[].class), 0, scopePermissions.length);

//        Pointer[] nScopePermissions = new Pointer[scopes.length];
//        for(int i = 0; i < nScopePermissions.length; i++)
//            nScopePermissions[i] = new Memory(Native.POINTER_SIZE);

//        ScopePermission[] scopePermissions = new ScopePermission[scopes.length];
//        Pointer nScopePermissions = new Memory(Native.POINTER_SIZE * scopes.length);
//        nScopePermissions.write(0, scopePermissions, 0, scopePermissions.length);

//        ScopePermission sp = new ScopePermission();
//        ScopePermission[] sps = (ScopePermission[]) sp.toArray(3);

//        ScopePermission.ByReference sp = new ScopePermission.ByReference();
//        ScopePermission.ByReference[] sps = (ScopePermission.ByReference[]) sp.toArray(3);

//        Pointer[] sps = new Pointer[scopes.length];
//        Pointer sp = new Memory(Native.POINTER_SIZE * scopes.length);
//        sp.write(0, sps, 0, sps.length);

        ScopePermission[] sp = (ScopePermission[]) new ScopePermission().toArray(3);

        Pointer[] arr = new Pointer[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sp[i].getPointer();
            sp[i] = null;
            //arr[i].clear();
        }

        SizeT tableSize = new SizeT(scopes.length);
        CreateInputParams in = new CreateInputParams();
        in.appName = "Test";
        in.scopeTable = nScopes;
        in.scopeTableSize = tableSize;
        in.pollForCallbacks = false;

        CreateResponse out = new CreateResponse();
        out.scopePermissionTable = arr[0];
        out.scopePermissionTableSize = tableSize;

        int rc = sdk.NVGSDK_Create(handle, in, out);
        System.out.println("rc = " + rc + " success = " + (rc >= 0));
        System.out.println("GFE Ver = " + out.gfeVersionStr);
    }
}

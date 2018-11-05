package me.cubxity.tests;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import me.cubxity.jna.*;

import java.util.Arrays;

public class GFE4JTest {


    public static void main(String... args) {
        GfeSDK sdk = GfeSDK.INSTANCE;

        Pointer handle = new Memory(Native.POINTER_SIZE);

        int[] scopes = new int[]{GfeSDK.NVGSDK_SCOPE_HIGHLIGHTS, GfeSDK.NVGSDK_SCOPE_HIGHLIGHTS_VIDEO, GfeSDK.NVGSDK_SCOPE_HIGHLIGHTS_SCREENSHOT};
        Pointer nScopes = new Memory(scopes.length * 4);    // int is 4 bytes
        nScopes.write(0, scopes, 0, scopes.length);

        @SuppressWarnings("MismatchedReadAndWriteOfArray")
        ScopePermission[] scopePermissions = new ScopePermission[scopes.length];
        Pointer nScopePermissions = new Memory(scopePermissions.length * Native.POINTER_SIZE);
        for (int i = 0; i < scopePermissions.length; i++) {
            Pointer p = new Memory(Native.POINTER_SIZE);
            scopePermissions[i] = new ScopePermission(p);
        }
        nScopePermissions.write(0, Arrays.copyOf(Arrays.stream(scopePermissions).map(Structure::getPointer).toArray(), scopePermissions.length, Pointer[].class), 0, scopePermissions.length);

        CreateInputParams in = new CreateInputParams();
        in.appName = "Test";
        in.scopeTable = nScopes;
        in.scopeTableSize = new SizeT(scopes.length);
        in.pollForCallbacks = false;

        CreateResponse out = new CreateResponse();
        out.scopePermissionTable = nScopePermissions;
        out.scopePermissionTableSize = new SizeT(scopes.length);

        int rc = sdk.NVGSDK_Create(handle, in, out);
        System.out.println("rc = " + rc + " success = " + (rc >= 0));
        System.out.println("GFE Ver = " + out.gfeVersionStr);
    }
}

package me.cubxity.jna;

import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;

public interface EmptyCallback extends StdCallLibrary.StdCallCallback {
    void callback(int rc, Pointer pointer);
}

package me.cubxity.jna;

import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;

public interface NotificationCallback extends StdCallLibrary.StdCallCallback {
    void callback(int type, Notification response, Pointer context);
}

package me.cubxity.jna;

import com.sun.jna.IntegerType;

public class UInt16T extends IntegerType {
    public UInt16T() {
        this(0);
    }

    public UInt16T(int value) {
        super(2, value, true);
    }
}
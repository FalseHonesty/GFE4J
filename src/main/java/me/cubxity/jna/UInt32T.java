package me.cubxity.jna;

import com.sun.jna.IntegerType;

public class UInt32T extends IntegerType {
    public UInt32T() {
        this(0);
    }

    public UInt32T(int value) {
        super(4, value, true);
    }
}
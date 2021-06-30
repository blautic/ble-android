
package com.diegulog.ble;

import org.jetbrains.annotations.NotNull;

import static android.bluetooth.BluetoothDevice.DEVICE_TYPE_CLASSIC;
import static android.bluetooth.BluetoothDevice.DEVICE_TYPE_DUAL;
import static android.bluetooth.BluetoothDevice.DEVICE_TYPE_LE;
import static android.bluetooth.BluetoothDevice.DEVICE_TYPE_UNKNOWN;

/**
 * This class represents the possible peripheral types
 */
public enum PeripheralType {
    /**
     * Unknown peripheral type, peripheral is not cached
     */
    UNKNOWN(DEVICE_TYPE_UNKNOWN),

    /**
     * Classic - BR/EDR peripheral
     */
    CLASSIC(DEVICE_TYPE_CLASSIC),

    /**
     * Bluetooth Low Energy peripheral
     */
    LE(DEVICE_TYPE_LE),

    /**
     * Dual Mode - BR/EDR/LE
     */
    DUAL(DEVICE_TYPE_DUAL);

    PeripheralType(final int value) {
        this.value = value;
    }

    public final int value;

    @NotNull
    public static PeripheralType fromValue(final int value) {
        for (PeripheralType type : values()) {
            if (type.value == value) {
                return type;
            }
        }
        return UNKNOWN;
    }
}

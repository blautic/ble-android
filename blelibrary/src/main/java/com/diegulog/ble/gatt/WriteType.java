package com.diegulog.ble.gatt;

import static android.bluetooth.BluetoothGattCharacteristic.PROPERTY_SIGNED_WRITE;
import static android.bluetooth.BluetoothGattCharacteristic.PROPERTY_WRITE;
import static android.bluetooth.BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE;
import static android.bluetooth.BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT;
import static android.bluetooth.BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE;
import static android.bluetooth.BluetoothGattCharacteristic.WRITE_TYPE_SIGNED;

/**
 * WriteType describes the type of write that can be done
 */
public enum WriteType {
    /**
     * Write characteristic and requesting acknowledgement by the remote peripheral
     */
    WITH_RESPONSE(WRITE_TYPE_DEFAULT, PROPERTY_WRITE),

    /**
     * Write characteristic without requiring a response by the remote peripheral
     */
    WITHOUT_RESPONSE(WRITE_TYPE_NO_RESPONSE, PROPERTY_WRITE_NO_RESPONSE),

    /**
     * Write characteristic including authentication signature
     */
    SIGNED(WRITE_TYPE_SIGNED, PROPERTY_SIGNED_WRITE);

    public final int writeType;
    public final int property;

    WriteType(final int writeType, final int property) {
        this.writeType = writeType;
        this.property = property;
    }
}

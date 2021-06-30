
package com.diegulog.ble.gatt;

import org.jetbrains.annotations.NotNull;

import static android.bluetooth.BluetoothDevice.BOND_BONDED;
import static android.bluetooth.BluetoothDevice.BOND_BONDING;
import static android.bluetooth.BluetoothDevice.BOND_NONE;

/**
 * The class represents the various possible bond states
 */
public enum BondState {
    /**
     * Indicates the remote peripheral is not bonded.
     * There is no shared link key with the remote peripheral, so communication
     * (if it is allowed at all) will be unauthenticated and unencrypted.
     */
    NONE(BOND_NONE),

    /**
     * Indicates bonding is in progress with the remote peripheral.
     */
    BONDING(BOND_BONDING),

    /**
     * Indicates the remote peripheral is bonded.
     * A shared link keys exists locally for the remote peripheral, so
     * communication can be authenticated and encrypted.
     */
    BONDED(BOND_BONDED);

    BondState(final int value) {
        this.value = value;
    }

    public final int value;

    @NotNull
    public static BondState fromValue(final int value) {
        for (BondState type : values()) {
            if (type.value == value) {
                return type;
            }
        }
        return NONE;
    }
}

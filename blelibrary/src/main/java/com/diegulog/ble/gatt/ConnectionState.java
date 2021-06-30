
package com.diegulog.ble.gatt;

import org.jetbrains.annotations.NotNull;

/**
 * This class represents the possible connection states
 */
public enum ConnectionState {
    /**
     * The peripheral is disconnected
     */
    DISCONNECTED(0),

    /**
     * The peripheral is connecting
     */
    CONNECTING(1),

    /**
     * The peripheral is connected
     */
    CONNECTED(2),

    /**
     * The peripheral is disconnecting
     */
    DISCONNECTING(3),

    /**
     * The peripheral connection failed
     */
    FAILED(4);

    ConnectionState(final int value) {
        this.value = value;
    }

    public final int value;

    @NotNull
    public static ConnectionState fromValue(final int value) {
        for (ConnectionState type : values()) {
            if (type.value == value) {
                return type;
            }
        }
        return DISCONNECTED;
    }
}

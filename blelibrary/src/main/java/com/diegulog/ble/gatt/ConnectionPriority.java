
package com.diegulog.ble.gatt;

import static android.bluetooth.BluetoothGatt.CONNECTION_PRIORITY_BALANCED;
import static android.bluetooth.BluetoothGatt.CONNECTION_PRIORITY_HIGH;
import static android.bluetooth.BluetoothGatt.CONNECTION_PRIORITY_LOW_POWER;

public enum ConnectionPriority {
    /**
     * Use the connection parameters recommended by the Bluetooth SIG.
     * This is the default value if no connection parameter update
     * is requested.
     */
    BALANCED(CONNECTION_PRIORITY_BALANCED),

    /**
     * Request a high priority, low latency connection.
     * An application should only request high priority connection parameters to transfer large
     * amounts of data over LE quickly. Once the transfer is complete, the application should
     * request BALANCED connection parameters to reduce energy use.
     */
    HIGH(CONNECTION_PRIORITY_HIGH),

    /**
     * Request low power, reduced data rate connection parameters.
     */
    LOW_POWER(CONNECTION_PRIORITY_LOW_POWER);

    ConnectionPriority(final int value) {
        this.value = value;
    }

    public final int value;
}


package com.diegulog.ble.gatt;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

import org.jetbrains.annotations.NotNull;

/**
 * Callbacks for the BluetoothPeripheral class
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class BlePeripheralCallback {

    /**
     * Callback invoked when the list of remote services, characteristics and descriptors
     * for the remote peripheral has been discovered.
     *
     */
    public void onServicesDiscovered(@NotNull BlePeripheral peripheral) {}

    /**
     * Callback invoked when the notification state of a characteristic has changed.
     *
     * <p>Use {@link BlePeripheral#isNotifying} to get the current notification state of the characteristic
     *
     * @param peripheral the peripheral
     * @param characteristic the characteristic for which the notification state changed
     * @param status GATT status code
     */
    public void onNotificationStateUpdate(@NotNull BlePeripheral peripheral, @NotNull BluetoothGattCharacteristic characteristic, @NotNull GattStatus status) {}

    /**
     * Callback invoked as the result of a characteristic read operation or notification/indication
     *
     * @param peripheral the peripheral
     * @param value the new value received
     * @param characteristic the characteristic for which the new value was received
     * @param status GATT status code
     */
    public void onCharacteristicUpdate(@NotNull BlePeripheral peripheral, @NotNull byte[] value, @NotNull BluetoothGattCharacteristic characteristic, @NotNull GattStatus status) {}

    /**
     * Callback invoked as the result of a characteristic write operation.
     *
     * @param peripheral the peripheral
     * @param value the value that was written
     * @param characteristic the characteristic written to
     * @param status GATT status code
     */
    public void onCharacteristicWrite(@NotNull BlePeripheral peripheral, @NotNull byte[] value, @NotNull BluetoothGattCharacteristic characteristic, @NotNull GattStatus status) {}

    /**
     * Callback invoked as the result of a descriptor read operation
     *
     * @param peripheral the peripheral
     * @param value the read value
     * @param descriptor the descriptor that was read
     * @param status GATT status code
     */
    public void onDescriptorRead(@NotNull BlePeripheral peripheral, @NotNull byte[] value, @NotNull BluetoothGattDescriptor descriptor, @NotNull GattStatus status) {}

    /**
     * Callback invoked as the result of a descriptor write operation.
     * This callback is not called for the Client Characteristic Configuration descriptor. Instead the {@link BlePeripheralCallback#onNotificationStateUpdate(BlePeripheral, BluetoothGattCharacteristic, GattStatus)} will be called
     *
     * @param peripheral the peripheral
     * @param value the value that was written
     * @param descriptor the descriptor written to
     * @param status the GATT status code
     */
    public void onDescriptorWrite(@NotNull BlePeripheral peripheral, @NotNull byte[] value, @NotNull BluetoothGattDescriptor descriptor, @NotNull GattStatus status) {}

    /**
     * Callback invoked when the bonding process is started
     *
     * @param peripheral the peripheral
     */
    public void onBondingStarted(@NotNull BlePeripheral peripheral) {}

    /**
     * Callback invoked when the bonding process has succeeded
     *
     * @param peripheral the peripheral
     */
    public void onBondingSucceeded(@NotNull BlePeripheral peripheral) {}

    /**
     * Callback invoked when the bonding process has failed
     *
     * @param peripheral the peripheral
     */
    public void onBondingFailed(@NotNull BlePeripheral peripheral) {}

    /**
     * Callback invoked when a bond has been lost and the peripheral is not bonded anymore.
     *
     * @param peripheral the peripheral
     */
    public void onBondLost(@NotNull BlePeripheral peripheral) {}

    /**
     * Callback invoked as the result of a read RSSI operation
     *
     * @param peripheral the peripheral
     * @param rssi the RSSI value
     * @param status GATT status code
     */
    public void onReadRemoteRssi(@NotNull BlePeripheral peripheral, int rssi, @NotNull GattStatus status) {}

    /**
     * Callback invoked as the result of a MTU request operation
     *
     * @param peripheral the peripheral
     * @param mtu the new MTU
     * @param status GATT status code
     */
    public void onMtuChanged(@NotNull BlePeripheral peripheral, int mtu, @NotNull GattStatus status) {}

    /**
     * Callback invoke as result of readPhy or setPhy operation
     *
     * @param peripheral the peripheral
     * @param txPhy the transmitter PHY in use.
     * @param rxPhy the receiver PHY in use
     * @param status GATT status code
     */
    public void onPhyUpdate(@NotNull BlePeripheral peripheral, @NotNull PhyType txPhy, @NotNull PhyType rxPhy, @NotNull GattStatus status) {}

    /**
     * Callback invoked when the connection parameters are updated.
     *
     * This can happen as a result of requestConnectionPriority() or when the stack/peripheral decides to change the connection parameters.
     * This callback is only called for Android 8 (Oreo) or newer.
     *
     * @param peripheral the peripheral
     * @param interval Connection interval used on this connection, 1.25ms unit.
     *                 Valid range is from 6 (7.5ms) to 3200 (4000ms).
     * @param latency  Slave latency for the connection in number of connection events.
     *                 Valid range is from 0 to 499.
     * @param timeout  Supervision timeout for this connection, in 10ms unit.
     *                 Valid range is from 10 (0.1s) to 3200 (32s).
     * @param status GATT status code
     */
    public void onConnectionUpdated(@NotNull BlePeripheral peripheral, int interval, int latency, int timeout, @NotNull GattStatus status) {}

    /**
     * NULL class to deal with nullability
     */
    public static class NULL extends BlePeripheralCallback { }
}

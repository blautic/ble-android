
package com.diegulog.ble;

import android.bluetooth.le.ScanResult;

import com.diegulog.ble.gatt.BlePeripheral;
import com.diegulog.ble.gatt.HciStatus;

import org.jetbrains.annotations.NotNull;

/**
 * Callbacks for the BluetoothCentralManager class
 */
public abstract class BleManagerCallback {

    /**
     * Successfully connected with a peripheral.
     *
     * @param peripheral the peripheral that was connected.
     */
    public void onConnectedPeripheral(@NotNull BlePeripheral peripheral) {}

    /**
     * Connecting with the peripheral has failed.
     *
     * @param peripheral the peripheral for which the connection was attempted
     * @param status the status code for the connection failure
     */
    public void onConnectionFailed(@NotNull BlePeripheral peripheral, @NotNull HciStatus status) {}

    /**
     * Peripheral disconnected
     *
     * @param peripheral the peripheral that disconnected.
     * @param status the status code for the disconnection
     */
    public void onDisconnectedPeripheral(@NotNull BlePeripheral peripheral, @NotNull HciStatus status) {}

    /**
     * Discovered a peripheral
     *
     * @param peripheral the peripheral that was found
     * @param scanResult the scanResult describing the peripheral
     */
    public void onDiscoveredPeripheral(@NotNull BlePeripheral peripheral, @NotNull ScanResult scanResult) {}

    /**
     * Scanning failed
     *
     * @param scanFailure the status code for the scanning failure
     */
    public void onScanFailed(@NotNull ScanFailure scanFailure) {}

    /**
     * Bluetooth adapter status changed
     *
     * @param state the current status code for the adapter
     */
    public void onBluetoothAdapterStateChanged(int state) {}
}

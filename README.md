# Agregar dependencias

Agrega el repositorio a tu `build.gradle` :

```groovy
maven { url = uri("https://jitpack.io") }
```

Agregar la librería al  `build.gradle`  de la aplicación:

```
implementation("com.github.blautic:ble-android:1.4")
```

# Conectar un dispositivo 

```java

//Callback para gestión de conexión y scaner
private final BleManagerCallback bleManagerCallback = new BleManagerCallback() {
    @Override
    public void onConnectedPeripheral(@NotNull BlePeripheral peripheral) {
        Log.i("connected to '%s'", peripheral.getAddress());
    }
    @Override
    public void onDisconnectedPeripheral(@NotNull BlePeripheral peripheral, @NotNull HciStatus status) {
        Log.i("onDisconnectedPeripheral to '%s'", peripheral.getAddress());
    }

    @Override
    public void onDiscoveredPeripheral(@NotNull BlePeripheral peripheral, @NotNull ScanResult scanResult) {
        ScanRecord record = scanResult.getScanRecord();
    }
};

//Callback para gestión del BluetoothGatt
  private final BlePeripheralCallback blePeripheralCallback = new BlePeripheralCallback() {
        @Override
        public void onServicesDiscovered(@NotNull BlePeripheral peripheral) {
            Log.d("onServicesDiscovered");
        }
         @Override
        public void onCharacteristicWrite(@NotNull BlePeripheral peripheral, @NotNull byte[] value, @NotNull BluetoothGattCharacteristic characteristic, @NotNull GattStatus status) {
            if (status == GattStatus.SUCCESS) {
                Log.i("SUCCESS: Writing <%s> to <%s>", BleBytesParser.bytes2String(value), characteristic.getUuid());
            } else {
                Log.i("ERROR: Failed writing <%s> to <%s> (%s)", BleBytesParser.bytes2String(value), characteristic.getUuid(), status);
            }
        }

        @Override
        public void onCharacteristicUpdate(@NotNull BlePeripheral peripheral, @NotNull byte[] value, @NotNull BluetoothGattCharacteristic characteristic, @NotNull GattStatus status) {
            UUID uuid = characteristic.getUuid();
        }
    };

//Inicializar BleManager
BleManager bleManager = new BleManager(context, bleManagerCallback, new Handler(Looper.getMainLooper()));
//BluetoothGatt si existe con esa mac lo devuelve o inicializa
BlePeripheral peripheral = bleManager.getPeripheral(MAC_ADDRESS);
//Conectar
bleManager.connectPeripheral(peripheral, blePeripheralCallback);
//Desconectar
blePeripheral.cancelConnection();

//Se pueden llamar despues de onServicesDiscovered
//Habilitar notificación
peripheral.setNotify(UUID_SERVICE, uuid, true);
//Escribir            
peripheral.writeCharacteristic(UUID_SERVICE, uuid, value);
//Leer
peripheral.readCharacteristic(UUID_SERVICE, uuid);

//Scanear
bleManager.scanForPeripherals();
// Detener Scan
bleManager.stopScan();



```

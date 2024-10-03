open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "online"
        protected set

    open val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }

    open fun printDeviceInfo(){
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
        SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    fun decreaseVolume(){
        speakerVolume--
        println("Speaker volume reduced to $speakerVolume.")
    }

    fun previousChannel() {
        channelNumber--
        println("Channel number reduced to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn()
        println(
                "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                        "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }

}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
        SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    fun decreaseBrightness(){
        brightnessLevel--
        println("Brightness reduced to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

class SmartHome(
        val smartTvDevice: SmartTvDevice,
        val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun decreaseTvVolume(){
        smartTvDevice.decreaseVolume();
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun changeTvChannelToPrevious(){
        smartTvDevice.previousChannel();
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }

    fun printSmartTvInfo(){
        smartTvDevice.printDeviceInfo();
    }

    fun printSmartLightInfo(){
        smartTvDevice.printDeviceInfo();
    }

    fun decreaseLightBrightness(){
        smartLightDevice.decreaseBrightness();
    }
}

class RangeRegulator(
        initialValue: Int,
        private val minValue: Int,
        private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    val smartDevice: SmartTvDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()

    val smartDevice2:  SmartLightDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()

    var smartHome:SmartHome = SmartHome(smartDevice, smartDevice2)
    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToPrevious()
    smartHome.printSmartTvInfo()
    smartHome.decreaseLightBrightness()
    smartHome.printSmartLightInfo()


}

class LightBulb {

    private boolean isOn;
    private int brightness;

    public LightBulb() {
        this.brightness = 0;
        this.isOn = false;
    }

    public void turnOn(int brightness) {
        this.isOn = true;
        setBrightness(brightness);
    }

    public void turnOff() {
        this.isOn = false;
        this.brightness = 0;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public int getBrightness() {
        return this.brightness;
    }

    public void adjustBrightness(int brightness) {
        if (this.isOn == true) {
            setBrightness(brightness);
        }
    }

    private void setBrightness(int brightness) {
        if (brightness > 100) {
            this.brightness = 100;
            return;
        }
        if (brightness < 0) {
            this.brightness = 0;
            return;
        }
        this.brightness = brightness;
    }
}

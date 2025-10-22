
class ParkingMeter {

    private int timeLeft = 0;
    private double ratePetHour;

    public ParkingMeter(double ratePetHour) {
        this.ratePetHour = ratePetHour;
    }

    public void addTime(double amount) {
        if (amount < 0) {
            return;
        }
        this.timeLeft += (amount / this.ratePetHour) * 60;
    }

    public void tick(){
        if (this.timeLeft > 0) {
            this.timeLeft -= 1;
        }
    }

    public boolean isExpired() {
        if (this.timeLeft == 0) {
            return true;
        }
        return false;
    }

    public int getTimeLeft() {
        return this.timeLeft;
    }

}

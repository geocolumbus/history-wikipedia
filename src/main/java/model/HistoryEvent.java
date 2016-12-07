package model;

/**
 * A History Event
 */
public class HistoryEvent {

    private String entry;
    private int dayOfMonth;

    public HistoryEvent(String entry, int dayOfMonth) {
        this.entry = entry;
        this.dayOfMonth = dayOfMonth;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    @Override
    public String toString() {
        return "HistoryEvent{" +
            "entry='" + entry + '\'' +
            ", dayOfMonth=" + dayOfMonth +
            '}';
    }
}

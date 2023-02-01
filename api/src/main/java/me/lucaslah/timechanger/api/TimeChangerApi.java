package me.lucaslah.timechanger.api;

public interface TimeChangerApi {
    /**
     * Sets the time of day
     * @param ticks the time ticks
     */
    void setTime(int ticks);
    void setTime(TimeOption time);
    default void setTime(String time) {
        setTime(TimeOption.valueOf(time));
    }
}

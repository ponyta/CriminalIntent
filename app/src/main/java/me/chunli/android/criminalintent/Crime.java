package me.chunli.android.criminalintent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.UUID;

public class Crime {
    private static final FormatStyle DATETIME_FORMAT = FormatStyle.MEDIUM;
    private UUID id;
    private String title;
    private LocalDate date;
    private LocalTime time;
    private boolean solved;
    private boolean requiresPolice;

    public Crime() {
        this.id = UUID.randomUUID();
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getFormattedDate() {
        return date.format(DateTimeFormatter.ofLocalizedDate(DATETIME_FORMAT));
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getFormattedTime() {
        return time.format(DateTimeFormatter.ofLocalizedTime(DATETIME_FORMAT));
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getFormattedDateTime() {
        return LocalDateTime.of(date, time)
                .format(DateTimeFormatter.ofLocalizedDateTime(DATETIME_FORMAT));
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public boolean isRequiresPolice() {
        return requiresPolice;
    }

    public void setRequiresPolice(boolean requiresPolice) {
        this.requiresPolice = requiresPolice;
    }

}

package com.walmart.ticketservice.constants;

import java.util.function.Supplier;

/**
 * Enum to hold the levels, rows and seats per row
 * 
 * If a new level is introduced, just adding another enum is sufficient
 * 
 */
public enum VenueLevelSeatsEnum {

    LEVEL_THREE(Constants.NINE, Constants.HOLD_SEAT_LIMIT, "Box :"),
    LEVEL_TWO(Constants.NINE, Constants.HOLD_SEAT_LIMIT, "Balcony :"),
    LEVEL_ONE(Constants.NINE, Constants.HOLD_SEAT_LIMIT, "First Class :");

    private int rows;

    private int seatsPerRow;

    private String levelName;

    /**
     * 
     * @param rows
     * @param seatsPerRow
     * @param levelName
     */
    private VenueLevelSeatsEnum(final int rows, final int seatsPerRow, final String levelName) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.levelName = levelName;
    }

    /**
     * Returns the total rows for the given Level
     * 
     * @return
     */
    public Supplier<Integer> totalRows = () -> rows;

    /**
     * Returns the count of seats of each row for given level
     * 
     * @return
     */
    public Supplier<Integer> supplySeatsPerRow = () -> seatsPerRow;

    /**
     * Returns the level name
     * 
     * @return
     */
    public Supplier<String> supplyLevelName = () -> levelName;

}

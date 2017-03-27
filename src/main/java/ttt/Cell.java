package ttt;

/**
 * Created by B0660864 on 2017-03-27.
 */
public class Cell {

    private Status actualStatus;
    private int cellID;

    public enum Status {
        CROSS,
        CIRCLE,
        EMPTY
    }

    Cell() {
        actualStatus = Status.EMPTY;
    }

    Cell(int cellID) {
        actualStatus = Status.EMPTY;
        this.cellID = cellID;
    }

    public boolean isStatus(Status statusToCheck) {
        if(actualStatus == statusToCheck){
            return true;
        }
        return false;
    }

    public Status getActualStatus() {
        return actualStatus;
    }

    public void setActualStatus(Status actualStatus) {
        this.actualStatus = actualStatus;
    }

    public int getCellID() {
        return cellID;
    }
}

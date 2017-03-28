package ttt;

/**
 * Created by B0660864 on 2017-03-27.
 */
class Cell {

    private Status status;
    private int cellID;

    public enum Status {
        CROSS,
        CIRCLE,
        EMPTY
    }

    Cell() {
        status = Status.EMPTY;
    }

    Cell(int cellID) {
        status = Status.EMPTY;
        this.cellID = cellID;
    }

    protected boolean isStatus(Status statusToCheck) {
        if(status == statusToCheck) {
            return true;
        }
        return false;
    }

    protected Status getStatus() {
        return status;
    }

    protected void setStatus(Status status) {
        this.status = status;
    }

    protected int getCellID() {
        return cellID;
    }
}

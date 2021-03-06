package afeka.battleship.Model;

public class Tile {
    public enum Status {NONE, HIT, MISS, PLACED, DROWNED}

    private int x;
    private int y;
    private Ship ship;
    private Status status;
    private boolean wasHitAnimated = false;
    private boolean wasDrawnAnimated = false;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        status = Status.NONE;
    }

    @Override
    public String toString() {
        switch (status) {
            case NONE:
                return "";
            case PLACED:
                return ("S" + ship.getId());
            case HIT:
                return "X";
            case MISS:
                return "~";
            case DROWNED:
                return "D";
            default:
                return "";
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Ship getShip() {
        return ship;
    }

    public int getId (){
        return y*Board.BOARD_SIZE+x;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Status getStatus() {
        return status;
    }

    public boolean setHit(Board board) {
        status = Status.HIT;
        return ship.setHit(board); //update ship's hit counter
    }

    public void setMiss() {
        status = Status.MISS;
    }

    public void setPlaced(Ship ship) {
        setShip(ship);
        status = Status.PLACED;
    }

    public void setDrowned() {
        status = Status.DROWNED;
    }

    public boolean isPlaced() {
        return status.equals(Status.PLACED);
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public boolean isWasHitAnimated() {
        return wasHitAnimated;
    }

    public void setWasHitAnimated(boolean wasHitAnimated) {
        this.wasHitAnimated = wasHitAnimated;
    }

    public boolean isWasDrawnAnimated() {
        return wasDrawnAnimated;
    }

    public void setWasDrawnAnimated(boolean wasDrawnAnimated) {
        this.wasDrawnAnimated = wasDrawnAnimated;
    }
}
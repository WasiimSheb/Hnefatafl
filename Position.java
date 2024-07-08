import java.util.Objects;

public class Position {
    private int row,col;
    public Position(int row, int col) {
        this.row=row;
        this.col=col;
    }

    public Position(Position p) {
        this.row=p.getRow();
        this.col=p.getCol();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && col == position.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row,col);
    }

    @Override
    public String toString() {
        return "("+row+", "+col+")";
    }
}


import java.util.Objects;

public class Coord {
    int x;
    int y;

    public Coord(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Coord coord = (Coord) o;
        return this.x == coord.x &&
            this.y == coord.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    @Override
    public String toString() {
        return "Coord{" +
            "x=" + this.x +
            ", y=" + this.y +
            '}';
    }
}


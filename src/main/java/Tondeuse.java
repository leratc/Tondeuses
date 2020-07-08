

class Tondeuse {
    int id;
    Coord coord;
    Direction direction;
    String scriptDeplacement;

    public Tondeuse(int id, Coord coord, Direction direction) {
        this.id = id;
        this.coord = coord;
        this.direction = direction;
    }
    void tickCoord(Integer xLimit,Integer yLimit) {
        switch (this.direction) {
            case N:
                if (this.coord.y < yLimit) {
                    this.coord.setY(this.coord.y + 1);
                }
                break;
            case E:
                if (this.coord.x < xLimit) {
                    this.coord.setX(this.coord.x + 1);
                }
                break;
            case S:
                if (this.coord.y > 0) {
                    this.coord.setY(this.coord.y - 1);
                }
                break;
            case W:
                if (this.coord.x > 0) {
                    this.coord.setX(this.coord.x - 1);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }
    }
    void nextDirection(TurnDirection td) {
        this.setDirection(this.direction.nextDirection(td));
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getScriptDeplacement() {
        return scriptDeplacement;
    }

    public void setScriptDeplacement(String scriptDeplacement) {
        this.scriptDeplacement = scriptDeplacement;
    }

    public void handleScriptDeplacement(Integer xLimit, Integer yLimit) {
        //changement direction et deplacement Tondeuse
        String[] scriptDeplacement= this.scriptDeplacement.split("");
        for (String s:scriptDeplacement) {
            if (s.equals("A")) {
                this.tickCoord(xLimit, yLimit);
            }
            else if (s.equals("D") || s.equals("G")) {
                this.nextDirection(TurnDirection.valueOf(s));
            }
        }
    }

    @Override
    public String toString() {
        return "Tondeuse{" +
            "id=" + id +
            ", coord=" + coord +
            ", direction=" + direction +
            '}';
    }
}

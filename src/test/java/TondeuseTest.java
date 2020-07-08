import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TondeuseTest {
    @Test
    @DisplayName("Test tickCoord_fromN()")
    public void test_tickCoord_fromN() {
        Tondeuse tondeuse = new Tondeuse(1,new Coord(2,1),Direction.N);
        tondeuse.tickCoord(5,5);
        assertThat(tondeuse.getCoord().getY()).isEqualTo(2);
    }
    @Test
    @DisplayName("Test tickCoord_fromS()")
    public void test_tickCoord_fromS() {
        Tondeuse tondeuse = new Tondeuse(1,new Coord(2,1),Direction.S);
        tondeuse.tickCoord(5,5);
        assertThat(tondeuse.getCoord().getY()).isEqualTo(0);
    }
    @Test
    @DisplayName("Test tickCoord_fromE()")
    public void test_tickCoord_fromE() {
        Tondeuse tondeuse = new Tondeuse(1,new Coord(2,1),Direction.E);
        tondeuse.tickCoord(5,5);
        assertThat(tondeuse.getCoord().getX()).isEqualTo(3);
    }
    @Test
    @DisplayName("Test tickCoord_fromW()")
    public void test_tickCoord_fromW() {
        Tondeuse tondeuse = new Tondeuse(1,new Coord(2,1),Direction.W);
        tondeuse.tickCoord(5,5);
        assertThat(tondeuse.getCoord().getX()).isEqualTo(1);
    }
    @Test
    @DisplayName("Test tickCoord_fromSOffGridNeg() = no move")
    public void test_tickCoord_fromSOffGridNeg() {
        Tondeuse tondeuse = new Tondeuse(1,new Coord(2,0),Direction.S);
        tondeuse.tickCoord(5,5);
        assertThat(tondeuse.getCoord().getY()).isEqualTo(0);
    }
    @Test
    @DisplayName("Test tickCoord_fromSOffGridPos() = no move")
    public void test_tickCoord_fromSOffGridPos() {
        Tondeuse tondeuse = new Tondeuse(1,new Coord(2,5),Direction.N);
        tondeuse.tickCoord(5,5);
        assertThat(tondeuse.getCoord().getY()).isEqualTo(5);
    }
    @Test
    @DisplayName("Test handleScriptDeplacement")
    public void test_handleScriptDeplacement() {
        Tondeuse tondeuse = new Tondeuse(1,new Coord(1,2),Direction.N);
        tondeuse.setScriptDeplacement("GAGAGAGAA");
        tondeuse.handleScriptDeplacement(5,5);
        assertThat(tondeuse.getCoord().getX()).isEqualTo(1);
        assertThat(tondeuse.getCoord().getY()).isEqualTo(3);
        assertThat(tondeuse.getDirection()).isEqualTo(Direction.N);
    }
    @Test
    @DisplayName("Test handleScriptDeplacement2")
    public void test_handleScriptDeplacement2() {
        Tondeuse tondeuse = new Tondeuse(1,new Coord(3,3),Direction.E);
        tondeuse.setScriptDeplacement("AADAADADDA");
        tondeuse.handleScriptDeplacement(5,5);
        assertThat(tondeuse.getCoord().getX()).isEqualTo(5);
        assertThat(tondeuse.getCoord().getY()).isEqualTo(1);
        assertThat(tondeuse.getDirection()).isEqualTo(Direction.E);
    }
}

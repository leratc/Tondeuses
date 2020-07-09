import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TondeusePlayGroundTest {
    @Test
    @DisplayName("Test tickCoord_fromN()")
    public void test_tickCoord_fromN() {
        String fileName = "src/test/resources/tondeusesScript.txt";
        TondeusePlayGround tondeusePlayGround = TondeusePlayGround.buildPlayGroundFromResourceFile(fileName);
        assertThat(tondeusePlayGround.getMapTondeuses().size()).isEqualTo(2);
        assertThat(tondeusePlayGround.getMapTondeuses().get(1).getCoord().getX()).isEqualTo(1);
        assertThat(tondeusePlayGround.getMapTondeuses().get(1).getCoord().getY()).isEqualTo(2);
        assertThat(tondeusePlayGround.getMapTondeuses().get(1).getDirection()).isEqualTo(Direction.N);
        assertThat(tondeusePlayGround.getMapTondeuses().get(1).getScriptDeplacement()).isEqualTo("GAGAGAGAA");
        assertThat(tondeusePlayGround.getMapTondeuses().get(2).getScriptDeplacement()).isEqualTo("AADAADADDA");
        assertThat(tondeusePlayGround.getMapTondeuses().get(2).getCoord().getX()).isEqualTo(3);
        assertThat(tondeusePlayGround.getMapTondeuses().get(2).getCoord().getY()).isEqualTo(3);
        assertThat(tondeusePlayGround.getMapTondeuses().get(2).getDirection()).isEqualTo(Direction.E);
    }
}

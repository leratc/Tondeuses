
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TondeusePlayGroundRunner {
    public static void main(final String[] args) {
       String fileName = "src/main/resources/tondeusesScript.txt";

        TondeusePlayGround tondeusePlayGround = TondeusePlayGround.buildPlayGroundFromResourceFile(fileName);

       tondeusePlayGround.getMapTondeuses().values().forEach(tondeuse-> {
            tondeuse.handleScriptDeplacement(tondeusePlayGround.width,tondeusePlayGround.height);
        });
        System.out.println(tondeusePlayGround.getMapTondeuses().values());

    }
}

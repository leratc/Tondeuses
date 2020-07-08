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

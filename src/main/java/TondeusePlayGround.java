

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class TondeusePlayGround {
    int width; // size of the grid
     int height; // top left corner is (x=0, y=0)
     Map<Integer,Tondeuse> mapTondeuses= new HashMap<>();

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Map<Integer, Tondeuse> getMapTondeuses() {
        return mapTondeuses;
    }

    public void setMapTondeuses(Map<Integer, Tondeuse> mapTondeuses) {
        this.mapTondeuses = mapTondeuses;
    }
    public static TondeusePlayGround buildPlayGroundFromResourceFile(String fileName) {
        TondeusePlayGround tondeusePlayGround=new TondeusePlayGround();
        File file= new File(fileName);
        try (Stream<String> stream = Files.lines(file.toPath())) {
            List<String> lines = stream.collect(Collectors.toList());
            for (int i=0;i<lines.size();i++) {
                int numLigne=i+1;
                if (numLigne==1) {
                    String ligne1= lines.get(0);
                    String[] xy= ligne1.split(" ");
                    tondeusePlayGround.setWidth(Integer.valueOf(xy[0])+1); //coordonnée 0 based d'où le + 1
                    tondeusePlayGround.setHeight(Integer.valueOf(xy[1])+1);//coordonnée 0 based d'où le + 1
                }
                else if (numLigne%2 == 0) {
                    // point de départ tondeuse
                    String[] pointDeDepartTondeuse= lines.get(i).split(" ");
                    Coord coord = new Coord(Integer.valueOf(pointDeDepartTondeuse[0]),Integer.valueOf(pointDeDepartTondeuse[1]));
                    int numeroTondeuse=numLigne/2;
                    Tondeuse tondeuse = new Tondeuse(numeroTondeuse,coord, Direction.valueOf(pointDeDepartTondeuse[2]));
                    tondeusePlayGround.getMapTondeuses().put(numeroTondeuse, tondeuse);
                }
                else {
                    int numtondeuse=(numLigne-1)/2;
                    tondeusePlayGround.getMapTondeuses().get(numtondeuse).setScriptDeplacement(lines.get(i));
                }
            }

        } catch (IOException e) {
              e.printStackTrace();
        }
      return tondeusePlayGround;
    }
    @Override
    public String toString() {
        return "TondeusePlayGround{" +
                "width=" + width +
                ", height=" + height +
                ", mapTondeuses=" + mapTondeuses +
                '}';
    }
}

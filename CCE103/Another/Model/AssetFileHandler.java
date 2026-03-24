package Another.Model;

import java.io.*;
import java.util.ArrayList;

public class AssetFileHandler {

    private static final String FILE_NAME = "assets.txt";

    // READ ALL ASSETS
    public static ArrayList<Asset> readAssets() {
        ArrayList<Asset> assetList = new ArrayList<>();

        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");

                if (data.length == 8) {
                    Asset asset = new Asset(
                            data[0],
                            data[1],
                            data[2],
                            data[3],
                            data[5],
                            data[6],
                            Double.parseDouble(data[4]),
                            data[7]
                    );
                    assetList.add(asset);
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return assetList;
    }

    // WRITE ALL ASSETS (Used for Update & Delete)
    public static void writeAssets(ArrayList<Asset> assets) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));

            for (Asset asset : assets) {
                bw.write(asset.toFileString());
                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ADD ASSET (Append)
    public static void addAsset(Asset asset) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true));
            bw.write(asset.toFileString());
            bw.newLine();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
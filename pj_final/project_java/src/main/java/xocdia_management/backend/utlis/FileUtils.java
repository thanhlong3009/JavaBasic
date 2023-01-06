package xocdia_management.backend.utlis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import xocdia_management.backend.model.Admin;
import xocdia_management.backend.model.Player;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileUtils {
    public static ArrayList<Player> getDataFromFileP(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(fileName));


            Type type = new TypeToken<ArrayList<Player>>(){}.getType();
            ArrayList<Player> players = gson.fromJson(reader, type);

            reader.close();
            return players;
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void setDataToFileP(String fileName, Object obj) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = Files.newBufferedWriter(Paths.get(fileName));
            gson.toJson(obj, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Admin> getDataFromFileAd(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(fileName));

            Type type = new TypeToken<ArrayList<Admin>>(){}.getType();
            ArrayList<Admin> admins = gson.fromJson(reader, type);

            reader.close();
            return admins;
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return new ArrayList<>();
    }
}

package arekceg.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Rainfall {

    public static double mean(String town, String strng) {
        final List<Double> parsedRainfallData = getRainfallDataForTown(town, strng);
        if(parsedRainfallData == null || parsedRainfallData.size() < 1){
            return -1.0;
        }
        final double averageRainfall = parsedRainfallData.stream()
        .collect(Collectors.averagingDouble(n -> n));

        return averageRainfall;
    }

    public static double variance(String town, String strng) {
        final double mean = mean(town, strng);
        final List<Double> parsedRainfallData = getRainfallDataForTown(town, strng);
        if(parsedRainfallData == null || parsedRainfallData.size() < 1){
            return -1.0;
        }
        final List<Double> meanDifference = new ArrayList<>();
        parsedRainfallData.forEach(temp -> meanDifference.add(mean - temp));
        final double variance = parsedRainfallData.stream()
        .map(temp -> mean - temp)
        .map(diff -> diff * diff)
        .collect(Collectors.averagingDouble(n -> n));
        
        return variance;
    }

    private static List<Double> getRainfallDataForTown(String town, String strng) {
        final Map<String, List<Double>> rainfallData = parseRainfallData(strng);

        return rainfallData.get(town);
    }

    private static Map<String, List<Double>> parseRainfallData(String dataString) {
        final Map<String, List<Double>> rainfallData = new HashMap<>();
        final List<String> dataLines = Arrays.asList(dataString.split("\\n"));
        dataLines.forEach(line -> {
            String[] splitLines = line.split(":");
            rainfallData.put(splitLines[0], parseRainfallString(splitLines[1]));
        });

        return rainfallData;
    }

    private static List<Double> parseRainfallString(String rainfallString) {
        final List<Double> parsedRainfallString = new ArrayList<>();
        final List<String> monthAndDataList = Arrays.asList(rainfallString.split(","));
        monthAndDataList.forEach(data -> parsedRainfallString.add(extractRainfall(data)));
        return parsedRainfallString;
    }

    private static double extractRainfall(String monthAndRainfall) {
        final String[] monthAndRainfallArray = monthAndRainfall.split(" ");
        return Double.parseDouble(monthAndRainfallArray[1]);
    }
}

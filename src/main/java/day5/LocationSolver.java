package day5;

public class LocationSolver {
    long solve(String seeds, String soilToSeed, String soilToVertilizer, String vertilizerWater, String waterToLight, String lightToTemperature, String temperatureToHumidity, String humidityToLocation) {
        Map seedToSoil = new PathParser().parse(soilToSeed);
        Map soilToVertilizerMap = new PathParser().parse(soilToVertilizer);
        Map vertilizerWaterMap = new PathParser().parse(vertilizerWater);
        Map waterToLightMap = new PathParser().parse(waterToLight);
        Map lightToTemperatureMap = new PathParser().parse(lightToTemperature);
        Map temperatureToHumidityMap = new PathParser().parse(temperatureToHumidity);
        Map humidityToLocationMap = new PathParser().parse(humidityToLocation);
        String[] split = seeds.split(" ");
        long smallest = Integer.MAX_VALUE;
        for (String s : split) {
            Long seed = Long.valueOf(s);
            long soil = seedToSoil.getDestination(seed);
            long vertilizer = soilToVertilizerMap.getDestination(soil);
            long water = vertilizerWaterMap.getDestination(vertilizer);
            long light = waterToLightMap.getDestination(water);
            long temperature = lightToTemperatureMap.getDestination(light);
            long humidity = temperatureToHumidityMap.getDestination(temperature);
            long location = humidityToLocationMap.getDestination(humidity);
            if (location < smallest) {
                smallest = location;
            }
        }
        return smallest;

    }
}

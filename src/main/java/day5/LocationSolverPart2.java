package day5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LocationSolverPart2 {
    long solve(String seeds, String soilToSeed, String soilToVertilizer, String vertilizerWater, String waterToLight, String lightToTemperature, String temperatureToHumidity, String humidityToLocation) throws ExecutionException, InterruptedException {
        Map seedToSoil = new PathParser().parse(soilToSeed);
        Map soilToVertilizerMap = new PathParser().parse(soilToVertilizer);
        Map vertilizerWaterMap = new PathParser().parse(vertilizerWater);
        Map waterToLightMap = new PathParser().parse(waterToLight);
        Map lightToTemperatureMap = new PathParser().parse(lightToTemperature);
        Map temperatureToHumidityMap = new PathParser().parse(temperatureToHumidity);
        Map humidityToLocationMap = new PathParser().parse(humidityToLocation);
        String[] split = seeds.split(" ");
        List<SeedRange> ranges = new ArrayList<>();
        for (int i = 0; i < split.length; i = i + 2) {
            ranges.add(new SeedRange(Long.parseLong(split[i]), Long.parseLong(split[i + 1])));
        }
        long smallest = Integer.MAX_VALUE;
        ExecutorService executor = Executors.newFixedThreadPool(ranges.size());
        List<Future<Long>> allFutures = new ArrayList<>();
        for (SeedRange range : ranges) {
            allFutures.add(executor.submit(() -> {
                long smallestForRange = Integer.MAX_VALUE;
                for (long i = 0; i < range.getRange(); i++) {
                    long seed = range.getStart() + i;
                    long soil = seedToSoil.getDestination(seed);
                    long vertilizer = soilToVertilizerMap.getDestination(soil);
                    long water = vertilizerWaterMap.getDestination(vertilizer);
                    long light = waterToLightMap.getDestination(water);
                    long temperature = lightToTemperatureMap.getDestination(light);
                    long humidity = temperatureToHumidityMap.getDestination(temperature);
                    long location = humidityToLocationMap.getDestination(humidity);
                    if (location < smallestForRange) {
                        smallestForRange = location;
                    }
                }
                return smallestForRange;

            }));

        }
        for (Future<Long> allFuture : allFutures) {
            Long l = allFuture.get();
            if (l < smallest) {
                smallest = l;
            }
        }
        return smallest;

    }
}

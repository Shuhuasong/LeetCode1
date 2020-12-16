package InterviewChallege.Amazon2020;

import java.io.IOException;
import java.util.*;

public class NearestCity {

    public NearestCity() { }

    public String[] nearCity(int numCity, String[] cities, int[] xCoord, int[] yCoord, int numQuery, String[] query){
        Map<String, int[]> mapCity = new HashMap<>();
        Map<String, String> nearCity = new HashMap<>();
        for(int i=0; i<numCity; i++){
            mapCity.put(cities[i], new int[]{xCoord[i], yCoord[i]});
            //System.out.println(cities[i] + " " + xCoord[i] + " " + yCoord[i]);
        }
        String[] res = new String[numQuery];
        int count = 0;
        for(int i=0; i<numQuery; i++){
            String queryCity = query[i];
            if(nearCity.containsKey(queryCity)){
                continue;
                //res[count++] = nearCity.get(queryCity);
                //System.out.println(count + " " + nearCity.get(queryCity));
            }
            int[] queryPoint = mapCity.get(queryCity);
            int qX = queryPoint[0];
            int qY = queryPoint[1];

            Map<String, Integer> distCity = new HashMap<>();
            int minDist = Integer.MAX_VALUE;

            for(String curCity : mapCity.keySet()){
                if(!curCity.equals(queryCity)) {
                    int[] point = mapCity.get(curCity);
                    int x = point[0];
                    int y = point[1];
                   // System.out.println(curCity + " " + x + " " + y);
                    if (qX == x || qY == y) {
                        if (qX == x) minDist = Math.min(minDist, Math.abs(qY - y));
                        else if(qY==y)
                            minDist = Math.min(minDist, Math.abs(qX - x));
                    }else {
                        continue;
                    }
                    if (minDist !=Integer.MAX_VALUE && !distCity.containsKey(curCity)) {
                        distCity.put(curCity, minDist);
                      // System.out.println(curCity + " " + minDist + " " + queryCity);
                    }
                }
            }
            if(minDist==Integer.MAX_VALUE ) continue;
            for(String city : distCity.keySet()){
                //System.out.println(queryCity + " " + city + " " + distCity.get(city) + " " + minDist);
                if(distCity.get(city)==minDist){
                    //System.out.println(count + " " + city);
                        //res[count++] = city;
                    if(!nearCity.containsKey(city)){
                        nearCity.put(city, queryCity);
                        System.out.println(city + " " + queryCity);
                    }
                    if(!nearCity.containsKey(queryCity)){
                        nearCity.put(queryCity, city);
                        System.out.println(queryCity + " " + city);
                    }
                }
            }
        }
        for(String c : nearCity.keySet()){
            System.out.println("NearCity: " + c + " " + nearCity.get(c));
        }
        for(int i=0; i<numQuery; i++){
            String q = query[i];
            if(!nearCity.containsKey(q)){
                res[i] = "NONE";
            }else
                res[i] = nearCity.get(q);
        }
        return res;
    }


/*


   class City{
       int x;
       int y;
       String name;
   }
    public int dist(City c1 , City c2){
        return (c2.x-c1.x) * (c2.x-c1.x) + (c2.y-c1.y)*(c2.y-c1.y);
    }

   public List<String> getNearestCity(int numOfCities, List<String> cities, List<Integer> xCoordinates,
                                      List<Integer> yCoordinates, int numOfQueries, List<String> queries){
       Map<String, City> cityMap = new HashMap<>();
       Map<Integer, Set<String>> xMap = new HashMap<>();
       Map<Integer, Set<String>> yMap = new HashMap<>();
       for(int i=0; i<numOfCities; i++){
           City city = new City();
           city.x = xCoordinates.get(i);
           city.y = yCoordinates.get(i);
           city.name = cities.get(i);

           cityMap.put(city.name, city);

           Set<String> cityWithX = xMap.getOrDefault(city.x, new HashSet<>());
           cityWithX.add(city.name);
           xMap.put(city.x, cityWithX);

           Set<String> cityWithY = yMap.getOrDefault(city.y, new HashSet());
           cityWithY.add(city.name);
           yMap.put(city.y, cityWithY);
       }

       List<String> result = new LinkedList<>();
       for(String query : queries){
           City city = cityMap.get(query);
           Set<String> curSet = new HashSet<>();
           curSet.addAll(xMap.get(city.x));
           curSet.addAll(yMap.get(city.y));

           int minDist = Integer.MAX_VALUE;
           String str = "";
           for(String name : curSet){
               City c = cityMap.get(name);
               int dist = dist(city, c);
               if(!name.equals(query) && dist <= minDist){
                   if(dist < minDist){
                       str = c.name;
                   }else if(str.compareTo(c.name) < 0){
                       str = c.name;
                   }
                   minDist = dist;
               }
           }
           if(str.length()>0){
               result.add(str);
           }else{
               result.add("None");
           }
           return result;
       }
   }

  */

    public static void main(String args[]) throws IOException{
        NearestCity nCity = new NearestCity();
        int numCity = 5;
//        String[] cities = {"c1", "c2", "c3","c4","c5"};
//        int[] xCoord = {3,2,1,4,2};
//        int[] yCoord = {3,2,3,2,1};
//        int numQuery = 5;
//        String[] query = {"c1", "c2", "c3","c4","c5"};
//
//            String[] cities = {"c1", "c2","c3"};
//            int[] xCoord = {3, 2, 1};
//            int[] yCoord = {3, 2, 3};
//            int numQuery = 3;
//            String[] query = {"c1", "c2", "c3"};

        String[] cities = {"green", "red","blue", "yellow", "pink"};
        int[] xCoord = {100, 200, 300, 400, 500};
        int[] yCoord = {100, 200, 300, 400, 500};
        int numQuery = 5;
        String[] query = {"green", "red", "blue", "yellow", "pink"};
        String[] result = new String[numQuery];
        result = nCity.nearCity(numCity,cities, xCoord, yCoord, numQuery, query);
        for(String s : result){
            System.out.print(s + " ");
        }
    }
}
//https://leetcode.com/discuss/interview-question/808374/

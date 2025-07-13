package src.not150;

import java.util.*;

public class BusRoutes {

    private Map<Integer,List<Integer>> buildMap(int[][] routes){
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < routes.length ; i++){
            int routeNumber = i;
            int[] stops = routes[i];
            for(int stop : stops){
                map.computeIfAbsent(stop, k -> new ArrayList<>()).add(routeNumber);
            }
        }
        return map;
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }
        Map<Integer,List<Integer>> stopsToRouteMap = buildMap(routes);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        int transferCount = 0;
        boolean[] visitedRoutes = new boolean[routes.length];

        while(!queue.isEmpty()){
            transferCount++;
            // BFS runs level by level
            int stopsInCurrentLevel = queue.size();
            for(int i = 0 ; i < stopsInCurrentLevel ; i++){
                int currentStop = queue.remove();
                List<Integer> routesServedByCurrentStop = stopsToRouteMap.getOrDefault(currentStop, new ArrayList<>());
                for(int route : routesServedByCurrentStop){

                    if(!visitedRoutes[route]){

                        visitedRoutes[route] = true;

                        for(int stop : routes[route]){
                            if(stop == currentStop){
                                continue;
                            }
                            else if(stop == target){
                                return transferCount;
                            }
                            else{
                                queue.add(stop);
                            }
                        }

                    }


                }


            }



        }


        return -1;
    }


    public static void main(String[] args) {
        new BusRoutes().numBusesToDestination(new int[][]{{1,2,7},{3,6,7}}, 1, 6);
    }

}

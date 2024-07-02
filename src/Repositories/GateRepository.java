package Repositories;

import Models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {
    private Map<Integer,Gate> getMap = new TreeMap<>();
    public Optional<Gate> findGateById(int gateId)
    {
        if(getMap.containsKey(gateId)){
            return Optional.of(getMap.get(gateId));
        }
        return Optional.empty();
    }
    public void put(Gate gate){
        getMap.put(gate.getId(),gate);
    }
}

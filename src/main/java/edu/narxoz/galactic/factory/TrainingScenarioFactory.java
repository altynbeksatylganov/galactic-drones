package edu.narxoz.galactic.factory;

import edu.narxoz.galactic.bodies.CelestialBody;
import edu.narxoz.galactic.bodies.Planet;
import edu.narxoz.galactic.bodies.SpaceStation;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.drones.Drone;
import edu.narxoz.galactic.task.DeliveryTask;

public class TrainingScenarioFactory implements DeliveryScenarioFactory {

    private final DroneCreator droneCreator;

    public TrainingScenarioFactory(DroneCreator droneCreator) {
        this.droneCreator = droneCreator;
    }

    @Override
    public CelestialBody createOrigin() {
        return new Planet("Earth", 0, 0, "Oxygen");
    }

    @Override
    public CelestialBody createDestination() {
        return new SpaceStation("Mars Station", 100, 0, 3);
    }

    @Override
    public Cargo createCargo() {
        return new Cargo(20, "Food");
    }

    @Override
    public Drone createDrone() {
        return droneCreator.create("H1", 50);
    }

    @Override
    public DeliveryTask createTask() {
        return new DeliveryTask(createOrigin(), createDestination(), createCargo());
    }
}

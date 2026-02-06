package edu.narxoz.galactic.factory;

import edu.narxoz.galactic.bodies.CelestialBody;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.drones.Drone;
import edu.narxoz.galactic.task.DeliveryTask;

public interface DeliveryScenarioFactory {

    CelestialBody createOrigin();

    CelestialBody createDestination();

    Cargo createCargo();

    Drone createDrone();

    DeliveryTask createTask();
}


package edu.narxoz.galactic.demo;

import edu.narxoz.galactic.dispatcher.Dispatcher;
import edu.narxoz.galactic.factory.*;
import edu.narxoz.galactic.drones.Drone;
import edu.narxoz.galactic.task.DeliveryTask;

public class DemoApp {

    public static void main(String[] args) {

        DroneCreator droneCreator = new HeavyDroneCreator();

        DeliveryScenarioFactory scenario =
                new TrainingScenarioFactory(droneCreator);

        Drone drone = scenario.createDrone();
        DeliveryTask task = scenario.createTask();

        Dispatcher dispatcher = new Dispatcher();

        System.out.println(dispatcher.assignTask(task, drone));
        System.out.println("Estimated time: " + task.estimateTime());
        System.out.println(dispatcher.completeTask(task));

        System.out.println("Drone status: " + drone.getStatus());
        System.out.println("Task state: " + task.getState());
    }
}

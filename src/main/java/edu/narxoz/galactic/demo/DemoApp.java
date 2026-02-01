package edu.narxoz.galactic.demo;

import edu.narxoz.galactic.bodies.*;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.dispatcher.Dispatcher;
import edu.narxoz.galactic.drones.*;
import edu.narxoz.galactic.task.DeliveryTask;

public class DemoApp {
    public static void main(String[] args) {

        Planet earth = new Planet("Earth", 0, 0, "Oxygen");
        SpaceStation marsStation = new SpaceStation("Mars Station", 100, 0, 3);

        Cargo cargo = new Cargo(20, "Food");

        LightDrone light = new LightDrone("L1", 10);
        HeavyDrone heavy = new HeavyDrone("H1", 50);

        Dispatcher dispatcher = new Dispatcher();
        DeliveryTask task = new DeliveryTask(earth, marsStation, cargo);

        System.out.println(dispatcher.assignTask(task, light));  // Должен FAIL
        System.out.println(dispatcher.assignTask(task, heavy));  // Должен SUCCESS

        System.out.println("Estimated time: " + task.estimateTime());

        System.out.println(dispatcher.completeTask(task));
        System.out.println("Drone status: " + heavy.getStatus());
        System.out.println("Task state: " + task.getState());
    }
}

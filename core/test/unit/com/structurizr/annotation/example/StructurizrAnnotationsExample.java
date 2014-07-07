package com.structurizr.annotation.example;

import com.structurizr.componentfinder.ComponentFinder;
import com.structurizr.componentfinder.SpringComponentFinderStrategy;
import com.structurizr.componentfinder.StructurizrComponentFinderStrategy;
import com.structurizr.model.*;

public class StructurizrAnnotationsExample {

    public static void main(String[] args) throws Exception  {
        Model model = new Model();
        SoftwareSystem softwareSystem = model.addSoftwareSystem(Location.Internal, "Example software system", "An example software system");

        Person user = model.addPerson(Location.External, "A user", "An example user");
        user.uses(softwareSystem, "Uses");

        Container webApplication = softwareSystem.addContainer("Web Application", "An example web application", "Apache Tomcat 7.x");
        user.uses(webApplication, "Uses");

        ComponentFinder componentFinder = new ComponentFinder(
                webApplication,
                "com.structurizr.example",
                new StructurizrComponentFinderStrategy(),
                new SpringComponentFinderStrategy());
        componentFinder.findComponents();
    }

}
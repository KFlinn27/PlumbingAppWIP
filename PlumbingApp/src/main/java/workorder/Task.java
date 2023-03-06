package workorder;

import java.math.BigDecimal;

public class Task{
    private String name;
    private BigDecimal cost;
    private String description;
    private Material[] materials;
    private double labor;

    public Task(String name, BigDecimal cost, String description, String materials, double labor){
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.materials = materials;
        this.labor = labor;
    }

    public double getLabor() {
        return labor;
    }

    public void setLabor(double labor) {
        this.labor = labor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Material[] getMaterials() {
        return materials;
    }

    public void setMaterials(Material[] materials) {
        this.materials = materials;
    }
}

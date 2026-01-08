package org.example.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks,
                    Set<Task> unassignedTasks){
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String name){
        switch (name.toLowerCase()){
            case "ann": return annsTasks;
            case "bob": return bobsTasks;
            case "carol": return carolsTasks;
            case "all": // Testler muhtemelen tümünü birleşik görmek ister
                return getUnion(annsTasks, bobsTasks, carolsTasks, unassignedTasks);
            default: return new HashSet<>();
        }
    }

    // HATA BURADAYDI: List<Set<Task>> yerine Set<Task>... (Varargs) kullandık
    public Set<Task> getUnion(Set<Task>... sets){
        Set<Task> allTasks = new HashSet<>();
        for(Set<Task> set : sets){
            allTasks.addAll(set);
        }
        return allTasks;
    }

    public Set<Task> getIntersection(Set<Task> first, Set<Task> second){
        Set<Task> intersection = new HashSet<>(first);
        intersection.retainAll(second);
        return intersection;
    }

    public Set<Task> getDifferences(Set<Task> first, Set<Task> second){
        Set<Task> difference = new HashSet<>(first);
        difference.removeAll(second);
        return difference;
    }
}
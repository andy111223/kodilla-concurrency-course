package simpleProjectAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class AdditionalProjectService {

    public CompletableFuture<List<StudentProjectAssignment>> assignAdditionalProjects() {
        System.out.println("Assigning additional project IDs to students:");

        List<Integer> additionalProjectIds = new ArrayList<>();
        for (int i = 6; i <= 10; i++) {
            additionalProjectIds.add(i);
        }

        Collections.shuffle(additionalProjectIds, new Random());

        List<String> additionalStudentNames = List.of(
                "M. Kowalski",
                "J. Daniels",
                "G. Boligłowa",
                "P. Kanmalantsky",
                "T. Martini"
        );

        List<StudentProjectAssignment> additionalAssignments = new ArrayList<>();
        for (int i = 0; i < additionalStudentNames.size(); i++) {
            additionalAssignments.add(new StudentProjectAssignment(additionalStudentNames.get(i), additionalProjectIds.get(i)));
        }

        return CompletableFuture.supplyAsync(() -> additionalAssignments);
    }
}

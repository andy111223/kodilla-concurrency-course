package simpleProjectAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class ProjectAssignmentService {

    public CompletableFuture<List<StudentProjectAssignment>> assignProjectsToStudents() {
        System.out.println("Assigning project IDs to students:");

        // List of student names
        List<String> studentNames = List.of(
                "A. Olszewski",
                "B. Jankowski",
                "H. Nowak",
                "J. Smith",
                "U. Nowakowski"
        );

        // List of project IDs
        List<Integer> projectIds = new ArrayList<>();
        for (int i = 1; i <= studentNames.size(); i++) {
            projectIds.add(i);
        }

        // Shuffle the project IDs to ensure randomness
        Collections.shuffle(projectIds, new Random());

        // Create a list of StudentProjectAssignment
        List<StudentProjectAssignment> assignments = new ArrayList<>();
        for (int i = 0; i < studentNames.size(); i++) {
            assignments.add(new StudentProjectAssignment(studentNames.get(i), projectIds.get(i)));
        }

        // Return the list of assignments as a CompletableFuture
        return CompletableFuture.supplyAsync(() -> assignments);
    }
}

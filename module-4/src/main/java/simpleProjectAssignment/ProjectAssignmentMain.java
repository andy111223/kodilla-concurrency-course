package simpleProjectAssignment;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ProjectAssignmentMain {

    public static final ProjectAssignmentService service = new ProjectAssignmentService();
    private static final AdditionalProjectService additionalService = new AdditionalProjectService();
    private static final ProjectNameProvider nameProvider = new ProjectNameProvider();

    public static void main(String[] args) {

        service.assignProjectsToStudents()
                .thenCompose(initialAssignments ->
                        additionalService.assignAdditionalProjects()
                                .thenApply(additionalAssignments -> {
                                    initialAssignments.addAll(additionalAssignments);
                                    return initialAssignments.stream().distinct().collect(Collectors.toList());
                                }))
                .thenCompose(assignments -> {
                    List<CompletableFuture<StudentProjectAssignment>> updatedAssignments = assignments.stream()
                             .map(assignment -> nameProvider.fetchProjectName(assignment.getProjectId())
                                .thenApply(projectName -> {
                                    assignment.setProjectName(projectName);
                                    return assignment;
                                }))
                            .toList();

                    CompletableFuture<Void> allOf = CompletableFuture.allOf(updatedAssignments.toArray(new CompletableFuture[0]));
                    return allOf.thenApply(v -> updatedAssignments.stream()
                                    .map(CompletableFuture::join)
                                    .collect(Collectors.toList()));
                }).thenAccept(updatedAssignments -> {
                    System.out.println("Student project ID updated with project name:");
                    System.out.println(updatedAssignments);
                }).join();
    }
}

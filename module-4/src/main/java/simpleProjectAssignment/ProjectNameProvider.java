package simpleProjectAssignment;

import java.util.concurrent.CompletableFuture;

public class ProjectNameProvider {

    public CompletableFuture<String> fetchProjectName(int projectId) {
        System.out.println("Providing projectName for project ID: " + projectId);
        return CompletableFuture.supplyAsync(() -> {
            return switch (projectId) {
                case 1 -> "Ishikawa Diagram";
                case 2 -> "Pareto Principle";
                case 3 -> "5 x Why";
                case 4 -> "Block Scheme";
                case 5 -> "ISO 14000";
                case 6 -> "Six Sigma";
                case 7 -> "Kaizen";
                case 8 -> "Kanban";
                case 9 -> "Scrum";
                case 10 -> "Lean";
                default -> throw new RuntimeException("Unknown project ID");
            };
        });
    }
}

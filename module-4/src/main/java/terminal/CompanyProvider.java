package terminal;

import java.util.concurrent.CompletableFuture;

public class CompanyProvider {

    public CompletableFuture<String> provideName(int companyId) {
        System.out.println("Providing name for ID: " + companyId);
        return CompletableFuture.supplyAsync(() -> {
            return switch (companyId) {
                case 1 -> "EasyFly";
                case 2 -> "FlyFast";
                case 3 -> "HardFly";
                case 4 -> "HardFlyFast";
                default -> throw new RuntimeException("Unknown company ID");
            };
        });
    }
}

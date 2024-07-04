package multi.semaphore.fileDownloader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileDownloaderMain {
    public static void main(String[] args) {

        String[] fileUrls = new String[300];
        for (int i = 0; i < fileUrls.length; i++) {
            fileUrls[i] = "http://example.com/file" + (i + 1) + ".zip";
        }
        ExecutorService executor = Executors.newCachedThreadPool();
        for(String url : fileUrls) {
            executor.submit(new FileDownloader(url));
        }
        executor.shutdown();

        while(!executor.isTerminated()) {
            //Waiting for all threads to complete
        }
        System.out.println("All files downloaded successfully");
    }
}
